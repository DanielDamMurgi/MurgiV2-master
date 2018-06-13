package murgiproject.www.iesmurgi.org.murgiprojectv2.ORLA.curso;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import murgiproject.www.iesmurgi.org.murgiprojectv2.BBDD_Alumnos.Curso;
import murgiproject.www.iesmurgi.org.murgiprojectv2.ORLA.ActivityCursos;
import murgiproject.www.iesmurgi.org.murgiprojectv2.ORLA.AlumnoActivity;
import murgiproject.www.iesmurgi.org.murgiprojectv2.R;

public class CursoAdapter extends RecyclerView.Adapter<CursoAdapter.ViewHolder> implements View.OnClickListener{
    private ArrayList<Curso> cursos;
    private ViewHolder viewHolder;
    private CardView cardView;
    private Intent intentAlumnos;
    private Context context;
    private String promo;

    public CursoAdapter (Context context, ArrayList<Curso> cursos, String promo){
        this.context = context;
        this.cursos = new ArrayList<>();
        this.cursos = cursos;
        this.promo=promo;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.esqueleto_cursos, viewGroup, false);
        viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        viewHolder.curso.setText(cursos.get(position).getNombre());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentAlumnos = new Intent(context,AlumnoActivity.class);
                intentAlumnos.putExtra("id_curso",cursos.get(position).getId());
                intentAlumnos.putExtra("id_promo",promo);

                context.startActivity(intentAlumnos);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cursos.size();
    }

    @Override
    public void onClick(View view) {

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView curso;

        ViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cardView_cursos);
            curso = (TextView)itemView.findViewById(R.id.TXV_Curso);

        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
