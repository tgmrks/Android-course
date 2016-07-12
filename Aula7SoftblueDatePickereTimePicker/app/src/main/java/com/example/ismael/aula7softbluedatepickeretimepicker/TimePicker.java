package com.example.ismael.aula7softbluedatepickeretimepicker;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by ismael on 14/07/15.
 */
public class TimePicker extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new TimePickerDialog(getActivity(), this, 12, 00, true);
    }

    @Override
    public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute) {
        String msg = String.format("vc selecionou a hora %02d:%02d", hourOfDay, minute);
        Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
    }
}
