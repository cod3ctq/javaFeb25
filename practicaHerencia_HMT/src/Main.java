//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Perro perro1 = new Perro("Rocky", 5, "pastor aleman");
        Gato gato1 = new Gato("Nena", 2, "blanca");

        perro1.comer();
        perro1.hacerSonido();
        System.out.println(perro1);

        gato1.dormir();
        gato1.hacerSonido();
        System.out.println(gato1);

    }
}