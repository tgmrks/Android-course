package com.example.ismael.aula17softbluedownload;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.v4.graphics.drawable.DrawableWrapper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.InputStream;

public class MainActivity extends Activity {

    private static final String IMG_PATH = "http://www.softblue.com.br/public/images/sbv2_logotipo.png";
    private ImageView img;
    private ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = (ImageView) findViewById(R.id.img1);
        progress = (ProgressBar) findViewById(R.id.progress1);
    }

    public void download(View view) {

        DownloadTask task = new DownloadTask();
        task.execute(IMG_PATH);
    }

    public class DownloadTask extends AsyncTask<String, Void, Drawable> {

        @Override
        protected void onPreExecute() {
            img.setVisibility(View.GONE);
            progress.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(Drawable drawable) {
            img.setImageDrawable(drawable);
            img.setVisibility(View.VISIBLE);
            progress.setVisibility(View.GONE);
        }

        @Override
        protected Drawable doInBackground(String... params) {
            String url = params[0];

                DefaultHttpClient http = null;
                InputStream in = null;

            try {
                try {
                    http = new DefaultHttpClient();
                    HttpGet get = new HttpGet(url);

                    HttpResponse response = http.execute(get);
                    in = response.getEntity().getContent();
                    return BitmapDrawable.createFromStream(in, null);
                } finally {
                    if (in != null) {
                        in.close();
                    }

                    if (http != null) {
                        http.getConnectionManager().shutdown();
                    }
                }
            } catch (Exception e){
                e.printStackTrace();
                return  null;
            }

        }
    }

}
