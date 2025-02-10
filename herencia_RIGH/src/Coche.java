public class Coche {
    String modelo;
    String año;
    String color;

    double peso;
    double potencia;

    public Coche(){

    }

    public Coche(String modelo, String año, String color) {
        this.modelo = modelo;
        this.año = año;
        this.color = color;
    }

    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getAño() {
        return año;
    }
    public void setAño(String año) {
        this.año = año;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "modelo='" + getModelo() + '\'' +
                ", año='" + getAño() + '\'' +
                ", color='" + getColor() + '\'' +
                '}';
    }
    public void relacionPesoPot(double peso, double potencia){
        double RPP = potencia/peso;
        System.out.println("la relacion PP es: "+RPP);
    }

}
