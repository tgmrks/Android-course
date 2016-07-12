package com.example.ismael.aula8softbluenavigationdrawer;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.SearchManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.audiofx.BassBoost;
import android.provider.Settings;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements PlanetAdapter.OnItemClickListener {

    private DrawerLayout drawerLayout;
    private ListView drawerList;
    private Planet selectedPlanet;
    private ActionBarDrawerToggle drawerToggle; //o "botão" do navigation drawer

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);

        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        drawerList = (ListView)findViewById(R.id.left_drawer);

        drawerList.setAdapter(new PlanetAdapter(this, this));


        if(getActionBar() != null){
            getActionBar().setDisplayHomeAsUpEnabled(true); //habilita
            getActionBar().setHomeButtonEnabled(true);      //os bottões do navigation drawer
        }

        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_open, R.string.drawer_close){
            @Override
            public void onDrawerOpened(View drawerView) {
                setTitle(R.string.title_choose);
                invalidateOptionsMenu(); //pede para q o menu seja recriado
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                if(selectedPlanet != null){
                    setTitle(selectedPlanet.getName());
                }
                else{
                    setTitle(R.string.app_name);
                }
                invalidateOptionsMenu();
            }
        };

        drawerLayout.setDrawerListener(drawerToggle);

        if(savedInstanceState == null){
            selectItem(null);
        }
        else{
            selectedPlanet = (Planet) savedInstanceState.getSerializable("planet");
            selectItem(selectedPlanet);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actions, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        boolean drawerOpen = drawerLayout.isDrawerOpen(drawerList);
        MenuItem searchMenu = menu.findItem(R.id.action_search);
        searchMenu.setVisible(!drawerOpen && selectedPlanet != null);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(drawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        if(item.getItemId() == R.id.action_search){
            Intent it = new Intent(Intent.ACTION_WEB_SEARCH);
            it.putExtra(SearchManager.QUERY, "Planeta " + selectedPlanet.getName());
            startActivity(it);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("planet", selectedPlanet );
    }

    private void selectItem(Planet planet){
        if(planet != null){
            this.selectedPlanet = planet;
            Fragment fragment = PlanetFragment.newInstance(planet);
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.content_frame, fragment);
            transaction.commit();
            setTitle(planet.getName());
        }

        drawerLayout.closeDrawer(drawerList);
    }

    @Override
    public void onClick(Planet planet) {
        selectItem(planet);
    }
}
