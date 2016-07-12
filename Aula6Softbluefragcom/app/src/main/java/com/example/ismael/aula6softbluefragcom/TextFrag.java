package com.example.ismael.aula6softbluefragcom;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by ismael on 27/06/15.
 */
public class TextFrag extends Fragment implements View.OnClickListener {

    private EditText edt;
    private OnTextListener listener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if(!(activity instanceof OnTextListener)){
            throw new RuntimeException("A activity deve implementar a interface TextFragment.OnTextListener");
        }

        listener = (OnTextListener) activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_text, container, false);

        edt = (EditText) view.findViewById(R.id.edt1);

        Button btn = (Button) view.findViewById(R.id.btn1);
        btn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        listener.catchText(edt.getText().toString());
    }

    public interface OnTextListener {
        public void catchText(String text);
    }

}
