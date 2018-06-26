package nytimes.rohan.com.nytimes.network;

import java.util.List;

import nytimes.rohan.com.nytimes.data.NewsData;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    /**
     * @GET declares an HTTP GET request
     * @Path("user") annotation on the userId parameter marks it as a
     * replacement for the {user} placeholder in the @GET path
     */
    @GET("7.json?api-key=54e5496eb75443aea29abca3eda6dbf6")
    Call<BaseResponse> getUser();
}






