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

import murgiproject.www.iesmurgi.org.murgiprojectv2.BBDD_Alumnos.ObtenerDatosBD;
import murgiproject.www.iesmurgi.org.murgiprojectv2.R;

public class ActivityOrla_login extends AppCompatActivity {
    // ATRIBUTOS
    //private boolean bandera=false; // para saber si el usuario se loguea de manera correcta
    private Intent activityRegistro, activityCursos;
    private EditText et_usuario, et_clave;
    private FirebaseAuth auth;
    private String correo,clave;
    public ProgressDialog progressDialog;
    private Button ini;

    // IMPLEMENTACION
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityorla_login);

    } // END onCreate

    @Override
    protected void onStart() {
        super.onStart();

        et_usuario = (EditText)findViewById(R.id.et_usuario);
        et_clave= (EditText)findViewById(R.id.et_clave);

        auth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);

        ini = (Button) findViewById(R.id.b_iniciar);

        ini.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                activityCursos = new Intent(getApplicationContext(),PromocionActivity.class);
                new ObtenerDatosBD(ActivityOrla_login.this).execute();
                startActivity(activityCursos);
                return  true;
            }
        });

    } //END onStart

    public void registrar(View view) {
        activityRegistro = new Intent(this,ActivityOrla_Registro.class);
        startActivity(activityRegistro);

    }// END registrar

    public void iniciar_sesion(View view) {

        if (comprobar_acceso()){
            progressDialog.setMessage(getResources().getString(R.string.iniciciando_sesion));
            progressDialog.show();

            auth.signInWithEmailAndPassword(correo,clave).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        new ObtenerDatosBD(ActivityOrla_login.this).execute();

                        activityCursos = new Intent(getApplicationContext(),PromocionActivity.class);
                        startActivity(activityCursos);


                        et_usuario.setText("");
                        et_clave.setText("");
                    }else{
                        progressDialog.cancel();
                        Toast.makeText(getApplicationContext(), getResources().getString(R.string.clave_contra_incorrectas), Toast.LENGTH_LONG).show();
                    }

                }
            });
        }

    }// END iniciar_sesion

    private boolean comprobar_acceso(){
        correo = et_usuario.getText().toString().trim();
        clave = et_clave.getText().toString();

        if (correo.isEmpty() || clave.isEmpty()) {
            if (correo.isEmpty()) {
                Toast.makeText(this, getResources().getString(R.string.inserta_correo), Toast.LENGTH_LONG).show();
                return false;
            } else {
                Toast.makeText(this, getResources().getString(R.string.inserta_contraseña), Toast.LENGTH_LONG).show();
                return false;
            }
        }
        return true;
    }// END comprobar_acceso
}
