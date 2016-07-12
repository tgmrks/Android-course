package com.example.ismael.aula4softblue;

import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txt, txtCount;
    private Button btn, btnCount;
    private EditText edtCount;
    //private Handler handler = new Handler(); //Lembrar de importar o Handler do Android e não o do java.util
    private MyHandler myHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = (TextView)findViewById(R.id.txtStatus);
        btn = (Button)findViewById(R.id.btn1);

        myHandler = new MyHandler(txt, btn);

        btnCount = (Button)findViewById(R.id.btnCount);
        txtCount = (TextView)findViewById(R.id.txtCount);
        edtCount = (EditText)findViewById(R.id.edtCount);

    }

    public void contar(View view){
        CounterTask task = new CounterTask(btnCount, txtCount, edtCount);
        int i = Integer.parseInt(edtCount.getText().toString());
        task.execute(i);

    }

    public void processar(View view){

        txt.setText("Processando...");
        btn.setEnabled(false);
        executarAlgoDemorado();
    }

    public void executarAlgoDemorado(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(15000);
//**************************************************************************************************
//              //USANDO METODO handlerMessage() --Lembrar de importar o Handler do Android e não o do java.util
                Message msg = Message.obtain();
                msg.what = MyHandler.MSG_UPDATE_UI;
                myHandler.sendMessage(msg);
//**************************************************************************************************
//              //USANDO METODO Handler() --Lembrar de importar o Handler do Android e não o do java.util
//                handler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        txt.setText("Processo finalizado!");
//                        btn.setEnabled(true);
//                    }
//                });
//**************************************************************************************************
//                //USANDO METODO runOnUiThread()
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        txt.setText("Processo finalizado!");
//                        btn.setEnabled(true);
//                    }
//                });
//**************************************************************************************************
            }
        }).start();

//        //CONVENCIONAL
//        Runnable r = new Runnable() {
//            @Override
//            public void run() {
//                SystemClock.sleep(15000);
//                txt.setText("Processo finalizado!");
//            }
//        };

//        Thread t = new Thread(r);
//        t.start();
    }

}
