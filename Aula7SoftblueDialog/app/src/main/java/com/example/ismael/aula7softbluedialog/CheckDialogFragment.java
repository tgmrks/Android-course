package com.example.ismael.aula7softbluedialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by ismael on 14/07/15.
 */
public class CheckDialogFragment extends DialogFragment implements DialogInterface.OnMultiChoiceClickListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        boolean checked[] = {true, false, true, false, false};

        //programação objetiva utilizando encadeamento
        return new AlertDialog.Builder(getActivity())
                .setTitle("Escolha uma banda:")     //quais serão previamente marcadas
                .setMultiChoiceItems(R.array.bandas, checked, this)
                .create();
    }

    @Override
    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
        String[] bandas = getActivity().getResources().getStringArray(R.array.bandas);
        String banda = bandas[which];

        if(isChecked){
            Toast.makeText(getActivity(), "vc escolheu a banda: " + banda, Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getActivity(), "vc desmarcou a banda: " + banda, Toast.LENGTH_SHORT).show();
        }


    }
}
