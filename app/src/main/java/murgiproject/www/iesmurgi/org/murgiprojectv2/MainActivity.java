package murgiproject.www.iesmurgi.org.murgiprojectv2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

import murgiproject.www.iesmurgi.org.murgiprojectv2.BBDD.Usuario;
import murgiproject.www.iesmurgi.org.murgiprojectv2.ORLA.ActivityOrla1_login;
import murgiproject.www.iesmurgi.org.murgiprojectv2.ORLA.Alumno;
import murgiproject.www.iesmurgi.org.murgiprojectv2.ORLA.Curso;

public class MainActivity extends AppCompatActivity {
    // Atributos
    public static ArrayList<Usuario> arrayusuarios = new ArrayList<Usuario>();
    public static ArrayList<Curso> arraycurso= new ArrayList<Curso>();

    public static ArrayList<Alumno> arrayalumnosesoa = new ArrayList<Alumno>();
    public static ArrayList<Alumno> arrayalumnosbacha = new ArrayList<Alumno>();
    public static ArrayList<Alumno> arrayalumnosdam = new ArrayList<Alumno>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (savedInstanceState==null) {
            crearCursos();
            crearAlumnos();
        }


        // Al pulsar

        ImageView iv_orla = (ImageView) findViewById(R.id.iv_orla);
        iv_orla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityOrla1_login.class);
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

    private void crearCursos() {
        arraycurso.add(new Curso("ESO A"));
       // arraycurso.add(new Curso("ESO B"));
       // arraycurso.add(new Curso("ESO C"));
        arraycurso.add(new Curso("BACH A"));
       // arraycurso.add(new Curso("BACH B"));
       // arraycurso.add(new Curso("BACH C"));
        arraycurso.add(new Curso("DAM"));
      //  arraycurso.add(new Curso("GAD"));

    }

    private void crearAlumnos() {
        insertaresoa();
        insertarbacha();
        insertardam();
    }

    private void insertaresoa() {
        // ESO A
        arrayalumnosesoa.add(new Alumno("rodriguez olvera, isabel","ESO A","https://drive.google.com/file/d/0B1hz1D7khQcJem5YX21LN2Q5Znc/view"));
        arrayalumnosesoa.add(new Alumno("reyes sanchez, blanca","ESO A","https://drive.google.com/file/d/0B1hz1D7khQcJTmV3RkZwTVg3YkU/view"));
        arrayalumnosesoa.add(new Alumno("ramos garcia, marga","ESO A","https://drive.google.com/file/d/0B1hz1D7khQcJQ1d4R3pJbnR4SnM/view"));
       // arrayalumnosesoa.add(new Alumno("ramos acuyo, cristina","ESO A","https://drive.google.com/file/d/0B1hz1D7khQcJSkxTNnRUREVPQ3c/view"));
        arrayalumnosesoa.add(new Alumno("perez amo, paula","ESO A","https://drive.google.com/file/d/0B1hz1D7khQcJSHlKQ1hLVk10Yk0/view"));
        arrayalumnosesoa.add(new Alumno("muñoz maldonado, lola","ESO A","https://drive.google.com/file/d/0B1hz1D7khQcJMGhHSDJuNVlzWTA/view"));
        arrayalumnosesoa.add(new Alumno("mkhimri ajana, chaimae","ESO A","https://drive.google.com/file/d/0B1hz1D7khQcJZ01aLVpsSnhkQ3M/view"));
        arrayalumnosesoa.add(new Alumno("lopez perez, laura","ESO A","https://drive.google.com/file/d/0B1hz1D7khQcJWVNJdTZuX3A2T00/view"));
        arrayalumnosesoa.add(new Alumno("granados garcia, rocio","ESO A","https://drive.google.com/file/d/0B1hz1D7khQcJbVBCV21PeEM1Rms/view"));
        arrayalumnosesoa.add(new Alumno("garcia barrionuevo, ana maria.","ESO A","https://drive.google.com/file/d/0B1hz1D7khQcJRkhUNXhUUG1CeTA/view"));
        arrayalumnosesoa.add(new Alumno("frias escobar, marta","ESO A","https://drive.google.com/file/d/0B1hz1D7khQcJOVZ5NTJXUW5tODA/view"));
        arrayalumnosesoa.add(new Alumno("figueredo rubio, francisco","ESO A","https://drive.google.com/file/d/0B1hz1D7khQcJT01RNXJpU2ZiWVE/view"));
        arrayalumnosesoa.add(new Alumno("fernandez torrecillas, maria","ESO A","https://drive.google.com/file/d/0B1hz1D7khQcJUVJBRlgtRWRBOEE/view"));
        arrayalumnosesoa.add(new Alumno("fernandez gualda, pablo","ESO A","https://drive.google.com/file/d/0B1hz1D7khQcJaVNsS3FSRm9WTUk/view"));
        arrayalumnosesoa.add(new Alumno("fernandez diaz-delgado, andrea","ESO A","https://drive.google.com/file/d/0B1hz1D7khQcJNWg3QlZ3S3JodWM/view"));
        arrayalumnosesoa.add(new Alumno("diaz barragan, cristina","ESO A","https://drive.google.com/file/d/0B1hz1D7khQcJNmJ2LWIzQTRFS1E/view"));
        arrayalumnosesoa.add(new Alumno("cavalli diaz, maria","ESO A","https://drive.google.com/file/d/0B1hz1D7khQcJcGFLRlVPWjlWNzQ/view"));
        arrayalumnosesoa.add(new Alumno("britit, intissar","ESO A","https://drive.google.com/file/d/0B1hz1D7khQcJbkF5ZjdfZm9BVEU/view"));
        arrayalumnosesoa.add(new Alumno("brao gutierrez, patricia","ESO A","https://drive.google.com/file/d/0B1hz1D7khQcJNTIyNGgzQTZJRGc/view"));
        arrayalumnosesoa.add(new Alumno("amziab, aouafaa","ESO A","https://drive.google.com/file/d/0B1hz1D7khQcJY3JSdmQyaER0ZW8/view"));
    }

    private void insertarbacha() {
        // BACH A
        arrayalumnosbacha.add(new Alumno("vidaña guerra, noelia","BACH A","https://drive.google.com/file/d/0B1hz1D7khQcJcnB2aVRZZWxuMjA/view"));
        arrayalumnosbacha.add(new Alumno("victoria martin, jose francisco","BACH A","https://drive.google.com/file/d/0B1hz1D7khQcJX2IzWTFvVFJFVVU/view"));
        arrayalumnosbacha.add(new Alumno("vargas lopez, mirella","BACH A","https://drive.google.com/file/d/0B1hz1D7khQcJblZTNGwzd2xhNDg/view"));
        arrayalumnosbacha.add(new Alumno("suarez hidalgo, lucia","BACH A","https://drive.google.com/file/d/0B1hz1D7khQcJMGJfNWRfRGpvNUU/view"));
        arrayalumnosbacha.add(new Alumno("sorroche martinez, marina","BACH A","https://drive.google.com/file/d/0B1hz1D7khQcJa1g4YXFFNVU4ZVE/view"));
        arrayalumnosbacha.add(new Alumno("salvador alcocer, rosa","BACH A","https://drive.google.com/file/d/0B1hz1D7khQcJWDRFR19leTdvbEE/view"));
        arrayalumnosbacha.add(new Alumno("rubio luque, jose","BACH A","https://drive.google.com/file/d/0B1hz1D7khQcJcGxLalRPX2xYajQ/view"));
        arrayalumnosbacha.add(new Alumno("rodriguez gomez, miguel angel","BACH A","https://drive.google.com/file/d/0B1hz1D7khQcJM0FtWFJzTFBxSk0/view"));
        arrayalumnosbacha.add(new Alumno("nieto ruiz, noelia","BACH A","https://drive.google.com/file/d/0B1hz1D7khQcJX2F6dVlpaFd0dGs/view"));
        arrayalumnosbacha.add(new Alumno("moreno lopez, maria","BACH A","https://drive.google.com/file/d/0B1hz1D7khQcJaUJKRnhKS2wyV1E/view"));
        arrayalumnosbacha.add(new Alumno("mingorance garzon, borja","BACH A","https://drive.google.com/file/d/0B1hz1D7khQcJc0g0aTVrY1BNQ2s/view"));
        arrayalumnosbacha.add(new Alumno("martinez medina, jefferson omar","BACH A","https://drive.google.com/file/d/0B1hz1D7khQcJUVNsdDg0UnI1MW8/view"));
        arrayalumnosbacha.add(new Alumno("martin paredes, raquel","BACH A","https://drive.google.com/file/d/0B1hz1D7khQcJdk1ISUNjOU5tM2s/view"));
        arrayalumnosbacha.add(new Alumno("jimenez cespedes, cristina","BACH A","https://drive.google.com/file/d/0B1hz1D7khQcJcGpzY1Y3T0FwREk/view"));
        arrayalumnosbacha.add(new Alumno("hidalgo fernandez, luz maria","BACH A","https://drive.google.com/file/d/0B1hz1D7khQcJQUIwNEZfOWd2VEE/view"));
        arrayalumnosbacha.add(new Alumno("gomez ruiz, carlos","BACH A","https://drive.google.com/file/d/0B1hz1D7khQcJcmVDNE9oU01XUzA/view"));
        arrayalumnosbacha.add(new Alumno("garcia granados, laura","BACH A","https://drive.google.com/file/d/0B1hz1D7khQcJMG0wUnUwTjlNODQ/view"));
        arrayalumnosbacha.add(new Alumno("fernandez lopez, minerva","BACH A","https://drive.google.com/file/d/0B1hz1D7khQcJVHBFRGdyOUk1SXc/view"));
        arrayalumnosbacha.add(new Alumno("fernan diaz-delgado, daniel antonio","BACH A","https://drive.google.com/file/d/0B1hz1D7khQcJVlZmRlhnUW04TVE/view"));
        arrayalumnosbacha.add(new Alumno("alvarez packham, amy.","BACH A","https://drive.google.com/file/d/0B1hz1D7khQcJRmR6bDlPOVF1amc/view"));
    }

    private void insertardam() {
        arrayalumnosdam.add(new Alumno("rodriguez lopez, claudio","DAM","https://drive.google.com/file/d/0B1hz1D7khQcJVE9tVW95d2RpLW8/view"));
        arrayalumnosdam.add(new Alumno("perez herrera, jose maria","DAM","https://drive.google.com/file/d/0B1hz1D7khQcJbm03Z1lOUkJNU0k/view"));
        arrayalumnosdam.add(new Alumno("monge torcuato, luis enrique","DAM","https://drive.google.com/file/d/0B1hz1D7khQcJZlRQa3lxNER2WFk/view"));
        arrayalumnosdam.add(new Alumno("martos garcia, jose francisco","DAM","https://drive.google.com/file/d/0B1hz1D7khQcJWDJFcnFNaG1jWlk/view"));
        arrayalumnosdam.add(new Alumno("jodar sanchez, miguel","DAM","https://drive.google.com/file/d/0B1hz1D7khQcJajByb3lOc2tCdFk/view"));
        arrayalumnosdam.add(new Alumno("gutierrez garcia, raquel","DAM","https://drive.google.com/file/d/0B1hz1D7khQcJekV1V3pPcU1QUkE/view"));
        arrayalumnosdam.add(new Alumno("gutierrez garcia, oscar","DAM","https://drive.google.com/file/d/0B1hz1D7khQcJaDJqb0Zfd3ZpRzA/view"));
        arrayalumnosdam.add(new Alumno("gomez montoya, ruben","DAM","https://drive.google.com/file/d/0B1hz1D7khQcJZ200Nkl2Y0xJR3c/view"));
        arrayalumnosdam.add(new Alumno("cano asensio, juan jose","DAM","https://drive.google.com/file/d/0B1hz1D7khQcJbER5a1dGRnhlbjg/view"));
        arrayalumnosdam.add(new Alumno("borrego ruiz, ismael","DAM","https://drive.google.com/file/d/0B1hz1D7khQcJZ2ZOOThkZVpXV1U/view"));
    }


}
