import com.logic.Basico;
import com.logic.Cajero;
import com.logic.Practicaja;
import com.models.Cuenta;
import com.models.RetiroSinTarjeta;
import com.models.Ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        //20 cuentas
        //Lista de cuentas
        //private static ArrayList<Cuenta> cuentas = new ArrayList<>();
        Cuenta ct1 = new Cuenta("12345","Ramon",2334000,1000000,100);
        Cuenta ct2 = new Cuenta("12346","Iván",174440,1000000,100);
        Cuenta ct3 = new Cuenta("12347","Oscar",45600,1000000,100);
        Cuenta ct4 = new Cuenta("12348","Juan",22220,1000000,100);
        Cuenta ct5 = new Cuenta("12349","Pedro",5643000,1000000,100);
        Cuenta ct6 = new Cuenta("12340","Kala",2220,1000000,100);
        Cuenta ct7 = new Cuenta("12315","Fanny",1500,1000000,100);
        Cuenta ct8 = new Cuenta("12325","Diana",188000,1000000,100);
        Cuenta ct9 = new Cuenta("12335","Pepe",17770,1000000,100);
        Cuenta ct10 = new Cuenta("12445","Emilio",56450,1000000,100);
        Cuenta ct11 = new Cuenta("12545","Abigil",456300,1000000,100);
        Cuenta ct12 = new Cuenta("12645","Leslie",1111111,10000000,100);
        Cuenta ct13 = new Cuenta("12745","Leydi",16660,1000000,100);
        Cuenta ct14 = new Cuenta("12845","Eduardo",666,1000000,100);
        Cuenta ct15 = new Cuenta("12945","Anna",7777,1000000,100);
        Cuenta ct16 = new Cuenta("12045","Paola",88888,1000000,100);
        Cuenta ct17 = new Cuenta("13345","Ximena",999999,1000000,100);
        Cuenta ct18 = new Cuenta("14345","Cesar",122,1000000,100);
        Cuenta ct19 = new Cuenta("15345","Daniela",175656,1000000,100);
        Cuenta ct20 = new Cuenta("16345","Brandon",1700000,10000000,100);

        List<Cuenta> dataBase = new ArrayList<>();
        dataBase.add(ct1);
        dataBase.add(ct2);
        dataBase.add(ct3);
        dataBase.add(ct4);
        dataBase.add(ct5);
        dataBase.add(ct6);
        dataBase.add(ct7);
        dataBase.add(ct8);
        dataBase.add(ct9);
        dataBase.add(ct10);
        dataBase.add(ct11);
        dataBase.add(ct12);
        dataBase.add(ct13);
        dataBase.add(ct14);
        dataBase.add(ct15);
        dataBase.add(ct16);
        dataBase.add(ct17);
        dataBase.add(ct18);
        dataBase.add(ct19);
        dataBase.add(ct20);

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

        Basico bas=new Basico();
        Practicaja pract = new Practicaja();
        pract.setUbicacion("boulevard 5de Mayo #1890");
        bas.setUbicacion("Boulevrd 5de Mayo #1890");
        //cargo de la db de los retiros sib tarjeta
        bas.setRetiroSinTajetaDb(retiros);
        pract.setRetiroSinTajetaDb(retiros);
        //Ejecuta el metodo retiroSinTarjeta y guarda el ticket
        // Ticket ticket =bas.retiroSinTarjeta();
        //Ticket ticket1=pract.retiroSinTarjeta();
        //System.out.println(ticket);
        //System.out.println(ticket1);

        pract.setCuentasDB(dataBase);

        Ticket ticket3 = (Ticket) pract.retirar("15345",176555)[0];
        System.out.println(ticket3);

        Ticket ticket4 = pract.depositar("14345",2000);
        System.out.println(ticket4);

        Ticket t8 = pract.transferir("C009", "C001",7500);
        System.out.println(t8);

 /*       Cajero c =new Cajero("Av. juarez 5298",50,dataBase);

        Object[] data =c.buscar("14345");
        System.out.println(data[0]);

        Ticket t = c.consultarSaldo("14345");
        System.out.println(t);*/

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
        telmexRecibos.add(new Recibo("TELMEX005", 500.60, true));

        Map<String, List<Recibo>> servicios =
        pract.setRecibosDB;

        Ticket T11 = pract.pagarServicio("TELCEL","CFE005");

    }
}
