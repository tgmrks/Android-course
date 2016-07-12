package com.example.ismael.aula12softblueconectandocomservice;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Intent it;
    private TimeService service;
    private TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtView = (TextView)findViewById(R.id.txt_seconds);
    }


    public void read(View view) {
        int second = service.getSeconds();
        txtView.setText(String.valueOf(second));

    }

    public void start(View view) {
        //amarrar a intent q chama o service ao contexto da aplicação e nao a da activity, para que a activity possa ser recolhida pelo garbageCollector
        System.out.println("passou pelo onClick start");
        it = new Intent(getApplicationContext(), TimeService.class);
        startService(it);

        TimeServiceConnection conn = new TimeServiceConnection();
        bindService(it, conn, 0);
    }

    public void stop(View view) {
        if(it != null){
            stopService(it);
        }
    }

    private class TimeServiceConnection implements ServiceConnection{

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

            TimeService.TimeServiceBinder binder = (TimeService.TimeServiceBinder) service;
            MainActivity.this.service = binder.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }

}
