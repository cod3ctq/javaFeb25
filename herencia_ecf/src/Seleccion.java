public class Seleccion {

    int id;
    String nombre;
    String Apellidos;
    int Edad;

    String concentrarse;
    String viajar;

    public Seleccion(){

    }

    public Seleccion(int id, String nombre, String apellidos, int edad, String concentrarse, String viajar) {
        this.id = id;
        this.nombre = nombre;
        Apellidos = apellidos;
        Edad = edad;
        this.concentrarse = concentrarse;
        this.viajar = viajar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    public String getConcentrarse() {
        return concentrarse;
    }

    public void setConcentrarse(String concentrarse) {
        this.concentrarse = concentrarse;
    }

    public String getViajar() {
        return viajar;
    }

    public void setViajar(String viajar) {
        this.viajar = viajar;
    }


    @Override
    public String toString() {
        return "SeleccionFutbol{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", Apellidos='" + Apellidos + '\'' +
                ", Edad=" + Edad +
                ", concentrarse='" + concentrarse + '\'' +
                ", viajar='" + viajar + '\'' +
                '}';
    }
}



