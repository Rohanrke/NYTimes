package nytimes.rohan.com.nytimes.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import nytimes.rohan.com.nytimes.App;


public class NetworkUtils {

    private NetworkUtils(){

    }


    /**
     *
     *  Checking if internet is available or not
     *
     * @return -- true/false depends on availability of internet
     */
    public static boolean isInternetAvailable(Context context) {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null &&
                activeNetwork.isConnected();

    }
}
