package com.service;

import com.models.Ticket;

public interface IOperacionesAvanzadas {

    Ticket depositar(String numeroCuenta,int monto);
    Ticket trasferir (String origen,String destino, int monto);
    Ticket pagarServicio(String convenio,String referencia);
}
