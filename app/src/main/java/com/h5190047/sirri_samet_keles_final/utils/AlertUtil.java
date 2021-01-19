package com.h5190047.sirri_samet_keles_final.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;

import androidx.appcompat.app.AlertDialog;

import com.h5190047.sirri_samet_keles_final.R;

public class AlertUtil {
    public static void  alertGoster(Activity activity, String baslik, String mesaj, String uyariTuru){

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(baslik);
        builder.setMessage(mesaj);
        if (uyariTuru.equals(Constant.INTERNET_UYARI)){
            builder.setPositiveButton(activity.getString(R.string.internet_uyari_btn_ayarlar), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    Intent intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
                    activity.startActivity(intent);
                    activity.finish();
                }
            });
            builder.setNegativeButton(activity.getString(R.string.internet_uyari_btn_cikis), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    activity.finish();
                }
            });
        }

        else{
            builder.setPositiveButton(activity.getString(R.string.cikis_uyari_btn_evet), new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                activity.finish();
            }
        });
            builder.setNegativeButton(activity.getString(R.string.cikis_uyari_btn_hayir), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
        }
        builder.show();
    }
}
