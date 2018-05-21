package murgiproject.www.iesmurgi.org.murgiprojectv2.ORLA;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import murgiproject.www.iesmurgi.org.murgiprojectv2.R;

/**
 * Created by Narka on 18/05/2018.
 */

public class FragmentoCurso extends Fragment {
    private ArrayList<AdapterDatos_Curso> datos;
    private Activity act;

    public FragmentoCurso() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.layout_fragmento_curso,container,false);
        AdapterCursoListview adapterCursoListview = new AdapterCursoListview(act,datos);
        ListView show = (ListView) root.findViewById(R.id.idListViewCurso);
        show.setAdapter(adapterCursoListview);


        for (int i=0;i<datos.size(); i++){
            Log.v("=====================","fff"+datos.get(i).getNombre());
        }
        return root;
    }

    public void setDatos(ArrayList<AdapterDatos_Curso> datos) {
        this.datos = datos;
    }

    public void setAct(Activity act) {
        this.act = act;
    }
}
