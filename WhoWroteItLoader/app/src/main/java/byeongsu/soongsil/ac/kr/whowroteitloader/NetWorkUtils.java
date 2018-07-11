package byeongsu.soongsil.ac.kr.whowroteitloader;

import android.net.NetworkInfo;
import android.net.Uri;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by bosslab on 18. 7. 11.
 */

public class NetWorkUtils {

    private static final String LOG_TAG = NetWorkUtils.class.getSimpleName();
    private static final String BOOK_BASE_URL = "https://www.googleapis.com/books/v1/volumes?";
    private static final String QUERY_PARM = "q"; // Parameter for the search string
    private static final String MAX_RESULTS = "maxResults"; // Parameter to limit the number of results
    private static final String PRINT_TYPE = "printType"; // Parameter to filter by print type

    static String getBookInfo(String queryString) {

        HttpURLConnection urlConnection = null; // Help connect network
        BufferedReader reader = null; // Read the incoming data
        String bookJSONString = null;


        try {

            // Build up query URI, limiting results to 10 items and printed books
            Uri builtURI = Uri.parse(BOOK_BASE_URL).buildUpon()
                    .appendQueryParameter(QUERY_PARM, queryString)
                    .appendQueryParameter(MAX_RESULTS, "10")
                    .appendQueryParameter(PRINT_TYPE, "books")
                    .build();

            // Convert URI to URL
            URL requestURL = new URL(builtURI.toString());

            // Make the request
            urlConnection = (HttpURLConnection) requestURL.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            // Read the response
            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();
            if (inputStream == null) {
                // Nothing to do
                return null;
            }

            reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                // Since it's JSON, adding a newline isn't necessary
                // it won't affect parsing
                // but it does make debugging a *lot* easier
                // if you print out the copleted buffer for debugging
                buffer.append(line + "\n");
            }
            if (buffer.length() == 0) {
                return null;
            }

            bookJSONString = buffer.toString();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            Log.d(LOG_TAG, bookJSONString);
            return bookJSONString;
        }
    }
}
