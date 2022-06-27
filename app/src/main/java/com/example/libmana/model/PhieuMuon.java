package com.example.libmana.model;

import java.util.Date;

public class PhieuMuon {
    public int maPM;
    public String maTT;
    public int maTV;
    public int maSach;
    public Date ngay;
    public int tienThue;
    public int traSach;
    public String khuyenMai;

    public PhieuMuon() {
    }

//    public PhieuMuon(int maPM, String maTT, int maTV, int maSach, Date ngay, int tienThue, int traSach) {
//        this.maPM = maPM;
//        this.maTT = maTT;
//        this.maTV = maTV;
//        this.maSach = maSach;
//        this.ngay = ngay;
//        this.tienThue = tienThue;
//        this.traSach = traSach;
//    }


    public PhieuMuon(int maPM, String maTT, int maTV, int maSach, Date ngay, int tienThue, int traSach, String khuyenMai) {
        this.maPM = maPM;
        this.maTT = maTT;
        this.maTV = maTV;
        this.maSach = maSach;
        this.ngay = ngay;
        this.tienThue = tienThue;
        this.traSach = traSach;
        this.khuyenMai = khuyenMai;
    }
}
