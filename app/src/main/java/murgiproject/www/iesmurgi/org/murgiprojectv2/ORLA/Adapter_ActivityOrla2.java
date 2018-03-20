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
 * Created by usuario on 26/02/18.
 */

public class Adapter_ActivityOrla2 extends ArrayAdapter<Curso> {
    // Constructor
    public Adapter_ActivityOrla2(@NonNull Context context, ArrayList<Curso> arraycurso) {
        super(context, 0,arraycurso);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view1 = convertView;

        if(view1==null) {
            view1 = LayoutInflater.from(getContext()).inflate(R.layout.activityorla2_cursosesqueleto,parent,false);
        }

        Curso c1= getItem(position);

        TextView tv_pantallacurso = (TextView) view1.findViewById(R.id.tv_pantallacurso);
        tv_pantallacurso.setText(c1.getNombrecurso());


        return view1;
    }
}
