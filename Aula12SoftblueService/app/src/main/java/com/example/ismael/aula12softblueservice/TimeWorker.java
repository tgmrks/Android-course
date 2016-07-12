package com.example.ismael.aula12softblueservice;

import android.os.SystemClock;
import android.util.Log;

/**
 * Created by ismael on 29/07/15.
 */
public class TimeWorker implements Runnable {

    private volatile boolean running;
    private int seconds;
    public static final String TAG = "App";

    @Override
    public void run() {
        running = true;

        while(running){
            seconds++;
            Log.i(TAG, "segundos " + seconds);
            SystemClock.sleep(1000);
        }
    }

    public void stop(){
        running = false;
    }
}
