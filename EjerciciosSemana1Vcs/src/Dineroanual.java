import java.util.Scanner;

public class Dineroanual {
    public static void main(String[] args) {
        double donacion;
        double centroSalud;
        double comedorNinos;
        double bolsa;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el monto de la donación:");
        donacion = scanner.nextDouble();
        if (donacion >= 10000) {
            centroSalud = donacion * 0.3;
            comedorNinos = donacion * 0.5;
            bolsa = donacion * 0.2;
        } else {
            centroSalud = donacion * 0.25;
            comedorNinos = donacion * 0.6;
            bolsa = donacion * 0.15;
        }
        System.out.println("La cantidad de dinero que se destinará al centro de salud es: $" + centroSalud);
        System.out.println("La cantidad de dinero que se destinará al comedor de niños es: $" + comedorNinos);
        System.out.println("La cantidad de dinero que se invertirá en la bolsa es: $" + bolsa);

        scanner.close();
    }
}

