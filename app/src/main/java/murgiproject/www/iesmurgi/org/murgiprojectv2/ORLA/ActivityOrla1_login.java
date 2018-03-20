package murgiproject.www.iesmurgi.org.murgiprojectv2.ORLA;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import murgiproject.www.iesmurgi.org.murgiprojectv2.MainActivity;
import murgiproject.www.iesmurgi.org.murgiprojectv2.R;

public class ActivityOrla1_login extends AppCompatActivity {
    // Atributos
    private boolean bandera=false; // para saber si el usuario se loguea de manera correcta

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityorla1_login);

        Button b_iniciar = (Button) findViewById(R.id.b_iniciar);
        b_iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et_usuario = (EditText)findViewById(R.id.et_usuario);
                EditText et_clave = (EditText)findViewById(R.id.et_clave);

                String nombre= et_usuario.getText().toString();
                String clave= et_clave.getText().toString();

                int posicion=0;

                for(int i=0;i< MainActivity.arrayusuarios.size();i++) {
                    if (nombre.equals(MainActivity.arrayusuarios.get(i).getNombre()) && clave.equals(MainActivity.arrayusuarios.get(i).getClave())) {
                        bandera=true;
                        posicion=i;
                    }
                }


                if (bandera==true) {
                    Toast toast1 = Toast.makeText(getApplicationContext(), "Te has logueado de manera correcta", Toast.LENGTH_LONG);
                    toast1.show();
                    bandera=false;

                    Intent i1= new Intent(getApplicationContext(),ActivityOrla2_Cursos.class); // Creo objeto Intent
                    i1.putExtra("Posicion",posicion);
                    startActivity(i1);
                }

                else { // si es falso
                    Toast toast1 = Toast.makeText(getApplicationContext(), "Nombre de usuario o clave incorrecta", Toast.LENGTH_LONG);
                    toast1.show();
                }

            }
        });


    }
}
