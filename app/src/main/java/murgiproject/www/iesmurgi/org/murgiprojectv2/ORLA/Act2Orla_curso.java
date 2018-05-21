package murgiproject.www.iesmurgi.org.murgiprojectv2.ORLA;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;


import murgiproject.www.iesmurgi.org.murgiprojectv2.BBDD.ObtenerDatosBD;
import murgiproject.www.iesmurgi.org.murgiprojectv2.R;

public class Act2Orla_curso extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act2_orla_curso);


        AdapterCursoListview adapterCursoListview = new AdapterCursoListview(this,ObtenerDatosBD.adaptarCurso);
        ListView show = (ListView) findViewById(R.id.idListViewCurso);
        show.setAdapter(adapterCursoListview);


//        for (int i=0;i<ObtenerDatosBD.adaptarCurso.size(); i++){
//            Log.v("=====================","fff"+ObtenerDatosBD.adaptarCurso.get(i).getNombre());
//        }
//        FragmentManager fragmentManager = getFragmentManager();
//        FragmentoCurso fragmentoCurso = new FragmentoCurso();
//        fragmentoCurso.setDatos(ObtenerDatosBD.adaptarCurso);
//        fragmentoCurso.setAct(this);
//        fragmentManager.beginTransaction().add(R.id.idFrameLayoutCurso, fragmentoCurso).commit();
    }
}
