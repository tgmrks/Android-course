package com.example.ismael.aula12softblueintentservice;

import android.app.IntentService;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;

public class TimeService extends IntentService {

    private static final String TAG = "App";

    public TimeService() {
        super("TimeService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        for(int i = 0; i < 10; i++){
            Log.i(TAG, "Segundo: " + i);
            SystemClock.sleep(1000);
        }
    }

}
