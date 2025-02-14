package com.models;

public class Recibo {

    private String folio;
    private double monto;
    private boolean pagado;

    //Constructores
    public Recibo(){}

    public Recibo(String folio, double monto, boolean pagado) {
        this.folio = folio;
        this.monto = monto;
        this.pagado = pagado;
    }

    //Getters y Setters
    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public boolean isPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    //toString
    @Override
    public String toString() {
        return "Recibo{" +
                "folio='" + folio + '\'' +
                ", monto=" + monto +
                ", pagado=" + pagado +
                '}';
    }
}
