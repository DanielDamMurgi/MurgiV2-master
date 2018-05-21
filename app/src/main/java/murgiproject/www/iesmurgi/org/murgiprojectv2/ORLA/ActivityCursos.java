package murgiproject.www.iesmurgi.org.murgiprojectv2.ORLA;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import murgiproject.www.iesmurgi.org.murgiprojectv2.Citas;
import murgiproject.www.iesmurgi.org.murgiprojectv2.Cursos;
import murgiproject.www.iesmurgi.org.murgiprojectv2.R;

public class ActivityCursos extends AppCompatActivity {
    private ArrayList<Curso> cursos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cursos);
        cursos = new ArrayList<>();


        cursos.add(new Curso("2","vbre"));

        CursosAdapter cursosAdapter= new CursosAdapter(this,cursos);
        ListView listView = (ListView) findViewById(R.id.ListaCursos);
        listView.setAdapter(cursosAdapter);

    }

}
