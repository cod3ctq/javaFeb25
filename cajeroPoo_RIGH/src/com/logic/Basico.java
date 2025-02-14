package com.logic;

import com.exceptions.NotExistException;
import com.models.RetiroSinTarjeta;
import com.models.Ticket;

import java.time.LocalDate;
import java.util.Scanner;

public class Basico extends Cajero{
    Scanner sacn =new Scanner(System.in);

    @Override
    public Ticket retiroSinTarjeta() {
        Ticket ticket=null;
        System.out.println("Ingresa la referencia: ");
        String referencia = sacn.nextLine();

        for (RetiroSinTarjeta temp:this.getRetiroSinTajetaDb()){
            if (temp.getReferencia().equals(referencia)){
                ticket = new Ticket(this.getUbicacion(), LocalDate.now(),
                        "Retiro sin tarjeta",temp.getMonto(),0);
                break;
            }
            if (ticket!=null){
                System.out.println("Exito");
                return ticket;
            }else {
                throw new NotExistException("fondos insufiiemtes");
            }
        }return ticket;

    }
}
