package com.logic;

import com.models.RetiroSinTarjeta;
import com.models.Ticket;

import java.time.LocalDate;
import java.util.Scanner;

public class Basico extends Cajero{
    Scanner scan= new Scanner(System.in);
    public Ticket retiroSinTarjeta(){
        Ticket ticket = null;
        System.out.println("Captura la referencia");
        String referencia = scan.nextLine();

        //BUSCA EL RETIRO SIN TRAJETA DENTRO DE LA BASE DE DATOS
        for (RetiroSinTarjeta temp:this.getRetiroSinTarjetaDB()){
            if (temp.getReferencia().equals(referencia)){
                ticket = new Ticket(this.getUbicacion(),LocalDate.now(),"Retiro sin tarjeta",
                        temp.getMonto(), 0);

            break;
            }
        }
        /*if (ticket! = null){
            System.out.println("Cobrado exitosamente");
         }
         */

        return ticket;
    }

}
