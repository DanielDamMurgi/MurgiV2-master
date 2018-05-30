package murgiproject.www.iesmurgi.org.murgiprojectv2.ORLA.promocion;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import murgiproject.www.iesmurgi.org.murgiprojectv2.BBDD_Alumnos.Promocion;
import murgiproject.www.iesmurgi.org.murgiprojectv2.R;

public class PromocionAdapter extends RecyclerView.Adapter<PromocionAdapter.ViewHolder>{
    private ArrayList<Promocion> promociones;
    private ViewHolder viewHolder;
    private CardView cardView;

    public PromocionAdapter (ArrayList<Promocion> promociones){
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
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        viewHolder.promocion.setText(promociones.get(position).getNombre());
    }

    @Override
    public int getItemCount() {
        return promociones.size();
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

}
