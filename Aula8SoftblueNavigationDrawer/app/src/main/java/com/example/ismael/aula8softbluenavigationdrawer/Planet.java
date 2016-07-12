package com.example.ismael.aula8softbluenavigationdrawer;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ismael on 19/07/15.
 */
public class Planet implements Serializable {

    private String name;
    private int imageId;

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }

    public static List<Planet> buildPlanets(Context context){
        List<Planet> planets = new ArrayList<>();

        Resources res = context.getResources();
        String[] names = res.getStringArray(R.array.planets_names);
        TypedArray images = res.obtainTypedArray(R.array.planets_imgs);

        for(int i = 0; i < names.length; i++){
            Planet p = new Planet();
            p.name = names[i];                //valor q é apresentado como DEFAULT se não achar i ID
            p.imageId = images.getResourceId(i, -1);
            planets.add(p);
        }

        images.recycle();

        return planets;
    }
}
