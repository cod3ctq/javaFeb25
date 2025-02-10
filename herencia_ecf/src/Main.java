//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Television tv1 = new Television("Sony", "FULL HD", 9000.0, 50);


        tv1.cambiarCanal(20);
        tv1.subirVolumen();
        tv1.bajarVolumen();


    SmartTv sm1 = new SmartTv();


    sm1.bajarVolumen();



    String[] con = {"Wifi 6", "Bluetooth 5.3", "DLNA", "NFC"};

    SmartTv sm2 = new SmartTv("SAMSUNG", "4K", 90, 15000, "Android",con, 500);


        System.out.println(tv1);
        System.out.println(sm2);

    }
}