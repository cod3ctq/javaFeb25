public class Main {
    public static void main(String[] args) {
//        Television tv1 = new Television("Sony","Full HD",50,9000);
//
//        tv1.cambiarCanal(20);
//        tv1.subirVolument();
//        tv1.bajrVolument();
//
//        String[] con ={"wifi 6","bluetooth 5.3","DLNA","NFC"};
//        SmartTv sm1 = new SmartTv();
//        SmartTv sm2 =new SmartTv("samsung","4k",90,15000,"Android",con,500);
//
//        sm2.cambiarCanal(10);
//        sm2.subirVolument();
//        sm2.bajrVolument();

        Coche co1 =new Coche("VW polo","2020","azul");
        String[] patros ={"monster","McLaren","RedBull","michelin","shell","momo"};
        ChocheCarreras CoC1 = new ChocheCarreras("Ferrari","2022","rojo",
                "F1","Commins",patros);

        co1.relacionPesoPot(1155,292);

    }
}