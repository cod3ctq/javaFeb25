import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.printf("Dame un numero");
        double num1= scanner.nextDouble();

        System.out.print("Dame un segundo numero");
        double num2=scanner.nextDouble();

        if (num1>num2) {
            System.out.println("El primer numero (" + num1 + ") es mayor que el segundo numero (" + num2 + ").");
        }else if (num1<num2) {
            System.out.println("El segundo numero (" + num2 + ") es mayor que el primer numero (" + num1 + ").");
        }else {
            System.out.println("Ambos numeros son iguales,");
        }

    }
}