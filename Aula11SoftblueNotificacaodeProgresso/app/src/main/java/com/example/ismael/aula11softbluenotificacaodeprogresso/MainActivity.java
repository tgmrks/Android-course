package com.example.ismael.aula11softbluenotificacaodeprogresso;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private  static final int NOTIFICATION_ID = 1;
    private NotificationManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    public void notify(View view) {

        final Notification.Builder builder = new Notification.Builder(this); //'final' para poder acessar dentro da thread
        builder.setContentTitle("Baixando Arquivo").setContentText("Aguarde...")
                .setSmallIcon(R.drawable.ic_file_download_white_24dp);
        builder.setProgress(0, 0, true);
        manager.notify(NOTIFICATION_ID, builder.getNotification()); //usar builder.build() para API >= 16

        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(5000);
                builder.setContentTitle("Arquivo baixado").setContentText("Finalizado");
                builder.setProgress(0, 0, false);
                //atualiza a notificação
                manager.notify(NOTIFICATION_ID, builder.getNotification());
            }
        }).start();
    }

    public void notify2(View view){

        final Notification.Builder builder = new Notification.Builder(this); //'final' para poder acessar dentro da thread
        builder.setContentTitle("Baixando Arquivo").setContentText("Aguarde...")
                .setSmallIcon(R.drawable.ic_file_download_white_24dp);

        new Thread(new Runnable() {
            @Override
            public void run() {
                //um exemplo mais eficiente poderia ser, obter o tamanho em byte do objeto de download e calcular a porcentagem a partir da quantidade baixada
                //indicando a porcentagem e quantidade já baixada
                for(int i = 0; i <= 100; i++){
                    builder.setProgress(100, i, false);
                    //atualiza a notificação
                    manager.notify(NOTIFICATION_ID, builder.getNotification());
                    SystemClock.sleep(100);//milesegundos
                }
                builder.setContentTitle("Arquivo baixado").setContentText("Finalizado");
                builder.setProgress(0, 0, false);
                manager.notify(NOTIFICATION_ID, builder.getNotification());
            }
        }).start();

    }

}
