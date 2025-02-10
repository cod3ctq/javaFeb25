public class Main {
    public static void main(String[] args) {
    Moto motoMami = new Moto("Kurazai","Atom", "3F9HU","Vino",2018, true);

        System.out.println("Informacion de la moto");
        motoMami.mostrarInfo();
        motoMami.Encender();
        motoMami.Apagar();
    }
}