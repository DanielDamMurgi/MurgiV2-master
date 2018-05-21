package murgiproject.www.iesmurgi.org.murgiprojectv2.ORLA;

/**
 * Created by Narka on 17/05/2018.
 */

public class AdapterDatos_Alumno {
    private String nombre;
    private String app;
    private String app2;
    private String rutaImg;
    private String curso;
    private String id_curso;

    public AdapterDatos_Alumno(String nombre, String app, String app2, String rutaImg, String curso, String id_curso) {
        this.nombre = nombre;
        this.app = app;
        this.app2 = app2;
        this.rutaImg = rutaImg;
        this.curso = curso;
        this.id_curso = id_curso;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApp() {
        return app;
    }

    public String getApp2() {
        return app2;
    }

    public String getRutaImg() {
        return rutaImg;
    }

    public String getCurso() {
        return curso;
    }

    public String getId_curso() {
        return id_curso;
    }
}
