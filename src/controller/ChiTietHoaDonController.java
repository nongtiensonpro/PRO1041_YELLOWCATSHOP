/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DBConnection.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.ChiTietHoaDonModel;

/**
 *
 * @author Nong_Tien_Son
 */
public class ChiTietHoaDonController {

    public boolean themHoaDonChiTiet(ChiTietHoaDonModel chiTietHoaDon) {
        ChiTietHoaDonModel chiTietHoaDonModel = new ChiTietHoaDonModel();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {

            String cauLenhTruyThem = "INSERT INTO HoaDonChiTiet (MaHoaDonChiTiet,MaHoaDon,MaSanPhamChiTiet ,TenSanPham ,SoLuong ,DonGia,TongTienCT)VALUES"
                    + "(?,?,?,?,?,?,?)";
            connection = DatabaseConnection.getConnection();
            statement = connection.prepareCall(cauLenhTruyThem);

            statement.setString(1, chiTietHoaDon.getMaHoaDonChiTiet());
            statement.setString(2, chiTietHoaDon.getMaHoaDon());
            statement.setString(3, chiTietHoaDon.getMaSanPhamChiTiet());
            statement.setString(4, chiTietHoaDon.getTenSanPham());
            statement.setInt(5, chiTietHoaDon.getSoLuong());
            statement.setInt(6, chiTietHoaDon.getDonGia());
            statement.setInt(7, chiTietHoaDon.getTongTien());
            statement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
        }
    }

    public List<ChiTietHoaDonModel> timtatCatChiTietHoaDon() {
        List<ChiTietHoaDonModel> listChiTietHoaDon = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            String cauLenhTruyVan = "SELECT * FROM HoaDonChiTiet";
            connection = DatabaseConnection.getConnection();
            statement = connection.prepareCall(cauLenhTruyVan);
            resultSet = statement.executeQuery();
            ChiTietHoaDonModel model = null;
            while (resultSet.next()) {
                model = new ChiTietHoaDonModel();
                model.setMaHoaDon(resultSet.getString("MaHoaDon"));
                model.setMaHoaDonChiTiet(resultSet.getString("MaHoaDonChiTiet"));
                model.setMaSanPhamChiTiet(resultSet.getString("MaSanPhamChiTiet"));
                model.setSoLuong(resultSet.getInt("SoLuong"));
                model.setDonGia(resultSet.getInt("DonGia"));
                model.setTongTien(resultSet.getInt("TongTienCT"));
                listChiTietHoaDon.add(model);
            }
            return listChiTietHoaDon;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
        }
    }

    public List<ChiTietHoaDonModel> timtatCatChiTietHoaDonTheoMa(String maHoaDon) {
        List<ChiTietHoaDonModel> listChiTietHoaDon = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            String cauLenhTruyVan = "SELECT * FROM HoaDon INNER JOIN HoaDonChiTiet "
                    + "ON HoaDon.MaHoaDon = HoaDonChiTiet.MaHoaDon WHERE HoaDonChiTiet.MaHoaDon = ?";
            connection = DatabaseConnection.getConnection();
            statement = connection.prepareCall(cauLenhTruyVan);
            statement.setString(1, maHoaDon);
            resultSet = statement.executeQuery();
            ChiTietHoaDonModel model = null;
            while (resultSet.next()) {
                model = new ChiTietHoaDonModel();
                model.setMaHoaDon(resultSet.getString("MaHoaDon"));
                model.setTenSanPham(resultSet.getString("TenSanPham"));
                model.setMaHoaDonChiTiet(resultSet.getString("MaHoaDonChiTiet"));
                model.setMaSanPhamChiTiet(resultSet.getString("MaSanPhamChiTiet"));
                model.setSoLuong(resultSet.getInt("SoLuong"));
                model.setDonGia(resultSet.getInt("DonGia"));
                model.setTongTien(resultSet.getInt("TongTienCT"));
                listChiTietHoaDon.add(model);
            }
            return listChiTietHoaDon;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
        }
    }

    public boolean xoaChiTietHoaDonTheoMa(String maHoaDon) {
        System.out.println(maHoaDon);
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            String cauLenhTruyVan = "DELETE FROM [dbo].[HoaDonChiTiet]\n" + "WHERE MaHoaDonChiTiet = ?";
            connection = DatabaseConnection.getConnection();
            statement = connection.prepareStatement(cauLenhTruyVan);
            statement.setString(1, maHoaDon);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Số hàng đã bị xóa: " + rowsAffected);
                return true;
            } else {
                System.out.println("Không có hàng nào được xóa.");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public boolean xoaChiTietHoaDonTheoMaGoc(String maHoaDon) {
        System.out.println(maHoaDon);
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            String cauLenhTruyVan = "DELETE FROM [dbo].[HoaDonChiTiet]\n" + "WHERE MaHoaDon = ?";
            connection = DatabaseConnection.getConnection();
            statement = connection.prepareStatement(cauLenhTruyVan);
            statement.setString(1, maHoaDon);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
//                System.out.println("Số hàng đã bị xóa: " + rowsAffected);
                return true;
            } else {
//                System.out.println("Không có hàng nào được xóa.");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public boolean ThemSLChiTietHoaDonTheoMa(ChiTietHoaDonModel sp) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            String cauLenhTruyVan = "UPDATE [dbo].[HoaDonChiTiet]\n"
                    + "   SET  SoLuong = ? ,"
                    + "    TongTienCT = ? \n"
                    + " WHERE MaHoaDonChiTiet = ?";
            connection = DatabaseConnection.getConnection();
            statement = connection.prepareStatement(cauLenhTruyVan);
            statement.setInt(1, sp.getSoLuong());
            statement.setInt(2, sp.getTongTien());
//            System.out.println(sp.getTongTien()+"MEOMEOMEOMEO");
            statement.setString(3, sp.getMaHoaDonChiTiet());
            statement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
