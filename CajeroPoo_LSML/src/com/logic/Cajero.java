package com.logic;

import com.models.Cuenta;
import com.models.RetiroSinTarjeta;
import com.models.Ticket;

import java.time.LocalDate;
import java.util.List;

public abstract class Cajero {
    private String ubicacion;
    private int cajeroIs;
    private List<Cuenta> cuentasDB;
    private List<RetiroSinTarjeta>retiroSinTarjetaDB;

    public Cajero(){

    }

    public Cajero(String ubicacion, int cajeroIs, List<Cuenta> cuentasDB) {
        this.ubicacion = ubicacion;
        this.cajeroIs = cajeroIs;
        this.cuentasDB = cuentasDB;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getCajeroIs() {
        return cajeroIs;
    }

    public void setCajeroIs(int cajeroIs) {
        this.cajeroIs = cajeroIs;
    }

    public List<Cuenta> getCuentasDB() {
        return cuentasDB;
    }

    public void setCuentasDB(List<Cuenta> cuentasDB) {
        this.cuentasDB = cuentasDB;
    }

    public List<RetiroSinTarjeta> getRetiroSinTarjetaDB() {
        return retiroSinTarjetaDB;
    }

    public void setRetiroSinTarjetaDB(List<RetiroSinTarjeta> retiroSinTarjetaDB) {
        this.retiroSinTarjetaDB = retiroSinTarjetaDB;
    }

    @Override
    public String toString() {
        return "Cajero{" +
                "ubicacion='" + ubicacion + '\'' +
                ", cajeroIs=" + cajeroIs +
                ", cuentasDB=" + cuentasDB +
                ", retiroSinTarjetaDB=" + retiroSinTarjetaDB +
                '}';
    }

    //SE PONE PARA QUE DEVUELVA OBJETOS PERSONALIZADOS POR NOSOTROS MISMOS
    //RECIBE NUMERO DE CUENTA, DEVUELVE OBJETO CUENTA COMPLETO
    //TODO METODO QUE NO ES VOID DEVUELVE UN RETUN
    //ES PARA QUE NOS DEVUELVA 2 OBJETOS
    public Object[] buscar(String numeroCuenta){
        Object [] data = new Object[2];

        for (Cuenta cuenta:cuentasDB){
            //FILTAR POR NUMERO
            if (cuenta.getNumCuenta().equals(numeroCuenta)){
                data [0]= cuenta;
                data [1] = cuentasDB.indexOf(cuenta);
                break;
            }
        }

        return data;
    }

    public Ticket consultarSaldo(String numeroCuenta){
        Ticket ticket = null;
        Cuenta cuenta= (Cuenta) this.buscar(numeroCuenta)[0];
                if (cuenta!=null){
                    System.out.println("Tu saldo actual es:"+cuenta.getSaldoDisponible());                                         //ES PARA TOMAR LA PARTE ENTERA
                    ticket = new Ticket(this.ubicacion, LocalDate.now(),"Consulta de saldo", cuenta.getSaldoDisponible(),(int) Math.random()*100);
                }
        return ticket;
    }
    public abstract Ticket retiroSinTarjeta();


}
