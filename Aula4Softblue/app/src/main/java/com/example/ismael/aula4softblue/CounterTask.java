package com.example.ismael.aula4softblue;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by ismael on 17/06/15.
 */
public class CounterTask extends AsyncTask<Integer, Integer, Void> {

    private Button btnCount;
    private TextView txtCount;
    private EditText edtCount;

    public CounterTask (Button btnCount, TextView txtCount, EditText edtCount){
        this.btnCount = btnCount;
        this.txtCount = txtCount;
        this.edtCount = edtCount;
    }

    @Override
    protected void onPreExecute() {
        btnCount.setEnabled(false);
        edtCount.setEnabled(false);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        btnCount.setEnabled(true);
        edtCount.setEnabled(false);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {

        int i = values[0];
        txtCount.setText(String.valueOf(i));
    }

    @Override
    protected Void doInBackground(Integer... params) {
        int count = params[0];
        for(int i = 0; i <= count; i++ ){
            SystemClock.sleep(750);
            publishProgress(i);
        }
        return null;
    }
}
