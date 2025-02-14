package com.logic;

import com.models.RetiroSinTarjeta;
import com.models.Ticket;

import java.time.LocalDate;
import java.util.Scanner;

public class Basico extends Cajero {
    Scanner scan = new Scanner(System.in);

    @Override
    public Ticket retiroSinTarjeta() {
        Ticket ticket = null;
        System.out.println("Ingresa la referencia");
        String referencia = scan.nextLine();
        for (RetiroSinTarjeta temp : this.getRetiroSinTarjetaDB()) {
            if (temp.getReferencia().equals(referencia)) {
                ticket = new Ticket(this.getUbicacion(), LocalDate.now(),
                        "Retiro Sin Tarjeta", temp.getMonto(), 0);
                break;
            }
        }
        //comprobacion
//        if (ticket != null){
//            System.out.println("Cobrado exitosamente");
//            return ticket;
//        }else {
//          try
//        poropagar una excepcion
//        }
        return ticket;
    }

}
