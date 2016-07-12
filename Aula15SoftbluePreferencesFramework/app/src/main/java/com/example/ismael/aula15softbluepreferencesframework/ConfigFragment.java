package com.example.ismael.aula15softbluepreferencesframework;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.SwitchPreference;

/**
 * Created by ismael on 31/07/15.
 */
public class ConfigFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {

    private SwitchPreference prefMapEnabled;
    private ListPreference prefUnit;
    private CheckBoxPreference prefSattelite;

    private Resources res;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.config);

        //pegar o contexto das views infladas na activity
        res = getActivity().getResources();
                                                              //*Key //Chave que identifica a preferencia
            prefMapEnabled = (SwitchPreference)findPreference(res.getString(R.string.pref_map_enabled));
            prefUnit = (ListPreference)findPreference(res.getString(R.string.pref_un_dist));
            prefSattelite = (CheckBoxPreference)findPreference(res.getString(R.string.pref_sattelite));

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
            //registrando um listener para verificar alteração
            prefs.registerOnSharedPreferenceChangeListener(this);

            boolean defValue = res.getBoolean(R.bool.map_enabled_default);
            boolean enabled = prefs.getBoolean(res.getString(R.string.pref_map_enabled), defValue);
            //declara valor no momento do onCreate
            setEnabled(enabled);

    }

    private void setEnabled(boolean enabled){
        prefSattelite.setEnabled(enabled);
        prefUnit.setEnabled(enabled);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

        if(key.equals(prefMapEnabled.getKey())){
            boolean defValue = res.getBoolean(R.bool.map_enabled_default);
            boolean enabled = sharedPreferences.getBoolean(key, defValue);
            //declara valor no momento da alteração
            setEnabled(enabled);
        }
    }
}
