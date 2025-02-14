package com.logic;

import com.constants.Messages;
import com.excepciones.*;
import com.models.Cuenta;
import com.models.Recibo;
import com.models.RetiroSinTarjeta;
import com.models.Ticket;
import com.service.IOperacionesAvanzadas;
import com.service.IOperacionesBasicas;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Practicaja extends Cajero implements IOperacionesBasicas, IOperacionesAvanzadas {
    Scanner scan = new Scanner(System.in);
    //base de datos de recibos
    private Map<String, List<Recibo>> recibosDB;

    @Override
    public Ticket retiroSinTarjeta() {
        Ticket ticket = null;
        System.out.println("Ingresa la referencia");
        String referencia = scan.nextLine();
        System.out.println("Captura  la constraseña");
        String contraseña = scan.nextLine();
        for (RetiroSinTarjeta temp : this.getRetiroSinTarjetaDB()) {
            if (temp.getReferencia().equals(referencia) && temp.getContraseña().equals(contraseña)) {
                ticket = new Ticket(this.getUbicacion(), LocalDate.now(),
                        "Retiro Sin Tarjeta", temp.getMonto(), 0);
                break;
            }

        }
        if (ticket!=null){
            System.out.println("cobrado exitosamente");
            return ticket;
        }else {
    throw new NotExistException(Messages.RETIRO_NO_EXISTE);
        }

    }
    
    @Override
    public Object[] retirar(String numeroCuenta, int monto) throws UnderMinimumException, InsufficientFundsException,NotExistException{
        Object[] data = new Object[2];
        Cuenta cuenta = (Cuenta) this.buscar(numeroCuenta)[0];

        //Si la cuenta existe....
        if (cuenta != null) {
            int index = (int) this.buscar(numeroCuenta)[1];
            //Validar que tenga suficiente saldo
            if (cuenta.getSaldoDisponible() < monto) {
                //lanzar una exepcion
                throw new InsufficientFundsException(Messages.FONDOS_INSUFICIENTES);
            } else if ((cuenta.getSaldoDisponible() - monto) < cuenta.getMin()) {
                //Validar que el retiro no me deje por debajo del minimo
                System.out.println("Retiro No Disponible");
                throw new UnderMinimumException(Messages.RETIRO_BAJO_EL_MINIMO);
            } else { //Ya puedo hacer el retiro
                //actualiza el saldo de la cuenta directamente dentro de la db
                this.getCuentasDb().get(index).setSaldoDisponible(
                        cuenta.getSaldoDisponible() - monto);
                data[0] = new Ticket(this.getUbicacion(), LocalDate.now(),
                        "RETIRO", monto, 0);
                data[1] = monto;
            }
        } else {
            System.out.println("La cuenta indicada No existe");
            throw new RuntimeException(Messages.CUENTA_INEXISTENTE);
        }

        return data;
    }

    @Override
    public Ticket depositar(String numeroCuenta, int monto) throws OverMaximumException, NotExistException {
        Ticket ticket = null;
        Cuenta cuenta = (Cuenta) this.buscar(numeroCuenta)[0];

        if (cuenta != null) {
            int index = (int) this.buscar(numeroCuenta)[1];
            // se valida que no exceda del monto maximo
            if (monto + cuenta.getSaldoDisponible() > cuenta.getMax()) {
                System.out.println("Se esta exediendo de la capacidad de deposito");
                throw new OverMaximumException(Messages.DEPOSITO_SUPERIOR_MAXIMO);
            } else {
                this.getCuentasDb().get(index).setSaldoDisponible(cuenta.getSaldoDisponible() + monto);
                ticket = new Ticket(this.getUbicacion(), LocalDate.now(), "Deposito", monto, 001);
            }

        } else {
            System.out.println("la cuenta no existe");
            throw  new NotExistException(Messages.CUENTA_INEXISTENTE);
        }
        return ticket;
    }

    @Override
    public Ticket transferir(String origen, String destino, int monto) {
        Ticket ticket = null;
        Cuenta cuentaOrigen = (Cuenta) this.buscar(origen)[0];
        Cuenta cuentaDestino = (Cuenta) this.buscar(destino)[0];
        //coprobacion si las cuentas existen
        if (cuentaDestino != null && cuentaOrigen != null) {
            //calcula el indice de las cuentas destino y origen

            int indexOrigen = (int) this.buscar(origen)[1];
            int indexDestino = (int) this.buscar(origen)[1];
            if (cuentaOrigen.getSaldoDisponible() < monto) {
                System.out.println("Fondos insuficientes");
                //lanzar una excepcion
            } else if ((cuentaOrigen.getSaldoDisponible() - monto) < cuentaOrigen.getMin()) {
                //Validar que el retiro no me deje por debajo del minimo
                System.out.println("Retiro No Disponible");
            }
            if (monto + cuentaDestino.getSaldoDisponible() > cuentaDestino.getMax()) {
                System.out.println("Se esta exediendo de la capacidad de deposito");
            } else if (cuentaDestino.getMax() < monto) {
                System.out.println("Exede al maximo posible");

            } else {
                this.getCuentasDb().get(indexOrigen).setSaldoDisponible(cuentaOrigen.getSaldoDisponible() - monto);
                this.getCuentasDb().get(indexDestino).setSaldoDisponible(cuentaDestino.getSaldoDisponible() + monto);

                ticket = new Ticket(this.getUbicacion(), LocalDate.now(), "Transferencia", monto, 001);
            }
        } else {
            System.out.println("una de las cuentas no existe");
        }
        return ticket;
    }

    // generar 5 objetos por cada servicio
    //CFE, Agua, SAT, TELMEX
    //Crear las listas correspondietse y agregar las listas al mapa

    @Override
    public Ticket pagarServicio(String convenio, String referencia) throws AlreadyPaidException, NotExistException{
        //primero buscar si el convenio existe
        Ticket ticket = null;
        if (recibosDB.containsKey(convenio)) {
            //iterar en la lista asociada
            for (Recibo aux : recibosDB.get(convenio)
            ) {
                if (aux.getFolio().equals(referencia)) {//verificando que existe el folio
                    if (aux.isPagado()) {
                        System.out.println("ya esta pagado");
                        throw new AlreadyPaidException(Messages.YA_PAGADO);
                    } else {
                        //marca como pagado el servicio
                        recibosDB.get(convenio).get(
                                recibosDB.get(convenio).indexOf(aux)
                        ).setPagado(true);
                        ticket = new Ticket(this.getUbicacion(), LocalDate.now(), "Pago de servicio", aux.getMonto(), 001);
                    }
                }

            }
        } else {
            System.out.println("No existe el convenio");
            //se lanza la exepcion
            throw new NotExistException(Messages.SERVICIO_INEXISTENTE);
        }

        return ticket;

    }

    private Map<String, List<Recibo>> getRecibosDB;
}

