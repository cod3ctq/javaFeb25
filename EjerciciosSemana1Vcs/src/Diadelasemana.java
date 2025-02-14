import java.util.Scanner;
public class Diadelasemana {
    public static void main(String[] args) {
    int dia;
    Scanner scanner = new Scanner(System.in);

    System.out.println("Ingrese el día de la semana (del 1 al 7):");
    dia = scanner.nextInt();

    if (dia >= 1 && dia <= 7) {
        System.out.println("El día correspondiente es: " + obtenerDia(dia));
    } else {
        System.out.println("ERROR: día no válido");
    }
    scanner.close();
}
    public static String obtenerDia(int dia) {
        switch (dia) {
            case 1:
                return "Lunes";
            case 2:
                return "Martes";
            case 3:
                return "Miércoles";
            case 4:
                return "Jueves";
            case 5:
                return "Viernes";
            case 6:
                return "Sábado";
            case 7:
                return "Domingo";
            default:
                return "";
        }
    }
}

