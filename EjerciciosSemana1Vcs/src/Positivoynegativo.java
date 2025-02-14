import java.util.Scanner;

public class Positivoynegativo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[20];
        int sumatoriaPositivos = 0;
        int sumatoriaImpares = 0;

        for (int i = 0; i < 20; i++) {
            System.out.println("Ingrese el número " + (i + 1));
            numeros[i] = scanner.nextInt();

            if (numeros[i] > 0) {
                System.out.println("El número " + numeros[i] + " es positivo");
                sumatoriaPositivos += numeros[i];
            } else if (numeros[i] < 0) {
                System.out.println("El número " + numeros[i] + " es negativo");
            }

            if (numeros[i] % 2 == 0) {
                System.out.println("El número " + numeros[i] + " es par");
            } else {
                System.out.println("El número " + numeros[i] + " es impar");
                sumatoriaImpares += numeros[i];
            }
        }

        System.out.println("La sumatoria de los positivos es: " + sumatoriaPositivos);
        System.out.println("La sumatoria de los impares es: " + sumatoriaImpares);

        scanner.close();
    }
}

