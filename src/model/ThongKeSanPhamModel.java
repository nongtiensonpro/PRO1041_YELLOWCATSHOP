/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Khanh
 */
public class ThongKeSanPhamModel {
     private String tenSanPham;
     private int soLuong;
     private int donGia;
    private int doanhThu;

    public ThongKeSanPhamModel() {
    }

    public ThongKeSanPhamModel(String tenSanPham, int soLuong, int donGia, int doanhThu) {
        this.tenSanPham = tenSanPham;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.doanhThu = doanhThu;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(int doanhThu) {
        this.doanhThu = doanhThu;
    }

   

   
}
