package com.example.ismael.aula8softbluemenusactionbar;

import android.app.ListActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ismael on 18/07/15.
 */
public class MultiActionModeActivity extends AppCompatActivity implements AbsListView.MultiChoiceModeListener {

    private ArrayAdapter<String> adapter;
    private ListView list;
    private List<String> selected = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_mode);

        list = (ListView)findViewById(R.id.list_v1);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        adapter.add("A");
        adapter.add("B");
        adapter.add("C");
        adapter.add("D");
        adapter.add("E");
        adapter.add("F");
        adapter.add("G");
        adapter.add("H");
        adapter.add("I");

        list.setAdapter(adapter);

        list.setMultiChoiceModeListener(this);
        list.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE_MODAL);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_action_multi_mode, menu);
        return true;
    }

    @Override
    public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
        String s = adapter.getItem(position); //PARA CAPITURAR O ITEM
        View view = list.getChildAt(position); //PARA ALTERAR A VIEW

        if(checked){
            view.setBackgroundColor(Color.BLUE);
            selected.add(s);
        }
        else{
            view.setBackgroundColor(Color.TRANSPARENT);
            selected.remove(s);
        }

    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        getMenuInflater().inflate(R.menu.menu_action_multi_mode, menu);
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {

        if(item.getItemId() == R.id.act_delete){
            for(String s : selected){
                adapter.remove(s);
            }
            mode.finish();
            return true;
        }
        return false;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {
        int count = list.getChildCount();

        for(int i = 0; i < count; i++){
            View view = list.getChildAt(i);
            view.setBackgroundColor(Color.TRANSPARENT);
        }

        selected.clear();
    }
}
