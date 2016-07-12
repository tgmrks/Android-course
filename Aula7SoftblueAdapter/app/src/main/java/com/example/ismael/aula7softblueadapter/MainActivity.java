package com.example.ismael.aula7softblueadapter;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    ////Usado quando o array_adapter é alimentado com um resource de strign
    //private ArrayAdapter<CharSequence> adapter;
    ////Usado para inserir dados programaticamente
    //private ArrayAdapter<String> adapter;
    private ProdutosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //>>>>>>>chama um layout nativo do android, não necessitando do xml da pasta layout do projeto
        //adapter = ArrayAdapter.createFromResource(this, R.array.produtos, android.R.layout.simple_list_item_1);

        //>>>>>>>adicionando conteúdo via programação
        //adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
//        adapter.add("Banana World");
//        adapter.add("Batatismo");
//        adapter.add("Pastafarism");

        adapter = new ProdutosAdapter(this, Produto.getProdutos());

        setListAdapter(adapter);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        //String item = adapter.getItem(position);

        Produto item = (Produto) adapter.getItem(position);
        Toast.makeText(this,"item clicado: " + item.getNome(), Toast.LENGTH_LONG).show();
    }
}
