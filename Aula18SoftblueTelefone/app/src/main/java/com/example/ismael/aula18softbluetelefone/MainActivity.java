package com.example.ismael.aula18softbluetelefone;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edtTelefone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtTelefone = (EditText)findViewById(R.id.edt);
    }

    public void call(View view) {

        String telfone = edtTelefone.getText().toString();
        Uri uri = Uri.parse("tel:"+telfone);
        Intent intent = new Intent(Intent.ACTION_CALL, uri);
        //Intent intent = new Intent(Intent.ACTION_DIAL, uri); //Chama o app de telefone mas não disca, o user terá q clicar em discar **não necessita de uses-permition no manifest
        startActivity(intent);
    }
}
