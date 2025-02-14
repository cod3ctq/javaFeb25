package com.logic;

import com.constants.Mnessages;
import com.exceptions.*;
import com.models.Cuenta;
import com.models.Recibo;
import com.models.RetiroSinTarjeta;
import com.models.Ticket;
import com.service.IOperacionesAvanzadas;
import com.service.IOperacionesBasicas;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Practicaja extends Cajero implements IOperacionesBasicas, IOperacionesAvanzadas {

    Scanner scan = new Scanner(System.in);
    private Map<String, List<Recibo>> recibosDB;

    @Override
    public Ticket retiroSinTarjeta() {

        Ticket ticket = null;
        System.out.println("Captura la referencia");
        String referencia = scan.nextLine();
        System.out.println("Capture la contraseña");
        String contraseña = scan.nextLine();

        //Busca el retiro sin tarjeta dentro de la base de datos
        for (RetiroSinTarjeta temp : this.getRetiroSinTarjeta()) {
            if (temp.getReferencia().equals(referencia) && temp.getContraseña().equals(contraseña)) {
                ticket = new Ticket(this.getUbicacion(), LocalDate.now(), "RETIRO SIN TARJETA", temp.getMonto(), 0);
                break;
            }
        }
        //Comprobacion
        if (ticket!=null)
        {
            System.out.println("Cobrado exitosamente");
            return ticket;
        }else {
            //lanzar la excepcion
            throw new NotExistException(Mnessages.RETIRO_NO_EXISTE);
        }
    }

    @Override
    public Object[] retirar(String numeroCuenta, int monto) throws InsufficientFundsException,UnderMinimumException,NotExistException{
        Object[] data = new Object[2];
        Cuenta cuenta = (Cuenta) this.buscar(numeroCuenta)[0];

        //Si la cuenta existe...
        if (cuenta != null) {
            int index = (int) this.buscar(numeroCuenta)[1];
            //Validar que tenga suficiente saldo
            if (cuenta.getSaldoDisponible() < monto) {
                System.out.println("Fondos Insuficientes");
                //Lanzar una excepcion
                throw new InsufficientFundsException(Mnessages.FONDOS_INSUFICIENTES);
            } else if ((cuenta.getSaldoDisponible() - monto) < cuenta.getMin()) {
                System.out.println("Retiro no Disponible.");
                throw new UnderMinimumException(Mnessages.RETIRO_BAJO_EL_MINIMO);
            } else //ya puedo hacer el retiro
            {
                //Actualiza el saldo de la cuenta directamente de la db
                this.getCuentasDB().get(index).setSaldoDisponible(cuenta.getSaldoDisponible() - monto);
                //Creacion del ticket y empaquetada de los datos de salida
                data[0] = new Ticket(this.getUbicacion(), LocalDate.now(), "RETIRO", monto, 0);
                data[1] = monto;

            }
        } else {
            System.out.println("La cuenta indicada no existe");
            throw new NotExistException(Mnessages.CUENTA_INEXISTENTE);
        }
        return data;
    }

    @Override
    public Ticket depositar(String numeroCuenta, int monto)  throws OverMaximumException,NotExistException{
        Ticket ticket = null;
        Cuenta cuenta = (Cuenta) this.buscar(numeroCuenta)[0];

        //Si la cuenta existe...
        if (cuenta != null) {
            int index = (int) this.buscar(numeroCuenta)[1];
            //Lanzar una excepcion
            if (cuenta.getSaldoDisponible() < monto) {
                System.out.println("El monto excede el maximo permitido de la cuenta");
                throw new OverMaximumException(Mnessages.MONTO_SUPERIOR_MAXIMO);
                //Lanzar una excepcion
            } else if ((cuenta.getSaldoDisponible() + monto) > cuenta.getMax()) { //validad que no me exceda
                System.out.println("Deposito no Disponible.");
                throw new OverMaximumException(Mnessages.DEPOSITO_SUPERIOR_MAXIMO);
            } else //ya puedo hacer el deposito
            {
                this.getCuentasDB().get(index).setSaldoDisponible(cuenta.getSaldoDisponible() + monto);
                //Creacion del ticket y empaquetada de los datos de salida
                ticket = new Ticket(this.getUbicacion(), LocalDate.now(), "DEPOSITO", monto, 0);

            }
        } else {
            System.out.println("La cuenta indicada no existe");
            throw new NotExistException(Mnessages.CUENTA_INEXISTENTE);
        }
        return ticket;
    }

    @Override
    public Ticket trasferir(String origen, String destino, int monto) {
        Ticket ticket = null;
        Cuenta cuentaOrigen = (Cuenta) this.buscar(origen)[0];
        Cuenta cuentaDestino = (Cuenta) this.buscar(destino)[0];

        //Comprobamos si las cuentas existen
        if (cuentaOrigen != null && cuentaDestino != null) {
            //Calcula los indices de las cuentas de origen y destino dentro de la db (lista)
            int indexOrigen = (int) this.buscar(origen)[1];
            int indexDestino = (int) this.buscar(destino)[1];
            //Validar que tenga suficiente saldo
            if (cuentaOrigen.getSaldoDisponible() < monto) {
                System.out.println("Fondos Insuficientes para la transferencia");
                //Lanzar una excepcion
            } else if ((cuentaOrigen.getSaldoDisponible() - monto) < cuentaOrigen.getMin()) {
                System.out.println("No es posible transferir, quedaria por debajo del minimo");
            }
            if (cuentaDestino.getSaldoDisponible() < monto) {
                System.out.println("El monto excede el maximo permitido de la cuenta");
                //Lanzar una excepcion
            } else if ((cuentaDestino.getSaldoDisponible() + monto) > cuentaDestino.getMax()) { //validad que no me exceda
                System.out.println("Transferencia no Posible, quedaria por encima del maximo.");
            } else {//Realizo la transferencia
                this.getCuentasDB().get(indexOrigen).setSaldoDisponible(cuentaOrigen.getSaldoDisponible() - monto);
                this.getCuentasDB().get(indexDestino).setSaldoDisponible(cuentaDestino.getSaldoDisponible() + monto);
                ticket = new Ticket(this.getUbicacion(), LocalDate.now(), "TRANSFERENCIA", monto, 0);
            }
        }
        else
        {
                System.out.println("Una de las 2 cuentas no existe");
                //lanzar excepcion
            }
        return ticket;
    }

        @Override
        public Ticket pagarServicio (String convenio, String referencia) throws AlreadyPaidException,NotExistException{
        Ticket ticket = null;
            //Buscar si el convenio ingresado existe
            if(recibosDB.containsKey(convenio)){
                //Iterar en la lista asociada al numero del convenio
                for(Recibo aux:recibosDB.get(convenio))
                {
                    if(aux.getFolio().equals(referencia)) //Verificando si existe
                    {
                        if(aux.isPagado())
                        System.out.println("Servicio ya ha sido pagado");
                        throw new AlreadyPaidException(Mnessages.YA_PAGADO);
                    }
                    else
                    {
                        //Marca como pagado el servicio
                        recibosDB.get(convenio).get(recibosDB.get(convenio).indexOf(aux)).setPagado(true);
                        ticket = new Ticket(this.getUbicacion(),LocalDate.now(),"PAGO DE SERVICIO",aux.getMonto(),0);
                    }
                }
            }
            else
            {
                System.out.println("No existe tal servicio");
                //Lanzar excepcion
                throw new NotExistException(Mnessages.SERVICIO_INEXISTENTE);
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



