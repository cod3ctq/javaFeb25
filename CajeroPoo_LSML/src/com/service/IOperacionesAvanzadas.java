package com.service;

import com.models.Ticket;

public interface IOperacionesAvanzadas {
    Ticket depositar (String numeroCuenta, int monto);
    Ticket transferir (String otrigen, String destino, int monto);
    Ticket pagarServicios (String convenio, String referencia);

}
