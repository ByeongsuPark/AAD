package byeongsu.soongsil.ac.kr.whowroteitloader;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {

    EditText mBookInput;
    TextView mTitleText;
    TextView mAuthorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBookInput = (EditText)findViewById(R.id.bookInput);
        mTitleText = (TextView)findViewById(R.id.titleText);
        mAuthorText = (TextView)findViewById(R.id.authorText);

        if(getSupportLoaderManager().getLoader(0) != null){
            getSupportLoaderManager().initLoader(0, null, this);
        }
    }

    public void searchBooks(View view) {

        String queryString = mBookInput.getText().toString();

        // Hide the Keyboard to show that the query is executed
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);

        // Check Network state
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if(networkInfo != null && networkInfo.isConnected() && queryString.length() != 0){

            Bundle queryBundle = new Bundle();
            queryBundle.putString("queryString", queryString);
            getSupportLoaderManager().restartLoader(0, queryBundle, this);

            mAuthorText.setText("");
            mTitleText.setText(R.string.loading_text);
        }else if(queryString.length() == 0){
            mAuthorText.setText("");
            mTitleText.setText("Please enter a search term");
        }else{
            mAuthorText.setText("");
            mTitleText.setText("Please check your network connection and try again");
        }
    }

    @Override
    public Loader<String> onCreateLoader(int id, Bundle args) {
        return new BookLoader(this, args.getString("queryString"));
    }

    @Override
    public void onLoadFinished(Loader<String> loader, String data) {

        // Parse the JSON strings
        try{

            JSONObject jsonObject = new JSONObject(data);
            JSONArray itemsArray = jsonObject.getJSONArray("items");

            // Iterate through the results
            for(int i = 0 ; i < itemsArray.length() ; i++){

                JSONObject book = itemsArray.getJSONObject(i); // Get the current item
                String title = null;
                String authors = null;
                JSONObject volumeInfo = book.getJSONObject("volumeInfo");

                try{
                    title = volumeInfo.getString("title");
                    authors = volumeInfo.getString("authors");
                }catch(Exception e){
                    e.printStackTrace();
                }

                // if both a title and author exist, update the TextViews and return
                if(title != null && authors != null){
                    mTitleText.setText(title);
                    mAuthorText.setText(authors);
                    return;
                }
            }

            // When there is no match result, update the TextViews
            mTitleText.setText("No Results Found");
            mAuthorText.setText("");


        } catch (Exception e) {
            mTitleText.setText("No Results Found");
            mAuthorText.setText("");
            e.printStackTrace();
        }

    }

    @Override
    public void onLoaderReset(Loader<String> loader) {

    }
}
