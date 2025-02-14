package com.service;

import com.models.Ticket;

public interface IOperacionesAvanzadas {
    Ticket depositar(String numeroCuenta);
    Ticket retirar(String numeroCuenta);
    Ticket pagarServicios(String convenio, String referencia);

}
