package com.example.ismael.aula6softbluefragcom;

import android.app.Activity;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity implements TextFrag.OnTextListener {

    private ResultFrag rFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getFragmentManager();
        rFrag = (ResultFrag) fm.findFragmentById(R.id.frag_result);

    }

    @Override
    public void catchText(String text) {
        rFrag.receive(text);
    }
}
