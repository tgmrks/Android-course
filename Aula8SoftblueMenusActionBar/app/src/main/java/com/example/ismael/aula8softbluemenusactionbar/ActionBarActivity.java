package com.example.ismael.aula8softbluemenusactionbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * Created by ismael on 17/07/15.
 */
public class ActionBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.action_bar_activity);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_test1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        //noinspection SimplifiableIfStatement
        if (item.getItemId() == R.id.action_settings) {
            return true;
        }
        else if (item.getItemId() == R.id.act_1){
            Toast.makeText(getApplicationContext(),"clicou em Câmera", Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId() == R.id.act_2){
            Toast.makeText(getApplicationContext(),"clicou em Agenda", Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId() == R.id.act_3){
            Toast.makeText(getApplicationContext(),"clicou em Ligar", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
}
