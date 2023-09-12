package Model;

public abstract class Usuario {
    //Atributos
    private int id;
    private String nombre;
    private String correo;
    private String matricula;
    private String telefono;

    //Constructor
    public Usuario(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Hola me llamo: " + nombre + ", Correo: " + correo + ", Matricula: " + matricula
                + ", telefono: " + telefono;
    }

    public abstract void mostrarInformacionUsuario();

    //Comportamientos
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}