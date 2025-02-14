public class Camion extends Vehiculo{
    int capacidad;
    int numEjes;
    boolean  tieneRemolque;
    public Camion(){

    }

    public Camion(String color, int ruedas, int puertas, int capacidad, int numEjes, boolean tieneRemolque) {
        super(color, ruedas, puertas);
        this.capacidad = capacidad;
        this.numEjes = numEjes;
        this.tieneRemolque = tieneRemolque;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getNumEjes() {
        return numEjes;
    }

    public void setNumEjes(int numEjes) {
        this.numEjes = numEjes;
    }

    public boolean isTieneRemolque() {
        return tieneRemolque;
    }

    public void setTieneRemolque(boolean tieneRemolque) {
        this.tieneRemolque = tieneRemolque;
    }

    @Override
    public String toString() {
        return "Camion{" +
                "capacidad=" + capacidad +
                ", numEjes=" + numEjes +
                ", tieneRemolque=" + tieneRemolque +
                ", color='" + color + '\'' +
                ", ruedas=" + ruedas +
                ", puertas=" + puertas +
                '}';
    }
}
