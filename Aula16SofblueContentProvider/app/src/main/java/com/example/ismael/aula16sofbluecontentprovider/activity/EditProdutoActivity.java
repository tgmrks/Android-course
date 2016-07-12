package com.example.ismael.aula16sofbluecontentprovider.activity;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ismael.aula16sofbluecontentprovider.R;
import com.example.ismael.aula16sofbluecontentprovider.data.Produto;
import com.example.ismael.aula16sofbluecontentprovider.data.ProdutoDAO;

/**
 * Created by ismael on 03/08/15.
 */
public class EditProdutoActivity extends Activity implements android.app.LoaderManager.LoaderCallbacks<Cursor> {

    private ProdutoDAO produtoDAO;
    private EditText edtNome;
    private EditText edtValor;
    private Produto produto;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editproduto);

        edtNome = (EditText) findViewById(R.id.edt_nome);
        edtValor = (EditText) findViewById(R.id.edt_valor);

        produtoDAO = ProdutoDAO.getInstance(this);

        long produtoId = getIntent().getLongExtra("produtoId", -1);

        if (produtoId != -1) {
            Bundle bundle = new Bundle();
            bundle.putLong("id", produtoId);
            getLoaderManager().initLoader(0, bundle, this);

//            edtNome.setText(produto.getNome());
//            edtValor.setText(String.valueOf(produto.getValor()));
        }
    }

    public void cancel(View view) {
        setResult(RESULT_CANCELED);
        finish();
    }

    public void process(View view) {
        String nome = edtNome.getText().toString();
        double valor = Double.parseDouble(edtValor.getText().toString());
        String msg;

        if (produto == null) {
            Produto produto = new Produto(nome, valor);
            produtoDAO.save(produto);
            msg = "Produto gravado com ID = " + produto.getId();

        } else {
            produto.setNome(nome);
            produto.setValor(valor);
            produtoDAO.update(produto);
            msg = "Produto atualizado com ID = " + produto.getId();
        }

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        setResult(RESULT_OK);
        finish();
    }


    @Override
    public android.content.Loader<Cursor> onCreateLoader(int id, Bundle args) {
        long produtoId = args.getLong("id");
        return produtoDAO.load((int) produtoId);
    }

    @Override
    public void onLoadFinished(android.content.Loader<Cursor> loader, Cursor data) {
        data.moveToFirst();
        produto = ProdutoDAO.fromCursor(data);
        edtNome.setText(produto.getNome());
        edtValor.setText(String.valueOf(produto.getValor()));
    }

    @Override
    public void onLoaderReset(android.content.Loader<Cursor> loader) {
    }
}
