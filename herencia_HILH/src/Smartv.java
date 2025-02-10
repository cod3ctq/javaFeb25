import java.util.Arrays;

public class Smartv extends Television { //hereda el codigo de television a smartv con extends
//Atributos propios
    String sistemaOperativo;
    String[] conectividad; //composicion
    double almacenamiento;

    public Smartv(){
      //constructor
    }

    public Smartv(String marca, String resolucion, double tamaño, double precio, String sistemaOperativo, String[] conectividad, double almacenamiento) {
        super(marca, resolucion, tamaño, precio);
        this.sistemaOperativo = sistemaOperativo;
        this.conectividad = conectividad;
        this.almacenamiento = almacenamiento;
    }
//getter setter
    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public String[] getConectividad() {
        return conectividad;
    }

    public void setConectividad(String[] conectividad) {
        this.conectividad = conectividad;
    }

    public double getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(double almacenamiento) {
        this.almacenamiento = almacenamiento;
    }
//tostring
    @Override
    public String toString() {
        return "Smartv{" +
                "sistemaOperativo='" + sistemaOperativo + '\'' +
                ", conectividad=" + Arrays.toString(conectividad) +
                ", almacenamiento=" + almacenamiento +
                '}';
    }
    //POLIMORFISMO incluye a la sobreescritura (cambiar la logica otriginal por una distinta
    //Sobreescritura
    @Override // <-- indica sobreescritura
    public void cambiarCanal (int nuevoCanal)
    {
        if(nuevoCanal<1 || nuevoCanal >100) {
            System.out.println("No existe este canal");
        }
        else {
        }
        this.canalActual = nuevoCanal;

        }
    }



