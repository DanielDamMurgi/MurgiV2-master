package murgiproject.www.iesmurgi.org.murgiprojectv2.ORLA;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import murgiproject.www.iesmurgi.org.murgiprojectv2.ORLA.promocion.FragmentoPromocion;
import murgiproject.www.iesmurgi.org.murgiprojectv2.R;

public class PromocionActivity extends AppCompatActivity {

    private FragmentoPromocion fragmentoPromocion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promocion);

        fragmentoPromocion = new FragmentoPromocion();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        fragmentoPromocion.promociones.clear();

    }
}
