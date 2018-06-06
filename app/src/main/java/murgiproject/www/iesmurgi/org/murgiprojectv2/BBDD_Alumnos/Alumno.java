package murgiproject.www.iesmurgi.org.murgiprojectv2.BBDD_Alumnos;

public class Alumno {
    private String id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String rutaImg;
    private String id_promocion;
    private String id_curso;

    private Promocion promocion;
    private Curso curso;

    public Alumno() {
    }

    public Alumno(String id, String nombre, String apellido1, String apellido2, String rutaImg) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.rutaImg = rutaImg;
    }

    public Alumno(String id, String nombre, String apellido1, String apellido2, String rutaImg, Promocion promocion, Curso curso) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.rutaImg = rutaImg;
        this.promocion = promocion;
        this.curso = curso;
    }

    public Alumno( String nombre, String apellido1, String apellido2, String rutaImg, String promocion, String curso) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.rutaImg = rutaImg;
        this.id_promocion = promocion;
        this.id_curso = curso;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getRutaImg() {
        return rutaImg;
    }

    public void setRutaImg(String rutaImg) {
        this.rutaImg = rutaImg;
    }

    public Promocion getPromocion() {
        return promocion;
    }

    public void setPromocion(Promocion promocion) {
        this.promocion = promocion;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getId_promocion() {
        return id_promocion;
    }

    public void setId_promocion(String id_promocion) {
        this.id_promocion = id_promocion;
    }

    public String getId_curso() {
        return id_curso;
    }

    public void setId_curso(String id_curso) {
        this.id_curso = id_curso;
    }
}
