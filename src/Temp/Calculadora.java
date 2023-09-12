package Temp;

public class Calculadora {
    public static double pi = 3.1416;


    public static int suma(int valorA, int valorB){
        System.out.println("Metodo 1");
        return valorA + valorB;
    }

    public  static  double suma(double valorA, double valorB){
        System.out.println("Metodo 2");
        return valorA + valorB;
    }

    public  static  double suma(int valorA, double valorB){
        System.out.println("Metodo 3");
        return valorA + valorB;
    }

    public  static  double suma(double valorA, int valorB){
        System.out.println("Metodo 4");
        return valorA + valorB;
    }



}
