import java.util.Arrays;

public class ChocheCarreras extends Coche{
    String tipoCarrera;
    String marcaTurbo;
    String[] patrosinador;

    public ChocheCarreras(){

    }

    public ChocheCarreras(String modelo, String año, String color, String tipoCarrera, String marcaTurbo, String[] patrosinador) {
        super(modelo, año, color);
        this.tipoCarrera = tipoCarrera;
        this.marcaTurbo = marcaTurbo;
        this.patrosinador = patrosinador;
    }

    public String getTipoCarrera() {
        return tipoCarrera;
    }
    public void setTipoCarrera(String tipoCarrera) {
        this.tipoCarrera = tipoCarrera;
    }
    public String getMarcaTurbo() {
        return marcaTurbo;
    }
    public void setMarcaTurbo(String marcaTurbo) {
        this.marcaTurbo = marcaTurbo;
    }
    public String[] getPatrosinador() {
        return patrosinador;
    }
    public void setPatrosinador(String[] patrosinador) {
        this.patrosinador = patrosinador;
    }

    @Override
    public String toString() {
        return "ChocheCarreras{" +
                "tipoCarrera='" + getTipoCarrera() + '\'' +
                ", marcaTurbo='" + getMarcaTurbo() + '\'' +
                ", patrosinador=" + Arrays.toString(getPatrosinador()) +
                ", modelo='" + getModelo() + '\'' +
                ", año='" + getAño() + '\'' +
                ", color='" + getColor() + '\'' +
                '}';
    }
}
