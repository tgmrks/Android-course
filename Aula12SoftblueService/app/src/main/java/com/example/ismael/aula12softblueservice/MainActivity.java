package com.example.ismael.aula12softblueservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Intent it;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void start(View view) {
        //amarrar a intent q chama o service ao contexto da aplicação e nao a da activity, para que a activity possa ser recolhida pelo garbageCollector
        it = new Intent(getApplicationContext(), TimeService.class);
        startService(it);
    }

    public void stop(View view) {
        if(it != null){
            stopService(it);
        }
    }
}
