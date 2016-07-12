package com.example.ismael.aula7softbluelistfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by ismael on 14/07/15.
 */
public class TextFragment extends Fragment {

    private TextView txtMsg;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_text, container, false);

        txtMsg = (TextView) view.findViewById(R.id.txt_texto);

        return view;
    }

    public void setText(String text) {
        txtMsg.setText(text);
    }
}
