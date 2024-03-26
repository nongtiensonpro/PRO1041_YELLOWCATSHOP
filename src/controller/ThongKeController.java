/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DBConnection.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ThongKeSanPhamModel;

/**
 *
 * @author Khanh
 */
public class ThongKeController {

    public List<ThongKeSanPhamModel> timkiemThongKeTheoSanPham() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ThongKeSanPhamModel hang = null;

        List<ThongKeSanPhamModel> danhsachHang = new ArrayList<>();
        try {
            connection = DatabaseConnection.getConnection();
            String caulenhtruyvan = new String("SELECT ChiTietSanPham.Ten,HoaDonChiTiet.SoLuong,HoaDonChiTiet.DonGia, SUM(HoaDonChiTiet.TongTienCT) AS TotalSales\n"
                    + "FROM HoaDonChiTiet\n"
                    + "JOIN ChiTietSanPham ON HoaDonChiTiet.MaSanPhamChiTiet = ChiTietSanPham.Ma_SanPhamChiTiet\n"
                    + "GROUP BY ChiTietSanPham.Ten,HoaDonChiTiet.SoLuong,HoaDonChiTiet.DonGia");
            statement = connection.prepareStatement(caulenhtruyvan);

            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                hang = new ThongKeSanPhamModel();
                hang.setTenSanPham(resultSet.getString("Ten"));
                hang.setSoLuong(resultSet.getInt("SoLuong"));
                hang.setDonGia(resultSet.getInt("DonGia"));
                hang.setDoanhThu(resultSet.getInt("TotalSales"));

                danhsachHang.add(hang);
            }
            return danhsachHang;
        } catch (Exception e) {
            e.printStackTrace();
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
        return null;
    }

    public List<ThongKeSanPhamModel> timkiemThongKeKhachHangthangnam(String nam, String thang) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ThongKeSanPhamModel hang = null;

        List<ThongKeSanPhamModel> danhsachHang = new ArrayList<>();
        try {
            connection = DatabaseConnection.getConnection();
            String caulenhtruyvan = new String(" SELECT COUNT(DISTINCT SDTKhachHang) as SoLuong \n"
                    + "                    FROM HoaDon where YEAR(HoaDon.NgayTao) = ?  and\n"
                    + "                        MONTH(HoaDon.NgayTao) = ?");
            statement = connection.prepareStatement(caulenhtruyvan);
            statement.setString(1, nam);
            statement.setString(2, thang);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                hang = new ThongKeSanPhamModel();

                hang.setDoanhThu(resultSet.getInt("SoLuong"));

                danhsachHang.add(hang);
            }
            return danhsachHang;
        } catch (Exception e) {
            e.printStackTrace();
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
        return null;
    }

    public List<ThongKeSanPhamModel> timkiemThongKeKhachHangnam(String nam) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ThongKeSanPhamModel hang = null;

        List<ThongKeSanPhamModel> danhsachHang = new ArrayList<>();
        try {
            connection = DatabaseConnection.getConnection();
            String caulenhtruyvan = new String(" SELECT COUNT(DISTINCT SDTKhachHang) as SoLuong \n"
                    + "                    FROM HoaDon where YEAR(HoaDon.NgayTao) = ? ");
            statement = connection.prepareStatement(caulenhtruyvan);
            statement.setString(1, nam);

            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                hang = new ThongKeSanPhamModel();

                hang.setDoanhThu(resultSet.getInt("SoLuong"));

                danhsachHang.add(hang);
            }
            return danhsachHang;
        } catch (Exception e) {
            e.printStackTrace();
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
        return null;
    }

    public List<ThongKeSanPhamModel> timkiemThongKeKhachHang() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ThongKeSanPhamModel hang = null;

        List<ThongKeSanPhamModel> danhsachHang = new ArrayList<>();
        try {
            connection = DatabaseConnection.getConnection();
            String caulenhtruyvan = new String(" SELECT COUNT(DISTINCT SDTKhachHang) as SoLuong\n"
                    + "FROM HoaDon");
            statement = connection.prepareStatement(caulenhtruyvan);

            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                hang = new ThongKeSanPhamModel();

                hang.setDoanhThu(resultSet.getInt("SoLuong"));

                danhsachHang.add(hang);
            }
            return danhsachHang;
        } catch (Exception e) {
            e.printStackTrace();
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
        return null;
    }

    public List<ThongKeSanPhamModel> timkiemThongKeTheoNam(String nam) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ThongKeSanPhamModel hang = null;

        List<ThongKeSanPhamModel> danhsachHang = new ArrayList<>();
        try {
            connection = DatabaseConnection.getConnection();
            String caulenhtruyvan = new String("	SELECT \n"
                    + "    YEAR(HoaDon.NgayTao) AS Nam,\n"
                    + "    ChiTietSanPham.Ten,\n"
                    + "    SUM(HoaDonChiTiet.SoLuong) AS TongSoLuong,\n"
                    + "	HoaDonChiTiet.DonGia,\n"
                    + "    SUM(HoaDonChiTiet.DonGia) AS TongDoanhThu\n"
                    + "	\n"
                    + "FROM \n"
                    + "    HoaDonChiTiet\n"
                    + "JOIN \n"
                    + "    ChiTietSanPham ON HoaDonChiTiet.MaSanPhamChiTiet = ChiTietSanPham.Ma_SanPhamChiTiet\n"
                    + "JOIN \n"
                    + "    HoaDon ON HoaDon.MaHoaDon = HoaDonChiTiet.MaHoaDon\n"
                    + "WHERE \n"
                    + "    YEAR(HoaDon.NgayTao) = ?\n"
                    + "GROUP BY \n"
                    + "    YEAR(HoaDon.NgayTao), \n"
                    + "    MONTH(HoaDon.NgayTao), \n"
                    + "    ChiTietSanPham.Ten,\n"
                    + "	HoaDonChiTiet.DonGia\n"
                    + "ORDER BY \n"
                    + "    Nam ASC");
            statement = connection.prepareStatement(caulenhtruyvan);
            statement.setString(1, nam);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                hang = new ThongKeSanPhamModel();
                hang.setTenSanPham(nam);
                hang.setTenSanPham(resultSet.getString("Ten"));
                hang.setSoLuong(resultSet.getInt("TongSoLuong"));
                hang.setDonGia(resultSet.getInt("DonGia"));
                hang.setDoanhThu(resultSet.getInt("TongDoanhThu"));

                danhsachHang.add(hang);
            }
            return danhsachHang;
        } catch (Exception e) {
            e.printStackTrace();
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
        return null;
    }

    public List<ThongKeSanPhamModel> timkiemThongKeTheoThang(String nam, String thang) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ThongKeSanPhamModel hang = null;

        List<ThongKeSanPhamModel> danhsachHang = new ArrayList<>();
        try {
            connection = DatabaseConnection.getConnection();
            String caulenhtruyvan = new String("SELECT \n"
                    + "    YEAR(HoaDon.NgayTao) AS Nam,\n"
                    + "    MONTH(HoaDon.NgayTao) AS Thang,\n"
                    + "    ChiTietSanPham.Ten,\n"
                    + "	HoaDonChiTiet.DonGia,\n"
                    + "    SUM(HoaDonChiTiet.SoLuong) AS TongSoLuong,\n"
                    + "    SUM(HoaDonChiTiet.DonGia) AS TongDoanhThu\n"
                    + "FROM \n"
                    + "    HoaDonChiTiet\n"
                    + "JOIN \n"
                    + "    ChiTietSanPham ON HoaDonChiTiet.MaSanPhamChiTiet = ChiTietSanPham.Ma_SanPhamChiTiet\n"
                    + "JOIN \n"
                    + "    HoaDon ON HoaDon.MaHoaDon = HoaDonChiTiet.MaHoaDon\n"
                    + "WHERE \n"
                    + "    YEAR(HoaDon.NgayTao) = ?\n"
                    + "    AND MONTH(HoaDon.NgayTao) = ?\n"
                    + "GROUP BY \n"
                    + "    YEAR(HoaDon.NgayTao), \n"
                    + "    MONTH(HoaDon.NgayTao), \n"
                    + "    ChiTietSanPham.Ten,\n"
                    + "	HoaDonChiTiet.DonGia\n"
                    + "ORDER BY \n"
                    + "    Nam ASC, \n"
                    + "    Thang ASC;");
            statement = connection.prepareStatement(caulenhtruyvan);
            statement.setString(1, nam);
            statement.setString(2, thang);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                hang = new ThongKeSanPhamModel();

                hang.setTenSanPham(resultSet.getString("Ten"));
                hang.setSoLuong(resultSet.getInt("TongSoLuong"));
                hang.setDonGia(resultSet.getInt("DonGia"));
                hang.setDoanhThu(resultSet.getInt("TongDoanhThu"));

                danhsachHang.add(hang);
            }
            return danhsachHang;
        } catch (Exception e) {
            e.printStackTrace();
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
        return null;
    }

    public List<ThongKeSanPhamModel> timkiemThongKeTheoTeSP(String ten) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ThongKeSanPhamModel hang = null;

        List<ThongKeSanPhamModel> danhsachHang = new ArrayList<>();
        try {
            connection = DatabaseConnection.getConnection();
            String caulenhtruyvan = new String("	SELECT \n"
                    + "    \n"
                    + "    ChiTietSanPham.Ten,\n"
                    + "	HoaDonChiTiet.DonGia,\n"
                    + "    SUM(HoaDonChiTiet.SoLuong) AS TongSoLuong,\n"
                    + "    SUM(HoaDonChiTiet.DonGia) AS TongDoanhThu\n"
                    + "FROM \n"
                    + "    HoaDonChiTiet\n"
                    + "JOIN \n"
                    + "    ChiTietSanPham ON HoaDonChiTiet.MaSanPhamChiTiet = ChiTietSanPham.Ma_SanPhamChiTiet\n"
                    + "JOIN \n"
                    + "    HoaDon ON HoaDon.MaHoaDon = HoaDonChiTiet.MaHoaDon\n"
                    + "WHERE \n"
                    + "    ChiTietSanPham.Ten = 'Giay luoi'\n"
                    + "GROUP BY \n"
                    + "    \n"
                    + "    ChiTietSanPham.Ten,\n"
                    + "	HoaDonChiTiet.DonGia");
            statement = connection.prepareStatement(caulenhtruyvan);
            statement.setString(1, ten);

            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                hang = new ThongKeSanPhamModel();

                hang.setTenSanPham(resultSet.getString("Ten"));
                hang.setSoLuong(resultSet.getInt("TongSoLuong"));
                hang.setDonGia(resultSet.getInt("DonGia"));
                hang.setDoanhThu(resultSet.getInt("TongDoanhThu"));

                danhsachHang.add(hang);
            }
            return danhsachHang;
        } catch (Exception e) {
            e.printStackTrace();
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
        return null;
    }
}
