package murgiproject.www.iesmurgi.org.murgiprojectv2.ORLA;

/**
 * Created by usuario on 27/02/18.
 */

public class Alumno {
    // Atributos
    String nombre;
    String curso;
    String enlaceurl;
    String codigoqr;

    // Constructores
    public Alumno(String nombre, String curso, String enlaceurl) {
        this.nombre = nombre;
        this.curso = curso;
        this.enlaceurl = enlaceurl;
    }

    public Alumno(String nombre, String curso, String enlaceurl, String codigoqr) {
        this.nombre = nombre;
        this.curso = curso;
        this.enlaceurl = enlaceurl;
        this.codigoqr = codigoqr;
    }

    // getters and setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getEnlaceurl() {
        return enlaceurl;
    }

    public void setEnlaceurl(String enlaceurl) {
        this.enlaceurl = enlaceurl;
    }

    public String getCodigoqr() {
        return codigoqr;
    }

    public void setCodigoqr(String codigoqr) {
        this.codigoqr = codigoqr;
    }
}
