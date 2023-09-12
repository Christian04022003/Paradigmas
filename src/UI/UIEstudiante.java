package UI;

import Model.Estudiante;
import Model.Maestro;
import Model.CitaMaestro;



import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class UIEstudiante {
    public static ArrayList<Estudiante> estudiantesConCurso = new ArrayList<>();

    public static void mostrarMenuEstudiante(){
        System.out.println("..::Estudiante::..");
        System.out.println("Bienvenido " + UIMenu.estudianteLogeado.getNombre());
        System.out.println("1-Agendar curso");
        System.out.println("2-Ver mis cursos");
        System.out.println("3-Cancelar");

        int respuesta = 0;
        do {
            Scanner sc = new Scanner(System.in);
            respuesta = Integer.valueOf(sc.nextLine());

            switch (respuesta){
                case 1:
                    reservarCurso();

                    break;
                case 2:
                    mostrarMisCursosReservados();
                    break;
                case 3:
                    System.out.println("Adios");
                    UIMenu.mostarMenu();
                    break;
                default:
                    System.out.println("Seleccione una opcion correcta");
            }
        }while(respuesta != 0);
    }

    public static void reservarCurso() {
        boolean continuarReserva = false;

        do {
            System.out.println("Reservar un curso");
            System.out.println("Maestros con cursos disponibles:");

            for (int i = 0; i < UIMaestro.maestrosConCursosDisponibles.size(); i++) {
                System.out.println(i + 1 + " - " + UIMaestro.maestrosConCursosDisponibles.get(i).getNombre());
            }

            System.out.println("Elige el número del maestro: ");
            Scanner sc = new Scanner(System.in);
            int respuestaMaestroElegido = Integer.valueOf(sc.nextLine());

            Maestro maestroElegido = UIMaestro.maestrosConCursosDisponibles.get(respuestaMaestroElegido - 1);

            System.out.println("Maestro: " + maestroElegido.getNombre());

            ArrayList<Maestro.CursoDisponible> cursosDisponiblesDelMaestro = maestroElegido.getCursosDisponibles();

            for (int i = 0; i < cursosDisponiblesDelMaestro.size(); i++) {
                System.out.println(i + 1 + " - " + cursosDisponiblesDelMaestro.get(i));
            }

            System.out.println("Número de curso: ");
            int indexCursoSeleccionado = Integer.valueOf(sc.nextLine()) - 1;

            System.out.println("Por favor confirma:");
            System.out.println("Maestro: " + maestroElegido.getNombre());
            System.out.println("Curso: " + cursosDisponiblesDelMaestro.get(indexCursoSeleccionado));
            System.out.println("1 - Si\n2 - No\n");
            int confirmacion = Integer.valueOf(sc.nextLine());

            if (confirmacion == 1) {
                Date fechaHoy = new Date();
                String hora = cursosDisponiblesDelMaestro.get(indexCursoSeleccionado).getHora();
                UIMenu.estudianteLogeado.addCitaMaestro(maestroElegido, fechaHoy, hora);
            } else {
                System.out.println("Elige otro curso");
            }

            System.out.println("¿Desea realizar otra?");
            System.out.println("1 - Si\n2 - No");
            int salirMenu = Integer.valueOf(sc.nextLine());

            if (salirMenu == 1 ){
                continuarReserva = true;
            }else {
                continuarReserva = false;
            }


        }while (continuarReserva == true);
        mostrarMenuEstudiante();

    }

    /**
    public static void mostrarMisCursosReservados() {
        System.out.println("Cursos:");
        Estudiante estudiante = UIMenu.estudianteLogeado;

        if(estudiante.getCitaMaestro().isEmpty() == true){
            System.out.println("No hay cursos ");
        }else {

            int j = 0;

            for (int i = 0; i < estudiante.getCitaMaestros().size() ; i++) {
                System.out.println(estudiante.getCitaMaestros().get(i).getMaestro() + " "
                        + estudiante.getCitaMaestros().get(i).getFecha() +
                        " " + estudiante.getCitaMaestros().get(i).getHora() );
            }

        }


    }

**/

    public static void mostrarMisCursosReservados() {
        System.out.println("Cursos del estudiante:");
        Estudiante estudiante = UIMenu.estudianteLogeado;

        if (estudiante.getCitaMaestros().isEmpty()) {
            System.out.println("No hay cursos");
        } else {
            for (CitaMaestro cita : estudiante.getCitaMaestros()) {
                Maestro maestro = cita.getMaestro();
                Date fecha = cita.getFecha();
                String hora = cita.getHora();

                System.out.println("Maestro: " + maestro.getNombre());
                System.out.println("Fecha: " + fecha);
                System.out.println("Hora: " + hora);
                System.out.println("\n");

            }
        }
        mostrarMenuEstudiante();
    }



}