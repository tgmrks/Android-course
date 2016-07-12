package com.example.ismael.aula16sofbluecontentprovider.provider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import com.example.ismael.aula16sofbluecontentprovider.data.DBHelper;
import com.example.ismael.aula16sofbluecontentprovider.data.ProdutosContract;

import java.io.IOException;
import java.util.regex.Matcher;

public class ProdutoProvider extends ContentProvider {

    private static final int MATCH_ALL = 1;
    private static final int MATCH_ONE = 2;
    private static final String AUTHORITY = "com.example.ismael.aula16sofbluecontentprovider.provider.ProdutoProvider";
                                                                                  //PATH
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/produtos");

    private SQLiteDatabase db;
    private UriMatcher matcher;

//    public ProdutoProvider() {
//    }

    @Override
    public boolean onCreate() {
        DBHelper dbHelper = DBHelper.getInstance(getContext());
        db = dbHelper.getWritableDatabase();

        //para identificar a solicitação
        matcher = new UriMatcher(UriMatcher.NO_MATCH);
        matcher.addURI(AUTHORITY, "/produtos", MATCH_ALL);
        matcher.addURI(AUTHORITY, "/produtos/#", MATCH_ONE);

        return true;
    }

    @Override                   //where
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        if(matcher.match(uri) == MATCH_ONE){
            String id = uri.getLastPathSegment();
//captura o retorno (rows affecteds) //executa o delete
            int count = db.delete(ProdutosContract.TABLE_NAME, ProdutosContract.Columns._ID + " =? ", new String[] {id});
//conceito de Loader para notificar alterações automaticamente (notifica o 'android')
            getContext().getContentResolver().notifyChange(uri, null);

            return count;
        }

        throw new IllegalArgumentException("URI não é suportada");

    }

    @Override
    public String getType(Uri uri) {
        int type = matcher.match(uri);

        if(type == MATCH_ONE){
                 //texto padrão obrigatorio //tipo variante do teu aplicativo (texto livre)
            return "vnd.android.cursor.item/vnd.com.example.ismael.aula16sofbluecontentprovider";
        }
        else if(type == MATCH_ALL){
            return "vnd.android.cursor.dir/vnd.com.example.ismael.aula16sofbluecontentprovider";
        }

        throw new IllegalArgumentException("URI não é suportada");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
//a inserção em banco retorna um ID
        Long id = db.insert(ProdutosContract.TABLE_NAME, null, values);
//o Content Provider retorna um URI para o dado inserido
        Uri newUri = ContentUris.withAppendedId(uri, id);
//conceito de Loader para notificar alterações automaticamente, porém, neste caso, passa-se a nova Uri (posi sofreu "alteração")
        getContext().getContentResolver().notifyChange(newUri, null);

        return newUri;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        int type = matcher.match(uri);
        System.out.println("valor de type: " + type);
        Cursor c;

        if(projection == null){
            projection = new String[]{
                ProdutosContract.Columns._ID,
                ProdutosContract.Columns.NOME,
                ProdutosContract.Columns.VALOR
            };
        }

        if(type == MATCH_ALL){
                                                //COLUNAS   //sem restrição
            c = db.query(ProdutosContract.TABLE_NAME, projection, null, null, null, null, sortOrder);

        }
        else if(type == MATCH_ONE){
            String id = uri.getLastPathSegment();           //restrição
            c = db.query(ProdutosContract.TABLE_NAME, projection, ProdutosContract.Columns._ID + " =? ", new String[]{id}, null, null, sortOrder);
        }
        else{
            throw new IllegalArgumentException("URI não é suportada");
        }
//conceito de Loader para notificar alterações automaticamente (notifica o 'android')
        c.setNotificationUri(getContext().getContentResolver(), uri);

        return c;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {

        if(matcher.match(uri) == MATCH_ONE){
            String id = uri.getLastPathSegment();
//captura o retorno (rows affecteds) //executa o update
            int count = db.update(ProdutosContract.TABLE_NAME, values, ProdutosContract.Columns._ID + " =? ", new String[] {id});
//conceito de Loader para notificar alterações automaticamente (notifica o 'android')
            getContext().getContentResolver().notifyChange(uri, null);

            return count;
        }

        throw new IllegalArgumentException("URI não é suportada");

    }
}
