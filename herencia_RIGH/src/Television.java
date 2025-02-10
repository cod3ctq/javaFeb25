public class Television {
    String marca;
    String resolucion;
    double tamaño;
    double precio;
    //smart
    int canalActual;
    int volumenActual;

    public Television(){

    }

    public Television(String marca, String resolucion, double tamaño, double precio) {
        this.marca = marca;
        this.resolucion = resolucion;
        this.tamaño = tamaño;
        this.precio = precio;
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
                "marca='" + getMarca() + '\'' +
                ", resolucion='" + getResolucion() + '\'' +
                ", tamaño=" + getTamaño() +
                ", precio=" + getPrecio() +
                '}';
    }

    //métodos
    public void cambiarCanal(int nuevoCanal){         //estructira de setter
        this.canalActual = nuevoCanal;
        System.out.println("Cnala: "+this.canalActual);
    }
    public void subirVolument(){
        this.volumenActual++;
        System.out.println("Volumen: "+this.volumenActual);
    }
    public void bajrVolument() {
        this.volumenActual--;
        System.out.println("Volumen: "+this.volumenActual);
    }
}
