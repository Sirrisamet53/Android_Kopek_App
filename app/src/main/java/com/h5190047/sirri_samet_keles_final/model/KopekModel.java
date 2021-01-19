package com.h5190047.sirri_samet_keles_final.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KopekModel {

    @SerializedName("Cinsi")
    @Expose
    private String cinsi;
    @SerializedName("Mizac")
    @Expose
    private String mizac;
    @SerializedName("YasamSuresi")
    @Expose
    private String yasamSuresi;
    @SerializedName("Renkler")
    @Expose
    private String renkler;
    @SerializedName("KariyerineBasladigiYer")
    @Expose
    private String kariyerineBasladigiYer;
    @SerializedName("Kutle")
    @Expose
    private String kutle;
    @SerializedName("Boy")
    @Expose
    private String boy;
    @SerializedName("Aciklama")
    @Expose
    private String aciklama;
    @SerializedName("BuyukResim")
    @Expose
    private String buyukResim;
    @SerializedName("KucukResim")
    @Expose
    private String kucukResim;

    public String getCinsi() {
        return cinsi;
    }

    public void setCinsi(String cinsi) {
        this.cinsi = cinsi;
    }

    public String getMizac() {
        return mizac;
    }

    public void setMizac(String mizac) {
        this.mizac = mizac;
    }

    public String getYasamSuresi() {
        return yasamSuresi;
    }

    public void setYasamSuresi(String yasamSuresi) {
        this.yasamSuresi = yasamSuresi;
    }

    public String getRenkler() {
        return renkler;
    }

    public void setRenkler(String renkler) {
        this.renkler = renkler;
    }

    public String getKariyerineBasladigiYer() {
        return kariyerineBasladigiYer;
    }

    public void setKariyerineBasladigiYer(String kariyerineBasladigiYer) {
        this.kariyerineBasladigiYer = kariyerineBasladigiYer;
    }

    public String getKutle() {
        return kutle;
    }

    public void setKutle(String kutle) {
        this.kutle = kutle;
    }

    public String getBoy() {
        return boy;
    }

    public void setBoy(String boy) {
        this.boy = boy;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public String getBuyukResim() {
        return buyukResim;
    }

    public void setBuyukResim(String buyukResim) {
        this.buyukResim = buyukResim;
    }

    public String getKucukResim() {
        return kucukResim;
    }

    public void setKucukResim(String kucukResim) {
        this.kucukResim = kucukResim;
    }

}
