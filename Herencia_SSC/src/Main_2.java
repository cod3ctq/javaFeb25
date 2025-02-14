public class Main_2 {

    public static void main(String[] args) {

        // Definir mas de una subclase

        Empleado emp1 = new Empleado("Javier Sanchéz",1522,17855.22,12);

        Diseñador dis1 = new Diseñador();
        String[] diasentregas = {"Lunes","Jueves","Viernes"};
        dis1.setNombre("Juan Díaz");
        dis1.setSalario(19580.12);
        dis1.setDiasVacaciones(15);
        dis1.setNumEmpleado(1322);
        dis1.setAgenda(diasentregas);
        String [] pendientes = {"Diseño pendiente de la página web"};
        dis1.setAgenda(pendientes);

        String [] diasreuniones = {"Todos los Lunes cada dos semanas"};
        String [] indicaciones = {"Verificar errores","Ayudar en cada area","Dirigir procesos"};
        Gerente ger1 = new Gerente("Luis Dominguez",1120,25233.52,24,diasreuniones,indicaciones);

        System.out.println(ger1);
        System.out.println(emp1);
        System.out.println(dis1);




    }
}
