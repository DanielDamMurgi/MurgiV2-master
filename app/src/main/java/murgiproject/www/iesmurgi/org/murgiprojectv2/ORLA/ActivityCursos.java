package murgiproject.www.iesmurgi.org.murgiprojectv2.ORLA;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import murgiproject.www.iesmurgi.org.murgiprojectv2.BBDD_Alumnos.Curso;
import murgiproject.www.iesmurgi.org.murgiprojectv2.BBDD_Alumnos.ObtenerDatosBD;
import murgiproject.www.iesmurgi.org.murgiprojectv2.R;

public class ActivityCursos extends AppCompatActivity {
    private ArrayList<Curso> cursos;
    private ObtenerDatosBD datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cursos);

        cursos = new ArrayList<>();


        CursosAdapter cursosAdapter= new CursosAdapter(this,datos.adaptarCurso);
        ListView listView = (ListView) findViewById(R.id.ListaCursos);
        listView.setAdapter(cursosAdapter);

    }
}
