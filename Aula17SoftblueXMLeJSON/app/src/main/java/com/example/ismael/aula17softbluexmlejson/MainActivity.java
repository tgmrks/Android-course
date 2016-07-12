package com.example.ismael.aula17softbluexmlejson;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private static final String URL = "http://code.softblue.com.br:8080/web/GerarNumeros";

    private EditText edtMin, edtMax, edtQtde;
    private RadioGroup grpFormat;
    private TextView txtNumeros;
    private ProgressBar progress;

    private DataHandler.Format format;
    private String requestStr;
    private String responseStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtMin = (EditText)findViewById(R.id.edt_min);
        edtMax = (EditText)findViewById(R.id.edt_max);
        edtQtde = (EditText)findViewById(R.id.edt_qtde);
        txtNumeros = (TextView)findViewById(R.id.txt_numeros);
        progress = (ProgressBar)findViewById(R.id.progress);
        grpFormat = (RadioGroup)findViewById(R.id.grp_format);
    }

    public void verDetalhes(View view){
        Intent it = new Intent(this, DetailsActivity.class);
        it.putExtra("format", format);
        it.putExtra("request", requestStr);
        it.putExtra("response", responseStr);
        startActivity(it);
    }

    public void gerar(View view){

        Integer min = Integer.valueOf(edtMin.getText().toString());
        Integer max = Integer.valueOf(edtMax.getText().toString());
        Integer qtde = Integer.valueOf(edtQtde.getText().toString());

        int checkedFormatId = grpFormat.getCheckedRadioButtonId();

        //Operação ternária
        format = checkedFormatId == R.id.opt_xml ? DataHandler.Format.XML : DataHandler.Format.JSON;

        InvokeWebServiceTask task = new InvokeWebServiceTask();
        task.execute(min, max, qtde, format);

    }

    public class InvokeWebServiceTask extends AsyncTask<Object, Void, List<Integer>>{

        @Override
        protected void onPreExecute() {
            progress.setVisibility(View.VISIBLE);
            txtNumeros.setVisibility(View.GONE);
        }

        @TargetApi(Build.VERSION_CODES.KITKAT)
        @Override
        protected void onPostExecute(List<Integer> integers) {
            StringBuilder sb = new StringBuilder();

            for(int number : integers){
                sb.append(number).append(System.lineSeparator());
            }

            txtNumeros.setText(sb.toString());

            progress.setVisibility(View.GONE);
            txtNumeros.setVisibility(View.VISIBLE);
        }

        @Override
        protected List<Integer> doInBackground(Object... params) {

            try {
                Integer min = (Integer) params[0];
                Integer max = (Integer) params[1];
                Integer qtde = (Integer) params[2];
                DataHandler.Format format = (DataHandler.Format) params[3];

                DataHandler handler = DataHandlerFactory.newDataHandller(format);
                DataBean data = new DataBean(min, max, qtde);

                requestStr = handler.convertToString(data);

                HttpClient http = new DefaultHttpClient();

                List<NameValuePair> getParams = new ArrayList<>();
                getParams.add(new BasicNameValuePair("tipo", format.toString()));
                getParams.add(new BasicNameValuePair("dados", requestStr));

                String getParamsStr = URLEncodedUtils.format(getParams, HTTP.UTF_8);
                HttpGet get = new HttpGet(URL + "?" + getParamsStr);

                HttpResponse response = http.execute(get);
                responseStr = EntityUtils.toString(response.getEntity());

                return handler.extractNumbers(responseStr);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }

        }
    }


}
