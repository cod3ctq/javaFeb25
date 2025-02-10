public class Carros2025 extends Carros1990{
    String turbo;
    String sensores;
    String rendimiento;
    public Carros2025(){

    }

    public Carros2025(String estereo, String material, double motor, double precio, String turbo, String sensores, String rendimiento) {
        super(estereo, material, motor, precio);
        this.turbo = turbo;
        this.sensores = sensores;
        this.rendimiento = rendimiento;
    }

    public String getTurbo() {
        return turbo;
    }

    public void setTurbo(String turbo) {
        this.turbo = turbo;
    }

    public String getSensores() {
        return sensores;
    }

    public void setSensores(String sensores) {
        this.sensores = sensores;
    }

    public String getRendimiento() {
        return rendimiento;
    }

    public void setRendimiento(String rendimiento) {
        this.rendimiento = rendimiento;
    }

    @Override
    public String toString() {
        return "Carros2025{" +
                "turbo='" + turbo + '\'' +
                ", sensores='" + sensores + '\'' +
                ", rendimiento='" + rendimiento + '\'' +
                ", estereo='" + estereo + '\'' +
                ", material='" + material + '\'' +
                ", motor=" + motor +
                ", precio=" + precio +
                '}';
    }
}
