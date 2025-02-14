import java.util.Scanner;
public class CostoKilogramo {
    public static void main(String[] args) {
        int zona;
        double peso;
        double costo;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la zona de destino (1-5):");
        zona = scanner.nextInt();

        System.out.println("Ingrese el peso del paquete (en kg):");
        peso = scanner.nextDouble();

        if (peso > 5) {
            System.out.println("ERROR: el paquete no puede ser transportado debido a su peso.");
        } else {
            costo = calcularCosto(zona, peso);

            System.out.println("El costo de la entrega es: " + costo + " euros.");
        }
        scanner.close();
    }
    public static double calcularCosto(int zona, double peso) {
        double costo = 0;

        switch (zona) {
            case 1:
                costo = peso * 24.00;
                break;
            case 2:
                costo = peso * 20.00;
                break;
            case 3:
                costo = peso * 21.00;
                break;
            case 4:
                costo = peso * 10.00;
                break;
            case 5:
                costo = peso * 18.00;
                break;
            default:
                System.out.println("ERROR: zona no válida.");
                break;
        }

        return costo;
    }
}
