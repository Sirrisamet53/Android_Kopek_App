package com.h5190047.sirri_samet_keles_final.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkUtil {
    public  static  boolean internetVarMi(Context context)
    {
        ConnectivityManager connectivityManager =(ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo =connectivityManager.getActiveNetworkInfo();

        if(networkInfo!=null && networkInfo.isAvailable() && networkInfo.isConnected())
        {
            return  true;
        }
        else
        {
            return  false;
        }

    }
}
