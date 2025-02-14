public class Inversion2 {
    public static void main(String[] args) {
        double inversionInicial = 700.00;
        double tasaInteresMensual = 0.02;
        double objetivo = 1500.00;

        double saldo = inversionInicial;
        int meses = 0;

        while (saldo < objetivo) {
            double interesMensual = saldo * tasaInteresMensual;
            saldo += interesMensual;
            meses++;
        }

        System.out.println("La persona necesitará " + meses + " meses para tener más de $" + objetivo);
    }
}