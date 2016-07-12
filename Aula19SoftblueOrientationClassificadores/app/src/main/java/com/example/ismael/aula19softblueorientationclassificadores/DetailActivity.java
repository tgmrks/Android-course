package com.example.ismael.aula19softblueorientationclassificadores;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by ismael on 10/08/15.
 */
public class DetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Regiao regiao = (Regiao) getIntent().getSerializableExtra("regiao");

        if (getResources().getBoolean(R.bool.dualPane)) {
            Intent intent = new Intent();
            intent.putExtra("regiao", regiao);
            setResult(RESULT_OK, intent);
            finish();
            return;
        }

        DetailFragment fragment = DetailFragment.newInstance(regiao);

        getFragmentManager().beginTransaction().add(android.R.id.content, fragment, "detail").commit();
    }
}
