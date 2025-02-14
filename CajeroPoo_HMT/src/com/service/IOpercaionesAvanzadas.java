package com.service;

import com.models.Ticket;

public interface IOpercaionesAvanzadas {
    Ticket depositar (String numeroCuenta, int monto);
    Ticket transferir (String numeroCuenta, String cuentaDestino, int monto);
    Ticket pagarServicio (String convenio, String referencia);



}
