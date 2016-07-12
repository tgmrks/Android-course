package com.example.ismael.aula8softbluemenusactionbar;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        ActionBar ab = getActionBar();
        if(ab != null){
            ab.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);

        //*****UP NAVIGATION via programação **deve-se remover a declaração no manifest
//        if(item.getItemId() == android.R.id.home){
//            Intent it = new Intent(this, MainActivity.class);
//            it.setFlags(it.FLAG_ACTIVITY_CLEAR_TOP);
//            startActivity(it);
//        }
//        return super.onOptionsItemSelected(item);
    }
}