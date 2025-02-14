package com.models;

public class Cuenta {
    private String numCuenta;
    private String beneficiario;
    private double saldo;
    private double max;
    private double min;

    public Cuenta(){}

    public Cuenta(String numCuenta, String beneficiario, double saldo, double max, double min) {
        this.numCuenta = numCuenta;
        this.beneficiario = beneficiario;
        this.saldo = saldo;
        this.max = max;
        this.min = min;
    }

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
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
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

    @Override
    public String toString() {
        return "Cuenta{" +
                "numCuenta='" + getNumCuenta() + '\'' +
                ", beneficiario='" + getBeneficiario() + '\'' +
                ", saldo=" + getSaldo() +
                ", max=" + getMax() +
                ", min=" + getMin() +
                '}';
    }
}
