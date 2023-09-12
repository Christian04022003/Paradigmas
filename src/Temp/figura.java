package Temp;

public abstract class figura {
    public abstract void dibujar(String nombre);

    public void saludar(String nombre){
        System.out.println("Hola soy una Temp.figura "+ nombre);
    }
}
