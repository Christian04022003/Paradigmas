package Model;

public class Secretaria extends Usuario{
    //Atributos
    private String facultad;
    private String programaEducativo;

    public Secretaria(String nombre, String correo) {
        super(nombre, correo);
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getProgramaEducativo() {
        return programaEducativo;
    }

    public void setProgramaEducativo(String programaEducativo) {
        this.programaEducativo = programaEducativo;
    }

    @Override
    public void mostrarInformacionUsuario() {
        System.out.println("Secretaria de la UV");
    }
}