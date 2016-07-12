package com.example.ismael.aula7softbluespinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private ArrayAdapter<Character> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner)findViewById(R.id.spinner);
                                                     //LAYOUT PARA LISTA DO SPINNER
        adapter = new ArrayAdapter<Character>(this, android.R.layout.simple_spinner_item);
        adapter.add('A');
        adapter.add('B');
        adapter.add('C');
        adapter.add('D');

        spinner.setAdapter(adapter);
        //LAYOUT PARA OS SPINNER
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //chamando o metodo implementado abaixo para que a activity saiba quando foi clicado
        spinner.setOnItemSelectedListener(this);
    }

    @Override                  //a spinner          //view da linha //...
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Character c = adapter.getItem(position);
        Toast.makeText(this, "letra selecionada: " + c, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
