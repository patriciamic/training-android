package com.indeco.trainingandroid.io.remote.pojos;

import com.indeco.trainingandroid.io.remote.entities.MyModel;

import org.json.JSONArray;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface AsisocService {
    @Headers({"Content-type: application/json",
            "Accept: */*"})
    @GET("get_beneficii_pers.php")
    Call<List<MyModel>> getMyModels(@Query("idClient") String idClient,
                                @Query("idPers") String idPers,
                                @Query("anluna") String anLuna);
}
