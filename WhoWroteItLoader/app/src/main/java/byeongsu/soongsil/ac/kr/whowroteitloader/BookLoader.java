package byeongsu.soongsil.ac.kr.whowroteitloader;

import android.content.Context;

/**
 * Created by bosslab on 18. 7. 16.
 */

public class BookLoader extends android.support.v4.content.AsyncTaskLoader<String> {

    String mQueryString;

    public BookLoader(Context context, String mQueryString) {
        super(context);
        this.mQueryString = mQueryString;
    }

    public BookLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();

        forceLoad();
    }

    @Override
    public String loadInBackground() {
        return NetWorkUtils.getBookInfo(mQueryString);
    }


}
