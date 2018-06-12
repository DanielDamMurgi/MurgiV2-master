package murgiproject.www.iesmurgi.org.murgiprojectv2.ORLA.curso;

import android.app.Fragment;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;

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

import murgiproject.www.iesmurgi.org.murgiprojectv2.BBDD_Alumnos.Curso;
import murgiproject.www.iesmurgi.org.murgiprojectv2.R;

public class FragmentoCurso extends Fragment {

    private static final String TAG = "";
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    public ArrayList<Curso> cursos = new ArrayList<>();
    public ProgressDialog progressDialog_curso;
    private String numPro;
    private final String consulta = "select distinct curso.id_curso, curso.nombre from curso, alumno where alumno.promocion = ";
    ActualizacionCurso actualizacionCurso;

    public FragmentoCurso() {

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragmento_cursos,container,false);

        linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_cursos);


        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        getActivity().setTitle("Cursos");
        numPro= getActivity().getIntent().getExtras().getString("id_promocion");
        progressDialog_curso = new ProgressDialog(getActivity());
        progressDialog_curso.setMessage("Cargando Cursos...");

        if (cursos.isEmpty()){
        progressDialog_curso.show();



            new ConsultaCursos(consulta+numPro, progressDialog_curso).execute();
            actualizacionCurso = new ActualizacionCurso();
            actualizacionCurso.execute();
        }

    }



    public void lanzarAdapter() {
        CursoAdapter adapter = new CursoAdapter(getActivity(),cursos);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    /////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////
    public class ConsultaCursos extends AsyncTask<Void, Void, ResultSet> {

        android.app.AlertDialog dialog;
        String consultaCs;
        Connection conexPd;
        Statement sentenciaPd;
        ResultSet resultPro;

        private final String dir = "jdbc:mysql://www.iesmurgi.org:3306/bjeff";
        private final String usu = "ujeff";
        private final String pass = "pjeff";

        public ConsultaCursos(String consulta, ProgressDialog dialog) {
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
                    cursos.add(new Curso(
                            resultPro.getString("id_curso"),
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

    public class ActualizacionCurso extends AsyncTask<Void, Void, Void> {

        public ActualizacionCurso() {
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
            progressDialog_curso.dismiss();
        }
    }//Fin AsynTack
}//FIN CLASE PRINCIPAL
