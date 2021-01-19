package com.h5190047.sirri_samet_keles_final.utils;

import com.google.gson.Gson;
import com.h5190047.sirri_samet_keles_final.model.KopekModel;

public class NesneUtil {
    public static String kopekToJsonString(KopekModel kopekModel){
        Gson gson = new Gson();
        return  gson.toJson(kopekModel);
    }
    public static KopekModel jsonStringToKopek(String jsonString){
        Gson gson =new Gson();
        return gson.fromJson(jsonString, KopekModel.class);
    }

}
