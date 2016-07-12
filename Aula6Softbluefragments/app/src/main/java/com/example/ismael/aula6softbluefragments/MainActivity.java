package com.example.ismael.aula6softbluefragments;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentLeft lf = new FragmentLeft();
        FragmentRight lr = new FragmentRight();

        FragmentManager fm = getFragmentManager();
        FragmentTransaction transac = fm.beginTransaction();
        transac.add(R.id.leftFrame, lf,"left");
        transac.add(R.id.rightFrame, lr, "right");
        transac.commit();
    }

}
