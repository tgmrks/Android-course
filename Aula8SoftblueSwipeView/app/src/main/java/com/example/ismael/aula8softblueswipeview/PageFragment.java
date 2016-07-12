package com.example.ismael.aula8softblueswipeview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ismael on 18/07/15.
 * *********************CRIA DINÂMICAMENTE VÁRIOS FRAMENTS.XML
 */
public class PageFragment extends Fragment {

    private int position;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState != null){
            position = savedInstanceState.getInt("fragmentPos");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        int layoutRes = 0;

        if(position == 0){
            layoutRes = R.layout.fragment_page1;
        }
        else if(position == 1){
            layoutRes = R.layout.fragment_page2;
        }
        else if(position ==2){
            layoutRes = R.layout.fragment_page3;
        }

        return inflater.inflate(layoutRes, container, false);
    }

    //sempre que chamado, irá criar uma nova instancia, chamando o onCreate...
    public static PageFragment newInstance(int position){
        PageFragment f = new PageFragment();
        f.position = position;
        return  f;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("fragmentPos", position);
    }
}
