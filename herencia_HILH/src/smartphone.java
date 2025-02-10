public class smartphone extends Telefono {
    //atributos
    double tamañoPantalla;
    String sistemaOperativo;
    double almacenamiento;
    double camaras;

    public smartphone(){
    }
//constructor
    public smartphone(String marca, String conectividad, double tamaño, double precio, double tamañoPantalla, String sistemaOperativo, double almacenamiento, double camaras) {
        super(marca, conectividad, tamaño, precio);
        this.tamañoPantalla = tamañoPantalla;
        this.sistemaOperativo = sistemaOperativo;
        this.almacenamiento = almacenamiento;
        this.camaras = camaras;
    }
    //setters and getters

    public double getTamañoPantalla() {
        return tamañoPantalla;
    }

    public void setTamañoPantalla(double tamañoPantalla) {
        this.tamañoPantalla = tamañoPantalla;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public double getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(double almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    public double getCamaras() {
        return camaras;
    }

    public void setCamaras(double camaras) {
        this.camaras = camaras;
    }
    //tostring

    @Override
    public String toString() {
        return "smartphone{" +
                "tamañoPantalla=" + tamañoPantalla +
                ", sistemaOperativo='" + sistemaOperativo + '\'' +
                ", almacenamiento=" + almacenamiento +
                ", camaras=" + camaras +
                ", marca='" + marca + '\'' +
                ", conectividad='" + conectividad + '\'' +
                ", tamaño=" + tamaño +
                ", precio=" + precio +
                '}';
    }
}
