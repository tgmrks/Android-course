package com.example.ismael.aula10softbluebroadcastreceiverenviando;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private MyReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        receiver = new MyReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.aula10.android.broadcast.TOAST");
        registerReceiver(receiver, intentFilter);

    }

    public void send(View view) {
        ////Para q este funcione deve-se descomentar a declaração do receiver no manifest
        ////Para o estático, somente a declaração no manifest é necessária (não precisando do register no onCreate e unregister no onDestroy)
//        Intent intent = new Intent("com.example.aula10.android.broadcast.TOAST");
//        intent.putExtra("msg", "Mensagem enviada via BroadcastReceiver ESTÁTICO");
//        sendBroadcast(intent);

        Intent intent = new Intent("com.example.aula10.android.broadcast.TOAST");
        intent.putExtra("msg", "Mensagem enviada via BroadcastReceiver DINÂMICO");
        sendBroadcast(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }
}
