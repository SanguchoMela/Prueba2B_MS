import java.io.Serializable;

public class Estudiante implements Serializable {
    //atributos
    private static final long serialVersionUID = 1L;

    private String codigo;
    private String cedula;
    private String nombre;
    private String apellido;

    /*private String signo;
    private int anioNac;
    private int mesNac;
    private int diaNac;
    */

    public Estudiante(String codigo, String cedula, String nombre, String apellido) {
        this.codigo = codigo;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString(){
        return "\nCodigo: " +codigo+ "\nCedula: " +cedula+ "\nNombre: " +nombre+ "\nApellido: " +apellido +"\n";
    }

}
