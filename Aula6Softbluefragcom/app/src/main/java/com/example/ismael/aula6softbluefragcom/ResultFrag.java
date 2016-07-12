package com.example.ismael.aula6softbluefragcom;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by ismael on 27/06/15.
 */
public class ResultFrag extends Fragment {

    private TextView txt;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_result, container, false);

        txt = (TextView) view.findViewById(R.id.txtTelaTexto);

        return view;
    }

    public void receive (String texto){
        txt.setText(texto.toString());
    }

}
