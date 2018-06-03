package byeongsu.soongsil.ac.kr.droidcafe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {

    private static final String TAG = OrderActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
    }

    public void displayToast(String message){
        Toast.makeText(this, message,
                Toast.LENGTH_SHORT).show();
    }

    public void onRadioButtonClicked(View view) {

        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()){

            case R.id.sameday:
                if(checked)
                    // Same day Service
                    displayToast(getString(R.string.chosen)
                    + getString(R.string.same_day_messenger_service));

                break;

            case R.id.nextday:
                if(checked)
                    // Next day Service
                    displayToast(getString(R.string.chosen)
                    + getString(R.string.next_day_ground_delivery));
                break;

            case R.id.pickup:
                if(checked)
                    // Pick up Service
                    displayToast(getString(R.string.chosen)
                    + getString(R.string.pick_up));

                break;
        }
    }
}
