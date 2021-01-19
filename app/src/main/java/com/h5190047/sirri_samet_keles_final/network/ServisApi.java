package com.h5190047.sirri_samet_keles_final.network;

import com.h5190047.sirri_samet_keles_final.model.KopekModel;

import java.util.List;
import io.reactivex.Observable;
import retrofit2.http.GET;
public interface ServisApi {
    //base url
    //
    @GET("kopekApi.json")
    Observable<List<KopekModel>> kopekleriGetir();
}
