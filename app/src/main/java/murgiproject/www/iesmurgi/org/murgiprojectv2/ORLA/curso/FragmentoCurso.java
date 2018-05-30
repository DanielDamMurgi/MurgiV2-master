package murgiproject.www.iesmurgi.org.murgiprojectv2.ORLA.curso;

import android.app.Fragment;

import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import murgiproject.www.iesmurgi.org.murgiprojectv2.BBDD_Alumnos.Curso;
import murgiproject.www.iesmurgi.org.murgiprojectv2.R;

public class FragmentoCurso extends Fragment {

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    public FragmentoCurso() {

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragmento_promocion,container,false);

        linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_promocion);

        ArrayList<Curso> pro = new ArrayList<>();
        pro.add(new Curso("1","2016/2017"));
        pro.add(new Curso("2","2017/2018"));

        CursoAdapter adapter = new CursoAdapter(pro);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);


        return view;
    }
}
