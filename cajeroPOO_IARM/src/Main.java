import com.logic.Basico;
import com.logic.Practicaja;
import com.models.Cuenta;
import com.models.RetiroSinTarjeta;
import com.models.Ticket;
import com.models.Recibo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Cuenta cuenta1 = new Cuenta("123456789", "Pepito", 1500, 3000, 0.0);
        Cuenta cuenta2 = new Cuenta("987654321", "Juana", 2000, 4000, 100.0);
        Cuenta cuenta3 = new Cuenta("555555555", "Carlos", 1000, 2500, 50.0);
        Cuenta cuenta4 = new Cuenta("111111111", "Ana", 3000, 5000, 200.0);
        Cuenta cuenta5 = new Cuenta("222222222", "Luis", 1800, 3500, 150.0);
        Cuenta cuenta6 = new Cuenta("333333333", "Sofia", 2500, 4500, 100.0);
        Cuenta cuenta7 = new Cuenta("444444444", "David", 1200, 3000, 75.0);
        Cuenta cuenta8 = new Cuenta("666666666", "Maria", 2200, 4000, 125.0);
        Cuenta cuenta9 = new Cuenta("777777777", "Pedro", 1600, 3200, 100.0);
        Cuenta cuenta10 = new Cuenta("888888888", "Elena", 2800, 4800, 175.0);
        Cuenta cuenta11 = new Cuenta("999999999", "Miguel", 1400, 3000, 75.0);
        Cuenta cuenta12 = new Cuenta("000000000", "Laura", 2600, 4600, 150.0);
        Cuenta cuenta13 = new Cuenta("121212121", "Javier", 1900, 3800, 125.0);
        Cuenta cuenta14 = new Cuenta("232323232", "Isabel", 2400, 4400, 100.0);
        Cuenta cuenta15 = new Cuenta("343434343", "Roberto", 1700, 3400, 100.0);
        Cuenta cuenta16 = new Cuenta("454545454", "Marta", 2100, 4200, 150.0);
        Cuenta cuenta17 = new Cuenta("565656565", "Daniel", 1300, 2800, 75.0);
        Cuenta cuenta18 = new Cuenta("676767676", "Lucia", 2300, 4300, 125.0);
        Cuenta cuenta19 = new Cuenta("787878787", "Alejandro", 1500, 3100, 100.0);
        Cuenta cuenta20 = new Cuenta("898989898", "Patricia", 2700, 4700, 175.0);
        ArrayList<Cuenta> dataBase = new ArrayList<Cuenta>();
        dataBase.add(cuenta1);
        dataBase.add(cuenta2);
        dataBase.add(cuenta3);
        dataBase.add(cuenta4);
        dataBase.add(cuenta5);
        dataBase.add(cuenta6);
        dataBase.add(cuenta7);
        dataBase.add(cuenta8);
        dataBase.add(cuenta9);
        dataBase.add(cuenta10);
        dataBase.add(cuenta11);
        dataBase.add(cuenta12);
        dataBase.add(cuenta13);
        dataBase.add(cuenta14);
        dataBase.add(cuenta15);
        dataBase.add(cuenta16);
        dataBase.add(cuenta17);
        dataBase.add(cuenta18);
        dataBase.add(cuenta19);
        dataBase.add(cuenta20);
        List<RetiroSinTarjeta> retiros = new ArrayList<RetiroSinTarjeta>();
        RetiroSinTarjeta retiro1 = new RetiroSinTarjeta("REF001", "pass123", 500);
        RetiroSinTarjeta retiro2 = new RetiroSinTarjeta("REF002", "clave456", 1000);
        RetiroSinTarjeta retiro3 = new RetiroSinTarjeta("REF003", "segura789", 1500);
        RetiroSinTarjeta retiro4 = new RetiroSinTarjeta("REF004", "abc123", 2000);
        RetiroSinTarjeta retiro5 = new RetiroSinTarjeta("REF005", "xyz789", 2500);
        RetiroSinTarjeta retiro6 = new RetiroSinTarjeta("REF006", "secure321", 3000);
        RetiroSinTarjeta retiro7 = new RetiroSinTarjeta("REF007", "pass999", 3500);
        RetiroSinTarjeta retiro8 = new RetiroSinTarjeta("REF008", "clave111", 4000);
        RetiroSinTarjeta retiro9 = new RetiroSinTarjeta("REF009", "safe456", 4500);
        RetiroSinTarjeta retiro10 = new RetiroSinTarjeta("REF010", "protegido654", 5000);
        RetiroSinTarjeta retiro11 = new RetiroSinTarjeta("REF011", "fuerte789", 5500);
        RetiroSinTarjeta retiro12 = new RetiroSinTarjeta("REF012", "ultraseguro852", 6000);
        RetiroSinTarjeta retiro13 = new RetiroSinTarjeta("REF013", "mypass753", 6500);
        RetiroSinTarjeta retiro14 = new RetiroSinTarjeta("REF014", "topsecret951", 7000);
        RetiroSinTarjeta retiro15 = new RetiroSinTarjeta("REF015", "guardado159", 7500);
        RetiroSinTarjeta retiro16 = new RetiroSinTarjeta("REF016", "secreto753", 8000);
        RetiroSinTarjeta retiro17 = new RetiroSinTarjeta("REF017", "codigo852", 8500);
        RetiroSinTarjeta retiro18 = new RetiroSinTarjeta("REF018", "password951", 9000);
        RetiroSinTarjeta retiro19 = new RetiroSinTarjeta("REF019", "segurísimo654", 9500);
        RetiroSinTarjeta retiro20 = new RetiroSinTarjeta("REF020", "acceso321", 10000);
        retiros.add(retiro1);
        retiros.add(retiro2);
        retiros.add(retiro3);
        retiros.add(retiro4);
        retiros.add(retiro5);
        retiros.add(retiro6);
        retiros.add(retiro7);
        retiros.add(retiro8);
        retiros.add(retiro9);
        retiros.add(retiro10);
        retiros.add(retiro11);
        retiros.add(retiro12);
        retiros.add(retiro13);
        retiros.add(retiro14);
        retiros.add(retiro15);
        retiros.add(retiro16);
        retiros.add(retiro17);
        retiros.add(retiro18);
        retiros.add(retiro19);
        retiros.add(retiro20);

        Basico bas = new Basico();
        Practicaja prac = new Practicaja();
        prac.setUbicacion("Boulevard 5 de mayo #1890");
        bas.setUbicacion("Boulevard 5 de mayo #1890");
        // Se carga la DB de los retiros sin tarjeta
        bas.setRetiroSinTarjetaDB(retiros);
        prac.setRetiroSinTarjetaDB(retiros);
        // Se ejecuta el metodo retriso sin tarjeta y se guarda el ticket resultante
        //Ticket ticket = bas.retiroSinTarjeta();
        //Ticket ticket2 = prac.retiroSinTarjeta();
        //System.out.println(ticket2);
        //Carga la base de datos (lista) sw cuentas en la practicaja

        prac.setCuentasDb(dataBase);
