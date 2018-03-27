package murgiproject.www.iesmurgi.org.murgiprojectv2.ORLA;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import murgiproject.www.iesmurgi.org.murgiprojectv2.MainActivity;
import murgiproject.www.iesmurgi.org.murgiprojectv2.R;

public class ActivityOrla2_Cursos extends AppCompatActivity {
    // Atributos
    int posicion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityorla2_cursoslv);

        posicion=getIntent().getExtras().getInt("Posicion");

        //Adapter
        Adapter_ActivityOrla2 adapter1= new Adapter_ActivityOrla2(this, MainActivity.arraycurso);
        ListView lv_orlacursos = (ListView)findViewById(R.id.lv_orlacursos);

       // lv_orlacursos.setAdapter(adapter1);
        lv_orlacursos.setAdapter(adapter1);

        lv_orlacursos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){

                    case 0:
                        if (posicion==0 || posicion==3) {
                            String aux= MainActivity.arraycurso.get(position).getNombrecurso();
                            Toast.makeText(getApplicationContext(),aux,Toast.LENGTH_SHORT).show();
                            Intent i1= new Intent(getApplicationContext(),ActivityOrla3_VerCursos.class); // Creo objeto Intent
                            i1.putExtra("Posicion",position);
                            startActivity(i1);
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"No tienes permiso para este curso",Toast.LENGTH_SHORT).show();
                        }

                        break;
                    case 1:
                        if (posicion==1 || posicion==3) {
                            String aux1= MainActivity.arraycurso.get(position).getNombrecurso();
                            Toast.makeText(getApplicationContext(),aux1,Toast.LENGTH_SHORT).show();
                            Intent i1= new Intent(getApplicationContext(),ActivityOrla3_VerCursos.class); // Creo objeto Intent
                            i1.putExtra("Posicion",position);
                            startActivity(i1);
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"No tienes permiso para este curso",Toast.LENGTH_SHORT).show();
                        }

                        break;
                    case 2:
                        if (posicion==2 || posicion==3) {
                            String aux2= MainActivity.arraycurso.get(position).getNombrecurso();
                            Toast.makeText(getApplicationContext(),aux2,Toast.LENGTH_SHORT).show();
                            Intent i1= new Intent(getApplicationContext(),ActivityOrla3_VerCursos.class); // Creo objeto Intent
                            i1.putExtra("Posicion",position);
                            startActivity(i1);
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"No tienes permiso para este curso",Toast.LENGTH_SHORT).show();
                        }

                        break;
                    default:

                        Toast.makeText(getApplicationContext(),"default",Toast.LENGTH_SHORT).show();
                        break;

                }
            }
        });



    }
}
