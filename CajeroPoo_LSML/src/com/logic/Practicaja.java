package com.logic;

import com.constans.Messages;
import com.exception.*;
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
    private Map<String, List<Recibo>> recursosBD;

    @Override
    public Ticket retiroSinTarjeta() {

        Ticket ticket = null;
        System.out.println("Capture la referencia: ");
        String referencia = scan.nextLine();
        System.out.println("Capture la contraseña: ");
        String contraseña = scan.nextLine();

        //Busca el retiro sin tarjeta dentro de la base de datos
        for (RetiroSinTarjeta temp : this.getRetiroSinTarjetaDB()) {
            if (temp.getReferencia().equals(referencia) && temp.getContraseña().equals(contraseña)) {
                ticket = new Ticket(this.getUbicacion(), LocalDate.now(),
                        "RETIRO SIN TARJETA", temp.getMonto(), 0);
                break;
            }
        }
        if (ticket!=null){
            System.out.println("Cobro exitosamente");
            return ticket;
        }else {
            //LANZAR LA EXCEPCION
            throw new NoExistException(Messages.RETIRO_NO_EXISTE);
        }
    }

    @Override
    public Object[] retirar(String numeroCuenta, int monto) throws  InsufficientFundsException,UnderMinimumException, NoExistException{
        Ticket ticket = null;
        Object[] data = new Object[2];
        Cuenta cuenta = (Cuenta) this.buscar(numeroCuenta)[0];


        //SI LA CUENTA EXISTE...
        if (cuenta != null) {
            int index = (int) this.buscar(numeroCuenta)[1];
            //VALIDAD QUE TENGA SUFICIENTE
            if (cuenta.getSaldoDisponible() < monto) {
                System.out.println("Fondos insuficientes");
                //LANZAR UNA EXCEPCION
                throw new InsufficientFundsException(Messages.FONDOS_INSUFICIENTES);
                //VALIDAD QUE EL RETIRO NO SE PASE Y NO DEJE POR DEBAJP DEL MINIMO
            } else if ((cuenta.getSaldoDisponible() - monto) < cuenta.getMin()) {
                System.out.println("Retiro no Disponible. ");
                throw new UnderMinimumException(Messages.RETIRO_BAJO_MINIMO);
            } else { //YA NO PUEDE HACER EL RETIRO
                //ACTUALIZA EL SALDO DE LA CUENTA DIRECTAMENTE DENTRO DE LA BASE DE DATOS
                data[0] = new Ticket(this.getUbicacion(), LocalDate.now(), "RETIRO", monto, 0);
                data[1] = monto;

            }
            //CREACION DE TICKER
            ticket = new Ticket(this.getUbicacion(), LocalDate.now(), "RETIRO", monto, 0);

        } else {
            System.out.println("La cuenta indicada no existe");
            throw new NoExistException(Messages.CUENTA_INEXISTENTE);
        }
        return data;
    }


    @Override
    public Ticket depositar(String numeroCuenta, int monto) throws OverMaximumException,NoExistException {
        Ticket ticket = null;
        Cuenta cuenta = (Cuenta) this.buscar(numeroCuenta)[0];
        if (cuenta != null) {
            int index = (int) this.buscar(numeroCuenta)[1];
            //VALIDAD QUE TENGA SUFICIENTE
            if (cuenta.getMax() < monto) {
                System.out.println("El monto excede el maximo permitido");
                //LANZAR UNA EXCEPCION
                throw new OverMaximumException(Messages.MONTO_SUPERIOR_MAXIMO);
                //VALIDAD QUE EL RETIRO NO SE PASE Y NO DEJE POR DEBAJP DEL MINIMO
            } else if ((cuenta.getSaldoDisponible() + monto) > cuenta.getMax()) {
                System.out.println("Deposito no disponible. ");
                throw new OverMaximumException(Messages.DEPOSITO_SUPERIOR_MAXIMO);
            } else { //YA NO PUEDE HACER EL RETIRO
                //ACTUALIZA EL SALDO DE LA CUENTA DIRECTAMENTE DENTRO DE LA BASE DE DATOS
                this.getCuentasDB().get(index).setSaldoDisponible(cuenta.getSaldoDisponible() + monto);
            }
            //CREACION DE TICKER
            ticket = new Ticket(this.getUbicacion(), LocalDate.now(), "DEPOSITO", monto, 0);

        } else {
            System.out.println("La cuenta indicada no existe");
            throw new NoExistException(Messages.CUENTA_INEXISTENTE);
        }
        return ticket;
    }

    @Override
    public Ticket transferir(String otrigen, String destino, int monto) {
        Ticket ticket = null;
        Cuenta cuentaOrigen = (Cuenta) this.buscar(otrigen)[0];
        Cuenta cuentaDestino = (Cuenta) this.buscar(destino)[0];

        if (cuentaOrigen != null && cuentaOrigen != null) {
            int indexOrigen = (int) this.buscar(otrigen)[1];
            int indexDestino = (int) this.buscar(destino)[1];
            //VALIDAD QUE TENGA SUFICIENTE
            if (cuentaOrigen.getSaldoDisponible() < monto) {
                System.out.println("Fondos insuficientes para la trasferencia");
                //LANZAR UNA EXCEPCION
                //VALIDAD QUE EL RETIRO NO SE PASE Y NO DEJE POR DEBAJP DEL MINIMO
            } else if ((cuentaOrigen.getSaldoDisponible() - monto) < cuentaOrigen.getMin()) {
                System.out.println("No es posible transferir, queda por debajo del minimo ");
                if (cuentaDestino.getMax() < monto) {
                    System.out.println("El monto excede el maximo permitido");

                } else if ((cuentaDestino.getSaldoDisponible() + monto) > cuentaDestino.getMax()) {
                    System.out.println("El monto transferido . ");
                } else {
                    this.getCuentasDB().get(indexOrigen).setSaldoDisponible(cuentaOrigen.getSaldoDisponible() - monto);
                    this.getCuentasDB().get(indexDestino).setSaldoDisponible(cuentaDestino.getSaldoDisponible() + monto);
                    ticket = new Ticket(this.getUbicacion(), LocalDate.now(), "DEPOSITO", monto, 0);

                }
            }
            }else {
            System.out.println("Alguna de las dos cuentas no existe");
        }
            return ticket;
    }

    @Override
    public Ticket pagarServicios(String convenio, String referencia) throws AlreadyPaidException,NoExistException {
        Ticket ticket = null;
        if (recursosBD.containsKey(convenio)){
            //ITERAR EN LA LISTA ASOCIADA AL NUMERO CONVENIO
            for (Recibo aux: recursosBD.get(convenio)){
                if (aux.getFolio().equals(referencia)){ //VERIFICANDO SI EXISTE
                    if (aux.isPagado()){
                        System.out.println("Servicio ya ha sido pagado anteriormente");
                        throw new  AlreadyPaidException(Messages.YA_PAGADO);
                    }else {
                        recursosBD.get(convenio).get(recursosBD.get(convenio).indexOf(aux)).setPagado(true);
                        ticket = new Ticket(this.getUbicacion(), LocalDate.now(), "Pago de servicios", aux.getMonto(), 0);
                    }
                }
            }
        }else {
            System.out.println("No existe el servicio");
            throw new NoExistException(Messages.SERVICIO_INEXISTENTE);
        }

        return ticket;
    }

    public Scanner getScan() {
        return scan;
    }

    public void setScan(Scanner scan) {
        this.scan = scan;
    }

    public Map<String, List<Recibo>> getRecursosBD() {
        return recursosBD;
    }

    public void setRecursosBD(Map<String, List<Recibo>> recursosBD) {
        this.recursosBD = recursosBD;
    }
}
