package murgiproject.www.iesmurgi.org.murgiprojectv2.ORLA;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import murgiproject.www.iesmurgi.org.murgiprojectv2.R;

/**
 * Created by Narka on 18/05/2018.
 */

public class CursosAdapter extends ArrayAdapter<Curso> {
    private  ArrayList<Curso> curso;

    public CursosAdapter(ActivityCursos activityCursos, ArrayList<Curso> curso){
        super(activityCursos,0,curso);
        //this.curso = curso;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.activityorla2_cursosesqueleto, parent, false);
        }

        Curso curso = getItem(position);

        TextView txtNom = (TextView) listItemView.findViewById(R.id.tv_pantallacurso);

        txtNom.setText(curso.getNombre());

        return listItemView;
    }
}
