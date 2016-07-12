package br.com.softblue.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class DetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String item = getIntent().getStringExtra("item");
        int layoutId;

        if (item.equals(getResources().getString(R.string.txt_dados1))) {
            layoutId = R.layout.dados1;
        } else if (item.equals(getResources().getString(R.string.txt_dados2))) {
            layoutId = R.layout.dados2;
        } else {
            layoutId = R.layout.dados3;
        }

        setContentView(layoutId);
    }

    public void onBack(View view) {
        finish();
    }
}
