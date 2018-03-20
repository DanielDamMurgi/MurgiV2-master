package murgiproject.www.iesmurgi.org.murgiprojectv2.ORLA;

/**
 * Created by usuario on 26/02/18.
 */

public class Curso {
    // Atributos
    private int idFoto;
    private String nombrecurso;

    // Constructor
    public Curso(String nombrecurso) {
        this.nombrecurso = nombrecurso;
    }

    // Getters and setters

    public int getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(int idFoto) {
        this.idFoto = idFoto;
    }

    public String getNombrecurso() {
        return nombrecurso;
    }

    public void setNombrecurso(String nombrecurso) {
        this.nombrecurso = nombrecurso;
    }
}
