package murgiproject.www.iesmurgi.org.murgiprojectv2.ORLA.promocion;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.*;
import java.util.ArrayList;

import murgiproject.www.iesmurgi.org.murgiprojectv2.BBDD_Alumnos.Promocion;
import murgiproject.www.iesmurgi.org.murgiprojectv2.Contacto;
import murgiproject.www.iesmurgi.org.murgiprojectv2.ORLA.ActivityCursos;
import murgiproject.www.iesmurgi.org.murgiprojectv2.R;

public class PromocionAdapter extends RecyclerView.Adapter<PromocionAdapter.ViewHolder> implements View.OnClickListener{
    private ArrayList<Promocion> promociones;
    private ViewHolder viewHolder;
    private CardView cardView;
    static Intent intentCursos;
    private int numPro;
    static Context context;

    public PromocionAdapter() {

    }

    public PromocionAdapter (Context context, ArrayList<Promocion> promociones){
        this.context = context;
        this.promociones = new ArrayList<>();
        this.promociones = promociones;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.esqueleto_promocion, viewGroup, false);
        viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {

        viewHolder.promocion.setText(promociones.get(position).getNombre());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentCursos = new Intent(context,ActivityCursos.class);
                intentCursos.putExtra("id_promocion",promociones.get(position).getId_promocion());
                context.startActivity(intentCursos);
            }
        });
    }

    @Override
    public int getItemCount() {
        return promociones.size();
    }

    @Override
    public void onClick(View view) {

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView promocion;

        ViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cardView);
            promocion = (TextView)itemView.findViewById(R.id.lbl_promocion);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);

    }

}// Fin clase
