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
import model.SizeModel;

/**
 *
 * @author LENHATLINH
 */
public class SizeController {

    public List<SizeModel> timkiemSize() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        SizeModel s = null;

        List<SizeModel> danhsachTenSize = new ArrayList<>();
        try {
            connection = DatabaseConnection.getConnection();
            String caulenhtruyvan = new String("select * from Size");
            statement = connection.prepareStatement(caulenhtruyvan);

            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                s = new SizeModel();
                s.setMaSize(resultSet.getString("MaSize"));
                s.setSoSize(resultSet.getInt("SoSize"));
                s.setMoTa(resultSet.getString("MoTa"));
                danhsachTenSize.add(s);
            }
            return danhsachTenSize;
        } catch (Exception e) {
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

    public Boolean themTenSize(SizeModel sanPhamtruyenvao) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnection.getConnection();
            String caulenhthem = new String("INSERT INTO [dbo].[Size]\n"
                    + "           ([MaSize]\n"
                    + "           ,[SoSize]\n"
                    + "           ,[MoTa])\n"
                    + "     VALUES\n"
                    + "           (?,\n"
                    + "           ?,\n"
                    + "           ?)");
            statement = connection.prepareStatement(caulenhthem);
            statement.setString(1, sanPhamtruyenvao.getMaSize());
            statement.setInt(2, sanPhamtruyenvao.getSoSize());
            statement.setString(3, sanPhamtruyenvao.getMoTa());
            statement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
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

    public Boolean suaTenSize(SizeModel sModel) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnection.getConnection();
            String caulenhUpdate = new String("UPDATE [dbo].[Size]\n"
                    + "   SET \n"
                    + "      [SoSize]=?\n"
                    + "      ,[MoTa]=?\n"
                    + "      WHERE [MaSize] = ?"
            );
            statement = connection.prepareStatement(caulenhUpdate);
            statement.setString(3, sModel.getMaSize());
            statement.setInt(1, sModel.getSoSize());
            statement.setString(2, sModel.getMoTa());
            statement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
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

    public List<SizeModel> timKiemSizeTheoMaSize(String masize) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        SizeModel sizeModel = null;
        List<SizeModel> listSize = new ArrayList<>();

        try {
            connection = DatabaseConnection.getConnection();

            String cauLenhTimKiem = "SELECT * FROM Size WHERE MaSize = ?";
            statement = connection.prepareStatement(cauLenhTimKiem);
            statement.setString(1, masize);

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                sizeModel = new SizeModel();
                sizeModel.setMaSize(resultSet.getString("MaSize"));
                sizeModel.setSoSize(resultSet.getInt("SoSize"));
                sizeModel.setMoTa(resultSet.getString("MoTa"));
                listSize.add(sizeModel);
            }
            return listSize;
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

        return listSize;
    }
    public List<SizeModel> timSizeGanDung(String masize) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<SizeModel> danhSachSize = new ArrayList<>();

        try {
            connection = DatabaseConnection.getConnection();
            String cauLenhTimKiemSQL = "SELECT * FROM [dbo].[Size] WHERE [MaSize] LIKE ? OR SoSize Like ?";
            statement = connection.prepareStatement(cauLenhTimKiemSQL);
            statement.setString(1, "%" + masize + "%");
            statement.setString(2, "%" + masize + "%");
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                SizeModel sizeNew = new SizeModel();
                sizeNew.setMaSize(resultSet.getString("MaSize"));
                sizeNew.setSoSize(resultSet.getInt("SoSize"));
                sizeNew.setMoTa(resultSet.getString("MoTa"));
                danhSachSize.add(sizeNew);
            }
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

        return danhSachSize;
    }
    public boolean ChecktrungMa(String ma) {

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DatabaseConnection.getConnection();

            String cauLenhThem = "SELECT MaSize, COUNT(*)\n"
                    + "FROM Size\n"
                    + "GROUP BY Ma\n"
                    + "HAVING COUNT(*) > 1; ";
            statement = connection.prepareStatement(cauLenhThem);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }
}
