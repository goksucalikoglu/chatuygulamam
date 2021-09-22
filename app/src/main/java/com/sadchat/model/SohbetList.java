package com.sadchat.model;

public class SohbetList {

    private String kullaniciId;
    private String kullaniciAdi;
    private String durum;
    private String tarih;
    private String profilResmiUrl;

    public SohbetList() {
    }

    public SohbetList(String kullaniciId, String kullaniciAdi, String durum, String tarih, String profilResmiUrl) {
        this.kullaniciId = kullaniciId;
        this.kullaniciAdi = kullaniciAdi;
        this.durum = durum;
        this.tarih = tarih;
        this.profilResmiUrl = profilResmiUrl;
    }

    public String getKullaniciId() {
        return kullaniciId;
    }

    public void setKullaniciId(String kullaniciId) {
        this.kullaniciId = kullaniciId;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getDurum() {
        return durum;
    }

    public void setDurum(String durum) {
        this.durum = durum;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String getProfilResmiUrl() {
        return profilResmiUrl;
    }

    public void setProfilResmiUrl(String profilResmiUrl) {
        this.profilResmiUrl = profilResmiUrl;
    }
}
