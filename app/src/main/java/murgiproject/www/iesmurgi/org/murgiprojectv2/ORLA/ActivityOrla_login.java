package murgiproject.www.iesmurgi.org.murgiprojectv2.ORLA;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


import murgiproject.www.iesmurgi.org.murgiprojectv2.R;

public class ActivityOrla_login extends AppCompatActivity {
    // ATRIBUTOS
    private Intent activityRegistro, activityPromocion;
    private EditText et_usuario, et_clave;
    private FirebaseAuth auth;
    private String correo,clave;

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
    } //END onStart

    public void registrar(View view) {
        activityRegistro = new Intent(this,ActivityOrla_Registro.class);
        startActivity(activityRegistro);
    }// END registrar

    public void iniciar_sesion(View view) {
        if (comprobar_acceso()){
            auth.signInWithEmailAndPassword(correo,clave).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                   if (task.isSuccessful()){
                       activityPromocion = new Intent(getApplicationContext(),PromocionActivity.class);
                       startActivity(activityPromocion);
                       et_usuario.setText("");
                       et_clave.setText("");
                    }else{
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
