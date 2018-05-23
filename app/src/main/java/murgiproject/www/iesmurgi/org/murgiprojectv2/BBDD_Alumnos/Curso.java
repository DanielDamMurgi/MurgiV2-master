package murgiproject.www.iesmurgi.org.murgiprojectv2.BBDD_Alumnos;

public class Curso {
    private String id_curso;
    private String nombre;

    public Curso() {
    }

    public Curso(String id, String nombre) {
        this.id_curso = id;
        this.nombre = nombre;
    }

    public String getId() {
        return id_curso;
    }

    public void setId(String id) {
        this.id_curso = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
