package com.example.ismael.aula17softbluesoap;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;


import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.Objects;

public class MainActivity extends Activity {

    private static final String ENDPOINT = "http://code.softblue.com.br:8080/web/services/CalculadoraWS";

    //private Button btn;
    private TextView txtResult;
    private RadioGroup grpOp;
    private EditText edtValor1, edtValor2;
    private ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtValor1 = (EditText)findViewById(R.id.edt1);
        edtValor2 = (EditText)findViewById(R.id.edt2);
        grpOp = (RadioGroup)findViewById(R.id.rGroup);
        txtResult = (TextView)findViewById(R.id.txt_result);
        progress = (ProgressBar)findViewById(R.id.pbar1);

    }

public void invoke (View view){
    Integer valor1 = Integer.valueOf(edtValor1.getText().toString());
    Integer valor2 = Integer.valueOf(edtValor2.getText().toString());

    int checkedId = grpOp.getCheckedRadioButtonId();
    String op = checkedId == R.id.rdb1? "somar" : "subtrair";

    InvokeWebServiceTask task = new InvokeWebServiceTask();
    task.execute(valor1, valor2, op);
}

public class InvokeWebServiceTask extends AsyncTask <Object, Void, Integer> {
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
    protected Integer doInBackground(Object... params) {
        Integer valor1 = (Integer) params[0];
        Integer valor2 = (Integer) params[1];
        String op = (String) params[2];

        return callWebService(valor1, valor2, op);
    }
}

public Integer callWebService (int valor1, int valor2, String op){

    try {
        SoapObject soap = new SoapObject("http://examples.softblue.com.br", op);
        soap.addProperty("v1", valor1);
        soap.addProperty("v2", valor2);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(soap);

        HttpTransportSE transport = new HttpTransportSE(ENDPOINT);
        transport.call("", envelope);

        Object object = envelope.getResponse();
        return Integer.valueOf(object.toString());

    } catch (IOException | XmlPullParserException e) {
        e.printStackTrace();
        return null;
    }

}

}
