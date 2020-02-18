package com.vnext.demomvp.model.network;

public class APIClient {
    public static final String BASE_URL = "http://192.84.41.19:81/";

    private APIClient() {
    }

    public static RequestAPI getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(RequestAPI.class);
    }
}
