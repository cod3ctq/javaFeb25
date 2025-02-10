public class Television {
    String marca;
    String resolucion;
    double tamaño;
    double precio;

    int canalActual;
    int volumenActual;

    //
    public Television() {

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
                "marca='" + marca + '\'' +
                ", resolucion='" + resolucion + '\'' +
                ", tamaño=" + tamaño +
                ", precio=" + precio +
                '}';
    }
    //las clases pueden adquirir comportamientos de tres maneras
    /* Metodos
    L_____Nativo
    L_____Heredado(estos se pueden sobreescribir)
    L_____Implementados(Traidos de interfaces )
     //interface es algo mas abstracto
     */
    //esto de abajo es un setter


    public void cambiarCanal(int nuevoCanal){
        this.canalActual= nuevoCanal;
    }
    public void subirVolumen(){
        this.volumenActual++;
        System.out.println("Volumen:------------------"+this.volumenActual);
    }

    public void bajarVolumen(){
        this.volumenActual--;
        System.out.println("Volumen:------------------"+ this.volumenActual);
    }
}