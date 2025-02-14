package com.logic;

import com.exceptions.AlreadyPaidException;
import com.exceptions.InsuficientFoundsException;
import com.exceptions.NotExceptions;
import com.models.Cuenta;
import com.models.Recibo;
import com.models.RetiroSinTarjeta;
import com.models.Ticket;
import com.service.IOperacionesAvanzadas;
import com.service.IOperacionesBasicas;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Practicaja extends Cajero implements IOperacionesBasicas, IOperacionesAvanzadas {
    Scanner sacn =new Scanner(System.in);
    Scanner sacn1 =new Scanner(System.in);
    private Map<String, List<Recibo>> mapR;

    @Override
    public Ticket retiroSinTarjeta() {
        Ticket ticket=null;
        System.out.println("Ingresa la referencia:");
        String referencia = sacn.nextLine();
        System.out.println("Escribe la contraseña:");
        String contraseña =  sacn1.nextLine();

        for (RetiroSinTarjeta temp:this.getRetiroSinTajetaDb()){
            if (temp.getReferencia().equals(referencia)  && temp.getContraseña().equals(contraseña)){
                ticket = new Ticket(this.getUbicacion(), LocalDate.now(),
                        "Retiro sin tarjeta",temp.getMonto(),0);
                break;
            }
        }
        return ticket;
    }

    @Override
    public Object[] retirar(String numeroCuenta, int monto) {
        Object[] data = new Object[2];
        Cuenta cuenta = (Cuenta) this.buscar(numeroCuenta)[0];

        //si la cuenta exite entonces:
        if (cuenta!=null){
            int index = (int) this.buscar(numeroCuenta)[1];
            //validar que enga suficiente saldo
            if (cuenta.getSaldo()<monto){
                System.out.println("saldo insuficiente");   //lanzar excepcion
                throw new OverMaximumExceptions("El deposito se llevarra a cabo")
                //throw new InsuficientFoundsException("Fondos insuficientes");
            } else if ((cuenta.getSaldo()-monto)<cuenta.getMin()) {
                System.out.println("Retiro NO dispoble");   //validar que el Retiro no me deje por debajo del minimo
                throw new UnderMinimumExceptions("El retiro dejaria el saldo por debajo del minimo");
            } else {    //Se puede hacer el retiro
                this.getCuentasDB().get(index).setSaldo(cuenta.getSaldo()-monto);
                data[0] =new Ticket(this.getUbicacion(),LocalDate.now(),"RETIRO",monto,0);
                data[1]=monto;
                throw new

            }
        }else {
            System.out.println("la cuenta NO existe");
            throw new NotExistExceptions("No existe tal servicio");
        }
        return data;
    }

    @Override
    public Ticket depositar(String numeroCuentaDepo, int monto) {
        Ticket data = null;
        Cuenta cuenta = (Cuenta) this.buscar(numeroCuentaDepo)[0];

        //si la cuenta exite entonces:
        if (cuenta!=null){
            int index = (int) this.buscar(numeroCuentaDepo)[1];
            //validar que enga suficiente saldo
            if (monto>cuenta.getMax()) {
                System.out.println("Deposito Supera el MAX dispoble");   //validar que el deposito no sea mayor al MAX permitido
            } else {    //Se puede hacer el deposito
                this.getCuentasDB().get(index).setSaldo(cuenta.getSaldo()+monto);
                data =new Ticket(this.getUbicacion(),LocalDate.now(),"DEPOSITO",monto,0);

            }
        }else {
            System.out.println("la cuenta NO existe");
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
            if (cuentaOrigen.getSaldo()<monto){
                System.out.println("saldo insuficiente");   //lanzar excepcion
            } else if ((cuentaOrigen.getSaldo()-monto)<cuentaOrigen.getMin()) {
                System.out.println("transferencia NO dispoble, quedaría debajo del MIN");
            }
            //validar que el monto no sea mayor al máximo
            else if(monto>cuentaDestino.getMax()) {
                System.out.println("Deposito Supera el MAX dispoble");   //validar que el deposito no sea mayor al MAX permitido
            } else if ((cuentaDestino.getSaldo()+monto)>cuentaDestino.getMax()){
                System.out.println("Deposito no disponible");
            } else {    //Se puede hacer la transferencia
                this.getCuentasDB().get(indexO).setSaldo(cuentaOrigen.getSaldo()-monto);
                this.getCuentasDB().get(indexD).setSaldo(cuentaDestino.getSaldo()+monto);
                ticket =new Ticket(this.getUbicacion(),LocalDate.now(),"TRANSFERENCIA",monto,0);
            }
        }else {
            System.out.println("la cuenta NO existe");
        }
        return ticket;
    }

    @Override
    public Ticket pagarServicio(String convenio, String referencia) {
        Ticket ticket =null;
        //buscar si el convenio existe
        if(mapR.containsKey(convenio)){
            //Iterar en la lista el número de convenio
            for (Recibo reb: mapR.get(convenio)) {
                if (reb.getFolio().equals(referencia)) {
                    if (reb.isPagado()){
                        System.out.println("Sericio ya ah sido pagado anteriormente");
                    }else {
                        //marcar como pagado el servicio
                        mapR.get(convenio).get(mapR.get(convenio).indexOf(reb)).setPagado(true);
                    }

                }
            }

        }else {
            System.out.println("no existe el servicio");
        }


        return null;
    }

    @Override
    public Ticket depositar(String numeroCuenta) throws OverMaximumException, NotExceptions {
        Ticket ticket = null;

        return null;
    }

    @Override
    public Ticket retirar(String numeroCuenta) {
        return null;
    }

    @Override
    public Ticket pagarServicios(String convenio, String referencia throws AlreadyPaidException) {
        Ticket = null;


        return null;
    }
    try{
        Ticket t11 = pract.
    }
}
