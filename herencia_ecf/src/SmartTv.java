import java.util.Arrays;

public class SmartTv extends Television{


String sistemaOperativo;
String[] conectividad;
double almacenamiento;


public SmartTv(){

}

    public SmartTv(String msrca, String resolucion, double tamaño, double precio, String sistemaOperativo, String[] conectividad, double almacenamiento) {
        super(msrca, resolucion, tamaño, precio);
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
                ", msrca='" + msrca + '\'' +
                ", resolucion='" + resolucion + '\'' +
                ", tamaño=" + tamaño +
                ", precio=" + precio +
                ", canalActual=" + canalActual +
                ", volumenActual=" + volumenActual +
                '}';
    }

    @Override //<-- indica sobreescritura
    public void cambiarCanal(int nuevoCanal){
        if (nuevoCanal<1 || nuevoCanal>100){
            System.out.println("No existe este canal");
        }else{
            this.canalActual=nuevoCanal;
        }

        this.canalActual = nuevoCanal;
        System.out.println("Canal: "+this.canalActual);

    }



    //La herencia se compone de 2 cosas la especializacion y la reutilizacion de codigo
}

