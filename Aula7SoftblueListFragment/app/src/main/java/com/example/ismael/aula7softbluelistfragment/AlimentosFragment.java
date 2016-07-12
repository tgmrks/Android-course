package com.example.ismael.aula7softbluelistfragment;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;

/**
 * Created by ismael on 14/07/15.
 */
public class AlimentosFragment extends ListFragment {

    private ArrayAdapter<Alimento> adapter;
    private OnItemClick listener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if(!(activity instanceof OnItemClick)){
            throw new RuntimeException("a activity não implementa interface OnItemCLick");
        }

        listener = (OnItemClick) activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1);

        String[] nomes = getActivity().getResources().getStringArray(R.array.alimentos_nomes);
        String[] precos = getActivity().getResources().getStringArray(R.array.alimentos_precos);

        for(int i = 0; i < nomes.length; i++){
            Alimento alimento = new Alimento(nomes[i], Double.parseDouble(precos[i]));
            adapter.add(alimento);
        }

        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Alimento alimento = adapter.getItem(position);

        if(listener != null){
            listener.onClick(alimento);
        }
    }

    public interface OnItemClick {
        public void onClick(Alimento alimento);
    }
}
