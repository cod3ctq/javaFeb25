//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Television tv1 = new Television("Sony","FULL HD",90000,50);

        tv1.cambiarCanal(20);
        tv1.subirVolumen();
        tv1.bajarVolumen();


        SmartTv sm1 = new SmartTv();
        sm1.cambiarCanal(20);
        sm1.subirVolumen();
        sm1.bajarVolumen();

        String[] con = {"Wifi 6","Bluetooth 5.3","DLNA","NFC"};
        SmartTv sm2 = new SmartTv("SAMSUNG","4K",15000,90,"ANDROID TV",con,500);
        sm2.cambiarCanal(105);
        sm2.subirVolumen();
        sm2.bajarVolumen();

        System.out.println(tv1);
        System.out.println(sm2);

    }
}