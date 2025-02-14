import java.util.Arrays;

public class SmartTv extends Television {

    String sistemaoperativo;
    String []conectividad; //composicion
    double almacenamiento;

    public SmartTv(){

    }

    public SmartTv(String marca, String resolucion, double tamaño, double precio, String sistemaoperativo, String[] conectividad, double almacenamiento) {
        super(marca, resolucion, tamaño, precio);
        this.sistemaoperativo = sistemaoperativo;
        this.conectividad = conectividad;
        this.almacenamiento = almacenamiento;
    }

    public String getSistemaoperativo() {
        return sistemaoperativo;
    }

    public void setSistemaoperativo(String sistemaoperativo) {
        this.sistemaoperativo = sistemaoperativo;
    }

    public double getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(double almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    public String[] getConectividad() {
        return conectividad;
    }

    public void setConectividad(String[] conectividad) {
        this.conectividad = conectividad;
    }

    @Override
    public String toString() {
        return "SmartTv{" +
                "sistemaoperativo='" + sistemaoperativo + '\'' +
                ", conectividad=" + Arrays.toString(conectividad) +
                ", almacenamiento=" + almacenamiento +
                ", volumenActual=" + volumenActual +
                ", tamaño=" + tamaño +
                ", marca='" + marca + '\'' +
                ", resolucion='" + resolucion + '\'' +
                ", precio=" + precio +
                ", canalActual=" + canalActual +
                '}';
    }
    //POLIMORFISMO
    // El polimorfismo incluye a la sobreescritura (cambiar la logica por una distinta)
    //sobreescritura
    @Override // esto indica sobreesxcritura
    public void cambiarCanal(int nuevoCanal){
       if (nuevoCanal<1 || nuevoCanal>100){
           System.out.println("No existe este canal");
       }
       else {
           this.canalActual = nuevoCanal;
       }
    }
}
