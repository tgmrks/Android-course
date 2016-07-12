package com.example.ismael.aula7softbluedialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by ismael on 14/07/15.
 */
public class MyDialogFragment extends DialogFragment implements DialogInterface.OnClickListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Pergunta")
                .setMessage("Vc compreende o funcionamento de Dialog?")
                .setPositiveButton("Sim", this)
                .setNegativeButton("Não", this);

        return builder.create();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {

        String msg = null;

        if(which == Dialog.BUTTON_POSITIVE){
            msg = "vc cliclou em SIM ♪~\\(˘O˘)/";
        }
        else if(which == Dialog.BUTTON_NEGATIVE){
            msg = "vc cliclou em NAO ¯\\_(ツ)_/¯";
        }

        Toast.makeText(getActivity(),msg, Toast.LENGTH_LONG).show();

    }
}
