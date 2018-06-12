package murgiproject.www.iesmurgi.org.murgiprojectv2.ORLA.promocion;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import murgiproject.www.iesmurgi.org.murgiprojectv2.BBDD_Alumnos.Promocion;
import murgiproject.www.iesmurgi.org.murgiprojectv2.R;

public class FragmentoPromocion extends Fragment {
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    public ArrayList<Promocion> promociones = new ArrayList<>();
    public ProgressDialog progressDialog_promocion;
    private final String consulta = "select * from promocion";
    ActualizacionPromocion actualizacionPromocion;

    public FragmentoPromocion() {

    }

    @Override
    public void onStart() {
        super.onStart();
        getActivity().setTitle("Promociones");
        progressDialog_promocion = new ProgressDialog(getActivity());
        progressDialog_promocion.setMessage("Cargando Promociones...");

        if (promociones.isEmpty()) {
            progressDialog_promocion.show();
            new ConsultaPromocion(consulta, progressDialog_promocion).execute();
            actualizacionPromocion = new ActualizacionPromocion();
            actualizacionPromocion.execute();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragmento_promocion, container, false);

        linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_promocion);

        return view;
    }

    public void lanzarAdapter() {
        PromocionAdapter adapter = new PromocionAdapter(getActivity(), promociones);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    /////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////
    public class ConsultaPromocion extends AsyncTask<Void, Void, ResultSet> {

        android.app.AlertDialog dialog;
        String consultaPd;
        Connection conexPd;
        Statement sentenciaPd;
        ResultSet resultPro;

        private final String dir = "jdbc:mysql://www.iesmurgi.org:3306/bjeff";
        private final String usu = "ujeff";
        private final String pass = "pjeff";

        public ConsultaPromocion(String consulta, ProgressDialog dialog) {
            this.consultaPd = consulta;
            this.dialog = dialog;
        }

        @Override
        protected ResultSet doInBackground(Void... params) {
            try {
                conexPd = DriverManager.getConnection(dir, usu, pass);
                sentenciaPd = conexPd.createStatement();
                resultPro = null;
                publishProgress();

                resultPro = sentenciaPd.executeQuery(consultaPd);

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return resultPro;
        }

        /**
         * Va añadiendo al arraylist de vistapedidos, los datos de la bbdd sobre la consulta.
         *
         * @param resultSet
         */
        @Override
        protected void onPostExecute(ResultSet resultSet) {
            super.onPostExecute(resultSet);
            try {
                while (resultSet.next()) {
                    promociones.add(new Promocion(
                            resultPro.getString("id_promocion"),
                            resultPro.getString("nombre")
                    ));
                }
                lanzarAdapter();

                conexPd.close();
                sentenciaPd.close();
                resultPro.close();


            } catch (Exception ex) {
            }
            dialog.dismiss();
        }
    }//Fin AsynTack


///////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////

    public class ActualizacionPromocion extends AsyncTask<Void, Void, Void> {

        private FragmentoPromocion frtPromocion;

        public ActualizacionPromocion() {
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            publishProgress();
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... voids) {
            super.onProgressUpdate();
            progressDialog_promocion.dismiss();
        }
    }//Fin AsynTack
}//Activity
