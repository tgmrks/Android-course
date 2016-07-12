package com.example.ismael.aula7softbluedatepickeretimepicker;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by ismael on 14/07/15.
 */
public class DatePicker extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new DatePickerDialog(getActivity(), this, 2020, 0, 1);
    }

    @Override
    public void onDateSet(android.widget.DatePicker view, int year, int monthOfYear, int dayOfMonth) {

        String msg = String.format("vc selecionou a data %02d/%02d/%d", dayOfMonth, monthOfYear + 1, year);
        Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
    }
}
