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
import model.ChatLieuModel;
import model.ChatLieuModel;

/**
 *
 * @author LENHATLINH
 */
public class ChatLieuController {

    public List<ChatLieuModel> timkiemChatLieu() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ChatLieuModel cl = null;

        List<ChatLieuModel> danhsachChatLieu = new ArrayList<>();
        try {
            connection = DatabaseConnection.getConnection();
            String caulenhtruyvan = new String("select * from ChatLieu");
            statement = connection.prepareStatement(caulenhtruyvan);

            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                cl = new ChatLieuModel();
                cl.setMaChatLieu(resultSet.getString("MaChatLieu"));
                cl.setTen(resultSet.getString("Ten"));
                cl.setMoTa(resultSet.getString("MoTa"));
                cl.setNgayTao(resultSet.getDate("NgayTao"));
                cl.setNgaySua(resultSet.getDate("NgaySua"));
                cl.setTrangThai(resultSet.getBoolean("TrangThai"));
                danhsachChatLieu.add(cl);
            }
            return danhsachChatLieu;
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

    public Boolean themChatLieu(ChatLieuModel chatLieutruyenvao) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnection.getConnection();
            String caulenhthem = new String("INSERT INTO [dbo].[ChatLieu]\n"
                    + "           ([MaChatLieu]\n"
                    + "           ,[Ten]\n"
                    + "           ,[MoTa]\n"
                    + "           ,[NgayTao]\n"
                    + "           ,[NgaySua]\n"
                    + "           ,[TrangThai])\n"
                    + "     VALUES\n"
                    + "           (?,\n"
                    + "           ?,\n"
                    + "           ?,\n"
                    + "           ?,\n"
                    + "           ?,\n"
                    + "           ?)");
            statement = connection.prepareStatement(caulenhthem);
            statement.setString(1, chatLieutruyenvao.getMaChatLieu());
            statement.setString(2, chatLieutruyenvao.getTen());
            statement.setString(3, chatLieutruyenvao.getMoTa());
            statement.setDate(4, chatLieutruyenvao.getNgayTao());
            statement.setDate(5, chatLieutruyenvao.getNgaySua());
            statement.setBoolean(6, chatLieutruyenvao.getTrangThai());
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

    public Boolean suaTenChatLieu(ChatLieuModel clModel) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnection.getConnection();
            String caulenhUpdate = new String("UPDATE [dbo].[ChatLieu]\n"
                    + "   SET \n"
                    + "      [Ten]=?\n"
                    + "      ,[MoTa]=?\n"
                    + "      ,[NgayTao]=?\n"
                    + "      ,[NgaySua]=?\n"
                    + "      ,[TrangThai]=?\n"
                    + "      WHERE[MaChatLieu] =?"
            );
            statement = connection.prepareStatement(caulenhUpdate);
            statement.setString(6, clModel.getMaChatLieu());
            statement.setString(1, clModel.getTen());
            statement.setString(2, clModel.getMoTa());
            statement.setDate(3, clModel.getNgayTao());
            statement.setDate(4, clModel.getNgaySua());
            statement.setBoolean(5, clModel.getTrangThai());
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

   public List<ChatLieuModel> timKiemChatLieuTheoMa(String machatlieu) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ChatLieuModel chatLieuNew = null;
        List<ChatLieuModel> listChatLieu = new ArrayList<>();

        try {
            connection = DatabaseConnection.getConnection();

            String cauLenhTimKiem = "SELECT * FROM ChatLieu WHERE MaChatLieu = ?";
            statement = connection.prepareStatement(cauLenhTimKiem);
            statement.setString(1, machatlieu);

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                chatLieuNew = new ChatLieuModel();
                chatLieuNew.setMaChatLieu(resultSet.getString("MaChatLieu"));
                chatLieuNew.setTen(resultSet.getString("Ten"));
                chatLieuNew.setMoTa(resultSet.getString("MoTa"));
                chatLieuNew.setNgayTao(resultSet.getDate("NgayTao"));
                chatLieuNew.setNgaySua(resultSet.getDate("NgaySua"));
                chatLieuNew.setTrangThai(resultSet.getBoolean("TrangThai"));
                listChatLieu.add(chatLieuNew);
            }
            return listChatLieu;
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

        return listChatLieu;
    }
    public List<ChatLieuModel> timChatLieuGanDung(String chatLieu) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<ChatLieuModel> danhSachSize = new ArrayList<>();

        try {
            connection = DatabaseConnection.getConnection();
            String cauLenhTimKiemSQL = "SELECT * FROM [dbo].[ChatLieu] WHERE [MaChatLieu] LIKE ? OR Ten Like ?";
            statement = connection.prepareStatement(cauLenhTimKiemSQL);
            statement.setString(1, "%" + chatLieu + "%");
            statement.setString(2, "%" + chatLieu + "%");
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ChatLieuModel chatLieuNew = new ChatLieuModel();
                chatLieuNew.setMaChatLieu(resultSet.getString("MaChatLieu"));
                chatLieuNew.setTen(resultSet.getString("Ten"));
                chatLieuNew.setMoTa(resultSet.getString("MoTa"));
                chatLieuNew.setNgayTao(resultSet.getDate("NgayTao"));
                chatLieuNew.setNgaySua(resultSet.getDate("NgaySua"));
                chatLieuNew.setTrangThai(resultSet.getBoolean("TrangThai"));
                danhSachSize.add(chatLieuNew);
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

            String cauLenhThem = "SELECT MaChatLieu, COUNT(*)\n"
                    + "FROM ChatLieu\n"
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
