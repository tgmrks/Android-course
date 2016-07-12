package com.example.ismael.aula18softbluesms;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SMSReceiver extends BroadcastReceiver {

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public void onReceive(Context context, Intent intent) {
        SmsMessage[] messages    = Telephony.Sms.Intents.getMessagesFromIntent(intent);
        SmsMessage message = messages[0];

        String from = message.getOriginatingAddress();
        String text = message.getMessageBody();
        //***caso um texto seja grande, será necessário iterar(for) sobre 'message[]' para pegar todas as partes

        Toast.makeText(context, from + " envior a mensagem: " + text, Toast.LENGTH_LONG).show();
    }
}
