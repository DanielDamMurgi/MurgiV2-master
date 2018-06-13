package murgiproject.www.iesmurgi.org.murgiprojectv2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import murgiproject.www.iesmurgi.org.murgiprojectv2.ORLA.ActivityOrla_login;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Al pulsar

        ImageView iv_orla = (ImageView) findViewById(R.id.iv_orla);
        iv_orla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityOrla_login.class);
                startActivity(intent);
            }
        });

        ImageView iv_historia = (ImageView) findViewById(R.id.iv_historia);
        iv_historia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Historia.class);
                startActivity(intent);
            }
        });

        ImageView iv_contacto = (ImageView) findViewById(R.id.iv_contacto);
        iv_contacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Contacto.class);
                startActivity(intent);
            }
        });

        ImageView iv_matricula = (ImageView) findViewById(R.id.iv_matricula);
        iv_matricula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Matriculacion.class);
                startActivity(intent);
            }
        });

        ImageView iv_mapa = (ImageView) findViewById(R.id.iv_mapa);
        iv_mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(intent);
            }
        });

        ImageView iv_cursos = (ImageView) findViewById(R.id.iv_cursos);
        iv_cursos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), VerCategoriasCursos.class);
                startActivity(intent);
            }
        });

        ImageView iv_citas = (ImageView) findViewById(R.id.iv_citas);
        iv_citas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Citas.class);
                startActivity(intent);
            }
        });

        ImageView iv_acercade = (ImageView) findViewById(R.id.iv_acercade);
        iv_acercade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // intent activity sobre acerca de nosotros programadores
                Intent i1 = new Intent(getApplicationContext(), Activity_Nosotros.class);
                startActivity(i1);
            }
        });
    }

}
