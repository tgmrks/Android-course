package com.example.ismael.aula15softbluesharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences prefs;
    private EditText edtNome;
    private EditText edtIdade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edtNome = (EditText)findViewById(R.id.edt_nome);
        edtIdade = (EditText)findViewById(R.id.edt_idade);

        prefs = getSharedPreferences("App", MODE_PRIVATE);

        String nome = prefs.getString("nome", null);
        int idade = prefs.getInt("idade", -1);

        if (nome != null) {
            edtNome.setText(nome);
        }

        if(idade != -1){
            edtIdade.setText(String.valueOf(idade));
        }

    }

    public void save(View view) {

        String nome = edtNome.getText().toString();
        int idade = Integer.parseInt(edtIdade.getText().toString());//int idade = Integer.valueOf(edtIdade.getText().toString());

        SharedPreferences.Editor editor =  prefs.edit();

        editor.putString("nome", nome);
        editor.putInt("idade", idade);
        //editor.commit();//***RODA NA UI Thread
        editor.apply();//***RODA EM OUTRA Thread

        Toast.makeText(this, "Dados Gravador!", Toast.LENGTH_SHORT).show();
    }
}
