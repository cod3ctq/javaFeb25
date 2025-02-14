public class Main {
    public static void main(String[] args) {
        Television tv1 = new Television("Sony","Full ashede",45,9000);

        tv1.cambiarCanal(20);
        tv1.subirVolumen();
        tv1.bajarVolumen();
        SmartTv sm1 = new SmartTv();
        sm1.cambiarCanal(20);
        sm1.subirVolumen();
        sm1.bajarVolumen();
//especializacion, basado en algo que ya existia, se reutiliza el codigo para hacer algo aun mejor o mas complejo
        //la herencia se compone de 2 partes primera la reutilizacion de codigo y la segunda la especializacion
        //Se puede hacer eso, pero perdderia en parte el proposito de la herencia ---->  SmartTv sm2 = new SmartTv(sm1.getMarca(), sm1.getResolucion(), )

        String[] con={"wifi 6", "Bluethoot 5.3", "DLNA", "NFC"};
        SmartTv sm2 = new SmartTv("LG", "4k", 60, 12000, "WebOS",con,16);
        sm2.cambiarCanal(103);
        System.out.println(tv1);
        System.out.println(sm2);
// otro uso de la herencia es la jerarquia
        //hacer otra clase con herencia

        Vehiculo coche= new Vehiculo("Azul",4,4);
        Camion camionCarga = new Camion("Rojo",18, 2, 15000,5, true );
        System.out.println(coche);
        System.out.println(camionCarga);



    }
}