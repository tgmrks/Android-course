package com.example.ismael.aula16sofbluecontentprovider.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ismael on 03/08/15.
 */
public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "produtosdb";
    public static final int DB_VERSION = 1;

    private static final String SQL_DROP = "DROP TABLE IF EXISTS " + ProdutosContract.TABLE_NAME;
    private static final String SQL_CREATE = String.format(
            "CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "%s TEXT NOT NULL, %s DOUBLE NOT NULL)", ProdutosContract.TABLE_NAME, ProdutosContract.Columns._ID, ProdutosContract.Columns.NOME, ProdutosContract.Columns.VALOR);

    //???padrão singleton?
    private static DBHelper instance;
    public static DBHelper getInstance(Context context){

        if(instance == null){
            instance = new DBHelper(context);
        }

        return instance;
    }

    //Constutor
    private DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

//Construtor padrão
//    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
//        super(context, name, factory, version);
//    }
//
//    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
//        super(context, name, factory, version, errorHandler);
//    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_DROP);
        db.execSQL(SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }
}
