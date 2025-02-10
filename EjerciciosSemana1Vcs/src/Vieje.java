import java.util.Scanner;

public class Vieje {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número de alumnos: ");
        int numAlumnos = scanner.nextInt();

        double costoPorAlumno;
        double costoTotal;

        if (numAlumnos >= 100) {
            costoPorAlumno = 65;
            costoTotal = numAlumnos * costoPorAlumno;
        } else if (numAlumnos >= 50) {
            costoPorAlumno = 70;
            costoTotal = numAlumnos * costoPorAlumno;
        } else if (numAlumnos >= 30) {
            costoPorAlumno = 95;
            costoTotal = numAlumnos * costoPorAlumno;
        } else {
            costoPorAlumno = 4000.0 / numAlumnos;
            costoTotal = 4000;
        }

        System.out.println("Costo total a pagar a la compañía: " + costoTotal + " euros");
        System.out.println("Cada alumno debe pagar: " + costoPorAlumno + " euros");

        scanner.close();
    }
}
