package com.h5190047.sirri_samet_keles_final.activities;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.h5190047.sirri_samet_keles_final.R;
import com.h5190047.sirri_samet_keles_final.adaptor.KopekAdaptor;
import com.h5190047.sirri_samet_keles_final.model.KopekModel;
import com.h5190047.sirri_samet_keles_final.network.Servis;
import com.h5190047.sirri_samet_keles_final.utils.AlertUtil;
import com.h5190047.sirri_samet_keles_final.utils.Constant;
import com.h5190047.sirri_samet_keles_final.utils.NesneUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ListeActivity extends AppCompatActivity {
    RecyclerView rcvKopekler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste);
        init();
    }

    @Override
    public void onBackPressed() {
        AlertUtil.alertGoster(this,getString(R.string.cikis_uyari_baslik),getString(R.string.cikis_uyari_mesaj), Constant.CIKIS_UYARI);

    }
    private  void  init()
    {
        kopekleriGetir();
    }

    void  kopekleriGetir()
    {
        ProgressDialog progressDialog =new ProgressDialog(ListeActivity.this);
        new Servis().getServiceApi().kopekleriGetir().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<KopekModel>>() {

                    List<KopekModel> kopekler=new ArrayList<>();

                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("RETROFIT","onSubscribe : ");
                    }

                    @Override
                    public void onNext(List<KopekModel> kopekList) {

                        progressDialog.setMessage(getString(R.string.progres_dialog_yazi));
                        progressDialog.show();


                        Log.e("RETROFIT","onNext : ");
                        kopekler=kopekList;
                    }
                    @Override
                    public void onError(Throwable e) {
                        progressDialog.dismiss();

                        Log.e("RETROFIT","onError : " + e.getLocalizedMessage());
                    }
                    @Override
                    public void onComplete()
                    {
                        progressDialog.dismiss();
                        Log.e("RETROFIT","onComplete : ");

                        if(kopekler.size()>0) {
                            initRecycleView(kopekler);
                        }
                    }
                });

    }
    private void ekranGecisi(KopekModel kopekModel) {

        Intent detayIntent = new Intent(getApplicationContext(), KopekDetayActivity.class);
        String tiklananKopekString = NesneUtil.kopekToJsonString(kopekModel);
        detayIntent.putExtra(Constant.TIKLANAN_KOPEK,tiklananKopekString);
        startActivity(detayIntent);
    }
    private  void  initRecycleView(List<KopekModel> kopekList)
    {
        rcvKopekler =findViewById(R.id.rcvKopekler);
        KopekAdaptor kopekAdaptor =new KopekAdaptor(kopekList, getApplicationContext(), new KopekAdaptor.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                KopekModel tiklananKopek =kopekList.get(pos);
                ekranGecisi(tiklananKopek);
            }
        });
        rcvKopekler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rcvKopekler.setAdapter(kopekAdaptor);
    }
}