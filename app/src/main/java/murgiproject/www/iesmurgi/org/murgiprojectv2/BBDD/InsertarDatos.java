package murgiproject.www.iesmurgi.org.murgiprojectv2.BBDD;

import android.app.Activity;
import android.os.AsyncTask;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;


public class InsertarDatos extends AsyncTask<String, Void, Statement> {
    // Atributos
    Activity activity1;
    private String nombre, apellidos, asunto,fecha, hora;

    // Constructor
    public InsertarDatos(Activity activity1, String nombre, String apellidos, String asunto, String fecha, String hora) {
        this.activity1 = activity1;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.asunto = asunto;
        this.fecha = fecha;
        this.hora = hora;
    }

    @Override
    protected Statement doInBackground(String... params) {
        try {
            Connection connection1;
            Class.forName("com.mysql.jdbc.Driver");
            String rutaINI ="www.iesmurgi.org";

            connection1 = (Connection) DriverManager.getConnection("jdbc:mysql://" + rutaINI + "/base20172", "ubase20172", "pbase20172");
            Statement estado = (Statement) connection1.createStatement();

            insertUser(estado);
            insertFecha(estado);
            insertHora(estado);

            return estado;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insertUser(Statement statement) throws SQLException {
        String insert = "insert into usuarios (nombre,apellidos,asunto)values('" + nombre + "','" + apellidos + "','" + asunto + "')";
        statement.executeUpdate(insert);
    }

    public void insertFecha(Statement statement) throws SQLException {

        String insert = "insert into fecha (fecha) values('" + fecha + "')";
        statement.executeUpdate(insert);
    }

    public void insertHora(Statement statement) throws SQLException {

        String insert = "insert into hora(hora) values('" + hora + "')";
        statement.executeUpdate(insert);
    }




}
