package com.logic;

import com.constants.Messages;
import com.exceptions.*;
import com.models.Cuenta;
import com.models.Recibo;
import com.models.RetiroSinTarjeta;
import com.models.Ticket;
import com.service.IOpAvanzadas;
import com.service.IOpBasicas;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Practicaja extends Cajero implements IOpBasicas, IOpAvanzadas {

    Scanner scan = new Scanner(System.in);

    private Map<String, List<Recibo>> recibosDB;

    @Override
    public Ticket retiroSinTarjeta() {

        Ticket ticket = null;
        System.out.println("Capture la referencia: ");
        String referencia = scan.nextLine();
        System.out.println("Capture la contraseña: ");
        String contraseña = scan.nextLine();

        //Busca el retiro sin tarjeta dentro de la base de datos
        for ( RetiroSinTarjeta temp : this.getRetiroSinTarjetaDB() )
        {
            if ( temp.getReferencia().equals( referencia ) && temp.getContraseña().equals( contraseña ) )
            {
                ticket = new Ticket( this.getUbicacion(), LocalDate.now(),
                        "RETIRO SIN TARJETA", temp.getMonto(), 0);
                break;
            }
        }

        //Comprobacion
        if ( ticket != null )
        {
            System.out.println("Cobrado exitosamente");
            return ticket;
        }
        else
        {
            //lanzar la excepcion
            throw new NotExistException( Messages.RETIRO_NO_EXISTE );
        }
    }

    @Override
    public Object[] retirar(String numeroCuenta, int monto) throws InsufficientFundsException, UnderMinimumException, NotExistException {

        Object[] data = new Object[ 2 ];
        Cuenta cuenta = (Cuenta) this.buscar( numeroCuenta )[ 0 ];

        if ( cuenta != null )
        {
            int index = (int) this.buscar( numeroCuenta )[ 1 ];
            //Validar que tenga suficiente saldo
            if ( cuenta.getSaldoDisponible() < monto )
            {
                System.out.println("Fondos insuficientes");
                //lanzar excepcion
                throw new InsufficientFundsException( Messages.FONDOS_INSUFICIENTES );
            }
            else if ( ( cuenta.getSaldoDisponible() - monto ) < cuenta.getMin() )//Validar que el retiro no me deje por debajo del mismo
            {
                System.out.println("Retiro no disponible");
                throw new UnderMinimumException( Messages.RETIRO_BAJO_EL_MINIMO );
            }
            else //Ya puede hacer el retiro
            {
                //actualiza el saldo de la cuenta directamente dentro de la db
                this.getCuentasDB().get( index ).setSaldoDisponible( cuenta.getSaldoDisponible() - monto );
                data[ 0 ] = new Ticket( this.getUbicacion(), LocalDate.now(), "RETIRO", monto, 0 );
                data[ 1 ] = monto;
            }
        }
        else
        {
            System.out.println("La cuenta indicada no existe");
            throw new NotExistException( Messages.CUENTA_INEXISTENTE );
        }
        return data;
    }

    @Override
    public Ticket depositar(String numeroCuenta, int monto) throws OverMaximumException, NotExistException {

        Ticket ticket = null;
        Cuenta cuenta = (Cuenta) this.buscar( numeroCuenta )[ 0 ];

        if ( cuenta != null )
        {
            int index = (int) this.buscar( numeroCuenta )[ 1 ];
            //Validar que no exceda el monto
            if ( cuenta.getMax() < monto )
            {
                System.out.println("Monto excedido");
                //lanzar excepcion
                throw new OverMaximumException( Messages.MONTO_SUPERIOR_MAXIMO );
            }
            else if ( ( cuenta.getSaldoDisponible() + monto ) > cuenta.getMax() )//Validar que el retiro no me deje por debajo del mismo
            {
                System.out.println("Deposito no disponible");
                throw new OverMaximumException( Messages.DEPOSITO_SUPERIOR_MAXIMO );
            }
            else //Ya puede hacer el deposito
            {
                //actualiza el saldo de la cuenta directamente dentro de la db
                this.getCuentasDB().get( index ).setSaldoDisponible( cuenta.getSaldoDisponible() + monto );
                ticket = new Ticket( this.getUbicacion(), LocalDate.now(), "DEPOSITO", monto, 0 );
            }
        }
        else
        {
            System.out.println("La cuenta indicada no existe");
            throw new NotExistException( Messages.CUENTA_INEXISTENTE );
        }
        return ticket;
    }

    @Override
    public Ticket transferir(String origen, String destino, int monto) {

        Ticket ticket = null;
        Cuenta cuentaOrigen = (Cuenta) this.buscar( origen )[ 0 ];
        Cuenta cuentaDestino = (Cuenta) this.buscar( destino )[ 0 ];

        //Comprobamos si las cuentas existen
        if ( cuentaOrigen != null && cuentaDestino != null )
        {
            int indexOrigen = (int) this.buscar( origen )[ 1 ];
            int indexDestino = (int) this.buscar( destino )[ 1 ];
            //Validar que tenga suficiente saldo
            if ( cuentaOrigen.getSaldoDisponible() < monto )
            {
                System.out.println("Fondos insuficientes para transferir");
                //lanzar excepcion
            }
            else if ( ( cuentaOrigen.getSaldoDisponible() - monto ) < cuentaOrigen.getMin() )//Validar que el retiro no me deje por debajo del mismo
            {
                System.out.println("No es posible transferir, quedaria debjao del minimmo");
            }
            else if ( cuentaDestino.getMax() < monto )
            {
                System.out.println("El monto transferido excede el maximo permitido de la cuenta");
                //lanzar excepcion
            }
            else if ( ( cuentaDestino.getSaldoDisponible() + monto ) > cuentaDestino.getMax() )//Validar que el retiro no me deje por debajo del mismo
            {
                System.out.println("No es porsible transferir, quedaria por encima del maximo");
            }
            else
            {
                this.getCuentasDB().get( indexOrigen ).setSaldoDisponible( cuentaOrigen.getSaldoDisponible() - monto );
                this.getCuentasDB().get( indexDestino ).setSaldoDisponible( cuentaDestino.getSaldoDisponible() + monto );
                ticket = new Ticket( this.getUbicacion(), LocalDate.now(), "TRANSFERENCIA", monto, 0 );
            }
        }
        else
        {
            System.out.println("Una de las dos cuentas no existe");
        }

        return ticket;
    }

    @Override
    public Ticket pagarServicio(String convenio, String referencia) {

        Ticket ticket = null;

        //Buscar si el convenio existe
        if ( recibosDB.containsKey( convenio ) )
        {
            //Iterar en la lista asciada al numero de convenio
            for ( Recibo temp : recibosDB.get( convenio ) )
            {
                if ( temp.getFolio().equals( referencia ) ) //Verificando si existe
                {
                    if ( temp.isPagado() )
                    {
                        System.out.println("Servicio ya pagado anteriormente");
                        throw new AlreadyPaidException( Messages.YA_PAGADO );
                    }
                    else
                    {
                        //Marca como pagado el servicio
                        int index = recibosDB.get( convenio ).indexOf( temp );
                        recibosDB.get( convenio ).get( index ).setPagado( true );
                        //Genera el ticket
                        ticket = new Ticket( this.getUbicacion(), LocalDate.now(),
                                "PAGO DE SERVICIO", temp.getMonto(), 0 );
                    }
                }
            }
        }
        else
        {
            System.out.println("No existe tal servicio");
            throw new NotExistException( Messages.SERVICIO_INEXISTENTE );
        }
        return ticket;
    }

    public Map<String, List<Recibo>> getRecibosDB() {
        return recibosDB;
    }

    public void setRecibosDB(Map<String, List<Recibo>> recibosDB) {
        this.recibosDB = recibosDB;
    }
}
