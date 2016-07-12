package com.example.ismael.aula10softbluerecebendobroadcastreceivernativos;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class EnergyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        /*Para realizar o teste, deve-se conectar ao emulador via telnet:
        *   no prompt do SO: #telnet localhost <porta do emulador>
        *       com o telnet conectador: #power ac <on/off>
        *
        *Obs.: verificar no doc de config.ini se a bateria está ativa (<user>/.android/avd/<pasta do emulador>/config.ini)*/

        String msg = null;

        if(intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)){
            msg = "dispositivo conectado na energia";
        }
        else if(intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED)){
            msg = "dispositivo desconectado da energia";
        }

        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }
}
