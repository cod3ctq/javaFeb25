package com.models;

public class Cuenta {

    private String numCuenta;
    private String beneficiario;
    private double saldoDisponible;
    private double max;
    private double min;

    //Constructores
    public Cuenta(){}

    public Cuenta(String numCuenta, String beneficiario, double saldoDisponible, double max, double min) {
        this.numCuenta = numCuenta;
        this.beneficiario = beneficiario;
        this.saldoDisponible = saldoDisponible;
        this.max = max;
        this.min = min;
    }

    //Getters y Setters
    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(String beneficiario) {
        this.beneficiario = beneficiario;
    }

    public double getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(double saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    //toString
    @Override
    public String toString() {
        return "Cuenta{" +
                "numCuenta='" + numCuenta + '\'' +
                ", beneficiario='" + beneficiario + '\'' +
                ", saldoDisponible=" + saldoDisponible +
                ", max=" + max +
                ", min=" + min +
                '}';
    }
}
