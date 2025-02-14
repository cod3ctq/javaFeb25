package com.models;

import java.time.LocalDate;

public class Ticket {

    private String ubicacion;
    private LocalDate fecha;
    private String tipoOperacion;
    private String saldoAnterior;
    private double monto;
    private int folio;

    public Ticket() {

    }

    public Ticket(String ubicacion, LocalDate fecha, String tipoOperacion, double monto, int folio) {
        this.ubicacion = ubicacion;
        this.fecha = fecha;
        this.tipoOperacion = tipoOperacion;
        this.monto = monto;
        this.folio = folio;
    }

    public Ticket(String ubicacion, LocalDate fecha, String tipoOperacion, String saldoAnterior, double monto, int folio) {
        this.ubicacion = ubicacion;
        this.fecha = fecha;
        this.tipoOperacion = tipoOperacion;
        this.saldoAnterior = saldoAnterior;
        this.monto = monto;
        this.folio = folio;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    @Override
    public String toString() {
        return "Ticket: \n" +
                "Ubicación: " + ubicacion + '\n' +
                "Fecha: " + fecha + "\n" +
                "Tipo de Operación: " + tipoOperacion + '\n' +
                "Monto: $" + monto + "\n" +
                "Folio: " + folio;
    }
}
