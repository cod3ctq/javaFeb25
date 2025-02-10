public class Gato extends Animales{

    String color;

    public Gato(String color) {
        this.color = color;
    }

    public Gato(String nombre, int edad, String color) {
        super(nombre, edad);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Gato{" +
                "color='" + color + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }

    @Override
    public void hacerSonido(){
        System.out.println(nombre +" esta maullando");
    }
}
