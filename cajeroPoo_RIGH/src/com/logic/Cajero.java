package com.logic;

import com.models.Cuenta;
import com.models.Recibo;
import com.models.RetiroSinTarjeta;
import com.models.Ticket;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public abstract class Cajero {
    private String ubicacion;
    private int cajerID;
    private List<Cuenta> cuentasDB;
    private List<RetiroSinTarjeta> retiroSinTajetaDb;
    private Map<String,List<Recibo>> serviciosDb;

    public Cajero(){}

    public Cajero(String ubicacion, int cajerID, List<Cuenta> cuentasDB,
                  List<RetiroSinTarjeta> retiroSinTajetaDb) {
        this.ubicacion = ubicacion;
        this.cajerID = cajerID;
        this.cuentasDB = cuentasDB;
    }

    public String getUbicacion() {
        return ubicacion;
    }
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    public int getCajerID() {
        return cajerID;
    }
    public void setCajerID(int cajerID) {
        this.cajerID = cajerID;
    }
    public List<Cuenta> getCuentasDB() {
        return cuentasDB;
    }
    public void setCuentasDB(List<Cuenta> cuentasDB) {
        this.cuentasDB = cuentasDB;
    }
    public List<RetiroSinTarjeta> getRetiroSinTajetaDb() {
        return retiroSinTajetaDb;
    }
    public void setRetiroSinTajetaDb(List<RetiroSinTarjeta> retiroSinTajetaDb) {
        this.retiroSinTajetaDb = retiroSinTajetaDb;
    }

    public Map<String, List<Recibo>> getServiciosDb() {
        return serviciosDb;
    }

    public void setServiciosDb(Map<String, List<Recibo>> serviciosDb) {
        this.serviciosDb = serviciosDb;
    }

    @Override
    public String toString() {
        return "Cajero{" +
                "ubicacion='" + getUbicacion() + '\'' +
                ", cajerID=" + getCajerID() +
                ", cuentasDB=" + getCuentasDB() +
                '}';
    }

    public Object[] buscar(String numeroCuenta){
        Object[] data = new Object[2];
        for (Cuenta cuenta:cuentasDB){
            if (cuenta.getNumCuenta().equals(numeroCuenta)){
                data[0]=cuenta;
                data[1]=cuentasDB.indexOf(cuenta);
                break;
            }
        }
        return data;
    }

    public Ticket consultarSaldo(String numeroCuenta){
       Ticket ticket= null;
       Cuenta cuenta = (Cuenta) this.buscar(numeroCuenta)[0];

       if (cuenta!=null){
           System.out.println("Tu saldo actual es: "+cuenta.getSaldo());
           ticket= new Ticket(this.ubicacion, LocalDate.now(),"Consulta Saldo",
                   cuenta.getSaldo(),(int) Math.random()*100);

       }
        return ticket;
    }
    public abstract Ticket retiroSinTarjeta();

}
