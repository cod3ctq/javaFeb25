package logic;

import models.RetiroSinTarjeta;
import models.Ticket;

import java.net.CacheRequest;
import java.time.LocalDate;
import java.util.Scanner;

public class Basico extends logic.Cajero {

    Scanner scan = new Scanner(System.in);
    @Override
    public Ticket retiroSinTarjeta(){

        Ticket ticket=null;
        System.out.println("Captura la referencia");
        String referencia = scan.nextLine();

        //Busca el retiro sin tarjeta dentro de la base de datos
        for(RetiroSinTarjeta temp:this.getRetiroSinTarjetaDB()){
            if(temp.getReferencia().equals(referencia)){
                ticket = new Ticket(this.getUbicacion(), LocalDate.now(),
                        "RETIRO SIN TARJETA", temp.getMonto(), 0);
                break;
            }
        }

        //Comprobacion
        /*if(ticket!=null){

            System.out.println("Cobrado exitosamente");


        } else{
        }

        */


        return ticket;

    }
}
