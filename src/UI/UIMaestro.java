package UI;

import Model.Maestro;

import java.util.ArrayList;
import java.util.Scanner;

public class UIMaestro {
    public static ArrayList<Maestro> maestrosConCursosDisponibles = new ArrayList<>();

    public static void mostrarMenuMaestro(){
        System.out.println("..::Maestro::..");
        System.out.println("Bienvenido " + UIMenu.maestroLogeado.getNombre());
        System.out.println("1.- Registrar un curso diponible");
        System.out.println("2.- Mostrar sus cursos agendados");
        System.out.println("0.- Cerrar sesion");

        int respuesta = 0;
        do {
            Scanner sc = new Scanner(System.in);
            respuesta = Integer.valueOf(sc.nextLine());

            switch (respuesta){
                case 1:
                    mostrarRegistrarCurso();
                    break;
                case 2:
                    mostrarMisCursos();
                    break;
                case 0:
                    System.out.println("Adios");
                    UIMenu.mostarMenu();
                    break;
                default:
                    System.out.println("Seleccione una opcion correcta");
            }
        }while (respuesta != 0);
    }

    public static void mostrarRegistrarCurso(){
        int respuesta = 0;
        do{
            System.out.println("..::Agendar un curso::..");
            System.out.println("Seleccione un mes:");
            for (int i = 0; i < 3; i++) {
                System.out.println(i+1 + ".-" + UIMenu.MESES[i]);
            }
            System.out.println("0.- Cancelar");

            Scanner sc = new Scanner(System.in);
            respuesta = Integer.valueOf(sc.nextLine());
            //1,2,3 [Enero, Febrero, Marzo]

            if (respuesta>0 && respuesta<4){
                int mesRespuesta = respuesta;
                System.out.println("Mes seleccionado: " + UIMenu.MESES[mesRespuesta-1]);
                System.out.println("Ingresa la fecha a registrar: [dd/mm/yyyy]");
                String fecha = sc.nextLine();
                System.out.println("La fecha seleccionada es: " + fecha + "\n1.-Continuar\n2.-Cambiar fecha");
                int respuestaFecha = Integer.valueOf(sc.nextLine());
                // Validar
                //
                if (respuestaFecha != 1) continue;

                int respuestaHora = 0;
                String hora = "";
                do{
                    System.out.println("Ingrese la hora disponible: [16:00]");
                    hora = sc.nextLine();
                    System.out.println("La hora seleccionada es: " + hora + "\n1.-Continuar\n2.-Cambiar hora");
                    respuestaHora = Integer.valueOf(sc.nextLine());
                }while (respuestaHora != 1);

                //Parcear la fecha a tipo date

                UIMenu.maestroLogeado.addCursoDisponible(fecha, hora);
                consultarExistenciaEnMaestroConCursos(UIMenu.maestroLogeado);
            } else if (respuesta == 0) {
                mostrarMenuMaestro();
            }
        }while (respuesta != 0);
    }

    public static void mostrarMisCursos(){
        System.out.println("Mis cursos");
        Maestro maestro = UIMenu.maestroLogeado;

        if(maestro.getCursosDisponibles().isEmpty() == true){
            System.out.println("No hay cursos disponibles");
        }else {


            int j = 0;

            for (int i = 0; i < maestro.getCursosDisponibles().size() ; i++) {
                j++;
                System.out.println("Fecha: " + maestro.getCursosDisponibles().get(i).getFecha(null) +
                        "Hora: " + maestro.getCursosDisponibles().get(i).getHora());

            }

        }




    }

    public static void consultarExistenciaEnMaestroConCursos(Maestro maestro){
        if (!maestrosConCursosDisponibles.contains(maestro)){
            maestrosConCursosDisponibles.add(maestro);
        }
    }
}