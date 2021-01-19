package com.h5190047.sirri_samet_keles_final.activities;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.h5190047.sirri_samet_keles_final.R;
import com.h5190047.sirri_samet_keles_final.model.KopekModel;
import com.h5190047.sirri_samet_keles_final.utils.Constant;
import com.h5190047.sirri_samet_keles_final.utils.GlideUtil;
import com.h5190047.sirri_samet_keles_final.utils.NesneUtil;
public class KopekDetayActivity extends AppCompatActivity {
    ImageView imgKapak;
    TextView  txtBaslik;
    TextView txtIcerik;
    TextView txtMizacBaslik;
    TextView txtMizac;
    TextView txtRenkler;
    TextView txtKutle;
    TextView txtBoy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kopek_detay);
        init();
    }
    private void init(){
        String tasinanKopekStrig = getIntent().getStringExtra(Constant.TIKLANAN_KOPEK);
        KopekModel kopekModel = NesneUtil.jsonStringToKopek(tasinanKopekStrig);
        imgKapak = findViewById(R.id.imgKapak);
        txtBaslik = findViewById(R.id.txtBaslik);
        txtIcerik = findViewById(R.id.txtIcerik);
        txtMizacBaslik=findViewById(R.id.txtMicazBaslik);
        txtMizac = findViewById(R.id.txtMizac);
        txtRenkler = findViewById(R.id.txtRenkler);
        txtKutle = findViewById(R.id.txtKutle);
        txtBoy = findViewById(R.id.txtBoy);


        txtBaslik.setText(kopekModel.getCinsi());
        txtIcerik.setText(kopekModel.getAciklama());
        txtMizac.setText(kopekModel.getMizac());
        txtRenkler.setText(kopekModel.getRenkler());
        txtKutle.setText(kopekModel.getKutle());
        txtBoy.setText(kopekModel.getBoy());

        GlideUtil.resmiIndiripGoster(getApplicationContext(),kopekModel.getBuyukResim(),imgKapak);

    }
}