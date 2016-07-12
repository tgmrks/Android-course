package com.example.ismael.aula16sofbluecontentprovidernativo;

import android.app.ListActivity;
import android.content.CursorLoader;
import android.database.Cursor;
import android.provider.Settings;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainActivity extends ListActivity implements android.app.LoaderManager.LoaderCallbacks<Cursor> {

    private SimpleCursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //colunas do cursor
        String[] columns = {
                Settings.System.NAME,
                Settings.System.VALUE
        };
        //resources do simple_list_item_2
        int[] resources = {
                android.R.id.text1,
                android.R.id.text2
        };

        adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, null, columns, resources, 0);
        setListAdapter(adapter);

        //iniciando o loader
        getLoaderManager().initLoader(0, null, this);

    }

    @Override
    public android.content.Loader<Cursor> onCreateLoader(int id, Bundle args) {

        String[] columns = {
                Settings.System._ID,
                Settings.System.NAME,
                Settings.System.VALUE
        };

        return new CursorLoader(this, Settings.System.CONTENT_URI, columns, null, null, Settings.System.NAME);
    }

    @Override
    public void onLoadFinished(android.content.Loader<Cursor> loader, Cursor data) {
        adapter.swapCursor(data);//troca cursor atual pelo 'data', neste caso nenhum pois null foi passado na criação do adapter
    }

    @Override
    public void onLoaderReset(android.content.Loader<Cursor> loader) {
        adapter.swapCursor(null);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Toast.makeText(this, "ID: " + id, Toast.LENGTH_SHORT).show();
    }
}
