package com.ipk.serasistemi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConnection {
    private static ApiService apiService=null;
    private static  String BASE_URL= "http://165.22.81.222/"; //projenin çalıştığı port numarası da ekliyor. numaranın sonuna :ile

    public static ApiService getApiService(){
        if(apiService==null){
            Retrofit retrofit=new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            apiService=retrofit.create(ApiService.class);
        }
        return apiService;
    }

}
