package murgiproject.www.iesmurgi.org.murgiprojectv2.ORLA.curso;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import murgiproject.www.iesmurgi.org.murgiprojectv2.BBDD.ObtenerDatosBD;
import murgiproject.www.iesmurgi.org.murgiprojectv2.BBDD_Alumnos.Curso;
import murgiproject.www.iesmurgi.org.murgiprojectv2.R;

/**
 * Created by Narka on 23/05/2018.
 */

public class AdaptarRecyCurso extends RecyclerView.Adapter<AdaptarRecyCurso.ViewHolder> {
    private ArrayList <Curso> curso;
    public class ViewHolder extends RecyclerView.ViewHolder{
        public ConstraintLayout con;
        public TextView nombre;

        public  ViewHolder (View root){
            super(root);
            con = (ConstraintLayout) root.findViewById(R.id.id_ConstraintLayout_curso);
            nombre = (TextView)  root.findViewById(R.id.id_TextVuew_Rec_nom);

        }
    }

    public AdaptarRecyCurso(ArrayList <Curso> curso) {
        this.curso = curso;
    }

    @Override
    public int getItemCount() {
        return curso.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TextView textView = holder.nombre;
        textView.setText(curso.get(position).getNombre());

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Creamos el inflater
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        //Creamos el view, donde cargamos el layout
        View root = layoutInflater.inflate(R.layout.layout_recycler_curso,parent,false);

        //El view lo ponemos en un viewHolder
        ViewHolder viewHolder = new ViewHolder(root);

        //Devolvemos un viewholder
        return viewHolder;
    }
}
