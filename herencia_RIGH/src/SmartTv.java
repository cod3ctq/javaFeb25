import java.util.Arrays;

public class SmartTv extends Television{
    String sistemaOp;
    String[] conectividad;
    double alamcenamiento;

    public SmartTv(){

    }

    public SmartTv(String marca, String resolucion, double tamaño, double precio, String sistemaOp, String[] conectividad, double alamcenamiento) {
        super(marca, resolucion, tamaño, precio);
        this.sistemaOp = sistemaOp;
        this.conectividad = conectividad;
        this.alamcenamiento = alamcenamiento;
    }

    public String getSistemaOp() {
        return sistemaOp;
    }
    public void setSistemaOp(String sistemaOp) {
        this.sistemaOp = sistemaOp;
    }
    public String[] getConectividad() {
        return conectividad;
    }
    public void setConectividad(String[] conectividad) {
        this.conectividad = conectividad;
    }
    public double getAlamcenamiento() {
        return alamcenamiento;
    }
    public void setAlamcenamiento(double alamcenamiento) {
        this.alamcenamiento = alamcenamiento;
    }

    @Override
    public String toString() {
        return "SmartTv{" +
                "sistemaOp='" + getSistemaOp() + '\'' +
                ", conectividad=" + Arrays.toString(getConectividad()) +
                ", alamcenamiento=" + getAlamcenamiento() +
                ", marca='" + getMarca() + '\'' +
                ", resolucion='" + getResolucion() + '\'' +
                ", tamaño=" + getTamaño() +
                ", precio=" + getPrecio() +
                ", canalActual=" + canalActual +
                ", volumenActual=" + volumenActual +
                ", marca='" + getMarca() + '\'' +
                ", resolucion='" + getResolucion() + '\'' +
                ", tamaño=" + getTamaño() +
                ", precio=" + getPrecio() +
                '}';
    }

    @Override   //Indica sobreescritura
    public void cambiarCanal(int nuevoCanal){         //polimorfismo -- sobreesritura
        if (nuevoCanal<1 || nuevoCanal>100){
            System.out.println("no existe canal");
        }else {
            this.canalActual = nuevoCanal;
            System.out.println("Canal: " + this.canalActual);
        }
    }
}
