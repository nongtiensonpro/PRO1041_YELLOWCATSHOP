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

    public String TongHoaDonTheoThangNam(String nam, String thang) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DatabaseConnection.getConnection();
            String caulenhtruyvan = new String(" select count (HoaDon.MaHoaDon) from HoaDon where YEAR(HoaDon.NgayTao) = '" + nam + "' and  MONTH(HoaDon.NgayTao) = '" + thang + "' and (HoaDon.TrangThai) = '1' ");
            statement = connection.prepareStatement(caulenhtruyvan);

            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String tong = resultSet.getString(1);
                return tong;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public String TongHoaDonTheoNam(String nam) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DatabaseConnection.getConnection();
            String caulenhtruyvan = new String(" select count (HoaDon.MaHoaDon) from HoaDon where YEAR(HoaDon.NgayTao) =  '" + nam + "' and (HoaDon.TrangThai) = '1' ");
            statement = connection.prepareStatement(caulenhtruyvan);

            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String tong = resultSet.getString(1);
                return tong;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public String TongHoaDon() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DatabaseConnection.getConnection();
            String caulenhtruyvan = new String(" select count (HoaDon.MaHoaDon) from HoaDon where (HoaDon.TrangThai) = '1' ");
            statement = connection.prepareStatement(caulenhtruyvan);

            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String tong = resultSet.getString(1);
                return tong;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public List<ThongKeSanPhamModel> timkiemTop3SanPham() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ThongKeSanPhamModel hang = null;

        List<ThongKeSanPhamModel> danhsachHang = new ArrayList<>();
        try {
            connection = DatabaseConnection.getConnection();
            String caulenhtruyvan = new String("	SELECT top 3\n"
                    + "                        \n"
                    + "                       ChiTietSanPham.Ten,\n"
                    + "                        SUM(HoaDonChiTiet.SoLuong) AS TongSoLuong,\n"
                    + "                    	HoaDonChiTiet.DonGia,\n"
                    + "                        SUM(HoaDonChiTiet.SoLuong)*HoaDonChiTiet.DonGia AS TongDoanhThu\n"
                    + "					--	count(HoaDon.MaHoaDon)\n"
                    + "                    \n"
                    + "                    FROM \n"
                    + "                        HoaDonChiTiet\n"
                    + "                     JOIN \n"
                    + "                        ChiTietSanPham ON HoaDonChiTiet.MaSanPhamChiTiet = ChiTietSanPham.Ma_SanPhamChiTiet\n"
                    + "                    JOIN \n"
                    + "                        HoaDon ON HoaDon.MaHoaDon = HoaDonChiTiet.MaHoaDon  \n"
                    + "                    where HoaDon.TrangThai = 1 \n"
                    + "                    GROUP BY \n"
                    + "               --  HoaDon.MaHoaDon,\n"
                    + "                        ChiTietSanPham.Ten,\n"
                    + "                    	HoaDonChiTiet.DonGia\n"
                    + "						 order by SUM(HoaDonChiTiet.SoLuong) desc ");
            statement = connection.prepareStatement(caulenhtruyvan);

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

    public List<ThongKeSanPhamModel> timkiemThongKeTheoSanPham() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ThongKeSanPhamModel hang = null;

        List<ThongKeSanPhamModel> danhsachHang = new ArrayList<>();
        try {
            connection = DatabaseConnection.getConnection();
            String caulenhtruyvan = new String("	SELECT \n"
                    + "                        \n"
                    + "                       ChiTietSanPham.Ten,\n"
                    + "                        SUM(HoaDonChiTiet.SoLuong) AS TongSoLuong,\n"
                    + "                    	HoaDonChiTiet.DonGia,\n"
                    + "                        SUM(HoaDonChiTiet.SoLuong)*HoaDonChiTiet.DonGia AS TongDoanhThu\n"
                    + "                    \n"
                    + "                    FROM \n"
                    + "                        HoaDonChiTiet\n"
                    + "                     JOIN \n"
                    + "                        ChiTietSanPham ON HoaDonChiTiet.MaSanPhamChiTiet = ChiTietSanPham.Ma_SanPhamChiTiet\n"
                    + "                    JOIN \n"
                    + "                        HoaDon ON HoaDon.MaHoaDon = HoaDonChiTiet.MaHoaDon\n"
                    + "                    where HoaDon.TrangThai = 1  \n"
                    + "                    GROUP BY \n"
                    + "                 \n"
                    + "                        ChiTietSanPham.Ten,\n"
                    + "                    	HoaDonChiTiet.DonGia");
            statement = connection.prepareStatement(caulenhtruyvan);

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

    public List<ThongKeSanPhamModel> timkiemThongKeKhachHangthangnam(String nam, String thang) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ThongKeSanPhamModel hang = null;

        List<ThongKeSanPhamModel> danhsachHang = new ArrayList<>();
        try {
            connection = DatabaseConnection.getConnection();
            String caulenhtruyvan = new String(" SELECT COUNT(DISTINCT SDTKhachHang) as SoLuong \n"
                    + "                    FROM HoaDon where YEAR(HoaDon.NgayTao) = ? and Month(HoaDon.NgayTao) = ?  and HoaDon.TrangThai = 1 ");
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
                    + "                    FROM HoaDon where YEAR(HoaDon.NgayTao) = ? and HoaDon.TrangThai = 1 ");
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
            String caulenhtruyvan = new String(" SELECT COUNT(DISTINCT SDTKhachHang) as SoLuong\n" +
"                     FROM HoaDon \n" +
"					 where HoaDon.TrangThai = 1");
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
            String caulenhtruyvan = new String("		SELECT \n"
                    + "                        YEAR(HoaDon.NgayTao) AS Nam,\n"
                    + "                       ChiTietSanPham.Ten,\n"
                    + "                        SUM(HoaDonChiTiet.SoLuong) AS TongSoLuong,\n"
                    + "                    	HoaDonChiTiet.DonGia,\n"
                    + "                        SUM(HoaDonChiTiet.SoLuong)*HoaDonChiTiet.DonGia AS TongDoanhThu\n"
                    + "                    \n"
                    + "                    FROM \n"
                    + "                        HoaDonChiTiet\n"
                    + "                     JOIN \n"
                    + "                        ChiTietSanPham ON HoaDonChiTiet.MaSanPhamChiTiet = ChiTietSanPham.Ma_SanPhamChiTiet\n"
                    + "                    JOIN \n"
                    + "                        HoaDon ON HoaDon.MaHoaDon = HoaDonChiTiet.MaHoaDon\n"
                    + "                    WHERE \n"
                    + "                        YEAR(HoaDon.NgayTao) = ? and HoaDon.TrangThai = 1 \n"
                    + "                    GROUP BY \n"
                    + "                        YEAR(HoaDon.NgayTao), \n"
                    + "                        ChiTietSanPham.Ten,\n"
                    + "                    	HoaDonChiTiet.DonGia\n"
                    + "                    ORDER BY \n"
                    + "                        Nam ASC");
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
                    + "    SUM(HoaDonChiTiet.SoLuong)*(HoaDonChiTiet.DonGia) AS TongDoanhThu\n"
                    + "FROM \n"
                    + "    HoaDonChiTiet\n"
                    + "JOIN \n"
                    + "    ChiTietSanPham ON HoaDonChiTiet.MaSanPhamChiTiet = ChiTietSanPham.Ma_SanPhamChiTiet\n"
                    + "JOIN \n"
                    + "    HoaDon ON HoaDon.MaHoaDon = HoaDonChiTiet.MaHoaDon\n"
                    + "WHERE \n"
                    + "    YEAR(HoaDon.NgayTao) = ?\n"
                    + "    AND MONTH(HoaDon.NgayTao) = ? AND HoaDon.TrangThai = 1 \n"
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

    public List<ThongKeSanPhamModel> timkiemThongKeTheoTenSP(String ten) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ThongKeSanPhamModel hang = null;

        List<ThongKeSanPhamModel> danhsachHang = new ArrayList<>();
        try {
            connection = DatabaseConnection.getConnection();
             String caulenhtruyvan = new String("	SELECT \n" +
"                   \n" +
"                        ChiTietSanPham.Ten,\n" +
"                    HoaDonChiTiet.DonGia,\n" +
"                      SUM(HoaDonChiTiet.SoLuong) AS TongSoLuong,\n" +
"                        SUM(HoaDonChiTiet.SoLuong)*HoaDonChiTiet.DonGia AS TongDoanhThu\n" +
"                    FROM \n" +
"                        HoaDonChiTiet\n" +
"                    JOIN \n" +
"                        ChiTietSanPham ON HoaDonChiTiet.MaSanPhamChiTiet = ChiTietSanPham.Ma_SanPhamChiTiet\n" +
"                    JOIN \n" +
"                        HoaDon ON HoaDon.MaHoaDon = HoaDonChiTiet.MaHoaDon\n" +
"                    WHERE \n" +
"                        ChiTietSanPham.Ten like '%"+ten+"%' and  HoaDon.TrangThai = 1 \n"  +
"                    GROUP BY \n" +
"                      \n" +
"                        ChiTietSanPham.Ten,\n" +
"                    	HoaDonChiTiet.DonGia");
            statement = connection.prepareStatement(caulenhtruyvan);
//            statement.setString(1, ten);

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
    
     public List<ThongKeSanPhamModel> Loc(String ngayBD, String ngayKT) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ThongKeSanPhamModel hang = null;

        List<ThongKeSanPhamModel> danhsachHang = new ArrayList<>();
        try {
            connection = DatabaseConnection.getConnection();
            String caulenhtruyvan = new String("		SELECT \n"
                    + "    YEAR(HoaDon.NgayTao) AS Nam,\n"
                    + "    MONTH(HoaDon.NgayTao) AS Thang,\n"
                    + "    ChiTietSanPham.Ten,\n"
                    + "	HoaDonChiTiet.DonGia,\n"
                    + "    SUM(HoaDonChiTiet.SoLuong) AS TongSoLuong,\n"
                    + "    SUM(HoaDonChiTiet.SoLuong) * HoaDonChiTiet.DonGia AS TongDoanhThu\n"
                    + "FROM \n"
                    + "    HoaDonChiTiet\n"
                    + "JOIN \n"
                    + "    ChiTietSanPham ON HoaDonChiTiet.MaSanPhamChiTiet = ChiTietSanPham.Ma_SanPhamChiTiet\n"
                    + "JOIN \n"
                    + "    HoaDon ON HoaDon.MaHoaDon = HoaDonChiTiet.MaHoaDon\n"
                    + "WHERE \n"
                    + "      (HoaDon.NgayTao) >=  '"+ngayBD+"' and (HoaDon.NgayTao) <=  '"+ngayKT+"'\n"
                    + "GROUP BY \n"
                    + "    YEAR(HoaDon.NgayTao), \n"
                    + "    MONTH(HoaDon.NgayTao), \n"
                    + "    ChiTietSanPham.Ten,\n"
                            + "	HoaDonChiTiet.DonGia\n"
                    + "ORDER BY \n"
                    + "    Nam ASC");
            statement = connection.prepareStatement(caulenhtruyvan);
//            statement.setString(1, ngayBD);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                hang = new ThongKeSanPhamModel();
//                hang.setTenSanPham(nam);
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
     
     public String LocHD(String ngayBD, String ngayKT) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DatabaseConnection.getConnection();
            String caulenhtruyvan = new String(" select count (*) from HoaDon where (HoaDon.NgayTao) >= '" + ngayBD + "' and  (HoaDon.NgayTao) <= '" + ngayKT + "' and (HoaDon.TrangThai) = '1' ");
            statement = connection.prepareStatement(caulenhtruyvan);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String tong = resultSet.getString(1);
                return tong;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    public String LocKH(String ngayBD, String ngayKT) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DatabaseConnection.getConnection();
            String caulenhtruyvan = new String("select   count (distinct HoaDon.SDTKhachHang) from HoaDon\n" +
"					where (HoaDon.NgayTao) >= '"+ngayBD+"' and (HoaDon.NgayTao) <= '"+ngayKT+"' and (HoaDon.TrangThai) = 1 ");
            statement = connection.prepareStatement(caulenhtruyvan);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String tong = resultSet.getString(1);
                return tong;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
