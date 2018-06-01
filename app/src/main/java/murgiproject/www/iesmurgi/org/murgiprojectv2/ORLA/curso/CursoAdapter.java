package murgiproject.www.iesmurgi.org.murgiprojectv2.ORLA.curso;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import murgiproject.www.iesmurgi.org.murgiprojectv2.BBDD_Alumnos.Curso;
import murgiproject.www.iesmurgi.org.murgiprojectv2.R;

public class CursoAdapter extends RecyclerView.Adapter<CursoAdapter.ViewHolder>{
    private ArrayList<Curso> cursos;
    private ViewHolder viewHolder;
    private CardView cardView;

    public CursoAdapter (ArrayList<Curso> cursos){
        this.cursos = new ArrayList<>();
        this.cursos = cursos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.esqueleto_cursos, viewGroup, false);
        viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        viewHolder.curso.setText(cursos.get(position).getNombre());
    }

    @Override
    public int getItemCount() {
        return cursos.size();
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
