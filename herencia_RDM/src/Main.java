public class Main {
    public static void main(String[] args) {

        //La herencia se compone dos partes, reutilizacion del codigo y especializacion
        //La herencia no es bidireccional, unicamente de padre a hijo

        /*Television tv1 = new Television("Sony", "FULL HD",
                9000.00, 50);

        tv1.cambiarCanal(20);
        tv1.subirVolumen();
        tv1.bajarVolumen();

        SmartTv sm1 = new SmartTv();
        sm1.cambiarCanal(25);
        sm1.subirVolumen();
        sm1.bajarVolumen();

        String[] con = {"Wifi 6", "Bluetooth 5.3", "DLNA", "NFC"};

        SmartTv sm2 = new SmartTv("SAMSUNG", "4k", 90, 15000, "Android",
                      con, 500);
        sm2.cambiarCanal(35);
        sm2.subirVolumen();
        sm2.bajarVolumen();
        sm2.getSistemaOperativo();

        //sm2.setMarca(tv1.getMarca());   //

        System.out.println(tv1);
        System.out.println(sm2);*/

        //Ejercicio propio: Reloj

        smartWatch sw1 = new smartWatch( "12 horas", "Digital", "Cuadrado", "Piel",
                        "Cafe", "iOS", "41 mm" );
        System.out.println(sw1);

        relojdeMuñeca rm1 = new relojdeMuñeca( "12 horas", "Digital", "Rectangulo",
                "Acero Inoxidable", "Dorado");
        System.out.println(rm1);

    }
}