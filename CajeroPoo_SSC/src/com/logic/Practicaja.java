package com.logic;

import com.constants.Messages;
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

    public Map<String, List<Recibo>> getRecibosDB() {
        return recibosDB;
    }

    public void setRecibosDB(Map<String, List<Recibo>> recibosDB) {
        this.recibosDB = recibosDB;
    }

    @Override
    public Ticket retiroSinTarjeta() throws NotExistException
    {
        Ticket ticket = null;
        System.out.println("Ingrese el número de Referencia: ");
        String referencia = scan.nextLine();
        System.out.println("Captura la contraseña: ");
        String contraseña = scan.nextLine();

        // Busca el retiro sin tarjeta dentro de la base de datos
        for (RetiroSinTarjeta temp : this.getRetiroSinTarjetaDB()) {
            if (temp.getReferencia().equals(referencia) && temp.getContraseña().equals(contraseña)) {
                ticket = new Ticket(this.getUbicacion(), LocalDate.now(),
                        "RETIRO SIN TARJETA", temp.getMonto(), 0);
                break;
            }
        }
        // Comprobación
        if (ticket != null) {
            System.out.println("Cobrado exitosamente");
            return ticket;
        } else {
            // Lanzar la excepción
            throw new NotExistException(Messages.RETIRO_NO_EXISTE);
        }
    }

    @Override
    public Object[] retirar(String numeroCuenta, int monto) throws NotExistException, InsufficientFundsException
    {

        Object[] data = new Object[2];
        Cuenta cuenta = (Cuenta) this.buscar(numeroCuenta)[0];

        // Si la cueta existe...
        if (cuenta != null) {
            int index = (int) this.buscar(numeroCuenta)[1];
            // Validar que tenga suficiente saldo
            // Validar que el retiro no me deje por debajo del minimo
            if (cuenta.getSaldoDisponible() < monto) {
                //System.out.println("Fondos insuficientes");
                // Lanzar una excepción
                throw new InsufficientFundsException(Messages.FONDOS_INSUFICIENTES);
            }
            // Validar que el retiro no me deje por debajo del minimo
            else if ((cuenta.getSaldoDisponible() - monto) < cuenta.getMin()) {
                //System.out.println("Retiro No Disponible.");
                throw new UnderMinimumException(Messages.RETIRO_BAJO_EL_MINIMO);
            } else { // Ya se puede realizar el retiro
                // Actualiza el saldo de la cuenta directamente dentro de la db
                this.getCuentasDB().get(index).setSaldoDisponible(
                        cuenta.getSaldoDisponible() - monto
                );

                // Creacion del ticket y empaquetado de los datos de salida
                data[0] = new Ticket(this.getUbicacion(), LocalDate.now(), "RETIRO", monto, 0);
                data[1] = monto;
            }

        } else {
            //System.out.println("LA CUENTA INDICADA NO EXISTE");
            throw new NotExistException(Messages.CUENTA_INEXISTENTE);
        }
        return data;
    }

    @Override
    public Ticket depositar(String cuentaDestino, int monto) throws OverMaximumException, NotExistException
    {
        Ticket ticket = null;
        Cuenta cuenta = (Cuenta) this.buscar(cuentaDestino)[0];
        int index = (int) this.buscar(cuentaDestino)[1];

        // Si la cueta existe...
        if (cuenta != null)
        {
            // Validar que si el monto es mayor por si mismo que el maximo de la cuenta
            if(cuenta.getMax()<monto) {
                //System.out.println("El monto excede el máximo permitido de la cuenta");
                // Lanzar una excepción
                throw new OverMaximumException(Messages.MONTO_SUPERIOR_MAXIMO);
            }
            else if ((cuenta.getSaldoDisponible()+monto)>cuenta.getMax())
            {// Validar que el deposito mas el saldo actual no sobrepase el maximo permitido
                //System.out.println("Deposito No Disponible.");
                throw new OverMaximumException(Messages.MONTO_SUPERIOR_MAXIMO);
            }
            else
            {
                // Ya validamos que existe, entonces...
                // Entonces agregamos el monto al nuevo saldo disponible
                //System.out.print("Dinero de la Cuenta antes del deposito $" + cuenta.getSaldoDisponible() + "\n");
                cuenta.setSaldoDisponible(cuenta.getSaldoDisponible() + monto);
                System.out.println("Deposito exitoso a la cuenta " + cuentaDestino + " de monto total $" + monto);
                //System.out.println("Nuevo Saldo Disponible Cuenta " + cuentaDestino + " de $" + cuenta.getSaldoDisponible());
                ticket = new Ticket(this.getUbicacion(), LocalDate.now(), "DEPOSITO", monto, 0);
            }
        }
        else
        {
            //System.out.println("LA CUENTA INDICADA NO EXISTE");
            throw new NotExistException(Messages.CUENTA_INEXISTENTE);
        }
        return ticket;
    }

    @Override
    public Ticket transferir(String origen, String destino, int monto) throws InsufficientFundsException, NotExistException, OverMaximumException, UnderMinimumException
    {
        Ticket ticket = null;
        Cuenta cuentaOrigen = (Cuenta) this.buscar(origen)[0];
        Cuenta cuentaDestino = (Cuenta) this.buscar(destino)[0];

        // Comprobamos si las cuentas existen

        if(cuentaOrigen!=null && cuentaDestino!=null)
        {
            int indexOrigen = (int) this.buscar(origen)[1];
            int indexDestino = (int) this.buscar(destino)[1];
            // Validar que tenga suficiente saldo
            // Validar que el retiro no me deje por debajo del minimo
            if (cuentaOrigen.getSaldoDisponible() < monto)
            {
                //System.out.println("Fondos insuficientes para la transferencia");
                // Lanzar una excepción
                throw new InsufficientFundsException(Messages.FONDOS_INSUFICIENTES);
            }
            // Validar que el retiro no me deje por debajo del minimo
            else if ((cuentaOrigen.getSaldoDisponible() - monto) < cuentaOrigen.getMin())
            {
                //System.out.println("No es posible transferir, quedaria por debajo del minimo");
                throw new UnderMinimumException(Messages.RETIRO_BAJO_EL_MINIMO);
            }
            else if(cuentaDestino.getMax()<monto)
            {
                //System.out.println("El monto excede el máximo permitido de la cuenta");
                throw new OverMaximumException(Messages.MONTO_SUPERIOR_MAXIMO);
            }
            else if ((cuentaDestino.getSaldoDisponible()+monto)>cuentaDestino.getMax())
            {// Validar que el deposito mas el saldo actual no sobrepase el maximo permitido
                //System.out.println("El monto excede el máximo permitido de la cuenta destino");
                throw new OverMaximumException(Messages.MONTO_SUPERIOR_MAXIMO);
            }
            else
            { // Realizo la transferencia
                this.getCuentasDB().get(indexOrigen).setSaldoDisponible(
                        cuentaOrigen.getSaldoDisponible() - monto
                );
                this.getCuentasDB().get(indexDestino).setSaldoDisponible(
                        cuentaDestino.getSaldoDisponible() + monto
                );

                ticket = new Ticket(this.getUbicacion(),LocalDate.now(),
                        "TRANSFERENCIA",monto,0);
            }
        }
        else
        {
            //System.out.println("Una de las 2 cuentas no existen");
            throw new NotExistException(Messages.CUENTA_INEXISTENTE);
        }
        return ticket;
    }

    @Override
    public Ticket pagarServicios(String convenio, String referencia) throws AlreadyPaidException, NotExistException
    {
        Ticket ticket = null;
        // Buscar si el convenio existe
        if(recibosDB.containsKey(convenio))
        {
            // Iterar si el convenio existe
            for(Recibo aux: recibosDB.get(convenio))
            {
                if(aux.getFolio().equals(referencia)) // Verificamos si existe
                {
                    if(aux.isPagado())
                    {
                        //System.out.println("Servicio ya pagado anteriormente");
                        throw new AlreadyPaidException(Messages.YA_PAGADO);
                    }
                    else
                    {
                        recibosDB.get(convenio).get(
                                recibosDB.get(convenio).indexOf(aux)
                        ).setPagado(true);
                        ticket = new Ticket(this.getUbicacion(),LocalDate.now(),
                                "PAGO DE SERVICIOS",aux.getMonto(),0);
                    }
                }
            }

        }
        else
        {
            //System.out.println("No existe tal servicio");
            // lanzar excepción
            throw new NotExistException(Messages.SERVICIO_INEXISTENTE);
        }
        return ticket;
    }




}
