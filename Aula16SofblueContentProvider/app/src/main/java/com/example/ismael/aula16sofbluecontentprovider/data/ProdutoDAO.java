package com.example.ismael.aula16sofbluecontentprovider.data;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.CursorLoader;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import com.example.ismael.aula16sofbluecontentprovider.provider.ProdutoProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ismael on 03/08/15.
 */
public class ProdutoDAO {

    private static ProdutoDAO instance;
//    private SQLiteDatabase db;
    private Context context;
    private ContentResolver resolver;

    //padrão singleton?
    public static ProdutoDAO getInstance(Context context) {
        if (instance == null) {
            instance = new ProdutoDAO(context.getApplicationContext());
        }
        return instance;
    }

    //Construtor
    private ProdutoDAO(Context context) {
        this.context = context;
        this.resolver = context.getContentResolver();//é a porta de entrada p/ o content provider
    }

    public CursorLoader list() {
        return new CursorLoader(context, ProdutoProvider.CONTENT_URI, null, null, null, ProdutosContract.Columns.NOME);
    }

    public CursorLoader load(int id) {
        Uri newUri = ContentUris.withAppendedId(ProdutoProvider.CONTENT_URI, id);
        return new CursorLoader(context, newUri, null, null, null, null);
    }

    public void save(Produto produto) {
        ContentValues values = new ContentValues();
        values.put(ProdutosContract.Columns.NOME, produto.getNome());
        values.put(ProdutosContract.Columns.VALOR, produto.getValor());
        Uri newUri = resolver.insert(ProdutoProvider.CONTENT_URI, values);
        String id = newUri.getLastPathSegment();
        produto.setId(Integer.valueOf(id));
    }

    public void update(Produto produto) {
        ContentValues values = new ContentValues();
        values.put(ProdutosContract.Columns.NOME, produto.getNome());
        values.put(ProdutosContract.Columns.VALOR, produto.getValor());
        Uri newUri = ContentUris.withAppendedId(ProdutoProvider.CONTENT_URI, produto.getId());
        resolver.update(newUri, values, null, null);
    }

    public void delete(int id) {
        Uri newUri = ContentUris.withAppendedId(ProdutoProvider.CONTENT_URI, id);
        resolver.delete(newUri, null, null);
    }

    public static Produto fromCursor(Cursor c) {
        int id = c.getInt(c.getColumnIndex(ProdutosContract.Columns._ID));
        String nome = c.getString(c.getColumnIndex(ProdutosContract.Columns.NOME));
        double valor = c.getDouble(c.getColumnIndex(ProdutosContract.Columns.VALOR));
        return new Produto(id, nome, valor);
    }
}