/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ChiTietHoaDonModel;
import model.HoaDonModel;
import model.KhachHangHoaDonModel;

/**
 *
 * @author Nong_Tien_Son
 */
public class ThongKeHoaDonController {

    public List<KhachHangHoaDonModel> thongKeKhachHangDaMua() {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<KhachHangHoaDonModel> listKhachHangDaMua = new ArrayList<>();
        KhachHangHoaDonModel khachHangHoaDonModel = null;

        try {
            String cauLenhTruyVan = "SELECT \n"
                    + "    HD.SDTKhachHang,\n"
                    + "    COUNT(DISTINCT HD.MaHoaDon) AS SoDonDaMua,\n"
                    + "    SUM(HDCT.TongTienCT) AS TongTienDaMua,\n"
                    + "    MAX(HD.NgayTao) AS NgayMuaGanNhat\n"
                    + "FROM \n"
                    + "    HoaDon HD\n"
                    + "INNER JOIN \n"
                    + "    HoaDonChiTiet HDCT ON HD.MaHoaDon = HDCT.MaHoaDon\n"
                    + "WHERE \n"
                    + "    HD.TrangThai = 1\n"
                    + "GROUP BY \n"
                    + "    HD.SDTKhachHang;";

            connection = DBConnection.DatabaseConnection.getConnection();

            statement = connection.prepareCall(cauLenhTruyVan);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                khachHangHoaDonModel = new KhachHangHoaDonModel();
                khachHangHoaDonModel.setSdtKhachHang(resultSet.getString("SDTKhachHang"));
                khachHangHoaDonModel.setSoDonDaMua(resultSet.getInt("SoDonDaMua"));
                khachHangHoaDonModel.setTongTienDaMua(resultSet.getLong("TongTienDaMua"));
                khachHangHoaDonModel.setNgayMuaGanNhat(resultSet.getDate("NgayMuaGanNhat"));
                listKhachHangDaMua.add(khachHangHoaDonModel);
            }
            return listKhachHangDaMua;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public List<KhachHangHoaDonModel> thongKeKhachHangDaMuaTheoSDTKH(String sdtKhachHang) {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<KhachHangHoaDonModel> listKhachHangDaMua = new ArrayList<>();
        KhachHangHoaDonModel khachHangHoaDonModel = null;

        try {
            String cauLenhTruyVan = "SELECT \n"
                    + "    HD.SDTKhachHang,\n"
                    + "    COUNT(DISTINCT HD.MaHoaDon) AS SoDonDaMua,\n"
                    + "    SUM(HDCT.TongTienCT) AS TongTienDaMua,\n"
                    + "    MAX(HD.NgayTao) AS NgayMuaGanNhat\n"
                    + "FROM \n"
                    + "    HoaDon HD\n"
                    + "INNER JOIN \n"
                    + "    HoaDonChiTiet HDCT ON HD.MaHoaDon = HDCT.MaHoaDon\n"
                    + "WHERE \n"
                    + "    HD.TrangThai = 1\n"
                    + "    AND HD.SDTKhachHang = ? \n"
                    + "GROUP BY \n"
                    + "    HD.SDTKhachHang;";

            connection = DBConnection.DatabaseConnection.getConnection();

            statement = connection.prepareCall(cauLenhTruyVan);
            statement.setString(1, sdtKhachHang);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                khachHangHoaDonModel = new KhachHangHoaDonModel();
                khachHangHoaDonModel.setSdtKhachHang(resultSet.getString("SDTKhachHang"));
                khachHangHoaDonModel.setSoDonDaMua(resultSet.getInt("SoDonDaMua"));
                khachHangHoaDonModel.setTongTienDaMua(resultSet.getLong("TongTienDaMua"));
                khachHangHoaDonModel.setNgayMuaGanNhat(resultSet.getDate("NgayMuaGanNhat"));
                listKhachHangDaMua.add(khachHangHoaDonModel);
            }
            return listKhachHangDaMua;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public List<HoaDonModel> thongHoaDonKhachHangDaMuaTheoSDTKH(String soDienThoai) {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<HoaDonModel> listHoaDonKhachHangDaMua = new ArrayList<>();
        HoaDonModel hoaDonModel = null;

        try {
            String cauLenhTruyVan = "SELECT * FROM HoaDon WHERE SDTKhachHang = ? ";
            connection = DBConnection.DatabaseConnection.getConnection();
            statement = connection.prepareCall(cauLenhTruyVan);
            statement.setString(1, soDienThoai);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                hoaDonModel = new HoaDonModel();
                hoaDonModel.setMaHoaDon(resultSet.getString("MaHoaDon"));
                hoaDonModel.setSoDienThoaiNV(resultSet.getString("SDTNhanVien"));
                hoaDonModel.setSoDienThoaiKH(resultSet.getString("SDTKhachHang"));
                hoaDonModel.setMaKhuyenMai(resultSet.getString("MaKhuyenMai"));
                hoaDonModel.setTongTien(resultSet.getInt("TongTien"));
                hoaDonModel.setNgayTao(resultSet.getDate("NgayTao"));
                hoaDonModel.setNgaySua(resultSet.getDate("NgaySua"));
                hoaDonModel.setTrangThai(resultSet.getBoolean("TrangThai"));
                hoaDonModel.setGhiChu(resultSet.getString("GhiChu"));
                listHoaDonKhachHangDaMua.add(hoaDonModel);
            }
            return listHoaDonKhachHangDaMua;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

    }

}
