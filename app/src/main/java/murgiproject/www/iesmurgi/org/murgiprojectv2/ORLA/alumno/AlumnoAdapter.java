package murgiproject.www.iesmurgi.org.murgiprojectv2.ORLA.alumno;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import murgiproject.www.iesmurgi.org.murgiprojectv2.BBDD_Alumnos.Alumno;
import murgiproject.www.iesmurgi.org.murgiprojectv2.R;

public class AlumnoAdapter extends RecyclerView.Adapter<AlumnoAdapter.ViewHolder>{
    private ArrayList<Alumno> alumnos;
    private ViewHolder viewHolder;
    private CardView cardView;
    private Context context;

    public AlumnoAdapter (Context context, ArrayList<Alumno> alumnos){
        this.context=context;
        this.alumnos = new ArrayList<>();
        this.alumnos = alumnos;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.esqueleto_alumnos, viewGroup, false);
        viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.alumno.setText(alumnos.get(position).getNombre()+"\n"+alumnos.get(position).getApellido1()+" "+alumnos.get(position).getApellido2());

        Picasso.with(context).load("https://drive.google.com/uc?export=download&id=0B1hz1D7khQcJem5YX21LN2Q5Znc").into(viewHolder.imagenAlumno);
        //  Picasso.with(context).error().load(alumnos.get(position).getRutaImg()).into(viewHolder.imagenAlumno);
        //insertarImagen(alumnos.get(position).getRutaImg()+"?usp=sharing",viewHolder.imagenAlumno);
        //https://drive.google.com/file/d/0B1hz1D7khQcJem5YX21LN2Q5Znc
    }



    @Override
    public int getItemCount() {
        return alumnos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView alumno;
        ImageView imagenAlumno;

        ViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cardView_cursos);
            alumno = (TextView)itemView.findViewById(R.id.TXV_nombreAlumno);
            imagenAlumno = (ImageView) itemView.findViewById(R.id.IMGV_fotoAlumno);

        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public void insertarImagen(String url, ImageView iv_pantallafoto4) {

        String[] p=url.split("/");
        //Create the new image link
        String imageLink="https://drive.google.com/uc?export=download&id="+p[5];
        Toast.makeText(context,imageLink,Toast.LENGTH_SHORT).show();

        Picasso.with(context)
                .load(imageLink)
                .error(R.mipmap.ic_launcher)
                .fit()
                .centerInside()
                .into(iv_pantallafoto4);
    }

}
