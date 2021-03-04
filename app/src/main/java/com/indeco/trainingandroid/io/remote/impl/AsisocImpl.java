package com.indeco.trainingandroid.io.remote.impl;

import com.indeco.trainingandroid.io.remote.RetrofitClientInstance;
import com.indeco.trainingandroid.io.remote.UICallable;
import com.indeco.trainingandroid.io.remote.entities.MyModel;
import com.indeco.trainingandroid.io.remote.pojos.AsisocService;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AsisocImpl {
    private final AsisocService service;
    private final String url = "https://asisocdev.indecosoft.net/";

    public AsisocImpl() throws Exception {
        service = RetrofitClientInstance.getRetrofitInstance(url).create(AsisocService.class);
    }

    public void getMyModels(String idClient, String idPers, String anLuna, UICallable<Response<List<MyModel>>> listener) {

        Call<List<MyModel>> call = service.getMyModels(idClient, idPers, anLuna);
        call.enqueue(new Callback<List<MyModel>>() {
            @Override
            public void onResponse(@NotNull Call<List<MyModel>> call, @NotNull Response<List<MyModel>> response) {
                listener.onResponse(response);
            }

            @Override
            public void onFailure(@NotNull Call<List<MyModel>> call, @NotNull Throwable t) {
                listener.onError(t.getMessage());
            }
        });
    }

}
