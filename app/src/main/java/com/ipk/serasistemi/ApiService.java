package com.ipk.serasistemi;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @GET("getall")
    Call<List<GhInfo>> getAll();

    @POST("/get/currentheat")
    Call<ResponseBody> getCurrentHeat(@Body int id);

    @POST("/set/currentheat")
    Call<ResponseBody> setCurrentHeat(@Body int id, @Body int heat);

    @POST("/get/targetheat")
    Call<ResponseBody> getTargetHeat(@Body int id);

    @POST("/set/currentheat")
    Call<ResponseBody> setTargetHeat(@Body int id, @Body int heat);
}
