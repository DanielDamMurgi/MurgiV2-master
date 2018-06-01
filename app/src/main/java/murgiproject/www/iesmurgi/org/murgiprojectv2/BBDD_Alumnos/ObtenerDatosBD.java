package murgiproject.www.iesmurgi.org.murgiprojectv2.BBDD_Alumnos;

/**
 * Created by Narka on 17/05/2018.
 */

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ObtenerDatosBD extends AsyncTask<String, Void, ResultSet> {
    //datos para conectar
    private final String dir = "jdbc:mysql://www.iesmurgi.org:3306/bjeff";
    private final String usu = "ujeff";
    private final String pass = "pjeff";

    //variables para mysql consultas
    private Connection connection = null;
    private Statement statementPromocion = null;
    private Statement statementCurso = null;
    private Statement statementAlumno = null;
    private ResultSet resultSetCursos = null;
    private ResultSet resultSetPromocion = null;
    private ResultSet resultSetAlumnos = null;

    //Adapters
    public static ArrayList<Promocion> adaptarPromocion = new ArrayList<>();
    public static ArrayList<Curso> adaptarCurso = new ArrayList<>();
    public static ArrayList<Alumno> adaptarAlumno = new ArrayList<>();

    //Activity
    private Activity activity = null;

    public ObtenerDatosBD(Activity activty) {
        this.activity = activity;
    }

    @Override
    protected void onPostExecute(ResultSet result) {
        int pp = 0;
        try {
            pp = 0;
            while (resultSetPromocion.next()) { //OBTENER DATOS TABLA PROMOCION
                adaptarPromocion.add(new Promocion(
                        resultSetPromocion.getString("id_promocion"),
                        resultSetPromocion.getString("nombre")
                ));
                pp++;
            }
            pp = 0;
            while (resultSetCursos.next()) { //OBTENER DATOS TABLA CURSOS
                adaptarCurso.add(new Curso(
                        resultSetCursos.getString("id_curso"),
                        resultSetCursos.getString("nombre")
                ));
//////Log
                //Log.v("Lista cursos",""+adaptarCurso.get(pp).id_curso()+" "+ adaptarCurso.get(pp).getNombre());
                pp++;

            }
            pp = 0;
            while (resultSetAlumnos.next()) { //OBTENER DATOS TABLA ALUMNOS

                adaptarAlumno.add(new Alumno(
                        resultSetAlumnos.getString("nombre") + " ",
                        resultSetAlumnos.getString("app"),
                        resultSetAlumnos.getString("app2"),
                        resultSetAlumnos.getString("rutaImg"),
                        resultSetAlumnos.getString("id_promocion"),
                        resultSetAlumnos.getString("id_curso")));
//////Log
               /* Log.v("Lista Alumnos",
                        ""+adaptarAlumno.get(pp).getNombre()+
                                ""+adaptarAlumno.get(pp).getApellido1()+
                                ""+adaptarAlumno.get(pp).getApellido2()+
                                ""+adaptarAlumno.get(pp).getCurso()+
                                ""+adaptarAlumno.get(pp).getRutaImg()+
                                ""+adaptarAlumno.get(pp).getId_curso()
                );*/
                pp++;

            }

        } catch (Exception ae) {
            Log.v("Error", "Error connection db obtenerdatosdb onpostExecute --------------------------------------" + ae.getLocalizedMessage());
            ae.printStackTrace();
        }
        close();
        // con.startActivity(new Intent(con,Act2Orla_curso.class));
    }


    private void close() {
        try {
            if (connection != null) {
                connection.close();
            }
            //cierre statements
            if (statementPromocion != null) {
                statementPromocion.close();
            }
            if (statementCurso != null) {
                statementCurso.close();
            }
            if (statementAlumno != null) {
                statementAlumno.close();
            }
            //cierre resultSets
            if (resultSetPromocion != null) {
                resultSetPromocion.close();
            }
            if (resultSetCursos != null) {
                resultSetCursos.close();
            }
            if (resultSetAlumnos != null) {
                resultSetAlumnos.close();
            }
        } catch (Exception ae) {
            Log.v("Error", "Error connection db obtenerdatosdb method close " + ae.getLocalizedMessage());
            ae.printStackTrace();
        }
    }

    @Override
    protected ResultSet doInBackground(String... strings) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(dir, usu, pass);
            statementPromocion = connection.createStatement();
            statementCurso = connection.createStatement();
            statementAlumno = connection.createStatement();
            resultSetPromocion = statementPromocion.executeQuery("select * from promocion");
            resultSetCursos = statementCurso.executeQuery("select * from curso");
            resultSetAlumnos = statementAlumno.executeQuery("select * from alumno");


        } catch (Exception ae) {
            Log.v("Error", "Error connection db obtenerdatosdb -----------------------------" + ae.getLocalizedMessage());
            ae.printStackTrace();
        }

        return null;
    }
}
