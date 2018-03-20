package murgiproject.www.iesmurgi.org.murgiprojectv2.ORLA;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import murgiproject.www.iesmurgi.org.murgiprojectv2.R;

/**
 * Created by usuario on 27/02/18.
 */

public class Adapter_ActivityOrla3 extends ArrayAdapter<Alumno> {
    // Constructor
    public Adapter_ActivityOrla3(@NonNull Context context, ArrayList<Alumno> arrayalumnos) {
        super(context, 0,arrayalumnos);
    }

    // getView


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view1=convertView;

        if (view1 == null) {
            view1 = LayoutInflater.from(getContext()).inflate(R.layout.activityorla3_vercursosesquelo, parent, false);
        }

        Alumno a1 = getItem(position);

        ImageView iv_idfoto3= (ImageView )view1.findViewById(R.id.iv_idfoto3);
        String url1=a1.getEnlaceurl();
        String url=url1+"?usp=sharing";
        insertarImagen(url,iv_idfoto3);

        TextView tv_pantallanombre3= (TextView) view1.findViewById(R.id.tv_pantallanombre3);
        tv_pantallanombre3.setText(a1.getNombre());




        return view1;
    }

    public void insertarImagen(String url, ImageView iv_idfoto3) {

        String[] p=url.split("/");
        //Create the new image link
        String imageLink="https://drive.google.com/uc?export=download&id="+p[5];
        //Toast.makeText(getContext(),imageLink,Toast.LENGTH_SHORT).show();


        Picasso.with(getContext())
                .load(imageLink)
                .error(R.mipmap.ic_launcher)
                .fit()
                .centerInside()
                .into(iv_idfoto3);
    }

}
