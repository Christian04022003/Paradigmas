import Model.Estudiante;
import Model.Maestro;
import Model.Secretaria;

import static UI.UIMenu.*;

public class Main {
    public static void main(String[] args) {


        maestros.add(new Maestro("Luis Morales", "morales@uv.mx"));
        maestros.add(new Maestro("Javier Pino", "jpino@uv.mx"));
        maestros.add(new Maestro("Jose Vergara", "jvergara@uv.mx"));
        maestros.add(new Maestro("Patricia Martinez", "pmartinez@uv.mx"));


        estudiantes.add(new Estudiante("Rocael", "rocael@uv.mx"));
        estudiantes.add(new Estudiante("Mercader", "mercader@uv.mx"));
        estudiantes.add(new Estudiante("Carlos", "calor@uv.mx"));
        estudiantes.add(new Estudiante("Gerardo", "gerardo@uv.mx"));

        secretarias.add(new Secretaria("Lupe","lupe@uv.mx"));
        secretarias.add(new Secretaria("Petra","petra@uv.mx"));

        mostarMenu();
    }
}