package com.example.ismael.aula18softbluesms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edt_telefone;
    private EditText edt_mensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_telefone = (EditText)findViewById(R.id.edt_tel);
        edt_mensagem = (EditText)findViewById(R.id.edt_mes);


    }

    public void send(View view) {

        String telefone = edt_telefone.getText().toString();
        String mensagem = edt_mensagem.getText().toString();

        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(telefone, null, mensagem, null, null);

    }
}
