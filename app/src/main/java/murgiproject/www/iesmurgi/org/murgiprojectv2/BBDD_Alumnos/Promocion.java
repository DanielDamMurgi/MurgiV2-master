package murgiproject.www.iesmurgi.org.murgiprojectv2.BBDD_Alumnos;

public class Promocion {

    //ATRIBUTOS
    private String id_promocion;
    private String nombre;

    public Promocion(String id_promocion, String nombre) {
        this.id_promocion = id_promocion;
        this.nombre = nombre;
    }

    public String getId_promocion() {
        return id_promocion;
    }

    public void setId_promocion(String id_promocion) {
        this.id_promocion = id_promocion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
