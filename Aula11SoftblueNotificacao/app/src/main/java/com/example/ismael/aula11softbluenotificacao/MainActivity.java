package com.example.ismael.aula11softbluenotificacao;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.NotificationCompat;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void notify(View view) {

        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentTitle("Notificação");
        builder.setContentText("Você recebeu uma notificação");
        builder.setSmallIcon(android.R.drawable.sym_action_chat);

        Intent it = new Intent(this, MessageActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, it, 0); //criando uma intent pendente para uma possivel execução
        builder.setContentIntent(pi);
        builder.setAutoCancel(true);//Para remover a notificação apos vizualizada

        //***********************Configuração para tela de bloqueio***********
//        builder.setVisibility(Notification.VISIBILITY_PRIVATE);//REQUER API LEVEL 21
        //***********************Configuração para tela de bloqueio***********

        //***********************Configuração para Prioridade***********
//        builder.setPriority(Notification.PRIORITY_MAX);//REQUER API LEVEL 16
//        builder.setDefaults(Notification.DEFAULT_ALL);
        //***********************Configuração para Prioridade***********

        Notification n = builder.getNotification();//*getNotification() foi depreciada a partir da API level 16, use .build() ao invés
        //Notification n = builder.build();//REQUER API LEVEL 16

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(100, n);
    }

    public void notify2(View view) {

        Notification.Builder builder = new Notification.Builder(this);
        builder.setSmallIcon(android.R.drawable.sym_action_chat);
        builder.setAutoCancel(true);

        //***********************Configuração para notificação expandida***********

//        Notification.BigTextStyle style = new Notification.BigTextStyle()
//                .setBigContentTitle("Notificação")
//                .setText("Você recebeu uma notificação");
//        builder.setStyle(style);
//
//        Intent it1 = new Intent(this, MyBoadcastReveiver);
//        it1.setAction(MyBroadcastReceiver.CONSTANTE2);
//        PendingIntent pi1 = new PendingIntent.getBroadcast(this, 0, it1, 0);
//
//        Intent it2 = new Intent(this, MyBoadcastReveiver);
//        it2.setAction(MyBroadcastReceiver.CONSTANTE2);
//        PendingIntent pi2 = new PendingIntent.getBroadcast(this, 0, it2, 0);
//
//        builder.addAction(android.R.drawable.ic_menu_view, "Botão 1", pi1);
//        builder.addAction(android.R.drawable.ic_menu_view, "Botão 2", pi2);

        //***Para que funcione, deve-se criar um broadcastReceiver...
        //***********************Configuração para notificação expandida***********

        Notification n = builder.getNotification();
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(101, n);


    }
}
