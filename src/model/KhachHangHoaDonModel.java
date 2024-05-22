/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Nong_Tien_Son
 */
public class KhachHangHoaDonModel {
    private String sdtKhachHang;
    private int soDonDaMua;
    private long tongTienDaMua;
    private Date ngayMuaGanNhat;
    private Date ngayMuaLanDau;

    public KhachHangHoaDonModel() {
    }

    public KhachHangHoaDonModel(String sdtKhachHang, int soDonDaMua, long tongTienDaMua, Date ngayMuaGanNhat, Date ngayMuaLanDau) {
        this.sdtKhachHang = sdtKhachHang;
        this.soDonDaMua = soDonDaMua;
        this.tongTienDaMua = tongTienDaMua;
        this.ngayMuaGanNhat = ngayMuaGanNhat;
        this.ngayMuaLanDau = ngayMuaLanDau;
    }

    public String getSdtKhachHang() {
        return sdtKhachHang;
    }

    public void setSdtKhachHang(String sdtKhachHang) {
        this.sdtKhachHang = sdtKhachHang;
    }

    public int getSoDonDaMua() {
        return soDonDaMua;
    }

    public void setSoDonDaMua(int soDonDaMua) {
        this.soDonDaMua = soDonDaMua;
    }

    public long getTongTienDaMua() {
        return tongTienDaMua;
    }

    public void setTongTienDaMua(long tongTienDaMua) {
        this.tongTienDaMua = tongTienDaMua;
    }

    public Date getNgayMuaGanNhat() {
        return ngayMuaGanNhat;
    }

    public void setNgayMuaGanNhat(Date ngayMuaGanNhat) {
        this.ngayMuaGanNhat = ngayMuaGanNhat;
    }

    public Date getNgayMuaLanDau() {
        return ngayMuaLanDau;
    }

    public void setNgayMuaLanDau(Date ngayMuaLanDau) {
        this.ngayMuaLanDau = ngayMuaLanDau;
    }

    

    
    
}
