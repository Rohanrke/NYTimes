package nytimes.rohan.com.nytimes.network;


import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.UnknownHostException;

import nytimes.rohan.com.nytimes.utils.ErrorUtils;
import nytimes.rohan.com.nytimes.utils.Logger;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class BaseCallback<BaseResponse> implements Callback<BaseResponse> {


    public static final String TAG = BaseCallback.class.getSimpleName();
    private static final int HTTP_OK = 200;
    private static final int ERROR_500 = 500;
    private static final int INVALID_SESSION = 401;
    private static final int ERROR_400 = 400;



    /**
     * Invoked when Successful response sent from server.

     * @param response Response from server
     */
    public abstract void onSuccess(BaseResponse response);

    /**
     * Invoked when a network exception occurred talking to the server or when an unexpected
     * exception occurred creating the request or processing the response.
     *
     * @param call Failed Call instance
     */
    public abstract void onFail(Call<BaseResponse> call, String baseError);


    public  void onSessionExpired(){

    }

    public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
        //Generic error response code are handled at base level


        switch (response.code()){
            case HTTP_OK:
                onSuccess(response.body());
                break;

            case INVALID_SESSION:
                // show alert message for invalid session
                onSessionExpired();


                break;

            case ERROR_400:

                try {
                    onFail(call, ErrorUtils.parseBaseError(response.errorBody().string()));
                }catch (IOException e){
                    e.printStackTrace();
                }
                break;

            case ERROR_500:

                try {
                    onFail(call, ErrorUtils.parseBaseError(response.errorBody().string()));
                }catch (IOException e){
                    e.printStackTrace();
                }


                break;
        }

    }

    @Override
    public void onFailure(Call<BaseResponse> call, Throwable t) {
        t.printStackTrace();
        Logger.logError(t.getMessage());
        if (t instanceof SocketException || t instanceof ConnectException || t instanceof UnknownHostException) {
            onFail(call,"No Internet Connection");
        }else {
            onFail(call, t.getMessage());
        }

    }

}
