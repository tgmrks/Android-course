package com.example.ismael.aula16sofbluecontentprovider.adapter;

/**
 * Created by ismael on 03/08/15.
 */
import android.content.Context;
import android.content.CursorLoader;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.ismael.aula16sofbluecontentprovider.R;
import com.example.ismael.aula16sofbluecontentprovider.data.Produto;
import com.example.ismael.aula16sofbluecontentprovider.data.ProdutoDAO;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ProdutosAdapter extends CursorAdapter {

    //FORMATAÇÃO PARA MODEDA
    private static final NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

    private LayoutInflater inflater;

    public ProdutosAdapter(Context context){
        super(context, null, 0);

        inflater = LayoutInflater.from(context);
    }


    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return inflater.inflate(R.layout.adapter_listprodutos, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        Produto p = ProdutoDAO.fromCursor(cursor);

        TextView txtNome = (TextView) view.findViewById(R.id.txt_nome);
        TextView txtValor = (TextView) view.findViewById(R.id.txt_valor);

        txtNome.setText(p.getNome());
        //txtValor.setText(String.valueOf(p.getValor()));
        txtValor.setText(nf.format(p.getValor()));
    }
}