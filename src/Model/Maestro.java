package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Maestro extends Usuario{
    //Atributos
    private String especialidad;
    private String rfc;

    //Metodo constructor
    public Maestro(String nombre, String correo){
        super(nombre, correo);
    }

    //Metodos - Comportamiento
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    ArrayList<CursoDisponible> cursosDisponibles = new ArrayList<>();
    public void addCursoDisponible(String date, String hora){
        cursosDisponibles.add(new Maestro.CursoDisponible(date, hora));
    }

    public ArrayList<CursoDisponible> getCursosDisponibles(){
        return cursosDisponibles;
    }

    //Clase anidada
    public static class CursoDisponible{
        //Atributos
        private int id;
        private Date fecha;
        private String hora;
        SimpleDateFormat fechaFormateda = new SimpleDateFormat("dd/MM/yyyy");

        //Constructor
        public CursoDisponible(String fecha, String hora) {
            try {
                this.fecha = fechaFormateda.parse(fecha);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            this.hora = hora;
        }

        @Override
        public String toString() {
            return "Curso disponible: " + fecha + ", Hora: " + hora;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Date getFecha() {
            return fecha;
        }

        public String getFecha(String texto) {
            return fechaFormateda.format(fecha);
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
    }

    @Override
    public String toString() {
        return super.toString() + ", Especialidad: " + especialidad + ", RFC: " + rfc;
    }

    @Override
    public void mostrarInformacionUsuario() {
        System.out.println("Maestro de la UV");
    }
}