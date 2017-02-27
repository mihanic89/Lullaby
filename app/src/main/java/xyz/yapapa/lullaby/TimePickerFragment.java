package com.yamilab.lullababy;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

/**
 * Created by Misha on 14.02.2017.
 */


public  class TimePickerFragment extends DialogFragment
        implements TimePickerDialog.OnTimeSetListener {

    SharedPreferences sPref;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current time as the default values for the picker

        int hour = 1;
        int minute = 0;


        // Create a new instance of TimePickerDialog and return it
        return new TimePickerDialog(getActivity(), this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));
    }

    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        // Do something with the time chosen by the user
        long timer_pick = 30000;
        String set_time;
        TextView textTimer;
        sPref = this.getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        timer_pick = (hourOfDay*60+ minute)*60000;


        set_time = String.format("%02d:%02d",hourOfDay,minute);

        ed.putLong("timer", timer_pick);
        Toast.makeText(this.getActivity(),"seconds remaining: " + timer_pick/1000 ,
               Toast.LENGTH_SHORT).show();
        textTimer = (TextView) getActivity().findViewById(R.id.textViewTimer);
        textTimer.setText(set_time);
        ed.putString("cheked_time",set_time);
        ed.commit();
    }


}
