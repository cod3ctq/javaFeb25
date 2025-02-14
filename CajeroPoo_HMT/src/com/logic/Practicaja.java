package com.logic;

import com.constants.Messages;
import com.exception.*;
import com.models.Cuenta;
import com.models.Recibo;
import com.models.RetiroSinTarjeta;
import com.models.Ticket;
import com.service.IOperacionesBasicas;
import com.service.IOpercaionesAvanzadas;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Practicaja extends Cajero implements IOperacionesBasicas, IOpercaionesAvanzadas {
    Scanner scan = new Scanner(System.in);

    private Map<String, List<Recibo>> reciboDB;

    public Map<String, List<Recibo>> getReciboDB() {
        return reciboDB;
    }

    public void setReciboDB(Map<String, List<Recibo>> reciboDB) {
        this.reciboDB = reciboDB;
    }

    @Override
    public Ticket retiroSinTarjeta() {
        Ticket ticket = null;
        System.out.println("Ingrese el número de Referencia: ");
        String referencia = scan.nextLine();
        System.out.println("Captura la contraseña");
        String contraseña = scan.nextLine();

        // Busca el retiro sin tarjeta dentro de la base de datos
        for (RetiroSinTarjeta temp : this.getRetiroSinTarjetaDB()) {
            if (temp.getReferencia().equals(referencia) && temp.getContraseña().equals(contraseña)) {
                ticket = new Ticket(this.getUbicacion(), LocalDate.now(),
                        "RETIRO SIN TARJETA", temp.getMonto(), 0);
                break;
            }
        }

        //comprobacion
        if (ticket != null) {
            System.out.println("Cobrado exitosamente");
            return ticket;

        } else {
            //lanzar la excepcion
            throw new NotExistException("No se encontraron los datos para el retiro sin tarjeta");
        }

    }

    @Override
    public Object[] retirar(String numeroCuenta, int monto) throws InsufficientFundsException, UnderMinimunException, NotExistException{
        Object[] data = new Object[2];
        Cuenta cuenta = (Cuenta) this.buscar(numeroCuenta)[0];

        //si la cuenta existe
        if (cuenta != null) {
            int index = (int) this.buscar(numeroCuenta)[1];
            //validar que la cuenta tenga suficiente
            if (cuenta.getSaldoDisponible() < monto) {
                System.out.println("Fondos insuficientes");
                //lanzar una excepcion
                throw new InsufficientFundsException(Messages.FONDOS_INSUFICIENTES);
            } else if ((cuenta.getSaldoDisponible() - monto) < cuenta.getMin()) { // validar que la cuenta no me deje por debajo del minimo
                System.out.println("Retiro no disponible");

                throw new UnderMinimunException(Messages.RETIRO_BAJO_EL_MINIMO);
            } else {//ya puedo hacer el retiro
                // actualiza el saldo de la cuenta directamente dentro de la DB
                this.getCuentasDB().get(index).setSaldoDisponible(
                        cuenta.getSaldoDisponible() - monto
                );
                data[0] = new Ticket(this.getUbicacion(), LocalDate.now(), "RETIRO", monto, 0);
                data[1] = monto;
            }


        } else {
            System.out.println("La cuenta indicada no existe");
            throw new NotExistException(Messages.CUENTA_INEXISTENTE);  //////////////////
        }

        return data;
    }


    @Override
    public Ticket depositar(String numeroCuentaDepo, int monto) throws OverMaximumException, NotExistException{
        Ticket data = null;
        Cuenta cuenta = (Cuenta) this.buscar(numeroCuentaDepo)[0];

        //si la cuenta exite entonces:
        if (cuenta!=null){
            int index = (int) this.buscar(numeroCuentaDepo)[1];
            //validar que tenga suficiente saldo
            if (monto>cuenta.getMax()) {
                System.out.println("Deposito Supera el MAX dispoble");   //validar que el deposito no sea mayor al MAX permitido
           // lanzar una excepcion
                throw new OverMaximumException(Messages.MONTO_SUPERIOR_MAXIMO);
            } else {    //Se puede hacer el deposito
                this.getCuentasDB().get(index).setSaldoDisponible(cuenta.getSaldoDisponible()+monto);
                data = new Ticket(this.getUbicacion(),LocalDate.now(),"DEPOSITO",monto,0);

            }
        }else {
            System.out.println("la cuenta NO existe");
            throw new NotExistException(Messages.CUENTA_INEXISTENTE);

        }
        return data;
    }

    @Override
    public Ticket transferir(String origen, String destino, int monto) {
        Ticket ticket = null;
        Cuenta cuentaOrigen = (Cuenta) this.buscar(origen)[0];
        Cuenta cuentaDestino = (Cuenta) this.buscar(destino)[0];

        //si la cuenta exite entonces:
        if (cuentaOrigen!=null && cuentaDestino!=null){
            int indexO = (int) this.buscar(origen)[1];
            int indexD = (int) this.buscar(destino)[1];
            //validar que enga suficiente saldo
            if (cuentaOrigen.getSaldoDisponible()<monto){
                System.out.println("saldo insuficiente");   //lanzar excepcion
            } else if ((cuentaOrigen.getSaldoDisponible()-monto)<cuentaOrigen.getMin()) {
                System.out.println("transferencia NO disponible, quedaría debajo del MIN");
            }
            //validar que el monto no sea mayor al máximo
            else if(monto>cuentaDestino.getMax()) {
                System.out.println("Deposito Supera el MAX disponible");   //validar que el deposito no sea mayor al MAX permitido
            } else if ((cuentaDestino.getSaldoDisponible()+monto)>cuentaDestino.getMax()){
                System.out.println("Deposito no disponible");
            } else {    //Se puede hacer la transferencia
                this.getCuentasDB().get(indexO).setSaldoDisponible(cuentaOrigen.getSaldoDisponible()-monto);
                this.getCuentasDB().get(indexD).setSaldoDisponible(cuentaDestino.getSaldoDisponible()+monto);
                ticket =new Ticket(this.getUbicacion(),LocalDate.now(),"TRANSFERENCIA",monto,0);
            }
        }else {
            System.out.println("la cuenta NO existe");
        }
        return ticket;
    }

    @Override
    public Ticket pagarServicio(String convenio, String referencia) throws AlReadyPaidException, NotExistException {
        Ticket ticket = null;
        //buscar si el convenio existe
        if(reciboDB.containsKey(convenio)){
            //Iterar en la lista el número de convenio
            for (Recibo aux: reciboDB.get(convenio)) {
                if (aux.getFolio().equals(referencia)) {
                    if (aux.isPagado()){
                        System.out.println("Sericio ya ah sido pagado anteriormente");
                        throw new AlReadyPaidException(Messages.YA_PAGADO);
                    }else {
                        //marcar como pagado el servicio
                        reciboDB.get(convenio).get(reciboDB.get(convenio).indexOf(aux)).setPagado(true);
                        ticket = new Ticket(this.getUbicacion(), LocalDate.now(),"PAGO DE SERVICIOS",aux.getMonto(),0);
                    }

                }
            }

        }else {
            System.out.println("no existe el servicio");
            throw new NotExistException(Messages.SERVICIO_INEXISTENTE);
        }
        return null;
    }
}