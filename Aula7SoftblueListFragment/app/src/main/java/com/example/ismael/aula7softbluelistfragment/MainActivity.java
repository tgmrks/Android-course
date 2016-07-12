package com.example.ismael.aula7softbluelistfragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements AlimentosFragment.OnItemClick {

    private TextFragment txtFrag;
    private static final NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    //pegando referencia da view "dentro" fragment
        txtFrag = (TextFragment) getFragmentManager().findFragmentById(R.id.frag_txt);

    }

    @Override
    public void onClick(Alimento alimento) {
        txtFrag.setText(String.format("O preço do %s é %s", alimento.getNome(), nf.format(alimento.getPreco())));
    }
}
