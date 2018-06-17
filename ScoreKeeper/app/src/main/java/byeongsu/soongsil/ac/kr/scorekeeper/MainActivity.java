package byeongsu.soongsil.ac.kr.scorekeeper;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int mTeam1 = 0;
    private int mTeam2 = 0;
    private TextView mTeam1Score;
    private TextView mTeam2Score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTeam1Score = (TextView) findViewById(R.id.score_team1);
        mTeam2Score = (TextView) findViewById(R.id.score_team2);

        if( savedInstanceState != null){

            mTeam1 = savedInstanceState.getInt("STATE_SCORE_1");
            mTeam2 = savedInstanceState.getInt("STATE_SCORE_2");

            mTeam1Score.setText(String.valueOf(mTeam1));
            mTeam2Score.setText(String.valueOf(mTeam2));
        }

        }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        // Save the score
        outState.putInt("STATE_SCORE_1", mTeam1);
        outState.putInt("STATE_SCORE_2", mTeam2);
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);

        // Change the label of the menu based on the state of the app
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if( nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        }else{
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Check if the correct item was clicked
        if(item.getItemId()==R.id.night_mode){
            // Get the night mode state of the app
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            // Set the theme mode for the restarted activity
            if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
        }

        recreate();

        return true;
    }

    /**
     * Method that handles the onClick of increment buttons.
     * @param view The button view that was clicked
     */
    public void increaseScore(View view) {

        switch (view.getId()) {

            case R.id.button_team1_plus:
                mTeam1Score.setText(String.valueOf(++mTeam1));
                break;

            case R.id.button_team2_plus:
                mTeam2Score.setText(String.valueOf(++mTeam2));
                break;
        }
    }

    /**
     * Method that handles the onClick of decrement buttons.
     * @param view The button view that was clicked.
     */
    public void decreaseScore(View view) {

        switch (view.getId()) {

            case R.id.button_team1_minus:
                mTeam1Score.setText(String.valueOf(--mTeam1));
                break;

            case R.id.button_team2_minus:
                mTeam2Score.setText(String.valueOf(--mTeam2));
                break;


        }
    }
}
