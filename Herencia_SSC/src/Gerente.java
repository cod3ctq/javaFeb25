import java.util.Arrays;

public class Gerente extends Empleado {

    String[] diasReuniones;
    String[] indicaciones;

    public Gerente() {

    }

    public Gerente(String nombre, int numEmpleado, double salario, int diasVacaciones, String[] diasReuniones, String[] indicaciones) {
        super(nombre, numEmpleado, salario, diasVacaciones);
        this.diasReuniones = diasReuniones;
        this.indicaciones = indicaciones;
    }

    public String[] getDiasReuniones() {
        return diasReuniones;
    }

    public void setDiasReuniones(String[] diasReuniones) {
        this.diasReuniones = diasReuniones;
    }

    public String[] getIndicaciones() {
        return indicaciones;
    }

    public void setIndicaciones(String[] indicaciones) {
        this.indicaciones = indicaciones;
    }

    @Override
    public String toString() {
        return "Gerente{" +
                "diasReuniones=" + Arrays.toString(diasReuniones) +
                ", indicaciones=" + Arrays.toString(indicaciones) +
                ", Nombre='" + Nombre + '\'' +
                ", numEmpleado=" + numEmpleado +
                ", salario=" + salario +
                ", diasVacaciones=" + diasVacaciones +
                '}';
    }
}
