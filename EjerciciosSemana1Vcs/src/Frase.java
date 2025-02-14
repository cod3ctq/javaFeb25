import java.util.Scanner;

public class Frase {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Ingrese una frase:");
    String frase = scanner.nextLine();

    System.out.println("Ingrese una letra:");
    char letra = scanner.next().charAt(0);

    int contador = 0;

    for (int i = 0; i < frase.length(); i++) {
        if (frase.charAt(i) == letra) {
            contador++;
        }
    }

    if (contador > 0) {
        System.out.println("La letra '" + letra + "' se encuentra " + contador + " veces en la frase.");
    } else {
        System.out.println("Carácter no encontrado.");
    }

    scanner.close();
}
}

