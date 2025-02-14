import java.util.Arrays;

public class Diseñador extends Empleado {

    String[] diasEntregas;
    String[] agenda;

    public Diseñador() {

    }

    public Diseñador(String nombre, int numEmpleado, double salario, int diasVacaciones, String[] diasEntregas, String[] agenda) {
        super(nombre, numEmpleado, salario, diasVacaciones);
        this.diasEntregas = diasEntregas;
        this.agenda = agenda;
    }

    public String[] getDiasEntregas() {
        return diasEntregas;
    }

    public void setDiasEntregas(String[] diasEntregas) {
        this.diasEntregas = diasEntregas;
    }

    public String[] getAgenda() {
        return agenda;
    }

    public void setAgenda(String[] agenda) {
        this.agenda = agenda;
    }

    @Override
    public String toString() {
        return "Diseñador{" +
                "diasEntregas=" + Arrays.toString(diasEntregas) +
                ", agenda=" + Arrays.toString(agenda) +
                ", Nombre='" + Nombre + '\'' +
                ", numEmpleado=" + numEmpleado +
                ", salario=" + salario +
                ", diasVacaciones=" + diasVacaciones +
                '}';
    }
}
