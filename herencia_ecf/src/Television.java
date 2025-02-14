
//QUE:
public class Television {

    String msrca;
    String resolucion;
    double tamaño;
    double precio;


    int canalActual;
    int volumenActual;


    public Television(){

    }

    public Television(String msrca, String resolucion, double tamaño, double precio) {
        this.msrca = msrca;
        this.resolucion = resolucion;
        this.tamaño = tamaño;
        this.precio = precio;
    }

    public String getMsrca() {
        return msrca;
    }

    public void setMsrca(String msrca) {
        this.msrca = msrca;
    }

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public double getTamaño() {
        return tamaño;
    }

    public void setTamaño(double tamaño) {
        this.tamaño = tamaño;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Television{" +
                "msrca='" + msrca + '\'' +
                ", resolucion='" + resolucion + '\'' +
                ", tamaño=" + tamaño +
                ", precio=" + precio +
                '}';
    }

    //Las clases pueden adquirir compartamiento de 3 maneras:
    /*
    1.- Metodos nativos
    2.- Metodos heredados (comunmente se sobreescriben)
    3.- Metodos implementados (traidos de interfaces)

    */

    //Polimorfismo: incluye a la sobre escritura (cambiar la logica
    //La multiherencia no existe en java
    //La clase padre hereda de la clase object
    //Otro uso de la herencia es hacer jerarquias de clases

    public void cambiarCanal(int nuevoCanal){
        this.canalActual = nuevoCanal;
        System.out.println("Canal: "+this.canalActual);

    }

    public void subirVolumen(){
        this.volumenActual++;
        System.out.println("Volumen: "+this.volumenActual);
    }

    public void bajarVolumen(){
        this.volumenActual--;
        System.out.println("Volumen: "+this.volumenActual);
    }




}


