package nytimes.rohan.com.nytimes.utils;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.test.runner.AndroidJUnit4;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import java.util.Random;

import nytimes.rohan.com.nytimes.R;

public class NetworkUtilsTest{


    private static boolean RESULT = new Random().nextBoolean();

     @Mock
     Context mMockContext;
     String appName = "NYTimes";




    @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();





    @Test
    public void isInternetAvailable() {

        Logger.logInfo("testing mContext");

        final ConnectivityManager manager = Mockito.mock(ConnectivityManager.class);
        final NetworkInfo networkInfo = Mockito.mock(NetworkInfo.class);
        Mockito.when(mMockContext.getSystemService(Context.CONNECTIVITY_SERVICE)).thenReturn(manager);
        Mockito.when(manager.getActiveNetworkInfo()).thenReturn(networkInfo);
        Mockito.when(networkInfo.isConnected()).thenReturn(RESULT);

        Assert.assertEquals(RESULT,NetworkUtils.isInternetAvailable(mMockContext));

        Mockito.verify(networkInfo).isConnected();
    }


    @Test
    public void testIsConnectedReturnsFalseWhenActiveNetworkInfoIsNull() {


        final ConnectivityManager manager = Mockito.mock(ConnectivityManager.class);

        Mockito.when(mMockContext.getSystemService(Context.CONNECTIVITY_SERVICE)).thenReturn(manager);
        Mockito.when(manager.getActiveNetworkInfo()).thenReturn(null);

        Assert.assertEquals(false, NetworkUtils.isInternetAvailable(mMockContext));
    }

}