import java.util.Arrays;

public class SmartTV extends Television{
    String sistemaOperativo;
    String[] conectividad;
    double almacenamiento;

//    public SmartTV(){
//
//    }

    public SmartTV(String marca, String resolucion, double tamaño, double precio, String sistemaOperativo, String[] conectividad, double almacenamiento) {
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
        return "SmartTV{" +
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

    @Override //<-- indica sobreescritura, se sobre escribe el metodo
    
    public void cambiarCanal(int nuevoCanal){
        if(nuevoCanal < 1 || nuevoCanal > 100){
            System.out.println("No existe este canal");
        }else{
            this.canalActual = nuevoCanal;
        }
    }

    /// El polimorfismo incluye a la escritura (cambiar la logica)
}
