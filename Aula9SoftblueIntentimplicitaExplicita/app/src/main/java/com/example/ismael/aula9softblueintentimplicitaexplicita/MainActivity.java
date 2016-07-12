package com.example.ismael.aula9softblueintentimplicitaexplicita;

import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void goTela2(View view) {
        //Intent it = new Intent(this, Main2Activity.class);
        Intent it = new Intent("com.example.ismael.aula9.intent.action.EMAIL");//esse nome é só um exemplo, podendo ser qualquer um desde q seja igual ao declarado no manifest
        startActivity(it);
    }

    public void goSettings(View view) {
        Intent it = new Intent(Settings.ACTION_SETTINGS);
        startActivity(it);
    }

    public void goNavegador(View view) {
        Uri uri = Uri.parse("http://www.google.com.br");
        Intent it = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(it);
    }
}
