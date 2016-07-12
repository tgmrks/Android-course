package com.example.ismael.aula11softblueagendandoalarme;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private AlarmManager manager;
    private PendingIntent pi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = (AlarmManager) getSystemService(ALARM_SERVICE);
    }

    public void agendar(View view) {

        Calendar c = Calendar.getInstance();
        c.add(Calendar.SECOND, 5);

        Intent it = new Intent(this, AlarmReceiver.class);
        pi = PendingIntent.getBroadcast(this, 0, it, 0);

        //Setar alarme
        //manager.set(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pi);

        //Setar repetição
        manager.setInexactRepeating(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), 5000, pi);

    }

    public void cancelar(View view) {
        if(pi != null){
            manager.cancel(pi);
        }
    }

}
