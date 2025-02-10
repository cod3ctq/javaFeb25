import java.util.Scanner;

public class Obrero {
    public static void main(String[] args) {
        int horasTrabajadas;
        double salario;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese las horas trabajadas:");
        horasTrabajadas = scanner.nextInt();
        salario = calcularSalario(horasTrabajadas);

        System.out.println("Su salario semanal es: $" + salario);
        scanner.close();
    }
    public static double calcularSalario(int horasTrabajadas) {
        double salario = 0;

        if (horasTrabajadas <= 40) {
            salario = horasTrabajadas * 16;
        } else {
            salario = 40 * 16 + (horasTrabajadas - 40) * 20;
        }
        return salario;
    }
}

