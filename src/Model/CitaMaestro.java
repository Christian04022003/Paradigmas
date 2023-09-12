package Model;

import java.util.Date;

public class CitaMaestro implements IAgendable{
    //Atributos
    private int id;
    private Maestro maestro;
    private Estudiante estudiante;
    private Date fecha;
    private String hora;

    public CitaMaestro(Maestro maestro, Estudiante estudiante, Date fecha, String hora) {
        this.maestro = maestro;
        this.estudiante = estudiante;
        this.fecha = fecha;
        this.hora = hora;
    }

    public CitaMaestro(Estudiante estudiante, Maestro maestro) {
        this.estudiante = estudiante;
        this.maestro = maestro;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Maestro getMaestro() {
        return maestro;
    }

    public void setMaestro(Maestro maestro) {
        this.maestro = maestro;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public void agendar(Date fecha, String hora) {
        this.fecha = fecha;
        this.hora = hora;

    }
}