public class Vehiculo {
    String color;
    int ruedas;
    int puertas;

    public Vehiculo(){

    }

    public Vehiculo(String color, int ruedas, int puertas) {
        this.color = color;
        this.ruedas = ruedas;
        this.puertas = puertas;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getRuedas() {
        return ruedas;
    }

    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "color='" + color + '\'' +
                ", ruedas=" + ruedas +
                ", puertas=" + puertas +
                '}';
    }
}
