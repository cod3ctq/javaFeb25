public class Invercion {
    public static void main(String[] args) {
        double inversionInicial = 1000.00;
        double tasaInteresMensual = 0.02;
        int meses = 12;

        double saldo = inversionInicial;

        for (int i = 0; i < meses; i++) {
            double interesMensual = saldo * tasaInteresMensual;
            saldo += interesMensual;
        }

        System.out.println("La cantidad de dinero que la persona tendrá al cabo de un año es: $" + String.format("%.2f", saldo));
    }
}
