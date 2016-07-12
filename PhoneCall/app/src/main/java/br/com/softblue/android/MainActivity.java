package br.com.softblue.android;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    private EditText edtTelefone;
    private TelephonyManager tm;
    private MyPhoneStateListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        edtTelefone = (EditText) findViewById(R.id.edt_telefone);

        tm = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);

        listener = new MyPhoneStateListener(this);

        tm.listen(listener, PhoneStateListener.LISTEN_CALL_STATE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        tm.listen(listener, PhoneStateListener.LISTEN_NONE);
    }

    public void call(View view) {
        String telefone = edtTelefone.getText().toString();

        Uri uri = Uri.parse("tel:" + telefone);

        Intent intent = new Intent(Intent.ACTION_CALL, uri);
        //Intent intent = new Intent(Intent.ACTION_DIAL, uri);
        startActivity(intent);
    }
}
