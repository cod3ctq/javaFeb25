package com.logic;

import com.models.RetiroSinTarjeta;
import com.models.Ticket;

import java.time.LocalDate;
import java.util.Scanner;

public class Basico extends Cajero {

    Scanner scan = new Scanner(System.in);

    @Override
    public Ticket retiroSinTarjeta()
    {
        Ticket ticket=null;
        System.out.println("Captura la referencia");
        String referencia = scan.nextLine();

        //Busca el retiro sin tarjeta dentro de la base de datos
        for (RetiroSinTarjeta temp:this.getRetiroSinTarjeta())
        {
            if(temp.getReferencia().equals(referencia))
            {
                ticket = new Ticket(this.getUbicacion(), LocalDate.now(),"RETIRO SIN TARJETA", temp.getMonto(),0 );
                break;
            }
        }
        //Comprobacion
//        if (ticket!=null)
//        {
//            System.out.println("Cobrado exitosamente");
//            return ticket;
//        }
        //else{ excepcion

        return ticket;
    }
}
