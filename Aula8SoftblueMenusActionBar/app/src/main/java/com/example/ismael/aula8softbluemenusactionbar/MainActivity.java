package com.example.ismael.aula8softbluemenusactionbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = (Button)findViewById(R.id.btn_1);
        Button btn2 = (Button)findViewById(R.id.btn_2);
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
    }

    public void goActionBarActivity(View view) {
        Intent it = new Intent(this, ActionBarActivity.class);
        startActivity(it);
    }

    public void goTestActivity(View view) {
        Intent it = new Intent(this, TestActivity.class);
        startActivity(it);
    }

    public void goModeActivity(View view) {
        Intent it = new Intent(this, ActionModeActivity.class);
        startActivity(it);
    }

    public void goMultiModeActivity(View view) {
        Intent it = new Intent(this, MultiActionModeActivity.class);
        startActivity(it);
    }

    public void goPopupMenuActivity(View view) {
        Intent it = new Intent(this, PopupMenuActivity.class);
        startActivity(it);
    }
}
