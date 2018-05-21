package murgiproject.www.iesmurgi.org.murgiprojectv2.BBDD_Alumnos;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.Toast;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import murgiproject.www.iesmurgi.org.murgiprojectv2.Citas;

public class ConexionBD_Alumnos extends AsyncTask<String, Void, ResultSet> {

    // Atributos
    private Activity activity1;

    // Constructor
    public ConexionBD_Alumnos(Activity activity1) {
        this.activity1=activity1;
    }

    @Override
    protected void onPostExecute(ResultSet result) {
        try {
            if (result != null){
                if (!result.next()) {
                    Toast.makeText(activity1,"No existen resultados con ese nombre",Toast.LENGTH_LONG).show();

                }else{
                    Citas.arraydatosHora.clear();
                    Citas.arraydatosFecha.clear();
                    while(result.next()){
                        Citas.arraydatosHora.add( result.getString(1));
                        Citas.arraydatosFecha.add(result.getString(2));
                    }
                }
            }else{
                Toast.makeText(activity1,"Consulta no disponible",Toast.LENGTH_LONG).show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected ResultSet doInBackground(String... strings) {

        try {
            String rutaINI ="www.iesmurgi.org";
            Connection connection1;
            Class.forName("com.mysql.jdbc.Driver");

            connection1 = (Connection) DriverManager.getConnection("jdbc:mysql://" + rutaINI + "/bjeff", "ujeff", "pjeff");
            Statement estado = (Statement) connection1.createStatement();
            String consulta = strings[0];
            ResultSet result1 = estado.executeQuery(consulta);

            return result1;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
