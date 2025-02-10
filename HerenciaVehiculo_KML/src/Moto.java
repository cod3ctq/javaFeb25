public class Moto extends Vehiculo {
    boolean tieneCaja;

    public Moto(String marca, String modelo, String placa, String color, int año, boolean tieneCaja) {
        super(marca, modelo, placa, color, año);
        this.tieneCaja = tieneCaja;
    }

    @Override
    public void mostrarInfo(String marca, String modelo, String placa, String color, int año, boolean tieneCaja) {
        super.mostrarInfo(marca, modelo, placa, color, año, tieneCaja);
    }

    @Override
    public void Encender(boolean encendido) {
        super.Encender(encendido);
    }

    @Override
    public void Apagar(boolean encendido) {
        super.Apagar(encendido);
    }
}
