public class Futbolista extends Seleccion {

    int numero_camiseta;
    String posicion;

    public Futbolista(){

    }

    public Futbolista(int id, String nombre, String apellidos, int edad, String concentrarse, String viajar, int numero_camiseta, String posicion) {
        super(id, nombre, apellidos, edad, concentrarse, viajar);
        this.numero_camiseta = numero_camiseta;
        this.posicion = posicion;
    }


    public int getNumero_camiseta() {
        return numero_camiseta;
    }

    public void setNumero_camiseta(int numero_camiseta) {
        this.numero_camiseta = numero_camiseta;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    @Override
    public String toString() {
        return "Futbolista{" +
                "numero_camiseta=" + numero_camiseta +
                ", posicion='" + posicion + '\'' +
                ", id=" + id +
                ", nombre='" + nombre + '\'' +
                ", Apellidos='" + Apellidos + '\'' +
                ", Edad=" + Edad +
                ", concentrarse='" + concentrarse + '\'' +
                ", viajar='" + viajar + '\'' +
                '}';
    }
}
