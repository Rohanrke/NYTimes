package nytimes.rohan.com.nytimes.repo;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import java.util.List;

import javax.inject.Singleton;

import nytimes.rohan.com.nytimes.data.NewsData;
import nytimes.rohan.com.nytimes.network.ApiService;
import nytimes.rohan.com.nytimes.network.BaseCallback;
import nytimes.rohan.com.nytimes.network.BaseResponse;
import nytimes.rohan.com.nytimes.network.ConnectionFactory;
import nytimes.rohan.com.nytimes.utils.Logger;
import retrofit2.Call;


@Singleton
public class HeadLineRepository {

    private ApiService apiService;


    public LiveData<List<NewsData>> getHeadLineData(){

        apiService = ConnectionFactory.getHttpConnection();

        final MutableLiveData<List<NewsData>> data =
                 new MutableLiveData<>();
        apiService.getUser().enqueue(new BaseCallback<BaseResponse>() {
            @Override
            public void onSuccess(BaseResponse baseResponse) {
                if (baseResponse!=null){
                    data.setValue(baseResponse.getResults());
                }
            }

            @Override
            public void onFail(Call<BaseResponse> call, String baseError) {

                Logger.logInfo("failure");
                data.setValue(null);
            }
        });
        return data;
    }
}
