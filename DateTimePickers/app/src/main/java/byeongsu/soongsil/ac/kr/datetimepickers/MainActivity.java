package byeongsu.soongsil.ac.kr.datetimepickers;

import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showDatePickerDialog(View view) {

        DialogFragment newFragment =  new DatePickerFragment();
        newFragment.show( getFragmentManager(),
                getString(R.string.date_picker));


    }

    public void showTimePickerDialog(View view) {

        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show( getFragmentManager(),
                getString(R.string.time_picker));
    }

    public void processDatePickerResult(int year, int month, int day){

        String year_string = Integer.toString(year);
        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);

        String date_message = ( month_string + " / " + day_string + " / " + year_string);

        Toast.makeText(this, getString(R.string.date) + date_message, Toast.LENGTH_SHORT)
                .show();

    }

    public void processTimePickerResult(int hourOfDay, int minute){

        String hour_string = Integer.toString(hourOfDay);
        String minute_string = Integer.toString(minute);

        String time_message =  ( hour_string + " : " + minute_string);

        Toast.makeText(this, getString(R.string.time) + time_message, Toast.LENGTH_SHORT)
                .show();
    }
}
