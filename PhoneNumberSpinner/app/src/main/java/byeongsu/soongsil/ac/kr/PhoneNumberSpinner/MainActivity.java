package byeongsu.soongsil.ac.kr.PhoneNumberSpinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private String mSpinnerLabel = "";
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Create ArrayAdapter using the string array and default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.labels_array, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Create a Spinner
        Spinner spinner = (Spinner) findViewById(R.id.label_spinner);
        if (spinner != null) {
            spinner.setAdapter(adapter);
            spinner.setOnItemSelectedListener(this);
            spinner.setSelection(0);
        }


    }

    public void showText(View view) {
        EditText editText = (EditText) findViewById(R.id.editText_main);
        TextView mPhoneLabel = (TextView) findViewById(R.id.text_phonelabel);
        if (editText != null) {
            String showString = editText.getText().toString() + " - " + mSpinnerLabel;
            mPhoneLabel.setText(editText.getText().toString() + " - " + mSpinnerLabel);
            Toast.makeText(this, showString, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        mSpinnerLabel = parent.getItemAtPosition(position).toString();
        showText(view);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

        Log.d(TAG, getString(R.string.nothing_selected));

    }
}
