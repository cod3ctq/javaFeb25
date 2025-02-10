public class Main {
    public static void main(String[] args) {
/*
        Television tv1 = new Television("sony","Full HD",86,20000);
        tv1.cambiarCanal(20);
        tv1.subirVolumen();
        tv1.bajarVolumen();

        Smartv sm1 = new Smartv();
        sm1.cambiarCanal(22);
        sm1.subirVolumen();
        sm1.bajarVolumen();

        String [] con = {"wifi 6", "bLUetooth 5.3", "DLNA","NFC"};
        Smartv sm2 = new Smartv("Samsung","4k",86,30000,"Android",con, 500);
        sm2.cambiarCanal(10);
        sm2.subirVolumen();
        sm2.bajarVolumen();

        System.out.println(tv1);
        System.out.println(sm2);
        System.out.println();
    }

 */
        Telefono tel1= new Telefono("Panasonic","alambrico",4,600);

        smartphone smp1= new smartphone();

        smartphone smp2= new smartphone("Iphone","5G",7,18000,7.2,"iOS",500,4);

        System.out.println(tel1);
        System.out.println(smp2);
    }
}