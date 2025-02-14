public class Carros1990 {
    String estereo;
    String material;
    double motor;
    double precio;


    public Carros1990(){

    }

    public Carros1990(String estereo, String material, double motor, double precio) {
        this.estereo = estereo;
        this.material = material;
        this.motor = motor;
        this.precio = precio;
    }

    public String getEstereo() {
        return estereo;
    }

    public void setEstereo(String estereo) {
        this.estereo = estereo;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getMotor() {
        return motor;
    }

    public void setMotor(double motor) {
        this.motor = motor;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Carros1990{" +
                "estereo='" + estereo + '\'' +
                ", material='" + material + '\'' +
                ", motor=" + motor +
                ", precio=" + precio +
                '}';
    }
}
