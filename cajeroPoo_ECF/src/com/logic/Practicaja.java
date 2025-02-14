package com.logic;

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

public  class Practicaja extends Cajero implements IOperacionesBasicas, IOperacionesAvanzadas {

    Scanner scan = new Scanner(System.in);

    private Map<String, List<Recibo>> recibosDB;
    private Ticket ticket;

    @Override
    public Ticket retiroSinTarjeta() {

        Ticket ticket = null;
        System.out.println("Captura la referencia");
        String referencia = scan.nextLine();
        System.out.println("Capture la contraseña");
        String contraseña = scan.nextLine();

        //Busca el retiro sin tarjeta dentro de la base de datos
        for (RetiroSinTarjeta temp : this.getRetiroSinTarjetaDB()) {
            if (temp.getReferencia().equals(referencia)
                    && temp.getContraseña().equals(contraseña)) {
                ticket = new Ticket(this.getUbicacion(), LocalDate.now(),
                        "RETIRO SIN TARJETA", temp.getMonto(), 0);
                break;
            }
        }


        if(ticket!=null){
            System.out.println("Cobrado exitosamente");
            return ticket;
        }else{
            //lanzar la excepcion
            throw new NotExistException("");
        }


        //Comprobacion
        /*if(ticket!=null){

            System.out.println("Cobrado exitosamente");


        } else{
        }

        */




    }


    @Override
    public Object[] retirar(String numeroCuenta, int monto) {
        Object[] data = new Object[2];
        Cuenta cuenta = (Cuenta) this.buscar(numeroCuenta)[0];


        //Si la cuenta existe....

        if (cuenta != null) {
            int index = (int) this.buscar(numeroCuenta)[1];
            //Validar que tenga suficiente saldo
            if (cuenta.getSaldoDisponible() < monto) {
                System.out.println("Fondos insuficientes");
                //lanzar una excepcion
                throw new IndexOutOfBoundsException("Fondos insuficientes");
            } else if ((cuenta.getSaldoDisponible() - monto) < cuenta.getMin()) {//Validar que el retiro no me deje por debajo del minimo
                System.out.println("Retiro No Disponible");
                throw new UnderMinumException("El retiro dejaria el saldo por debajo del minimo");
            } else { //Ya puedo hacer el retiro

                //actualiza el saldo de la cuenta directamente dentro de la db
                this.getCuentasDB().get(index).setSaldoDisponible(
                        cuenta.getSaldoDisponible() - monto

                );


                data[0] = new Ticket(this.getUbicacion(), LocalDate.now(),
                        "RETIRO", monto, 0);

                data[1] = monto;

            }
        } else {
            System.out.println("La cuenta indicada No existe");
            throw new NotExistException("La cuenta indicada No existe");
        }


        return data;
    }

    @Override
    public Ticket depositar(String numeroCuenta, int monto) throws InsufficientFundsException {
        Ticket ticket = null;
        Cuenta cuenta = (Cuenta) this.buscar(numeroCuenta)[0];

        if (cuenta != null) {
            int index = (int) this.buscar(numeroCuenta)[1];
            //Validar que si el monto es mayor por si mismo que el maximo de la cuenta
            if (cuenta.getMax() < monto) {
                System.out.println("El monto excede el maximo permitido de la cuenta");
                //lanzar una excepcion
                throw new OverMaxiumException("El monto excede el maximo permitido de la cuenta");
            } else if ((cuenta.getSaldoDisponible() + monto) > cuenta.getMax()) {//Validar que el retiro no me deje por debajo del minimo
                System.out.println("Deposito No Disponible");
                throw new OverMaxiumException("El deposito llevaria por encima del maximo el saldo de la cuenta");
            } else { //Ya puedo hacer el retiro

                //actualiza el saldo de la cuenta directamente dentro de la db
                this.getCuentasDB().get(index).setSaldoDisponible(
                        cuenta.getSaldoDisponible() + monto

                );


                ticket = new Ticket(this.getUbicacion(), LocalDate.now(),
                        "DEPOSITO", monto, 0);


            }
        } else {
            System.out.println("La cuenta indicada No existe");
            throw new NotExistException("La cuenta indicada No existe");
        }


        return ticket;

    }




    @Override
    public Ticket transferir(String origen, String destino, int monto) {
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
                System.out.println("Fondos insuficientes para la transferencia");
                //lanzar una excepcion
            } else if ((cuentaOrigen.getSaldoDisponible() - monto) < cuentaOrigen.getMin()) {//Validar que el retiro no me deje por debajo del minimo
                System.out.println("No es posible transferir, quedaria por debajo del minimo");

            } else if (cuentaDestino.getMax() < monto) {
                System.out.println("El monto excede el maximo permitido de la cuenta");
                //lanzar una excepcion
            } else if ((cuentaDestino.getSaldoDisponible() + monto) > cuentaDestino.getMax()) {//Validar que el retiro no me deje por debajo del minimo
                System.out.println("Deposito No Disponible");



            else {
                    this.getCuentasDB().get(indexOrigen).setSaldoDisponible(

                            cuentaOrigen.getSaldoDisponible() - monto
                    );

                    this.getCuentasDB().get(indexDestino).setSaldoDisponible(

                            cuentaDestino.getSaldoDisponible() + monto
                    );

                    ticket = new Ticket(this.getUbicacion(), LocalDate.now(),
                            "TRANSFERENCIA", monto, 0);


                }

            } else {
                System.out.println("Una de las 2 cuentas no existe");
                //lanzar excepcion
            }

            return ticket;

        }


    }
    @Override
    public Ticket pagarServicio(String convenio, String referencia) throws AlreadyPaidException, NotExistException{
        //Buscar si el convenio existe
        if(recibosDB.containsKey(convenio)){
            //Iterar en la lista asociada al numerp de convenio
            for(Recibo aux:recibosDB.get(convenio)){
                if(aux.getFolio().equals(referencia)){

                    if(aux.isPagado()){
                        System.out.println("Servicio ya ha sido pagado anteriormente");
                        throw new AlreadyPaidException("Servicio ya ha sido pagado anteriormente");
                    }else{
                        recibosDB.get(convenio).get(
                                recibosDB.get(convenio).indexOf(aux)).setPagado(true);
                        ticket = new Ticket(this.getUbicacion(), LocalDate.now(),
                                "PAGO DE SERVICIOS", aux.getMonto(),0);
                    }

                }
            }

        }else{
            System.out.println("No existe tal servicio");
            //lanzar excepcion
            throw new NotExistException("No existe tal servicio");
        }
    }


}





//Generar unos 5 objetos por cada servicio
//CFE, AGUA, SAT, TELMEX
//Crear las listas correspondientes y añadir las listas al Mapa

