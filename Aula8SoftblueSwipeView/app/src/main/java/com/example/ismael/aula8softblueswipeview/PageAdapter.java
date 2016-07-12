package com.example.ismael.aula8softblueswipeview;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by ismael on 18/07/15.
 */
public class PageAdapter extends FragmentStatePagerAdapter{


    public PageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        //Para retornar um item, ele já chama a criação que por si já retorna um item...
        return PageFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        //3 pq temos 3 layouts de fragments para mostrar... portanto, podendo ser até dinamico se possivel
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        //retorno dinamicamente o titulo da tab...
        return "Tab " + (position+1);
    }
}
