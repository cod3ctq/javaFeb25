package com.service;

import com.models.Ticket;

public interface IOperacionesAvanzadas {

    Ticket depositar (String cuentaDestino, int monto);
    Ticket transferir (String origen, String destino, int monto);
    Ticket pagarServicios (String convenio,String referencia);
}
