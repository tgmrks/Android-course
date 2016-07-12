package com.example.ismael.aula15softbluepreferencesframework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ConfigFragment configFrag = new ConfigFragment();

        //Chamada de Fragment de forma dinâmica
        getFragmentManager()
                .beginTransaction()
                .replace(android.R.id.content, configFrag, "ConfigFragment")
                .commit();
    }

}
