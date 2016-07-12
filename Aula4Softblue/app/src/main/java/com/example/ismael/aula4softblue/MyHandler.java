package com.example.ismael.aula4softblue;

import android.os.Handler;
import android.os.Message;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by ismael on 16/06/15.
 */
public class MyHandler extends Handler {

    public static final int MSG_UPDATE_UI = 100;

    private TextView txt;
    private Button btn;

    public MyHandler (TextView txt, Button btn){

        this.txt = txt;
        this.btn = btn;
    }

    @Override
    public void handleMessage(Message msg) {

        if(msg.what == MSG_UPDATE_UI){
            btn.setEnabled(true);
            txt.setText("Processo finalizado!");
        }

    }
}
