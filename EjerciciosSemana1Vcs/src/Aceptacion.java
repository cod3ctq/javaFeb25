import java.util.Scanner;

public class Aceptacion {
    public static void main(String[] args) {
        int edad;
        int nota;
        char sexo;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese su edad:");
        edad = scanner.nextInt();

        System.out.println("Ingrese su nota:");
        nota = scanner.nextInt();

        System.out.println("Ingrese su sexo (M/F):");
        sexo = scanner.next().charAt(0);

        String aceptacion = calcularAceptacion(edad, nota, sexo);

        System.out.println("La aceptación de su solicitud es: " + aceptacion);

        scanner.close();
    }

    public static String calcularAceptacion(int edad, int nota, char sexo) {
        if (edad >= 18 && nota >= 5) {
            if (sexo == 'M') {
                return "POSIBLE";
            } else if (sexo == 'F') {
                return "ACEPTADA";
            }
        }
        return "NO ACEPTADA";
    }
}
