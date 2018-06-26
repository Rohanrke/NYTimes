package nytimes.rohan.com.nytimes;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;


import java.util.List;

import static org.junit.Assert.assertFalse;

import static org.mockito.Mockito.*;

import nytimes.rohan.com.nytimes.data.NewsData;
import nytimes.rohan.com.nytimes.viewmodel.NewsViewModel;
import okhttp3.mockwebserver.MockWebServer;


public class NYTimesServiceTest {



    @Mock
    private NewsViewModel viewModel;

    private MockWebServer webServer;



    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        webServer = new MockWebServer();
        webServer.start();
        webServer.url("/").toString();
    }

    @Test
    public void testApiData(){

      OngoingStubbing<LiveData<List<NewsData>>> stubbing =  when(viewModel.getNewsData()).thenReturn(new MutableLiveData<List<NewsData>>());
      LiveData<List<NewsData>>  data =  stubbing.getMock();
      assertFalse(data.getValue().isEmpty());

    }

}
