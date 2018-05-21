package murgiproject.www.iesmurgi.org.murgiprojectv2.ORLA;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
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

public class AdapterCursoListview extends ArrayAdapter<AdapterDatos_Curso> {
    private  ArrayList<AdapterDatos_Curso> curso;
    public AdapterCursoListview(Activity act, ArrayList<AdapterDatos_Curso> curso){
        super(act,0,curso);
        this.curso = curso;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View root = LayoutInflater.from(getContext()).inflate(R.layout.layout_listview_curso,parent,false);
        Log.v("----------------","asdaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

        TextView txtNom = (TextView) root.findViewById(R.id.idTxtCursoNom);

        txtNom.setText(curso.get(position).getNombre());

        return root;
    }
}
