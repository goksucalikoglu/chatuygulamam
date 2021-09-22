package com.sadchat.model;

public class AramaList {
    private String kullanıcıID, kullaniciAdi,tarih,profilURL, cagriTuru;
    public AramaList() {
    }
    public AramaList(String kullanıcıID, String kullaniciAdi, String tarih, String profilURL, String cagriTuru) {
        this.kullanıcıID = kullanıcıID;
        this.kullaniciAdi = kullaniciAdi;
        this.tarih = tarih;
        this.profilURL = profilURL;
        this.cagriTuru = cagriTuru;
    }
    public String getKullanıcıID() {
        return kullanıcıID;
    }

    public void setKullanıcıID(String kullanıcıID) {
        this.kullanıcıID = kullanıcıID;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String getProfilURL() {
        return profilURL;
    }

    public void setProfilURL(String profilURL) {
        this.profilURL = profilURL;
    }

    public String getCagriTuru() {
        return cagriTuru;
    }

    public void setCagriTuru(String cagriTuru) {
        this.cagriTuru = cagriTuru;
    }
}
