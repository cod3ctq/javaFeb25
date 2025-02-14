package com.models;

public class RetiroSinTarjeta {
    private String referencia;
    private String contraseña;
    private int monto;

    public RetiroSinTarjeta(){

    }
    public RetiroSinTarjeta(String referencia, String contraseña, int monto) {
        this.referencia = referencia;
        this.contraseña = contraseña;
        this.monto = monto;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "RetiroSinTarjeta{" +
                "referencia='" + referencia + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", monto=" + monto +
                '}';
    }
}
