package com.example.ismael.aula16sofbluecontentprovider.activity;

import android.app.ListActivity;
import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.ismael.aula16sofbluecontentprovider.R;
import com.example.ismael.aula16sofbluecontentprovider.adapter.ProdutosAdapter;
import com.example.ismael.aula16sofbluecontentprovider.data.Produto;
import com.example.ismael.aula16sofbluecontentprovider.data.ProdutoDAO;
import com.example.ismael.aula16sofbluecontentprovider.dialog.DeleteDialog;

import java.util.List;

public class ListProdutosActivity extends ListActivity implements DeleteDialog.OnDeleteListener, AdapterView.OnItemLongClickListener, LoaderManager.LoaderCallbacks<Cursor>{

    private ProdutoDAO produtoDAO;
    private ProdutosAdapter adapter;

//*********************************** INFLATE ******************************************************
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listprodutos);

        getListView().setOnItemLongClickListener(this);

        adapter = new ProdutosAdapter(this);
        setListAdapter(adapter);

        produtoDAO = ProdutoDAO.getInstance(getApplicationContext());

       getLoaderManager().initLoader(0, null, this);
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
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == REQ_EDIT && resultCode == RESULT_OK) {
//            updateList();
//        }
//    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent intent = new Intent(getApplicationContext(), EditProdutoActivity.class);
        intent.putExtra("produtoId", id);
        startActivity(intent);
    }
//**************************************************************************************************

//*********************************** DELETE *******************************************************
    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
        DeleteDialog dialog = new DeleteDialog();
        dialog.setProdutoId((int) id);
        dialog.show(getFragmentManager(), "deleteDialog");
        return true;
    }

    @Override
    public void onDelete(int produtoId) {
        produtoDAO.delete(produtoId);;
    }

//OS LOADERS MONITORAM AS ALTERAÇÕES, por isso não é necessário criar um metodo par tratar-las
    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return produtoDAO.list();
    }//ao terminar irá chamar o onLoadFinished

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        adapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        adapter.swapCursor(null);//invalida o cursor ja utilizado para um novo carregamento
    }
}
