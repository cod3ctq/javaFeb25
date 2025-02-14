package com.logic;

import com.models.Cuenta;
import com.models.RetiroSinTarjeta;
import com.models.Ticket;
import com.service.IOperacionesBasicas;

import java.time.LocalDate;
import java.util.Scanner;

public class Basico extends Cajero implements IOperacionesBasicas {

    Scanner scan = new Scanner(System.in);

    @Override
    public Ticket retiroSinTarjeta() {
        Ticket ticket = null;
        System.out.println("Ingrese el número de Referencia: ");
        String referencia = scan.nextLine();

        // Busca el retiro sin tarjeta dentro de la base de datos
        for (RetiroSinTarjeta temp: this.getRetiroSinTarjetaDB())
        {
            if(temp.getReferencia().equals(referencia))
            {
                ticket = new Ticket(this.getUbicacion(), LocalDate.now(),
                        "RETIRO SIN TARJETA", temp.getMonto(),0);
                break;
            }
        }

      /*  if (ticket!=null){
            System.out.println("Cobrado exitosamente");
            return ticket;*/
        return ticket;

    }

    @Override
    public Object[] retirar(String numeroCuenta, int monto) {
        Object[] data = new Object[2];
        Cuenta cuenta = (Cuenta) this.buscar(numeroCuenta)[0];

        //si la cuenta existe
        if (cuenta!=null){
            int index = (int)this.buscar(numeroCuenta)[1];
            //validar que la cuenta tenga suficiente
            if (cuenta.getSaldoDisponible()<monto){
                System.out.println("Fondos insuficientes");
                //lanzar una excepcion
            } else if ((cuenta.getSaldoDisponible()-monto) < cuenta.getMin()){ // validar que la cuenta no me deje por debajo del minimo
                System.out.println("Retiro no disponible");
            }else{//ya puedo hacer el retiro
                // actualiza el saldo de la cuenta directamente dentro de la DB
                this.getCuentasDB().get(index).setSaldoDisponible(
                        cuenta.getSaldoDisponible()-monto
                );
                data[0] = new Ticket(this.getUbicacion(), LocalDate.now(),"RETIRO",monto,0);
                data[1] = monto;
            }


        } else {
            System.out.println("La cuenta indicada no existe");
        }

        return data;
    }
}