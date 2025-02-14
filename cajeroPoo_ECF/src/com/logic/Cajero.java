package com.logic;

import com.models.Cuenta;
import com.models.RetiroSinTarjeta;
import com.models.Ticket;

import java.time.LocalDate;
import java.util.List;

public abstract class  Cajero {

    private String ubicacion;
    private int cajeroId;
    private List<Cuenta> cuentasDB;
    private List<RetiroSinTarjeta> retiroSinTarjetaDB;

    public Cajero(){

    }

    public Cajero(String ubicacion, int cajeroId, List<Cuenta> cuentasDB) {
        this.ubicacion = ubicacion;
        this.cajeroId = cajeroId;
        this.cuentasDB = cuentasDB;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getCajeroId() {
        return cajeroId;
    }

    public void setCajeroId(int cajeroId) {
        this.cajeroId = cajeroId;
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
                ", cajeroId=" + cajeroId +
                ", cuentasDB=" + cuentasDB +
                '}';
    }

    //Recibe: numero de cuenta
    //Devuelve : Objeto cuenta completo
    public Object[] buscar(String numeroCuenta){
       Object[] data = new Object[2];


        //Buscar
        for(Cuenta cuenta: cuentasDB){

            //filtrar por numero de cuenta
            if(cuenta.getNumCuenta().equals(numeroCuenta)){
                data[0]= cuenta;
                data[1]= cuentasDB.indexOf(cuenta);
                break;
            }

        }


        return data;
    }

    public Ticket consultarSaldo(String numeroCuenta){
        Ticket ticket=null;
        Cuenta cuenta =  (Cuenta) this.buscar(numeroCuenta)[0];

        //Si la cuenta existe...
        if(cuenta!=null){
            System.out.println("Tu saldo actual es: "+cuenta.getSaldoDisponible());
            ticket = new Ticket(this.ubicacion, LocalDate.now(), "CONSULTA SALDO",
                    cuenta.getSaldoDisponible(), (int) Math.random()*100 );

        }

        return ticket;
    }

    public abstract Ticket retiroSinTarjeta();


}

