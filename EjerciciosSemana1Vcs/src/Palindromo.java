import java.util.Scanner;

public class Palindromo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese una palabra:");
        String cadena = scanner.nextLine();

        boolean esPalindromo = esPalindromo(cadena);

        if (esPalindromo) {
            System.out.println("La cadena es palíndromo.");
        } else {
            System.out.println("La cadena no es palíndromo.");
        }
        scanner.close();
    }

    public static boolean esPalindromo(String cadena) {
        cadena = cadena.replaceAll("\\s+", "").toLowerCase();

        String inversa = new StringBuilder(cadena).reverse().toString();
        return cadena.equals(inversa);
    }
}

