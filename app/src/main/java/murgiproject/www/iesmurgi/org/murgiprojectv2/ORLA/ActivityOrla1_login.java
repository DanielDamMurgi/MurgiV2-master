package murgiproject.www.iesmurgi.org.murgiprojectv2.ORLA;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.security.MessageDigest;

import murgiproject.www.iesmurgi.org.murgiprojectv2.MainActivity;
import murgiproject.www.iesmurgi.org.murgiprojectv2.R;

public class ActivityOrla1_login extends AppCompatActivity {
    // Atributos
    private boolean bandera=false; // para saber si el usuario se loguea de manera correcta
    private Intent activityRegistro, activityCursos;
    private EditText et_usuario, et_clave;
    private FirebaseAuth auth;
    private String correo,clave;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityorla1_login);

    }

    @Override
    protected void onStart() {
        super.onStart();

        et_usuario = (EditText)findViewById(R.id.et_usuario);
        et_clave= (EditText)findViewById(R.id.et_clave);

        auth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);




       /* Button b_iniciar = (Button) findViewById(R.id.b_iniciar);
        b_iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


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
        });*/
    }

    public void registrar(View view) {
        activityRegistro = new Intent(this,ActivityOrla_Registro.class);
        startActivity(activityRegistro);

    }

    public void iniciar_sesion(View view) {

        correo = et_usuario.getText().toString().trim();
        clave = et_clave.getText().toString();

        if (correo.isEmpty() || clave.isEmpty()){
            if (correo.isEmpty()){
                Toast.makeText(this,"Inserta el correo",Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this, "Inserta la contraseña",Toast.LENGTH_LONG).show();
            }
        }else{
            progressDialog.setMessage("Iniciando sesión...");
            progressDialog.show();

            auth.signInWithEmailAndPassword(correo,clave).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(getApplicationContext(), "Nom oorrecta", Toast.LENGTH_LONG);
                        progressDialog.cancel();
                        activityCursos = new Intent(getApplicationContext(),ActivityOrla2_Cursos.class);
                        activityCursos.putExtra("Posicion",3);
                        startActivity(activityCursos);
                    }else{
                        progressDialog.cancel();
                        Toast.makeText(getApplicationContext(), "Nombre de usuario o clave incorrecta", Toast.LENGTH_LONG);
                    }

                }
            });
        }




    }
}
