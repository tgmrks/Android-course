package com.example.ismael.aula7softbluedialog;

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

    public void open(View view) {

        MyDialogFragment dialog = new MyDialogFragment();
        dialog.show(getFragmentManager(), "dialog");
    }

    public  void openSimple(View view){
        SimpleDialogFragment dialog = new SimpleDialogFragment();
        dialog.show(getFragmentManager(), "simleDialog");
    }

    public  void openRadio(View view){
        RadioDialogFragment dialog = new RadioDialogFragment();
        dialog.show(getFragmentManager(), "RadioDialog");
    }

    public void openMultiple(View view) {
        CheckDialogFragment dialog = new CheckDialogFragment();
        dialog.show(getFragmentManager(), "CheckDialog");
    }
}
