public class Main {
    public static void main(String[] args) {
        Television tv1 = new Television("Sony", "FULL HD", 9000.00, 50);
        tv1.cambiarCanal(1);
        tv1.subirVolumen();
        tv1.bajarVolumen();

        SmartTV sm1 = new SmartTV();
        sm1.cambiarCanal(20);
        sm1.subirVolumen();
        sm1.bajarVolumen();

        String[] con = {"Wifi 6", "Bluetooth 5.3", "DLNA", "NFC"};
        SmartTV sm2 = new SmartTV("SAMSUNG", "4K", 90, 15000, "ANDOID", con,500);
        sm2.cambiarCanal(10);
        sm2.subirVolumen();
        sm2.bajarVolumen();

    }
}