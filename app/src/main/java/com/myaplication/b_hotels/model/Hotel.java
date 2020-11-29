package com.myaplication.b_hotels.model;

import com.google.gson.annotations.SerializedName;

public class Hotel {

    @SerializedName("id")
    private Integer id;

    @SerializedName("nama")
    private String nama;

    @SerializedName("alamat")
    private String alamat;

    @SerializedName("nomor_telp")
    private String nomor_telp;

    @SerializedName("kordinat")
    private String kordinat;

    @SerializedName("gambar_url")
    private String gambar_url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String  nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNomor_telp() {
        return nomor_telp;
    }

    public void setNomor_telp(String nomor_telp) {
        this.nomor_telp = nomor_telp;
    }

    public String getKordinat() {
        return kordinat;
    }

    public void setKordinat(String kordinat) {
        this.kordinat = kordinat;
    }

    public String getGambar_url() {
        return gambar_url;
    }

    public void setGambar_url(String gambar_url) {
        this.gambar_url = gambar_url;
    }


}