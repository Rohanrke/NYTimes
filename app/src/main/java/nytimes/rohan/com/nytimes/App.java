package nytimes.rohan.com.nytimes;

import android.app.Application;
import android.content.Context;

public class App extends Application {




    private Context mAppContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppContext = this.getApplicationContext();

    }

}
