package byeongsu.soongsil.ac.kr.droidcafe;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       /* if (id == R.id.action_settings) {
            return true;
        }
        */
        return super.onOptionsItemSelected(item);
    }

    public void displayToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT)
                .show();
    }


    /**
     *  display a toast message for the food order
     *  and starts the food order activity
     * @param message   Message to display
     */

    // 아래의 메서드는 실질적으로 MainActivity파일의 어느 위치에 넣어도 상관은 x
    // 그러나 이런 메서드를 넣을때는 싈질적으로 코드내에서 호출하는 함수 내에 넣는게 좋다고 함.
    public void showFoodOrder(String message){
        displayToast(message);
        Intent intent = new Intent(this, OrderActivity.class);
        startActivity(intent);
    }

    /**
     * Show a message that the donut image was clicked
     */
    public void showDonutOrder(View view){
        showFoodOrder(getString(R.string.donut_order_message));
    }

    /**
     * Show a message that the ice cream image was clicked
     */
    public void showIceCreamOrder(View view){
        showFoodOrder(getString(R.string.ice_cream_order_message));
    }

    /**
     * Show a message that the Froyo image was clicked
     */
    public void showFroyoOrder(View view){
        showFoodOrder(getString(R.string.froyo_order_message));
    }
}
