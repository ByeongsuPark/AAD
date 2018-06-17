package byeongsu.soongsil.ac.kr.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
