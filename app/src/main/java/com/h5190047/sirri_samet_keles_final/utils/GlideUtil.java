package com.h5190047.sirri_samet_keles_final.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.h5190047.sirri_samet_keles_final.R;


public class GlideUtil {

    public  static  void resmiIndiripGoster(Context context, String url, ImageView img)
    {
        Glide.with(context)
                .load(url)
                .error(R.drawable.resim_yok)
                .centerCrop()
                .into(img);
    }
}
