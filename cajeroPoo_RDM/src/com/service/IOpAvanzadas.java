package com.service;

import com.models.Ticket;

public interface IOpAvanzadas {

    Ticket depositar( String numeroCuenta, int monto );
    Ticket transferir( String origen, String destino, int monto );
    Ticket pagarServicio( String convenio, String referencia );

}
