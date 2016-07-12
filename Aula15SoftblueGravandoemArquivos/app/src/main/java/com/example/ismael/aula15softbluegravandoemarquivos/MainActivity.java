package com.example.ismael.aula15softbluegravandoemarquivos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //** WRITE
    public void writeInternal(View view) {
        Intent intent = new Intent(this, WriteActivity.class);
        intent.putExtra(Constants.STORAGE_TYPE, Constants.Types.INTERNAL);
        startActivity(intent);
    }
    public void writeExternal(View view) {
        Intent intent = new Intent(this, WriteActivity.class);
        intent.putExtra(Constants.STORAGE_TYPE, Constants.Types.EXTERNAL);
        startActivity(intent);
    }

    //** READ
    public void readInternal(View view) {
        Intent intent = new Intent(this, ReadActivity.class);
        intent.putExtra(Constants.STORAGE_TYPE, Constants.Types.INTERNAL);
        startActivity(intent);
    }
    public void readExternal(View view) {
        Intent intent = new Intent(this, ReadActivity.class);
        intent.putExtra(Constants.STORAGE_TYPE, Constants.Types.EXTERNAL);
        startActivity(intent);
    }
}
