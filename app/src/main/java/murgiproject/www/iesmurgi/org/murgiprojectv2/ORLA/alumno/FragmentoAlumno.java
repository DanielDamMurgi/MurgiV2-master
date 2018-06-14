package murgiproject.www.iesmurgi.org.murgiprojectv2.ORLA.alumno;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import murgiproject.www.iesmurgi.org.murgiprojectv2.BBDD_Alumnos.Alumno;
import murgiproject.www.iesmurgi.org.murgiprojectv2.R;

public class FragmentoAlumno extends Fragment {

    private static final String TAG = "";
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    public ArrayList<Alumno> alumnos = new ArrayList<>();
    public ProgressDialog progressDialog_alumno;
    private String numCurso;
    private String numPromocion;
    private String consulta;
    ActualizacionAlumno actualizacionAlumno;

    public FragmentoAlumno() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_fragmento_alumno, container, false);

        linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_alumnos);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        getActivity().setTitle("Fotos orla");
        numCurso = getActivity().getIntent().getExtras().getString("id_curso");
        numPromocion = getActivity().getIntent().getExtras().getString("id_promo");
        progressDialog_alumno = new ProgressDialog(getActivity());
        progressDialog_alumno.setMessage("Cargando Alumnos...");

        Log.d(TAG,"curso "+numCurso+ "promo "+numPromocion);

        if (alumnos.isEmpty()){
            progressDialog_alumno.show();
            new ConsultaAlumnos("select distinct id_al, nombre, app,app2,rutaImg from alumno where id_curso = "+numCurso+" AND promocion = "+numPromocion, progressDialog_alumno).execute();
            actualizacionAlumno = new ActualizacionAlumno();
            actualizacionAlumno.execute();
        }
    }

    public void lanzarAdapter() {
        AlumnoAdapter adapter = new AlumnoAdapter(getActivity(),alumnos);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    /////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////
    public class ConsultaAlumnos extends AsyncTask<Void, Void, ResultSet> {

        android.app.AlertDialog dialog;
        String consultaCs;
        Connection conexPd;
        Statement sentenciaPd;
        ResultSet resultPro;

        private final String dir = "jdbc:mysql://www.iesmurgi.org:3306/bjeff";
        private final String usu = "ujeff";
        private final String pass = "pjeff";

        public ConsultaAlumnos(String consulta, ProgressDialog dialog) {
            this.consultaCs = consulta;
            this.dialog = dialog;
        }

        @Override
        protected ResultSet doInBackground(Void... params) {
            try {
                conexPd = DriverManager.getConnection(dir, usu, pass);
                sentenciaPd = conexPd.createStatement();
                resultPro = null;
                publishProgress();

                if (consultaCs.startsWith("select"))
                    resultPro = sentenciaPd.executeQuery(consultaCs);

                if (consultaCs.startsWith("update") || consultaCs.startsWith("delete")) {
                    sentenciaPd.executeUpdate(consultaCs);
                }

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
                    alumnos.add(new Alumno(
                            resultPro.getString("id_al"),
                            resultPro.getString("nombre"),
                            resultPro.getString("app"),
                            resultPro.getString("app2"),
                            resultPro.getString("rutaImg")
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

    public class ActualizacionAlumno extends AsyncTask<Void, Void, Void> {

        public ActualizacionAlumno() {
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Thread.sleep(3500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            publishProgress();
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... voids) {
            super.onProgressUpdate();
            progressDialog_alumno.dismiss();
        }
    }//Fin AsynTack
}
