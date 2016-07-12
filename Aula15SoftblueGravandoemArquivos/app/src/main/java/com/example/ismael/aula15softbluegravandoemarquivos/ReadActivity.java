package com.example.ismael.aula15softbluegravandoemarquivos;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ReadActivity extends AppCompatActivity {

    private TextView txtText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        txtText = (TextView)findViewById(R.id.txt_text);

        //Pegando valor de leitura da intent
        Constants.Types types = (Constants.Types) getIntent().getSerializableExtra(Constants.STORAGE_TYPE);

        try {
            if(types == Constants.Types.INTERNAL){
                readInternal();
            }
            else{
                readExternal();
            }
        } catch (IOException e) {
            Toast.makeText(this, "Erro: " + e.getMessage(), Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private void readInternal() throws IOException{
        FileInputStream in = new FileInputStream(Constants.FILE_NAME);

        try (Scanner scanner = new Scanner(in)) {
            StringBuilder sb = new StringBuilder();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                sb.append(line).append(System.lineSeparator());
            }

            txtText.setText(sb.toString());
        }
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private void readExternal() throws IOException {
        String status = Environment.getExternalStorageState();

        if (!status.equals(Environment.MEDIA_MOUNTED)) {
            throw new IOException("A área de armazenamento não está pronta");
        }

        File dir = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
        File file = new File(dir, Constants.FILE_NAME);

        try (Scanner scanner = new Scanner(file)) {
            StringBuilder sb = new StringBuilder();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                sb.append(line).append(System.lineSeparator());
            }

            txtText.setText(sb.toString());
        }
    }

}
