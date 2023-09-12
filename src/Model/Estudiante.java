package Model;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;


public class Estudiante extends Usuario{
    //Atributos
    private String semestre;
    private ArrayList<CitaMaestro> citaMaestros = new ArrayList<>();
    private SimpleDateFormat fechaFormateda = new SimpleDateFormat("dd/MM/yyyy");
    private Date fecha;

    //Metodo constructor
    public Estudiante(String nombre, String correo){
        super(nombre,correo);
    }

    //Comportamientos
    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }


    public ArrayList<CitaMaestro> getCitaMaestros(){
        return citaMaestros;
    }

    public void addCitaMaestro(Maestro maestro, Date fecha, String hora){
        CitaMaestro citaMaestro = new CitaMaestro(this, maestro);
        citaMaestro.agendar(fecha, hora);
        this.citaMaestros.add(citaMaestro);

    }

    public ArrayList<CitaMaestro> getCitaMaestro(){
        return citaMaestros;

    }



    @Override
    public String toString() {
        return super.toString() + ", Semestre: " + semestre;
    }

    @Override
    public void mostrarInformacionUsuario() {
        System.out.println("Soy un estiante de LIS");
    }


}

