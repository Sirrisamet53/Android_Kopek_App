package com.h5190047.sirri_samet_keles_final.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

import com.h5190047.sirri_samet_keles_final.R;
import com.h5190047.sirri_samet_keles_final.utils.AlertUtil;
import com.h5190047.sirri_samet_keles_final.utils.Constant;
import com.h5190047.sirri_samet_keles_final.utils.NetworkUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        splsScrn();
    }
    public void splsScrn(){
        CountDownTimer splsTimer=new CountDownTimer(Constant.MILI_SANIYE_SPLSSCRN,Constant.INTERVAL_SPLSSCRN) {
            @Override
            public void onTick(long millisUntilFinished) {
            }
            @Override
            public void onFinish() {
                ekranGecisi();
            }
        };
        splsTimer.start();
    }
    private void ekranGecisi() {
        if (NetworkUtil.internetVarMi(getApplicationContext()))
        {
            Intent listeIntent = new Intent(getApplicationContext(),ListeActivity.class);
            startActivity(listeIntent);
            finish();
        }
        else{
            AlertUtil.alertGoster(this,getString(R.string.internet_uyari_baslik),getString(R.string.internet_uyari_mesaj),Constant.INTERNET_UYARI);
        }
    }
}