package Model;

public class ClaseExterna {
    String  nombre = "Eduardo";

    public void metodoExterno(){
        class ClaseLocal {
            public void saludar(){
                System.out.println("Hola me llamo: " + nombre);
            }
        }
        ClaseLocal claseLocal = new ClaseLocal();
        claseLocal.saludar();
    }

}