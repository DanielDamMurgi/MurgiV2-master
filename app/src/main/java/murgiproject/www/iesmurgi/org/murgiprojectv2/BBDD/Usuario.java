package murgiproject.www.iesmurgi.org.murgiprojectv2.BBDD;

/**
 * Created by usuario on 26/02/18.
 */

public class Usuario {
    // Atributos
    private String nombre="";
    private String clave="";

    // Constructor
    public Usuario(String nombre, String clave) {
        this.nombre = nombre;
        this.clave = clave;
    }


    // Getters and setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
