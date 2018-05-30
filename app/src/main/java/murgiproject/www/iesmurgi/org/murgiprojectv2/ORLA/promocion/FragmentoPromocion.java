package murgiproject.www.iesmurgi.org.murgiprojectv2.ORLA.promocion;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import murgiproject.www.iesmurgi.org.murgiprojectv2.BBDD_Alumnos.Promocion;
import murgiproject.www.iesmurgi.org.murgiprojectv2.R;

public class FragmentoPromocion extends Fragment {
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;


    public FragmentoPromocion() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_fragmento_promocion, container, false);

        linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_promocion);

        ArrayList<Promocion> pro = new ArrayList<>();
        pro.add(new Promocion("1","2016/2017"));
        pro.add(new Promocion("2","2017/2018"));

        PromocionAdapter adapter = new PromocionAdapter(pro);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

        return view;
    }

}
