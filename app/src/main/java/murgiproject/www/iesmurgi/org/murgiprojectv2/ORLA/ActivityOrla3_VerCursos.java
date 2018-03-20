package murgiproject.www.iesmurgi.org.murgiprojectv2.ORLA;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import murgiproject.www.iesmurgi.org.murgiprojectv2.MainActivity;
import murgiproject.www.iesmurgi.org.murgiprojectv2.R;

public class ActivityOrla3_VerCursos extends AppCompatActivity {
    // atributos
    int posicion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityorla3_vercursosgv);

        posicion = getIntent().getExtras().getInt("Posicion");

        if (posicion==0) {
            Adapter_ActivityOrla3 adapter1= new Adapter_ActivityOrla3(this, MainActivity.arrayalumnosesoa);
            GridView gv_activityorla3 = (GridView) findViewById(R.id.gv_activityorla3);
            gv_activityorla3.setAdapter(adapter1);

            gv_activityorla3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent i1= new Intent(getApplicationContext(),ActivityOrla4_Veralumno.class); // Creo objeto Intent
                    i1.putExtra("PosicionCurso",0);
                    i1.putExtra("PosicionAlumno",position);
                    startActivity(i1);
                }
            });
        }

        if (posicion==1) {
            Adapter_ActivityOrla3 adapter1= new Adapter_ActivityOrla3(this, MainActivity.arrayalumnosbacha);
            GridView gv_activityorla3 = (GridView) findViewById(R.id.gv_activityorla3);
            gv_activityorla3.setAdapter(adapter1);
            gv_activityorla3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent i1= new Intent(getApplicationContext(),ActivityOrla4_Veralumno.class); // Creo objeto Intent
                    i1.putExtra("PosicionCurso",1);
                    i1.putExtra("PosicionAlumno",position);
                    startActivity(i1);
                }
            });
        }


        if (posicion==2) {
            Adapter_ActivityOrla3 adapter1= new Adapter_ActivityOrla3(this, MainActivity.arrayalumnosdam);
            GridView gv_activityorla3 = (GridView) findViewById(R.id.gv_activityorla3);
            gv_activityorla3.setAdapter(adapter1);

            gv_activityorla3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent i1= new Intent(getApplicationContext(),ActivityOrla4_Veralumno.class); // Creo objeto Intent
                    i1.putExtra("PosicionCurso",2);
                    i1.putExtra("PosicionAlumno",position);
                    startActivity(i1);
                }
            });
        }


    }

}





/*
        String url="";
        try {
            iv_pantallafotoa.setImageBitmap(DownloadImage(url));
        } catch (IOException e) {
            e.printStackTrace();
        }}




    public static InputStream LoadImageFromWebOperations(final String url) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                FTPClient ftpClient = new FTPClient();
                try {
                    ftpClient.connect("www.iesmurgi.org");
                    ftpClient.login("segundodam", "segundodam2017");
                    ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
                    inStream = ftpClient.retrieveFileStream(url);
                    ftpClient.disconnect();
                } catch (Exception e) {
                    System.out.println("el error es "+e.getMessage());
                }
            }
        });
        thread.start();

        while (thread.isAlive()){

        }

        return inStream;
    }

    public static Bitmap DownloadImage(String URL) throws IOException {
        Bitmap bitmap = null;
        InputStream in = null;
        in = LoadImageFromWebOperations(URL);
        bitmap = BitmapFactory.decodeStream(in);
        if(!(inStream == null)) {
            try {
                inStream.close();
            } catch (IOException e) {
                System.out.println("Error en bitmap");
            }
        }
        return bitmap;
    }
 */