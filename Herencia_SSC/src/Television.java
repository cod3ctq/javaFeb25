
//QUE:
public class Television {

    String marca;
    String resolucion;
    double precio;
    double tamaño;

    int canalActual;
    int volumenActual;

    //****;

    public Television() {

    }

    public Television(String marca, String resolucion, double precio, double tamaño) {
        this.marca = marca;
        this.resolucion = resolucion;
        this.precio = precio;
        this.tamaño = tamaño;
    }

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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getTamaño() {
        return tamaño;
    }

    public void setTamaño(double tamaño) {
        this.tamaño = tamaño;
    }

    @Override
    public String toString() {
        return "Television{" +
                "marca='" + marca + '\'' +
                ", resolucion='" + resolucion + '\'' +
                ", precio=" + precio +
                ", tamaño=" + tamaño +
                '}';
    }

    // Pueden adquirir corportamniento de 3 maneras:

    /*
    1.- Métodos nativos
    2.- Métodos heredados (comunmente se sobreescriben)
    3.- Metodos implementados (traidos de interfaces)
    */

    public void cambiarCanal(int nuevoCanal)
    {
        this.canalActual = nuevoCanal;
        System.out.println("Canal Actual: " + canalActual);
    }

    public void subirVolumen()
    {
        this.volumenActual++;
        System.out.println("Volumen: " + volumenActual);
    }

    public void bajarVolumen()
    {
        this.volumenActual--;
        System.out.println("Volumen: " + volumenActual);
    }


}


// La clase public hereda de la clase Object
// La herencia da jerarquias de clases
// Una clase puede heredar a otras clases pero una clase no puede tener herencias de mas de una clase





