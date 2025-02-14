public class Telefono {
    String marca;
    String conectividad;
    double tamaño;
    double precio;

    public Telefono (){

    }
//constructor
    public Telefono(String marca, String conectividad, double tamaño, double precio) {
        this.marca = marca;
        this.conectividad = conectividad;
        this.tamaño = tamaño;
        this.precio = precio;
    }
    //setters and getters

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getConectividad() {
        return conectividad;
    }

    public void setConectividad(String conectividad) {
        this.conectividad = conectividad;
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
    //tostring

    @Override
    public String toString() {
        return "Telefono{" +
                "marca='" + marca + '\'' +
                ", conectividad='" + conectividad + '\'' +
                ", tamaño=" + tamaño +
                ", precio=" + precio +
                '}';
    }
}
