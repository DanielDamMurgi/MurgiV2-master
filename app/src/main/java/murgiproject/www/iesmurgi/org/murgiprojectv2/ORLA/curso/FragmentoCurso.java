package murgiproject.www.iesmurgi.org.murgiprojectv2.ORLA.curso;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import murgiproject.www.iesmurgi.org.murgiprojectv2.BBDD.ObtenerDatosBD;
import murgiproject.www.iesmurgi.org.murgiprojectv2.BBDD_Alumnos.Curso;
import murgiproject.www.iesmurgi.org.murgiprojectv2.R;

/**
 * Created by Narka on 23/05/2018.
 */

public class FragmentoCurso extends Fragment {
    public FragmentoCurso() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.layout_fragmento_grid,container,false);

        RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.id_Recycle_Frame) ;

        //start Adapter
        //ArrayList <Curso> datos = ObtenerDatosBD.adaptarCurso;
        AdaptarRecyCurso adaptarRecyCurso = new AdaptarRecyCurso();


        return root;
    }
}
