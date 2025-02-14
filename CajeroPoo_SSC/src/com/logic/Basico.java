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
        // Comprobación
//        if(ticket != null)
//        {
//            System.out.println("Cobrado exitosamente");
//        }
//        else
//        {
//           propagar una excepcion
//        }
        return ticket;
    }

    @Override
    public Object[] retirar(String numeroCuenta, int monto) {

        Object[] data = new Object[2];
        Cuenta cuenta = (Cuenta) this.buscar(numeroCuenta)[0];//** try catch

        // Si la cueta existe...
        if(cuenta!=null)
        {
            int index = (int) this.buscar(numeroCuenta)[1];
            // Validar que tenga suficiente saldo
            // Validar que el retiro no me deje por debajo del minimo
            if(cuenta.getSaldoDisponible()<monto)
            {
                System.out.println("Fondos insuficientes");
                // Lanzar una excepción
            }
            // Validar que el retiro no me deje por debajo del minimo
            else if ((cuenta.getSaldoDisponible()-monto)<cuenta.getMin())
            {
                System.out.println("Retiro No Disponible.");
            }
            else
            { // Ya se puede realizar el retiro
                // Actualiza el saldo de la cuenta directamente dentro de la db
                this.getCuentasDB().get(index).setSaldoDisponible(
                        cuenta.getSaldoDisponible()-monto
                );

                // Creacion del ticket y empaquetado de los datos de salida
                data[0] = new Ticket(this.getUbicacion(),LocalDate.now(),"RETIRO",monto,0);
                data[1] = monto;
            }

        }
        else
        {
            System.out.println("LA CUENTA INDICADA NO EXISTE");
            //System.exit(0);
        }
        return data;
    }
}
