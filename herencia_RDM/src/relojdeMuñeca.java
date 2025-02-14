public class relojdeMuñeca extends Reloj {

    String materialCorrea;
    String colorCorrea;

    public relojdeMuñeca ()
    {

    }

    public relojdeMuñeca(String formato, String tipo, String forma, String materialCorrea, String colorCorrea) {
        super(formato, tipo, forma);
        this.materialCorrea = materialCorrea;
        this.colorCorrea = colorCorrea;
    }

    public String getMaterialCorrea() {
        return materialCorrea;
    }

    public void setMaterialCorrea(String materialCorrea) {
        this.materialCorrea = materialCorrea;
    }

    public String getColorCorrea() {
        return colorCorrea;
    }

    public void setColorCorrea(String colorCorrea) {
        this.colorCorrea = colorCorrea;
    }

    @Override
    public String toString() {
        return "relojdeMuñeca{" +
                "materialCorrea='" + materialCorrea + '\'' +
                ", colorCorrea='" + colorCorrea + '\'' +
                ", formato='" + formato + '\'' +
                ", tipo='" + tipo + '\'' +
                ", forma='" + forma + '\'' +
                '}';
    }
}
