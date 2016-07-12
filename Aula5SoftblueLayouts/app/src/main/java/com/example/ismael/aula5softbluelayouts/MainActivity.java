package com.example.ismael.aula5softbluelayouts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    Button btnL, btnR, btnP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnL = (Button)findViewById(R.id.btnLinear);
        btnR = (Button)findViewById(R.id.btnRelative);
        btnP = (Button)findViewById(R.id.btnProgress);
    }

    public void goLinear(View view){
        Intent it = new Intent(getApplicationContext(), LinearLayoutActivity.class);
        startActivity(it);;

    }

    public void goRelative(View view){
        Intent it = new Intent(getApplicationContext(), RelativeLayoutActivity.class);
        startActivity(it);

    }

    public void goProgress(View view){
        Intent it = new Intent(getApplicationContext(), ProgressBarActivity.class);
        startActivity(it);
    }

}
