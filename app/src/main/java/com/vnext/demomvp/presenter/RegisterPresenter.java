package com.vnext.demomvp.presenter;

import android.text.TextUtils;
import android.util.Log;

import com.vnext.demomvp.model.entity.BaseResponse;
import com.vnext.demomvp.model.interfaces.RegisterContract;
import com.vnext.demomvp.model.network.APIClient;
import com.vnext.demomvp.model.network.RequestAPI;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterPresenter implements RegisterContract.Presenter {
    RegisterContract.View view;

    public RegisterPresenter(RegisterContract.View view) {
        this.view = view;
    }

    @Override
    public void handleRegister(String username, String password) {
        RequestAPI requestAPI = APIClient.getAPIService();
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("username1", username);

        map.put("password", password );
        Call<BaseResponse<String>> listCall = requestAPI.register(map);
        listCall.enqueue(new Callback<BaseResponse<String>>() {
            @Override
            public void onResponse(Call<BaseResponse<String>> call, Response<BaseResponse<String>> response) {
                BaseResponse<String> baseResponses = response.body();
                if(baseResponses.getStatus()==200 && !TextUtils.isEmpty(baseResponses.getData())){
                    view.registerSuccess(baseResponses.getMessage());
                }else {
                    view.registerFailure();
                    Log.e("TAG", "" + baseResponses.getMessage64());
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<String>> call, Throwable t) {
                Log.e("tag",""+t.getMessage());
                view.registerFailure();
            }
        });
     }
}
