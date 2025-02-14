import java.util.Arrays;

public class Empleado {

    String Nombre;
    int numEmpleado;
    double salario;
    int diasVacaciones;

   public Empleado() {

   }

    public Empleado(String nombre, int numEmpleado, double salario, int diasVacaciones) {
        Nombre = nombre;
        this.numEmpleado = numEmpleado;
        this.salario = salario;
        this.diasVacaciones = diasVacaciones;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(int numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getDiasVacaciones() {
        return diasVacaciones;
    }

    public void setDiasVacaciones(int diasVacaciones) {
        this.diasVacaciones = diasVacaciones;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "Nombre='" + Nombre + '\'' +
                ", numEmpleado=" + numEmpleado +
                ", salario=" + salario +
                ", diasVacaciones=" + diasVacaciones +
                '}';
    }
}
