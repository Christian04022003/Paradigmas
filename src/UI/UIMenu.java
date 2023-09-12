package UI;

import Model.Estudiante;
import Model.Maestro;
import Model.Secretaria;

import java.util.ArrayList;
import java.util.Scanner;

public class UIMenu {
    public static final String[] MESES = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
        "Julio", "Agosto", "Septiembre", "Octubre","Noviembre", "Diciembre"};
    public static Maestro maestroLogeado;
    public static ArrayList<Maestro> maestros = new ArrayList<>();
    public static ArrayList<Estudiante> estudiantes = new ArrayList<>();
    public static ArrayList<Secretaria> secretarias = new ArrayList<>();

    public static Estudiante estudianteLogeado;

    public static void mostarMenu(){
        System.out.println("..::Bienvenido::..");
        System.out.println("Seleccionen una opcion:");
        System.out.println("1-Maestros");
        System.out.println("2-Estudiantes");
        System.out.println("3-Salir");

        int respuesta = 0;

        do {
            Scanner sc = new Scanner(System.in);
            respuesta = Integer.valueOf(sc.nextLine());

            switch (respuesta){
                case 1:
                    System.out.println("..::Maestro::..");
                    loginUsuario(1);
                    break;
                case 2:
                    System.out.println("..::Estudiante::..");
                    loginUsuario(2);
                    break;
                case 3:
                    System.out.println("..::Adios::..");
                    break;
                default:
                    System.out.println("Seleccione una opcion correcta");
            }
        }while (respuesta != 3);
    }


    private static void loginUsuario(int tipoUsuario) {
        //Maestros - Tipo 1
        //Estudiantes - Tipo 2
        //Secretarias - Tipo 3



        //Secretarias Tarea - Falta el modulo de secretaria
        boolean correoCorrecto = false;
        do {
            System.out.println("Ingresa el correo:");
            Scanner sc = new Scanner(System.in);
            String correo = sc.nextLine();

            if (tipoUsuario == 1){
                for (Maestro maestro:maestros) {
                    if (maestro.getCorreo().equals(correo)){
                        correoCorrecto = true;
                        maestroLogeado = maestro;
                        UIMaestro.mostrarMenuMaestro();
                    }
                }
            }

            if (tipoUsuario == 2){
                for (Estudiante estudiante:estudiantes) {
                    if (estudiante.getCorreo().equals(correo)){
                        correoCorrecto = true;
                        estudianteLogeado = estudiante;
                        UIEstudiante.mostrarMenuEstudiante();
                    }
                }
            }
        }while (!correoCorrecto);



    }

}