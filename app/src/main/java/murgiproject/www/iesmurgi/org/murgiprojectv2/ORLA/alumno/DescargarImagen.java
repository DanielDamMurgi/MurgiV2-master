package murgiproject.www.iesmurgi.org.murgiprojectv2.ORLA.alumno;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.InputStream;

public class DescargarImagen extends AsyncTask<String, Void, Bitmap> {
    private ImageView imageView;
    private Bitmap imagen;

    public DescargarImagen(ImageView imageView) {
        this.imageView = imageView;
    }

    protected Bitmap doInBackground(String... urls) {
        String urldisplay = urls[0];
        try {
            InputStream in = new java.net.URL(urldisplay).openStream();
            imagen = BitmapFactory.decodeStream(in);
        } catch (Exception e) {

        }
        return imagen;
    }

    @SuppressLint("NewApi")
    protected void onPostExecute(Bitmap result) {
        if (result != null) {
            imageView.setImageBitmap(result);
        }
    }
}