//        Ticket t3 = (Ticket) prac.retirar("C015",3864 )[0];
//        System.out.println(t3);
        //System.out.println(cuenta18.getSaldoDisponible());
        //Ticket t4 = prac.depositar("676767676", 2000);
        //System.out.println(t4);
        //System.out.println("Nuevo saldo: " + cuenta18.getSaldoDisponible());
        Ticket t5 = prac.transferir("121212121", "000000000", 1900);
        System.out.println(t5);

// se hacen multiples comprobaciones para verificar que el codigo funcione como deberia, el mio hace la transferencia pero le faltan
//comprobaciones para confirmar datos como el monto minimo y maximo permitido

        /*
        Cajero c = new Cajero("av. tuarez 5298", 50, dataBase);
        Object[] data = c.buscar("898989898");
        System.out.println(data[0]);
        System.out.println(data[1]);

        Ticket t = c.consultarSaldo("898989898");
        System.out.println(t);*/

        // CFE (Comisión Federal de Electricidad)
        List<Recibo> cfeRecibos = new ArrayList<>();
        cfeRecibos.add(new Recibo("CFE001", 320.50, false));
        cfeRecibos.add(new Recibo("CFE002", 450.75, true));
        cfeRecibos.add(new Recibo("CFE003", 590.00, false));
        cfeRecibos.add(new Recibo("CFE004", 295.30, true));
        cfeRecibos.add(new Recibo("CFE005", 730.10, false));

        // AGUA (Servicio de Agua Potable)
        List<Recibo> aguaRecibos = new ArrayList<>();
        aguaRecibos.add(new Recibo("AGUA001", 180.60, true));
        aguaRecibos.add(new Recibo("AGUA002", 210.40, false));
        aguaRecibos.add(new Recibo("AGUA003", 265.90, true));
        aguaRecibos.add(new Recibo("AGUA004", 150.80, false));
        aguaRecibos.add(new Recibo("AGUA005", 190.20, true));

        // SAT (Servicio de Administración Tributaria)
        List<Recibo> satRecibos = new ArrayList<>();
        satRecibos.add(new Recibo("SAT001", 1200.50, false));
        satRecibos.add(new Recibo("SAT002", 700.00, true));
        satRecibos.add(new Recibo("SAT003", 980.30, false));
        satRecibos.add(new Recibo("SAT004", 1450.20, true));
        satRecibos.add(new Recibo("SAT005", 1100.75, false));

        // TELMEX (Servicio de Teléfono y Internet)
        List<Recibo> telmexRecibos = new ArrayList<>();
        telmexRecibos.add(new Recibo("TELMEX001", 350.40, true));
        telmexRecibos.add(new Recibo("TELMEX002", 420.50, false));
        telmexRecibos.add(new Recibo("TELMEX003", 330.90, true));
        telmexRecibos.add(new Recibo("TELMEX004", 280.75, false));
        telmexRecibos.add(new Recibo("TELMEX005", 500.60, true));

        Map<String, List<Recibo>> servicios = new HashMap<String, List<Recibo>>();

        servicios.put("CFE", cfeRecibos);
        servicios.put("AGUA", aguaRecibos);
        servicios.put("SAT", satRecibos);
        servicios.put("TELMEX", telmexRecibos);
        //Caso donde el recibo ya se habia pagado antes
        //Ticket t9 = prac.pagarServicio("AGUA","AGUA003");
        //System.out.println(t9);
try {
    Ticket t10 = prac.pagarServicio("CFE","CFE004");
    System.out.println(t10);
}catch (Exception ex){
    System.out.println(ex.getMessage());
}

    }
}