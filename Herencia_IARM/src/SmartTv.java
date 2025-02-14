import java.util.Arrays;

public class SmartTv extends Television {
    String sistemaOperativo;
    String[] conectividad;
    double almacenamiento;

    public SmartTv (){

    }

    public SmartTv(String marca, String resolucion, double tamaño, double precio, String sistemaOperativo, String[] conectividad, double almacenamiento) {
        super(marca, resolucion, tamaño, precio);
        this.sistemaOperativo = sistemaOperativo;
        this.conectividad = conectividad;
        this.almacenamiento = almacenamiento;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public String[] getConectividad() {
        return conectividad;
    }

    public void setConectividad(String[] conectividad) {
        this.conectividad = conectividad;
    }

    public double getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(double almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    @Override
    public String toString() {
        return "SmartTv{" +
                "sistemaOperativo='" + sistemaOperativo + '\'' +
                ", conectividad=" + Arrays.toString(conectividad) +
                ", almacenamiento=" + almacenamiento +
                ", marca='" + marca + '\'' +
                ", resolucion='" + resolucion + '\'' +
                ", tamaño=" + tamaño +
                ", precio=" + precio +
                ", canalActual=" + canalActual +
                ", volumenActual=" + volumenActual +
                '}';
    }
    /*se aplica sobreescritura, es parte del polimorfismo
    el polimorfismo incluye a la sobreescritura (cambiar la logica )
    en este caso la clase hija puede hacerlo de manera particular
    */
    @Override //indica sobrescritura
    //este manual sirve para que el siguiente programador sepa que aqui se sobrescribio, como saber que o de donde se sobrescribio?, por la parte extends al principio

    public void cambiarCanal(int nuevoCanal){
        if(nuevoCanal<1 ||  nuevoCanal>100){
            System.out.println("No existe ese canal");
        }else {
        System.out.println("Canal: ++++++++++++++++++"+this.canalActual);
    }
    }

}
