package com.example.ismael.aula17softbluexmlejson;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

/**
 * Created by ismael on 08/07/15.
 */
public class DetailsActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_details);

        Bundle extras = getIntent().getExtras();

        TextView txtFormat = (TextView) findViewById(R.id.txt_format);
        DataHandler.Format format = (DataHandler.Format) extras.getSerializable("format");
        if(format != null){
            txtFormat.setText(format.toString());
        }

        TextView txtRequest = (TextView) findViewById(R.id.txt_request);
        String request = extras.getString("request");
        if(request != null){
            txtRequest.setText(request);
        }

        TextView txtResponse = (TextView) findViewById(R.id.txt_response);
        String response = extras.getString("response");
        if (response != null) {
            txtResponse.setText(response);
        }
    }
}
