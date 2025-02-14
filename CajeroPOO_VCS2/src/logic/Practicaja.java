package logic;

import com.excepcion.InsufficientFundsException;
import com.excepcion.NotExistException;
import com.excepcion.OverMaximumExceptio;
import models.Cuenta;
import models.Recibo;
import models.Ticket;
import servis.IOperacionesAvanzadas;
import servis.IOperacionesBasicas;


import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;

public class Practicaja extends logic.Cajero implements IOperacionesBasicas, IOperacionesAvanzadas {
    Scanner scan = new Scanner(System.in);

    private Map <String List>> RecibosDB;


    @Override
    public Ticket retiroSinTarjeta() {
        return null;
    }
//Lanzar la excepcion
    throw new NotExistException("No se encontraran datos para el retiro son tarjeta");


    @Override
    public Object[] retirar(String numeroCuenta, int monto) throws InsufficientFundsException {
        Object[] data = new Object[2];
        Cuenta cuenta = (Cuenta) this.buscar(numeroCuenta)[0];



        //Si la cuenta existe....

        if(cuenta!=null){
            int index = (int) this.buscar(numeroCuenta)[1];
            //Validar que tenga suficiente saldo
            if(cuenta.getSaldoDisponible()<monto){
                System.out.println("Fondos insuficientes");
                //lanzar una excepcion
            }else if((cuenta.getSaldoDisponible()-monto)<cuenta.getMin()){//Validar que el retiro no me deje por debajo del minimo
                System.out.println("Retiro No Disponible");
            }else{ //Ya puedo hacer el retiro

                //actualiza el saldo de la cuenta directamente dentro de la db
                this.getCuentasDB().get(index).setSaldoDisponible(
                        cuenta.getSaldoDisponible()-monto
                );
            }
        }else {
            System.out.println("La cuenta indicada No existe");

            public Ticket Transferir (String origen, String destino,int monto);
            Ticket ticket = null;
            Cuenta cuentaorigen = (Cuenta) this.buscar(origen)[];
            Cuenta cuentadestino = (Cuenta) this.buscar(destino)[];
            if ()
                int indexOrigen = (int) this.buscar(numeroCuenta)[1];
            int indexDestino = (int) this.buscar(numeroCuenta)[1];

            //Validar que tenga suficiente saldo
            if (cuenta.getSaldoDisponible() < monto) {
                System.out.println("Fondos insuficientes");
                //lanzar una excepcion
            } else if ((cuenta.getSaldoDisponible() - monto) < cuenta.getMin()) {//Validar que el retiro no me deje por debajo del minimo
                System.out.println("No es posible tranferir, quedarte por debajo del minimo");
                throw new inderMknimunException("El retiro dejaria el saldo por debajo del minimo ");

            }

            if (cuentadestino.getMax() < monto) ;
            System.out.println("El monto transferido excede el maximo permitido de la cuenta");
        }else  if (cuentadestino.getSaldoDisponible()monto)>cunetadestino.getMx()){
    System.out.println("No es posible transferir");
    throw new NotExistException("La cuenta indicada no existe");
    throw new NotExistException("La cuenta indicada no existe");

    throw new OverMaximumExceptio("El deposito llevaria por por encima del ");
        }
        Ticket = new Ticket(this.getUbicacion(), LocalDate.now(),"Transferencia",monto,8);
    }

    System.out.println();

    if (recibosBD.containsKey(convenio)){

        for (Recibo aux:recibos.get(convenio)){
            if (aux.getFolio().equals(referencia)){

                if (aux.isPagado()) {
                    System.out.println("El servicio ya ha sido pagado anteriormente ");
                }else{
                    recibosBD.get(convenio).get (
                            recibosBD.get(convenio).indexOf(aux)
                    )setPagado(true);
                    ticket = new Ticket(this.getUbicacion().LocalDate.now(), "PAGO DE SERVICIOS", aux.getMonto(),0);
                }
            }
        }
        }else{
        System.out.println("No existe tal servicio");
    }
    public Ticket transferirir(String hola, String bcde, int i) {
        return null;
    }
    public void setRecibosBD(Map<String,java.util.List<Recibo>> servicios) {
    }
    public Ticket pagarServicio(String agua, String agua003) {
        return null;
    }
    @Override
    public Object[] depositar(String numeroCuenta, int monto) {
        return new Object[0];
    }
}
