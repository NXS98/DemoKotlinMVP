package com.vnext.demomvp.presenter;

import com.vnext.demomvp.model.entity.Category;
import com.vnext.demomvp.model.interfaces.CategoryContract;
import com.vnext.demomvp.model.network.APIClient;
import com.vnext.demomvp.model.network.RequestAPI;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryPresenter implements CategoryContract.Presenter {
    public ArrayList<Category> categories;
    private CategoryContract.View view;

    public CategoryPresenter(CategoryContract.View view) {
        this.view = view;
    }

    @Override
    public void loadDataCategory() {
        RequestAPI requestAPI = APIClient.getAPIService();
        Call<ArrayList<Category>> listCall = requestAPI.getDataCategory();
        listCall.enqueue(new Callback<ArrayList<Category>>() {
            @Override
            public void onResponse(Call<ArrayList<Category>> call, Response<ArrayList<Category>> response) {
                categories = response.body();
                view.loadDataCategory(categories);
            }

            @Override
            public void onFailure(Call<ArrayList<Category>> call, Throwable t) {

            }
        });
    }
}
