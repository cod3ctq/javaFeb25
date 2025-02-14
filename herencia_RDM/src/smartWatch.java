public class smartWatch extends relojdeMuñeca{
    String sistemaOperativo;
    String tamañoPantalla;

    public smartWatch ()
    {

    }

    public smartWatch(String formato, String tipo, String forma, String materialCorrea, String colorCorrea, String sistemaOperativo, String tamañoPantalla) {
        super(formato, tipo, forma, materialCorrea, colorCorrea);
        this.sistemaOperativo = sistemaOperativo;
        this.tamañoPantalla = tamañoPantalla;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public String getTamañoPantalla() {
        return tamañoPantalla;
    }

    public void setTamañoPantalla(String tamañoPantalla) {
        this.tamañoPantalla = tamañoPantalla;
    }

    @Override
    public String toString() {
        return "smartWatch{" +
                "sistemaOperativo='" + sistemaOperativo + '\'' +
                ", tamañoPantalla='" + tamañoPantalla + '\'' +
                ", materialCorrea='" + materialCorrea + '\'' +
                ", colorCorrea='" + colorCorrea + '\'' +
                ", formato='" + formato + '\'' +
                ", tipo='" + tipo + '\'' +
                ", forma='" + forma + '\'' +
                '}';
    }
}
