package com.example.ismael.aula11softbluenotificacoescomtoast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void notify1(View view) {
        Toast t = Toast.makeText(this, "Aviso", Toast.LENGTH_SHORT);
        t.show();
    }

    public void notify2(View view) {
        Toast t = Toast.makeText(this, "Aviso", Toast.LENGTH_SHORT);
        t.setGravity(Gravity.CENTER, 0, 0);
        t.show();
    }

    public void notify3(View view) {
        Toast t = new Toast(this);
        t.setGravity(Gravity.CENTER, 0, 0);

        View v = getLayoutInflater().inflate(R.layout.toast, null);
        TextView txt = (TextView) v.findViewById(R.id.txt_toast);
        txt.setText("Custom");

        t.setView(v);
        t.show();
    }
}
