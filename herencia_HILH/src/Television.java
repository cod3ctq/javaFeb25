//QUE :
public class Television {
//atributos genericos
    String marca;
    String resolucion;
    double tamaño;
    double precio;

    int canalActual;
    int volumenActual;

    public Television(){

    }
//Constructor
    public Television(String marca, String resolucion, double tamaño, double precio) {
        this.marca = marca;
        this.resolucion = resolucion;
        this.tamaño = tamaño;
        this.precio = precio;
    }
//Getter Setter
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
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
//ToString
    @Override
    public String toString() {
        return "Television{" +
                "marca='" + marca + '\'' +
                ", resolucion='" + resolucion + '\'' +
                ", tamaño=" + tamaño +
                ", precio=" + precio +
                '}';
    }

    //Comportamiento de las clases
    //Las clases pueden adquirir comportamiento de tres maneras

    /*
    1 - Metodos Nativos ((crear un metodo aqui mismo, desde cero)
    2 - Metodos Heredados (comunmente se sobre escriben)
    3 - Metodos implementados (traidos de interfaces) //
     */

    public void cambiarCanal (int nuevoCanal)
    {
        this.canalActual = nuevoCanal;
        System.out.println("Canal: " +this.canalActual);
    }

    public void subirVolumen()
    {
        this.volumenActual++;
        System.out.println("Volumen: " +this.volumenActual);
    }

    public void bajarVolumen()
    {
        this.volumenActual--;
        System.out.println("Volumen: " +this.volumenActual);
    }



}
