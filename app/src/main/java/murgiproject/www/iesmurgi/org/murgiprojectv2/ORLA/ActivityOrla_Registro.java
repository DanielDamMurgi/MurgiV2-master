package murgiproject.www.iesmurgi.org.murgiprojectv2.ORLA;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.Console;

import murgiproject.www.iesmurgi.org.murgiprojectv2.R;

public class ActivityOrla_Registro extends AppCompatActivity {

    private EditText correo, clave1, clave2;
    private FirebaseAuth auth;
    private String email, pass, auxPass;
    private ProgressDialog progressDialog;
    private String TAG;
    private Intent activityLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orla__registro);


    }

    @Override
    protected void onStart() {
        super.onStart();

        //FirebaseUser currentUser = auth.getCurrentUser();
        //updateUI(currentUser);

        correo = (EditText) findViewById(R.id.TXT_Registro_Correo);
        clave1 = (EditText) findViewById(R.id.TXT_Registro_Contraseña);
        clave2 = (EditText) findViewById(R.id.TXT_Registro_RepetirContraseña);

        auth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);
        activityLogin = new Intent(getApplicationContext(), ActivityOrla1_login.class);


    }

    public void registro(View view) {

        if (comprobarCampos()) {
            progressDialog.setMessage("Registrando usuario...");
            progressDialog.show();

            auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        progressDialog.cancel();
                        Toast.makeText(ActivityOrla_Registro.this, "Registrado correctamente", Toast.LENGTH_SHORT).show();
                        startActivity(activityLogin);
                        ///FirebaseUser user = auth.getCurrentUser();
                        //updateUI(user);
                    } else {
                        progressDialog.cancel();

                        //Log.v(TAG, "createUserWithEmail:failure", task.getException());
                        Toast.makeText(ActivityOrla_Registro.this, "Fallo de registro."+task.getException(),
                                Toast.LENGTH_SHORT).show();
                        //updateUI(null);
                    }
                }
            });
        }
    }

    private boolean comprobarCampos() {


        if (correo.getText().length() <=0 || clave1.getText().length() <=0 || clave2.getText().length()<=0) {

            if (correo.getText().length() <=0) {
                Toast.makeText(this, "Inserta el correo", Toast.LENGTH_LONG).show();
                return false;
            } else if (clave1.getText().length() <=0) {
                Toast.makeText(this, "Inserta la contraseña", Toast.LENGTH_LONG).show();
                return false;
            } else {
                Toast.makeText(this, "Inserta la repetición de la contraseña", Toast.LENGTH_LONG).show();
                return false;
            }
        } else {
            email = correo.getText().toString().trim();
            pass = clave1.getText().toString();
            auxPass = clave2.getText().toString();

            if (!pass.equals(auxPass)) {
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_LONG).show();
                return false;
            }

        }

        return true;
    }

}
