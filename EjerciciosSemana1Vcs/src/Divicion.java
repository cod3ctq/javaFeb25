import java.util.Scanner;

public class Divicion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el primer número: ");
        double num1 = scanner.nextDouble();

        System.out.print("Introduce el segundo número: ");
        double num2 = scanner.nextDouble();


        if (num2 == 0) {
            System.out.println("Error: No se puede dividir por cero.");
        } else {

            double resultado = num1 / num2;
            System.out.println("El resultado de la división es: " + resultado);
        }

        // Cerrar el scanner
        scanner.close();
    }
}
