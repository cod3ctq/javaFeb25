import java.util.Scanner;
public class Uva {
        public static void main(String[] args) {
            int precioInicial;
            char tipo;
            int tamaño;
            int cantidad;

            Scanner scanner = new Scanner(System.in);

            System.out.println("Ingrese el precio inicial por kilo de uva:");
            precioInicial = scanner.nextInt();

            System.out.println("Ingrese el tipo de uva (A/B):");
            tipo = scanner.next().charAt(0);

            System.out.println("Ingrese el tamaño de la uva (1/2):");
            tamaño = scanner.nextInt();

            System.out.println("Ingrese la cantidad de kilos de uva:");
            cantidad = scanner.nextInt();

            double precioFinal = calcularPrecio(precioInicial, tipo, tamaño);

            double montoTotal = precioFinal * cantidad;

            System.out.println("El precio final por kilo de uva es: $" + precioFinal);
            System.out.println("El monto total que recibirá el productor es: $" + montoTotal);

            scanner.close();
        }

        public static double calcularPrecio(int precioInicial, char tipo, int tamaño) {
            double precioFinal = precioInicial;

            if (tipo == 'A') {
                if (tamaño == 1) {
                    precioFinal += 0.20;
                } else if (tamaño == 2) {
                    precioFinal += 0.30;
                }
            } else if (tipo == 'B') {
                if (tamaño == 1) {
                    precioFinal -= 0.30;
                } else if (tamaño == 2) {
                    precioFinal -= 0.50;
                }
            }

            return precioFinal;
        }
    }
    
