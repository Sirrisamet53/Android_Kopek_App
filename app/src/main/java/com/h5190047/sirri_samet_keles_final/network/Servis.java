package com.h5190047.sirri_samet_keles_final.network;

import com.h5190047.sirri_samet_keles_final.utils.Constant;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Servis {


    private static Retrofit retrofit;
    private static Retrofit getRetrofit() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constant.BASE_URL)
                    .client(getOkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }

    static OkHttpClient okHttpClient;
    private static OkHttpClient getOkHttpClient()
    {
        if(okHttpClient == null) {
            okHttpClient =  new OkHttpClient().newBuilder().build();
        }

        return okHttpClient;
    }

    ServisApi serviceApi;
    public ServisApi getServiceApi() {

        if(serviceApi == null) {
            serviceApi = getRetrofit().create(ServisApi.class);
        }

        return serviceApi;
    }
}
