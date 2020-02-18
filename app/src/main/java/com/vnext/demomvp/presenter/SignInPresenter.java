package com.vnext.demomvp.presenter;

import android.widget.Toast;

import com.vnext.demomvp.model.entity.User;
import com.vnext.demomvp.model.interfaces.SignInContract;
import com.vnext.demomvp.model.network.APIClient;
import com.vnext.demomvp.model.network.RequestAPI;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SignInPresenter implements SignInContract.Presenter {
    private SignInContract.View view;
    private RequestAPI requestAPI;
    public SignInPresenter(SignInContract.View view) {
        this.view = view;
    }

    @Override
    public void handleSignIn(String username, String password) {
         requestAPI = APIClient.getAPIService();
        Call<ArrayList<User>> call = requestAPI.signIn(username,password);
        call.enqueue(new Callback<ArrayList<User>>() {
            @Override
            public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {
                if(response.body()!=null){
                    ArrayList<User> users = response.body();
                    if(users.size()!=0){
                        System.out.println("=======================size::::"+users.size());
                        view.signInSuccess();
                    }else {
                        view.signInFailure("False");
                    }
                }
            }

            @Override
            public void onFailure(Call<ArrayList<User>> call, Throwable t) {
                System.out.println("LOI SEVER");
            }
        });
    }
}
