public class Reloj {
    String formato;
    String tipo;
    String forma;

    public Reloj ()
    {

    }

    public Reloj(String formato, String tipo, String forma) {
        this.formato = formato;
        this.tipo = tipo;
        this.forma = forma;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    @Override
    public String toString() {
        return "Reloj{" +
                "formato='" + formato + '\'' +
                ", tipo='" + tipo + '\'' +
                ", forma='" + forma + '\'' +
                '}';
    }
}
