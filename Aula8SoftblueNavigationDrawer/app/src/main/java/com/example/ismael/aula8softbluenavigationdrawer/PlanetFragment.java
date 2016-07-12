package com.example.ismael.aula8softbluenavigationdrawer;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ismael on 19/07/15.
 */
public class PlanetFragment extends Fragment {

    private Planet planet;

    public static PlanetFragment newInstance(Planet planet) {
        PlanetFragment fragment = new PlanetFragment();
        fragment.planet = planet;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true); //****para não perder os valores, quando houver uma "atualização/ mudança ed status" na tela...
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_planet, container, false);

        ImageView image = ((ImageView) view.findViewById(R.id.image));
        image.setImageResource(planet.getImageId());
        getActivity().setTitle(planet.getName());

        return view;
    }
}
