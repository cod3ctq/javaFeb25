public class Main {
    public static void main(String[] args) {
    /*Television tv1 = new Television("Sony","Full HD",86,602);

    //herencia se compone de dos partes la primera realizacion de codigo y la segunda especializacion

    tv1.cambiarCanal(20);
    tv1.subirVolumen();
    tv1.bajarVolumen();

        SmartTv sm1 = new SmartTv();
        sm1.cambiarCanal(25);
        sm1.subirVolumen();
        sm1.bajarVolumen();

        String[] con={"Wifi 6", "Bluethooth 5.3", "DLNA","NFC"};
        SmartTv sm2 = new SmartTv("SAMSUNG","4K",90,15000,
                "ANDROID",con,500);

        sm2.cambiarCanal(10);
        sm2.subirVolumen();
        sm2.bajarVolumen();
        sm2.getSistemaoperativo();

         System.out.println(tv1);
        System.out.println(sm2);
     */
        Carros1990 c1= new Carros1990("Manual","acero",1.6,300000);
        Carros2025 c2=new Carros2025("Bluethooth","aluminio",2.0,500000,"turbo doble",
                "Seguridad", "Carga electrica");
        System.out.println(c1);
        System.out.println(c2);

    }


}