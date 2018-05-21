package murgiproject.www.iesmurgi.org.murgiprojectv2.ORLA;

/**
 * Created by Narka on 17/05/2018.
 */

public class Curso {
    private String idCurso;
    private String nombre;

    public Curso(String idCurso, String nombre) {
        this.idCurso = idCurso;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public String idCurso() {
        return idCurso;
    }
}
