package br.com.softblue.android;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class MyPhoneStateListener extends PhoneStateListener {

    private Context context;

    public MyPhoneStateListener(Context context) {
        this.context = context;
    }

    @Override
    public void onCallStateChanged(int state, String incomingNumber) {

        String texto;

        if (state == TelephonyManager.CALL_STATE_IDLE) {
            texto = "Chamada desligada";
        } else if (state == TelephonyManager.CALL_STATE_OFFHOOK) {
            texto = "Telefone fora do gancho";
        } else if (state == TelephonyManager.CALL_STATE_RINGING) {
            texto = "Recebendo chamada de " + incomingNumber;
        } else {
            texto = "Estado desconhecido";
        }

        Toast.makeText(context, texto, Toast.LENGTH_SHORT).show();
    }
}
