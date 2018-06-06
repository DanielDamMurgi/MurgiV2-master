package murgiproject.www.iesmurgi.org.murgiprojectv2.ORLA;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import murgiproject.www.iesmurgi.org.murgiprojectv2.ORLA.alumno.FragmentoAlumno;
import murgiproject.www.iesmurgi.org.murgiprojectv2.R;

public class AlumnoActivity extends AppCompatActivity {

    private FragmentoAlumno fragmentoAlumno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumno);

        fragmentoAlumno = new FragmentoAlumno();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        fragmentoAlumno.alumnos.clear();

    }
}
