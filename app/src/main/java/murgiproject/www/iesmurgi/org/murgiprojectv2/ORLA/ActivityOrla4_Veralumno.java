package murgiproject.www.iesmurgi.org.murgiprojectv2.ORLA;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import murgiproject.www.iesmurgi.org.murgiprojectv2.MainActivity;
import murgiproject.www.iesmurgi.org.murgiprojectv2.R;

public class ActivityOrla4_Veralumno extends AppCompatActivity {
    // Atributo
    int posicioncurso;
    int posicionalumno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityorla4_veralumnoesqueleto);

        posicioncurso = getIntent().getExtras().getInt("PosicionCurso");
        posicionalumno= getIntent().getExtras().getInt("PosicionAlumno");

        ImageView iv_pantallafoto4= (ImageView)findViewById(R.id.iv_pantallafoto4);
        TextView tv_pantalladescripcion4 = (TextView) findViewById(R.id.tv_pantalladescripcion4);



        if (posicioncurso==0) {
            String url1=(MainActivity.arrayalumnosesoa.get(posicionalumno).getEnlaceurl() );
            String url=url1+"?usp=sharing";
            insertarImagen(url,iv_pantallafoto4);

            tv_pantalladescripcion4.setText(MainActivity.arrayalumnosesoa.get(posicionalumno).getNombre());

        }

        if (posicioncurso==1) {
            String url1=(MainActivity.arrayalumnosbacha.get(posicionalumno).getEnlaceurl() );
            String url=url1+"?usp=sharing";
            insertarImagen(url,iv_pantallafoto4);

            tv_pantalladescripcion4.setText(MainActivity.arrayalumnosbacha.get(posicionalumno).getNombre());
        }

        if (posicioncurso==2) {
            String url1=(MainActivity.arrayalumnosdam.get(posicionalumno).getEnlaceurl() );
            String url=url1+"?usp=sharing";
            insertarImagen(url,iv_pantallafoto4);

            tv_pantalladescripcion4.setText(MainActivity.arrayalumnosdam.get(posicionalumno).getNombre());
        }



    }



    public void insertarImagen(String url, ImageView iv_pantallafoto4) {

        String[] p=url.split("/");
        //Create the new image link
        String imageLink="https://drive.google.com/uc?export=download&id="+p[5];
        //Toast.makeText(getContext(),imageLink,Toast.LENGTH_SHORT).show();

        Picasso.with(this)
                .load(imageLink)
                .error(R.mipmap.ic_launcher)
                .fit()
                .centerInside()
                .into(iv_pantallafoto4);
    }
}
