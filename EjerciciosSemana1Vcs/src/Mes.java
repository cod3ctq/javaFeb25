import java.util.Scanner;
public class Mes {
    public static void main(String[] args) {
        int mes;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese un número entero entre uno y doce:");
        mes = scanner.nextInt();

        if (mes >= 1 && mes <= 12) {
            System.out.println("El mes " + obtenerMes(mes) + " tiene " + obtenerDias(mes) + " días.");
        } else {
            System.out.println("ERROR: número no válido");
        }
        scanner.close();
    }
    public static String obtenerMes(int mes) {
        switch (mes) {
            case 1:
                return "Enero";
            case 2:
                return "Febrero";
            case 3:
                return "Marzo";
            case 4:
                return "Abril";
            case 5:
                return "Mayo";
            case 6:
                return "Junio";
            case 7:
                return "Julio";
            case 8:
                return "Agosto";
            case 9:
                return "Septiembre";
            case 10:
                return "Octubre";
            case 11:
                return "Noviembre";
            case 12:
                return "Diciembre";
            default:
                return "";
        }
    }

    public static int obtenerDias(int mes) {
        switch (mes) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                return 28;
            default:
                return 0;
        }
    }
}
