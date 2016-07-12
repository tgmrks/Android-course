package com.example.ismael.aula8softbluemenusactionbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

/**
 * Created by ismael on 18/07/15.
 */
public class PopupMenuActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);


    }

    public void showPopup(View view) {
        PopupMenu popup = new PopupMenu(this, view);
        popup.inflate(R.menu.menu_popup);
        popup.setOnMenuItemClickListener(this);
        popup.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {

        if(item.getItemId() == R.id.act_popup1){
            Toast.makeText(this, "Anterior", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if(item.getItemId() == R.id.act_popup2){
            Toast.makeText(this, "Próximo", Toast.LENGTH_SHORT).show();
            return true;
        }

        return false;
    }
}
