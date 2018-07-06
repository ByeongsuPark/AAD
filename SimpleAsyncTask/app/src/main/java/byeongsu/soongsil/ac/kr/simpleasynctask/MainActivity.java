package byeongsu.soongsil.ac.kr.simpleasynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TEXT_STATE = "TEXT_STATE" ;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.textView1);

        if( savedInstanceState != null){
            mTextView.setText(savedInstanceState.getString(TEXT_STATE));
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Save the state of the TextView
        outState.putString(TEXT_STATE, mTextView.getText().toString());
    }

    public void startTask(View view) {

        // Put a Message in the TextView
        mTextView.setText("Napping... ");

        // Start the AsyncTask.
        // The AsyncTask has a callback that will update the TextView
        new SimpleAsyncTask(mTextView).execute();
    }

    public class SimpleAsyncTask extends AsyncTask<Void, Void, String>{

        TextView mTextView;

        public SimpleAsyncTask(TextView mTextView) {
            this.mTextView = mTextView;
        }

        @Override
        protected String doInBackground(Void... voids) {

            // Generate a random number between 0 and 10
            Random r = new Random();
            int n = r.nextInt(11);

            // Make the task take long enough that we have
            // time to rotate the phone while it is running
            int s = n * 200;

            // Sleep for the random amount of time
            try{
                Thread.sleep(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Return a String result;
            return "Awake at last after sleeping for " + s + "milliseconds";
        }

        @Override
        protected void onPostExecute(String s) {
            mTextView.setText(s);
        }
    }
}



