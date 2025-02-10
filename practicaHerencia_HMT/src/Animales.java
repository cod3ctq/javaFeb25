public class Animales {

    String nombre;
    int edad;

public Animales (){

}

    public Animales(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Animales{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }

    public void hacerSonido(){
        System.out.println(nombre +" hace un sonido");
    }
    public void comer(){
        System.out.println(nombre+"  esta comiendo");
    }
    public void dormir(){
        System.out.println(nombre+ " esta durmiendo");
    }
}
