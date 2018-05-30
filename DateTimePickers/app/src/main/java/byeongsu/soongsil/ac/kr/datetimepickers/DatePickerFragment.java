package byeongsu.soongsil.ac.kr.datetimepickers;


import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

import static java.util.Calendar.MONTH;

/**
 * A simple {@link Fragment} subclass.
 */
public class DatePickerFragment extends DialogFragment
                        implements DatePickerDialog.OnDateSetListener{

    // There is no need to create a layout for a standard picker.

    @NonNull // indicate that return value Dialog can't be null.
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Use the current date as a default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        // Some executions with user selected date
        MainActivity activity = (MainActivity) getActivity();
        activity.processDatePickerResult(year, month, dayOfMonth);


    }
}
