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

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Cuenta> dataBase = new ArrayList<>();

        Cuenta cuenta1 = new Cuenta("C001", "Juan Perez", 1500.50, 5000.00, 100.00);
        Cuenta cuenta2 = new Cuenta("C002", "Maria Gomez", 2300.75, 7000.00, 200.00);
        Cuenta cuenta3 = new Cuenta("C003", "Carlos Ruiz", 1200.00, 6000.00, 150.00);
        Cuenta cuenta4 = new Cuenta("C004", "Laura Martinez", 3300.20, 8000.00, 250.00);
        Cuenta cuenta5 = new Cuenta("C005", "Pedro Garcia", 4500.60, 10000.00, 300.00);
        Cuenta cuenta6 = new Cuenta("C006", "Ana Lopez", 3100.50, 9000.00, 180.00);
        Cuenta cuenta7 = new Cuenta("C007", "Luis Torres", 5000.40, 11000.00, 350.00);
        Cuenta cuenta8 = new Cuenta("C008", "Elena Perez", 6200.90, 12000.00, 400.00);
        Cuenta cuenta9 = new Cuenta("C009", "Ricardo Diaz", 8000.00, 13000.00, 500.00);
        Cuenta cuenta10 = new Cuenta("C010", "Isabel Fernandez", 10000.00, 14000.00, 600.00);
        Cuenta cuenta11 = new Cuenta("C011", "Fernando Martin", 1500.20, 7000.00, 100.00);
        Cuenta cuenta12 = new Cuenta("C012", "Paula Gonzalez", 4500.90, 10000.00, 200.00);
        Cuenta cuenta13 = new Cuenta("C013", "Victor Sanchez", 1800.10, 8000.00, 150.00);
        Cuenta cuenta14 = new Cuenta("C014", "Raquel Herrera", 2900.50, 9000.00, 220.00);
        Cuenta cuenta15 = new Cuenta("C015", "Javier Ruiz", 2200.80, 9500.00, 180.00);
        Cuenta cuenta16 = new Cuenta("C016", "Carmen Silva", 3700.70, 11000.00, 280.00);
        Cuenta cuenta17 = new Cuenta("C017", "Miguel Castro", 4100.40, 12000.00, 300.00);
        Cuenta cuenta18 = new Cuenta("C018", "Sofia Morales", 3300.00, 10500.00, 220.00);
        Cuenta cuenta19 = new Cuenta("C019", "Antonio Alvarez", 5300.60, 11500.00, 350.00);
        Cuenta cuenta20 = new Cuenta("C020", "Pablo Martinez", 4600.30, 12500.00, 280.00);


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

       // Cajero c = new Cajero("Av. juarez 5298",50,dataBase);

       /* Object[] data = c.buscar("C020" );
        System.out.println(data[0]);
        System.out.println(data[1]);

        Ticket t = c.consultarSaldo("C020");
        System.out.println(t);*/

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
        Practicaja pract = new Practicaja();
        bas.setUbicacion("Boulevard 5 de mayo #1890");
        pract.setUbicacion("Boulevard 5 de mayo #1890");


        // CFE (Comisión Federal de Electricidad)
        ArrayList<Recibo> cfeRecibos = new ArrayList<>();
        cfeRecibos.add(new Recibo("CFE001", 320.50, false));
        cfeRecibos.add(new Recibo("CFE002", 450.75, true));
        cfeRecibos.add(new Recibo("CFE003", 590.00, false));
        cfeRecibos.add(new Recibo("CFE004", 295.30, true));
        cfeRecibos.add(new Recibo("CFE005", 730.10, false));

        // AGUA (Servicio de Agua Potable)
        ArrayList<Recibo> aguaRecibos = new ArrayList<>();
        aguaRecibos.add(new Recibo("AGUA001", 180.60, true));
        aguaRecibos.add(new Recibo("AGUA002", 210.40, false));
        aguaRecibos.add(new Recibo("AGUA003", 265.90, true));
        aguaRecibos.add(new Recibo("AGUA004", 150.80, false));
        aguaRecibos.add(new Recibo("AGUA005", 190.20, true));

        // SAT (Servicio de Administración Tributaria)
        ArrayList<Recibo> satRecibos = new ArrayList<>();
        satRecibos.add(new Recibo("SAT001", 1200.50, false));
        satRecibos.add(new Recibo("SAT002", 700.00, true));
        satRecibos.add(new Recibo("SAT003", 980.30, false));
        satRecibos.add(new Recibo("SAT004", 1450.20, true));
        satRecibos.add(new Recibo("SAT005", 1100.75, false));

        // TELMEX (Servicio de Teléfono y Internet)
        ArrayList<Recibo> telmexRecibos = new ArrayList<>();
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

        //carga la DB de servicios a la pracricaja
        pract.setReciboDB(servicios);

        //en este caso este recibo relacionado ha este convenio ya habia sido pagado
        try {
            Ticket t9 = pract.pagarServicio("AGUA", "AGUA003");
            System.out.println(t9);
        } catch (Exception ex){
            System.out.println(ex.getMessage());//este es mensaje
            ex.printStackTrace();// muestra la excepcion
        }



        // cargo la DB de los retiros sin tarjeta
        bas.setRetiroSinTarjeta(retiros);
        pract.setRetiroSinTarjeta(retiros);
        // ejecuto el metodo retiroSinTarjeta y guardo el ticket resultante
        //  Ticket ticket = bas.retiroSinTarjeta();
        // System.out.println(ticket);

        // ejecuto el metodo retiroSinTarjeta y guardo el ticket resultante
        //     Ticket ticket2 = pract.retiroSinTarjeta();
        //   System.out.println(ticket);

        // carga la base de datos (lista) de cuentas en la practicaja
        pract.setCuentasDB(dataBase);
        Ticket t3 = (Ticket) pract.retirar("C015",200)[0];
        System.out.println(t3);


        pract.setCuentasDB(dataBase);
        Ticket t4 = pract.depositar("C015",1200);
        System.out.println(t4);


       // Cuenta cuenta12 = new Cuenta("C012", "Paula Gonzalez", 4500.90, 10000.00, 200.00);
       // Cuenta cuenta13 = new Cuenta("C013", "Victor Sanchez", 1800.10, 8000.00, 150.00);
        // transfiero una cantidad de una cuenta a otra en este caso no deberia ser posible porque
        // no cuenta con la  cantidad suficiente
        //Ticket t5 = pract.transferir("C012", "C013", 5000);

        //En este caso si me alcanza pero quedaria por debajo del minimo
        //Ticket t6 = pract.transferir("C012", "C013", 4000);

        //en este punto si deberia dejarme poder hacer la transefeerencia
        //Ticket t7 = pract.transferir("C012", "C013", 1000);

        Ticket t8 = pract.transferir("C009","C001",7500);

        System.out.println(t8);

    }
}