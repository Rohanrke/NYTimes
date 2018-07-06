package nytimes.rohan.com.nytimes.utils;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.test.runner.AndroidJUnit4;

import junit.framework.Assert;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Random;

@RunWith(AndroidJUnit4.class)
public class NetworkUtilsTest{

    private static final boolean RESULT = new Random().nextBoolean();

    @Rule
    public MockitoRule mockitoRule =  MockitoJUnit.rule();



    @Test
    public void isInternetAvailable() {

        final Context context = Mockito.mock(Context.class);
        final NetworkInfo networkInfo = Mockito.mock(NetworkInfo.class);
        final ConnectivityManager manager = Mockito.mock(ConnectivityManager.class);

        Mockito.when(context.getSystemService(Context.CONNECTIVITY_SERVICE)).thenReturn(manager);
        Mockito.when(manager.getActiveNetworkInfo()).thenReturn(networkInfo);
        Mockito.when(networkInfo.isConnected()).thenReturn(RESULT);

        Assert.assertEquals(RESULT,NetworkUtils.isInternetAvailable());

        Mockito.verify(networkInfo).isConnected();
    }

    @Test
    public void testIsConnectedReturnsFalseWhenActiveNetworkInfoIsNull() {
        final Context context = Mockito.mock(Context.class);
        final ConnectivityManager manager = Mockito.mock(ConnectivityManager.class);

        Mockito.when(context.getSystemService(Context.CONNECTIVITY_SERVICE)).thenReturn(manager);
        Mockito.when(manager.getActiveNetworkInfo()).thenReturn(null);

        Assert.assertEquals(false, NetworkUtils.isInternetAvailable());
    }
}