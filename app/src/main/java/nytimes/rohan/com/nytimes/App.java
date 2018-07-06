package nytimes.rohan.com.nytimes;

import android.app.Application;
import android.content.Context;

public class App extends Application {


    private static App INSTANCE;


    private Context mAppContext;

    @Override
    public void onCreate() {
        super.onCreate();

        INSTANCE = this;
        mAppContext = this.getApplicationContext();

    }

    public static App getInstance() {
        return INSTANCE;
    }
}
