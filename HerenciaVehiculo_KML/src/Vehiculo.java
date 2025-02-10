public class Vehiculo {
    String marca;
    String modelo;
    String placa;
    String color;
    int año;
    boolean encendido;

    public Vehiculo() {

    }

    public Vehiculo(String marca, String modelo, String placa, String color, int año) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.color = color;
        this.año = año;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public boolean isEncendido() {
        return encendido;
    }

    public void setEncendido(boolean encendido) {
        this.encendido = encendido;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", placa='" + placa + '\'' +
                ", color='" + color + '\'' +
                ", año=" + año +
                ", encendido=" + encendido +
                '}';
    }
    public void mostrarInfo(String marca, String modelo, String placa, String color, int año){
        System.out.println("Marca: " + marca + ", Modelo: " + modelo + ", Año: " + año);
    }
    public void Encender(boolean encendido){
        encendido = true;
        System.out.println(encendido);
        }
    public void Apagar(boolean encendido){
        encendido = false;
        System.out.println(encendido);
    }
}


