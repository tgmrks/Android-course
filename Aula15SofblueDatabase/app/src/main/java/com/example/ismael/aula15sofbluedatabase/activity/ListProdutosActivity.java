package com.example.ismael.aula15sofbluedatabase.activity;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.ismael.aula15sofbluedatabase.R;
import com.example.ismael.aula15sofbluedatabase.adapter.ProdutosAdapter;
import com.example.ismael.aula15sofbluedatabase.data.Produto;
import com.example.ismael.aula15sofbluedatabase.data.ProdutoDAO;
import com.example.ismael.aula15sofbluedatabase.dialog.DeleteDialog;

import java.util.ArrayList;
import java.util.List;

public class ListProdutosActivity extends ListActivity implements DeleteDialog.OnDeleteListener, AdapterView.OnItemLongClickListener{

    private static final int REQ_EDIT = 100;

    private ProdutoDAO produtoDAO;
    private ProdutosAdapter adapter;

//*********************************** INFLATE ******************************************************
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listprodutos);

        adapter = new ProdutosAdapter(this);
        setListAdapter(adapter);

        getListView().setOnItemLongClickListener(this);

        produtoDAO = ProdutoDAO.getInstance(this);

        updateList();
    }

    private void updateList() {
        List<Produto> produtos = produtoDAO.list();
        adapter.setItems(produtos);
    }
//**************************************************************************************************

//********************************** EDIT **********************************************************
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_listprodutos, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_add) {
            Intent intent = new Intent(getApplicationContext(), EditProdutoActivity.class);
            startActivityForResult(intent, REQ_EDIT);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQ_EDIT && resultCode == RESULT_OK) {
            updateList();
        }
    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent intent = new Intent(getApplicationContext(), EditProdutoActivity.class);
        intent.putExtra("produto", adapter.getItem(position));
        startActivityForResult(intent, REQ_EDIT);
    }
//**************************************************************************************************

//*********************************** DELETE *******************************************************
    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
        Produto produto = adapter.getItem(position);

        DeleteDialog dialog = new DeleteDialog();
        dialog.setProduto(produto);
        dialog.show(getFragmentManager(), "deleteDialog");
        return true;
    }

    @Override
    public void onDelete(Produto produto) {
        produtoDAO.delete(produto);
        updateList();
    }
//*********************************** DELETE *******************************************************

}
