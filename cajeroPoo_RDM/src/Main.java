import com.logic.Basico;
import com.logic.Cajero;
import com.logic.Practicaja;
import com.models.Cuenta;
import com.models.Recibo;
import com.models.RetiroSinTarjeta;
import com.models.Ticket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Cuenta cuenta1 = new Cuenta("C001", "Alberto Soto", 8500.00, 15000.00, 500.00);
        Cuenta cuenta2 = new Cuenta("C002", "Lucia Mendez", 6200.50, 13000.00, 400.00);
        Cuenta cuenta3 = new Cuenta("C003", "Raul Fernandez", 7500.30, 14000.00, 300.00);
        Cuenta cuenta4 = new Cuenta("C004", "Clara Castillo", 4300.40, 11000.00, 200.00);
        Cuenta cuenta5 = new Cuenta("C005", "Eduardo Jimenez", 5300.20, 12000.00, 250.00);
        Cuenta cuenta6 = new Cuenta("C006", "Marta Alvarez", 8800.10, 16000.00, 600.00);
        Cuenta cuenta7 = new Cuenta("C007", "Jorge Ruiz", 7100.80, 13500.00, 450.00);
        Cuenta cuenta8 = new Cuenta("C008", "Sonia Perez", 6400.60, 12500.00, 350.00);
        Cuenta cuenta9 = new Cuenta("C009", "Carlos Gutierrez", 5700.70, 14000.00, 300.00);
        Cuenta cuenta10 = new Cuenta("C010", "Cristina Ramos", 7900.90, 14500.00, 500.00);
        Cuenta cuenta11 = new Cuenta("C011", "Miguel Hernandez", 6800.40, 13000.00, 400.00);
        Cuenta cuenta12 = new Cuenta("C012", "Patricia Ruiz", 6200.60, 12000.00, 350.00);
        Cuenta cuenta13 = new Cuenta("C013", "Vicente Torres", 9100.50, 15000.00, 500.00);
        Cuenta cuenta14 = new Cuenta("C014", "Ana Ramirez", 7700.80, 13500.00, 450.00);
        Cuenta cuenta15 = new Cuenta("C015", "Diego Martinez", 8900.90, 16000.00, 600.00);
        Cuenta cuenta16 = new Cuenta("C016", "Ines Castillo", 5500.60, 11500.00, 300.00);
        Cuenta cuenta17 = new Cuenta("C017", "Fernando Alvarez", 6800.10, 12500.00, 350.00);
        Cuenta cuenta18 = new Cuenta("C018", "Marina Sanchez", 7500.30, 14000.00, 400.00);
        Cuenta cuenta19 = new Cuenta("C019", "Tomás López", 9000.00, 16000.00, 500.00);
        Cuenta cuenta20 = new Cuenta("C020", "Esteban Garcia", 8100.40, 15000.00, 600.00);

        List<Cuenta> dataBase = new ArrayList<Cuenta>();
        dataBase.add( cuenta1 );
        dataBase.add( cuenta2 );
        dataBase.add( cuenta3 );
        dataBase.add( cuenta4 );
        dataBase.add( cuenta5 );
        dataBase.add( cuenta6 );
        dataBase.add( cuenta7 );
        dataBase.add( cuenta8 );
        dataBase.add( cuenta9 );
        dataBase.add( cuenta10 );
        dataBase.add( cuenta11 );
        dataBase.add( cuenta12 );
        dataBase.add( cuenta13 );
        dataBase.add( cuenta14 );
        dataBase.add( cuenta15 );
        dataBase.add( cuenta16 );
        dataBase.add( cuenta17 );
        dataBase.add( cuenta18 );
        dataBase.add( cuenta19 );
        dataBase.add( cuenta20 );

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

        List<RetiroSinTarjeta> retiros = new ArrayList<RetiroSinTarjeta>();

        retiros.add( retiro1 );
        retiros.add( retiro2 );
        retiros.add( retiro3 );
        retiros.add( retiro4 );
        retiros.add( retiro5 );
        retiros.add( retiro6 );
        retiros.add( retiro7 );
        retiros.add( retiro8 );
        retiros.add( retiro9 );
        retiros.add( retiro10 );
        retiros.add( retiro11 );
        retiros.add( retiro12 );
        retiros.add( retiro13 );
        retiros.add( retiro14 );
        retiros.add( retiro15 );
        retiros.add( retiro16 );
        retiros.add( retiro17 );
        retiros.add( retiro18 );
        retiros.add( retiro19 );
        retiros.add( retiro20 );

        Basico bas =  new Basico();
        Practicaja pract = new Practicaja();
        pract.setUbicacion( "Boulevard 5 de Mayo #1890" );
        bas.setUbicacion( "Boulevard 5 de Mayo #1890" );
        //cargo la db de los retiros sin tarjeta
        bas.setRetiroSinTarjetaDB( retiros );
        pract.setRetiroSinTarjetaDB( retiros );
        //Ejecuto el metodo retiro sin tarjeta y guardo el ticket resultante
        //Ticket ticket = bas.retiroSinTarjeta();
        //Ticket ticket2 = pract.retiroSinTarjeta();
        //System.out.println(ticket2);

        //Carga la base de datos (lista) de cuentas en la practicaja
        pract.setCuentasDB( dataBase );
        Ticket ticket3 = (Ticket) pract.retirar( "C020", 6500 )[ 0 ];
        //System.out.println(ticket3);

        Ticket ticket4 = pract.depositar( "C020", 10000 );
        //System.out.println(ticket4);

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

        servicios.put( "CFE", cfeRecibos );
        servicios.put( "AGUA", aguaRecibos );
        servicios.put( "SAT", satRecibos );
        servicios.put( "TELMEX", telmexRecibos );

        //Carga la db de servicios a la practicaja
        pract.setRecibosDB( servicios );

        /*Ticket ticket9 = pract.pagarServicio( "AGUA", "AGUA003" );
        System.out.println(ticket9);

        Ticket ticket10 = pract.pagarServicio( "CFE", "CFE005" );
        System.out.println(ticket10);

        Ticket ticket11 = pract.pagarServicio( "TELCEL", "AGUA003" );
        System.out.println(ticket11);

        Ticket ticket5 = pract.transferir( "C012", "C013", 5000 );
        //System.out.println(ticket5);
        */

        try
        {
            Ticket ticket11 = pract.pagarServicio( "TELCEL", "CFE005" );
        }catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }



        /*
        Cajero c = new Cajero( "Av. Juarez 5298", 50, dataBase );
        Object[] data = c.buscar( "C014" );
        //System.out.println(data[ 0 ]);
        //System.out.println(data[ 1 ]);

        Ticket t = c.consultarSaldo( "C020" );
        System.out.println(t);
        */
    }
}