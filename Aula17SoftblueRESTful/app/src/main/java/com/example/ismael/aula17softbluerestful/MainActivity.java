package com.example.ismael.aula17softbluerestful;

import android.content.Entity;
import android.os.AsyncTask;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String URL = "http://code.softblue.com.br:8080/web/Somar";

    private EditText edtValor1;
    private EditText edtValor2;
    private RadioGroup grpMethod;
    private TextView txtResult;
    private ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtValor1 = (EditText) findViewById(R.id.edt1);
        edtValor2 = (EditText) findViewById(R.id.edt2);
        grpMethod = (RadioGroup) findViewById(R.id.rGroup);
        txtResult = (TextView) findViewById(R.id.txt_result);
        progress = (ProgressBar) findViewById(R.id.pbar1);

    }

    public void invoke (View view) {
        Integer valor1 = Integer.valueOf(edtValor1.getText().toString());
        Integer valor2 = Integer.valueOf(edtValor2.getText().toString());

        InvokeWebServiceTask task = new InvokeWebServiceTask();
        task.execute(valor1, valor2, grpMethod.getCheckedRadioButtonId());
    }

    public class InvokeWebServiceTask extends AsyncTask <Integer, Void, Integer> {
        @Override
        protected void onPreExecute() {
            progress.setVisibility(View.VISIBLE);
            txtResult.setVisibility(View.GONE);
        }

        @Override
        protected void onPostExecute(Integer result) {
            txtResult.setText(result.toString());
            progress.setVisibility(View.GONE);
            txtResult.setVisibility(View.VISIBLE);
        }

        @Override
        protected Integer doInBackground(Integer... params) {
            Integer valor1 = params[0];
            Integer valor2 = params[1];
            int checkedMethodId = params[2];

            if (checkedMethodId == R.id.rdb1) {
                return callWebServiceGet(valor1, valor2);
            } else {
                return callWebServicePost(valor1, valor2);
            }
        }
    }

    public Integer callWebServiceGet (int valor1, int valor2) {

        try {
            HttpClient http = new DefaultHttpClient();

            List<NameValuePair> params = new ArrayList<>();
            params.add(new BasicNameValuePair("v1", String.valueOf(valor1)));
            params.add(new BasicNameValuePair("v2", String.valueOf(valor2)));

            //REQUEST VAI NO CORPO DA URL
            String paramsStr = URLEncodedUtils.format(params, HTTP.UTF_8);

            HttpGet get = new HttpGet(URL + "?" + paramsStr);
            HttpResponse response = http.execute(get);

            String result = EntityUtils.toString(response.getEntity());

            return  Integer.valueOf(result);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    public Integer callWebServicePost (int valor1, int valor2) {

        try {
            HttpClient http = new DefaultHttpClient();
            //REQUEST É ENCAPSULADA
            HttpPost post = new HttpPost(URL);

            List<NameValuePair> params = new ArrayList<>();
            params.add(new BasicNameValuePair("v1", String.valueOf(valor1)));
            params.add(new BasicNameValuePair("v2", String.valueOf(valor2)));

            post.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));

            HttpResponse response = http.execute(post);

            String result = EntityUtils.toString(response.getEntity());

            return Integer.valueOf(result);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
}
