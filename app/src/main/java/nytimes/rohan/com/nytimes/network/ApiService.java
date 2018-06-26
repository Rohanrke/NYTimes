package nytimes.rohan.com.nytimes.network;

;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    /**
     * @GET declares an HTTP GET request
     */
    @GET("7.json?api-key=54e5496eb75443aea29abca3eda6dbf6")
    Call<BaseResponse> getUser();
}






