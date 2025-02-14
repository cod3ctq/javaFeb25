import java.util.Scanner;

public class MultlipicarIntroducido {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el número para la tabla de multiplicar:");
        int numero = scanner.nextInt();

        System.out.println("Ingrese la iteración deseada:");
        int iteracion = scanner.nextInt();

        System.out.println("Tabla de multiplicar del " + numero + " hasta " + iteracion + ":");
        for (int i = 1; i <= iteracion; i++) {
            int resultado = numero * i;
            System.out.println(numero + " x " + i + " = " + resultado);
        }

        scanner.close();
    }
}

