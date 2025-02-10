import java.util.Scanner;
public class Dado {
    public static void main(String[] args) {
        int resultado;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el resultado obtenido al lanzar el dado:");
        resultado = scanner.nextInt();

        if (resultado < 1 || resultado > 6) {
            System.out.println("ERROR: número incorrecto");
        } else {
            int caraOpuesta = calcularCaraOpuesta(resultado);

            System.out.println("La cara opuesta al resultado obtenido es: " + obtenerLetras(caraOpuesta));
        }

        scanner.close();
    }
    public static int calcularCaraOpuesta(int resultado) {
        switch (resultado) {
            case 1:
                return 6;
            case 2:
                return 5;
            case 3:
                return 4;
            case 4:
                return 3;
            case 5:
                return 2;
            case 6:
                return 1;
            default:
                return 0;
        }
    }
    public static String obtenerLetras(int numero) {
        switch (numero) {
            case 1:
                return "Uno";
            case 2:
                return "Dos";
            case 3:
                return "Tres";
            case 4:
                return "Cuatro";
            case 5:
                return "Cinco";
            case 6:
                return "Seis";
            default:
                return "";
        }
    }
}
