package com.logic;

import com.models.Cuenta;
import com.models.RetiroSinTarjeta;
import com.models.Ticket;

import java.time.LocalDate;
import java.util.List;

public abstract class Cajero {
    private String ubicacion;
    private int cajeroId;
    private List<Cuenta> cuentasDb;
    private List<RetiroSinTarjeta> retiroSinTarjetaDB;

    public Cajero() {

    }

    public Cajero(String ubicacion, int cajeroId, List<Cuenta> cuentasDb) {
        this.ubicacion = ubicacion;
        this.cajeroId = cajeroId;
        this.cuentasDb = cuentasDb;
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

    public List<Cuenta> getCuentasDb() {
        return cuentasDb;
    }

    public void setCuentasDb(List<Cuenta> cuentasDb) {
        this.cuentasDb = cuentasDb;
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
                ", cuentasDb=" + cuentasDb +
                '}';
    }
    //que datos necesito, cual es la accion
    //recibe numero de cuenta, Devuelve: objeto cuenta completo


    public Object[] buscar(String numeroCuenta) {
        Object[] data = new Object[2];
        //Buscar
        for (Cuenta cuenta : cuentasDb) {
            if (cuenta.getNumCuenta().equals(numeroCuenta)) {
                data[0] = cuenta;
                data[1] = cuentasDb.indexOf(cuenta);

                break;
            }
        }
        return data;
    }

    public Ticket consultarSaldo(String numCuenta) {
        Ticket ticket = null;
        //catseo, pasar de un objeto a algo especifico
        Cuenta cuenta = (Cuenta) this.buscar(numCuenta)[0];

        if (cuenta != null) {
            System.out.println("Tu saldo actual es: " + cuenta.getSaldoDisponible());
            ticket = new Ticket(this.ubicacion, LocalDate.now(), "Consulta saldo ",
                    cuenta.getSaldoDisponible(), (int) Math.random() * 100);

        }
        return ticket;
    }

    public abstract Ticket retiroSinTarjeta();
}
