package com.example.ismael.aula5softbluelayouts;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ProgressBarActivity extends AppCompatActivity {

    private TextView txt;
    private ProgressBar pBar;
    private int animTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);

        animTime = getResources().getInteger(android.R.integer.config_longAnimTime);

        txt = (TextView)findViewById(R.id.txtTeste);
        pBar = (ProgressBar)findViewById(R.id.pBar);

        txt.setVisibility(View.GONE);

        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(5000);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        showContent();
                    }
                });
            }
        }).start();

    }
//****************************TRANSAÇÃO ENTRE AS VIEWS
    public void showContent(){
        txt.setVisibility(View.VISIBLE);
        txt.setAlpha(0.0f);

        txt.animate().alpha(1.0f).setDuration(animTime).setListener(null);

        pBar.animate().alpha(0.0f).setDuration(animTime).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                pBar.setVisibility(View.GONE);
            }
        });
    }

}
