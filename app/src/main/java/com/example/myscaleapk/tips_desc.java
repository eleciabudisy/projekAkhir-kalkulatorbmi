package com.example.myscaleapk;

public class tips_desc {

    private  String nama;
    private  String desc;
    private  int id_gambar;

    public tips_desc(String nama, String desc, int id_gambar) {
        this.nama = nama;
        this.desc = desc;
        this.id_gambar = id_gambar;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getId_gambar() {
        return id_gambar;
    }

    public void setId_gambar(int id_gambar) {
        this.id_gambar = id_gambar;
    }
}
