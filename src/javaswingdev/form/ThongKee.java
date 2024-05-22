/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package javaswingdev.form;

import controller.ExcelExporter;
import controller.ThongKeController;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.ThongKeSanPhamModel;
import utilities.MsgBox;

/**
 *
 * @author Khanh
 */
public class ThongKee extends javax.swing.JPanel {

    ThongKeController thongKeController = new ThongKeController();
    List<ThongKeSanPhamModel> listSP = thongKeController.timkiemThongKeTheoSanPham();

    /**
     * Creates new form ThongKee
     */
    public ThongKee() {
        initComponents();
//        loadHangHoa();
        loadTop3();
        rdoTatca.setSelected(true);
        cboThang.setVisible(false);
        thongKeTatCa();
    }
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private void loadtimkiem(String nam) {
        List<ThongKeSanPhamModel> listSP = thongKeController.timkiemThongKeTheoNam(nam);

        DefaultTableModel dtm = (DefaultTableModel) tblHangHoa.getModel();
        dtm.setRowCount(0);
        long tong = 0;
        txtSoHoaDon.setText(thongKeController.TongHoaDonTheoNam(nam));
        try {
            txtTongKhachHang.setText(String.valueOf(thongKeController.timkiemThongKeKhachHangnam(nam).get(0).getDoanhThu()));
        } catch (Exception e) {
            txtTongKhachHang.setText("0");
        }
        for (ThongKeSanPhamModel thongKeSanPhamModel : listSP) {
            dtm.addRow(new Object[]{
                thongKeSanPhamModel.getTenSanPham(),
                thongKeSanPhamModel.getSoLuong(),
                thongKeSanPhamModel.getDonGia(),
                thongKeSanPhamModel.getDoanhThu()
            });
            tong += thongKeSanPhamModel.getDoanhThu();
        }
        txtDoanhThu.setText(String.valueOf(tong));
    }

    private void loadtimkiemthang(String nam, String thang) {
        List<ThongKeSanPhamModel> listSP = thongKeController.timkiemThongKeTheoThang(nam, thang);

        DefaultTableModel dtm = (DefaultTableModel) tblHangHoa.getModel();
        dtm.setRowCount(0);
        long tong = 0;
        txtSoHoaDon.setText(thongKeController.TongHoaDonTheoThangNam(nam, thang));
        try {
            txtTongKhachHang.setText(String.valueOf(thongKeController.timkiemThongKeKhachHangthangnam(nam, thang).get(0).getDoanhThu()));
        } catch (Exception e) {
            txtTongKhachHang.setText("0");
        }
        for (ThongKeSanPhamModel thongKeSanPhamModel : listSP) {
            dtm.addRow(new Object[]{
                thongKeSanPhamModel.getTenSanPham(),
                thongKeSanPhamModel.getSoLuong(),
                thongKeSanPhamModel.getDonGia(),
                thongKeSanPhamModel.getDoanhThu()
            });
            tong += thongKeSanPhamModel.getDoanhThu();
        }
        txtDoanhThu.setText(String.valueOf(tong));
    }

    private void loadTop3() {
        listSP = thongKeController.timkiemTop3SanPham();
        DefaultTableModel dtm = (DefaultTableModel) tblTop3.getModel();
        dtm.setRowCount(0);
        long tong = 0;
        txtSoHoaDon.setText(thongKeController.TongHoaDon());
        txtTongKhachHang.setText(String.valueOf(thongKeController.timkiemThongKeKhachHang().get(0).getDoanhThu()));
        for (ThongKeSanPhamModel thongKeSanPhamModel : listSP) {
            dtm.addRow(new Object[]{
                thongKeSanPhamModel.getTenSanPham(),
                thongKeSanPhamModel.getSoLuong(),
                thongKeSanPhamModel.getDonGia(),
                thongKeSanPhamModel.getDoanhThu()
            });
            tong += thongKeSanPhamModel.getDoanhThu();
        }
        txtDoanhThu.setText(String.valueOf(tong));
    }
private void Loc(){
        Date ngayBD = txtNBD.getDate();
        Date ngayKT = txtNKT.getDate();
        listSP = thongKeController.Loc(simpleDateFormat.format(ngayBD), simpleDateFormat.format(ngayKT));

     DefaultTableModel dtm = (DefaultTableModel) tblHangHoa.getModel();
     dtm.setRowCount(0);
        long tong = 0;
     txtSoHoaDon.setText(thongKeController.LocHD(simpleDateFormat.format(ngayBD), simpleDateFormat.format(ngayKT)));
     txtTongKhachHang.setText(thongKeController.LocKH(simpleDateFormat.format(ngayBD), simpleDateFormat.format(ngayKT)));
//        txtTongKhachHang.setText(String.valueOf(thongKeController.timkiemThongKeKhachHang().get(0).getDoanhThu()));
        for (ThongKeSanPhamModel thongKeSanPhamModel : listSP) {
            dtm.addRow(new Object[]{
                thongKeSanPhamModel.getTenSanPham(),
                thongKeSanPhamModel.getSoLuong(),
                thongKeSanPhamModel.getDonGia(),
                thongKeSanPhamModel.getDoanhThu()
            });
            tong += thongKeSanPhamModel.getDoanhThu();
        }
        txtDoanhThu.setText(String.valueOf(tong));
}
    private void loadHangHoa() {
//        listSP = thongKeController.timkiemThongKeTheoSanPham();
        DefaultTableModel dtm = (DefaultTableModel) tblHangHoa.getModel();
        dtm.setRowCount(0);
        long tong = 0;
        txtSoHoaDon.setText(thongKeController.TongHoaDon());
        txtTongKhachHang.setText(String.valueOf(thongKeController.timkiemThongKeKhachHang().get(0).getDoanhThu()));
        for (ThongKeSanPhamModel thongKeSanPhamModel : listSP) {
            dtm.addRow(new Object[]{
                thongKeSanPhamModel.getTenSanPham(),
                thongKeSanPhamModel.getSoLuong(),
                thongKeSanPhamModel.getDonGia(),
                thongKeSanPhamModel.getDoanhThu()
            });
            tong += thongKeSanPhamModel.getDoanhThu();
        }
        txtDoanhThu.setText(String.valueOf(tong));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtDoanhThu = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtSoHoaDon = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtTongKhachHang = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        rdoTatca = new javax.swing.JRadioButton();
        rdoTheothang = new javax.swing.JRadioButton();
        rdoTheonam = new javax.swing.JRadioButton();
        cboThang = new javax.swing.JComboBox<>();
        txtNam = new javax.swing.JTextField();
        txtTimKiem = new javax.swing.JTextField();
        btnTimkiem = new javax.swing.JButton();
        btnLammoiThongke = new javax.swing.JButton();
        txtNBD = new com.toedter.calendar.JDateChooser();
        txtNKT = new com.toedter.calendar.JDateChooser();
        btnLoc = new javax.swing.JButton();
        btnxuatXcelThongke = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblHangHoa = new javaswingdev.swing.table.Table();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTop3 = new javaswingdev.swing.table.Table();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Doanh Thu");

        txtDoanhThu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(txtDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Số Hóa Đơn");

        txtSoHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(99, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Tổng Khách Hàng");

        txtTongKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTongKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTongKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        buttonGroup1.add(rdoTatca);
        rdoTatca.setText("Tất cả");
        rdoTatca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoTatcaMouseClicked(evt);
            }
        });
        rdoTatca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoTatcaActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoTheothang);
        rdoTheothang.setText("Theo tháng");
        rdoTheothang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoTheothangMouseClicked(evt);
            }
        });
        rdoTheothang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoTheothangActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoTheonam);
        rdoTheonam.setText("Theo năm");
        rdoTheonam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoTheonamMouseClicked(evt);
            }
        });
        rdoTheonam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoTheonamActionPerformed(evt);
            }
        });

        cboThang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", " " }));
        cboThang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboThangMouseClicked(evt);
            }
        });
        cboThang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboThangActionPerformed(evt);
            }
        });
        cboThang.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cboThangPropertyChange(evt);
            }
        });

        txtNam.setText("2024");
        txtNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamActionPerformed(evt);
            }
        });

        btnTimkiem.setText("Tìm kiếm");
        btnTimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimkiemActionPerformed(evt);
            }
        });

        btnLammoiThongke.setText("Làm mới");
        btnLammoiThongke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLammoiThongkeActionPerformed(evt);
            }
        });

        btnLoc.setText("Lọc");
        btnLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocActionPerformed(evt);
            }
        });

        btnxuatXcelThongke.setText("Xuất Excel");
        btnxuatXcelThongke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxuatXcelThongkeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTimkiem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLammoiThongke)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnxuatXcelThongke)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLoc)
                        .addGap(60, 60, 60))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(rdoTheonam, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel8Layout.createSequentialGroup()
                                    .addComponent(rdoTheothang)
                                    .addGap(102, 102, 102)))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(rdoTatca)
                                .addGap(131, 131, 131)))
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNam, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNBD, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                            .addComponent(txtNKT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(184, 184, 184))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(rdoTatca)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdoTheothang)
                            .addComponent(cboThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(txtNBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdoTheonam)
                        .addComponent(txtNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTimkiem)
                        .addComponent(btnLammoiThongke)
                        .addComponent(btnxuatXcelThongke))
                    .addComponent(btnLoc))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        tblHangHoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Sản Phẩm", "Số lượng", "Đơn Giá", "Doanh Thu"
            }
        ));
        jScrollPane4.setViewportView(tblHangHoa);

        jTabbedPane2.addTab("Chi tiết", jScrollPane4);

        tblTop3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tên", "Số Lượng", "Đơn gia", "Doanh thu"
            }
        ));
        jScrollPane1.setViewportView(tblTop3);

        jTabbedPane2.addTab(" Top 3 SP bán nhiều nhất", jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 51, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rdoTatcaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoTatcaMouseClicked
        // TODO add your handling code here:
        //        loadHangHoa();
        cboThang.setVisible(false);
    }//GEN-LAST:event_rdoTatcaMouseClicked

    private void rdoTatcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoTatcaActionPerformed
        thongKeTatCa();
    }//GEN-LAST:event_rdoTatcaActionPerformed

    private void thongKeTatCa() {
        // TODO add your handling code here:
        listSP = thongKeController.timkiemThongKeTheoSanPham();
        cboThang.setVisible(false);
        loadHangHoa();
    }

    private void rdoTheothangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoTheothangMouseClicked
        // TODO add your handling code here:

        cboThang.setVisible(true);
        String nam = txtNam.getText();
        String thang = cboThang.getSelectedItem().toString();
        loadtimkiemthang(nam, thang);
        System.out.println(nam + "123");
        System.out.println(thang);
    }//GEN-LAST:event_rdoTheothangMouseClicked

    private void rdoTheothangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoTheothangActionPerformed

    }//GEN-LAST:event_rdoTheothangActionPerformed

    private void rdoTheonamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoTheonamMouseClicked

    }//GEN-LAST:event_rdoTheonamMouseClicked

    private void rdoTheonamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoTheonamActionPerformed
        // TODO add your handling code here:
        cboThang.setVisible(false);
        String nam = txtNam.getText();
        loadtimkiem(nam);
    }//GEN-LAST:event_rdoTheonamActionPerformed

    private void cboThangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboThangMouseClicked
        // TODO add your handling code here:
        cboThang.setVisible(true);
        String nam = txtNam.getText();
        String thang = cboThang.getSelectedItem().toString();
        loadtimkiemthang(nam, thang);
        System.out.println(nam + "123");
        System.out.println(thang);
    }//GEN-LAST:event_cboThangMouseClicked

    private void cboThangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboThangActionPerformed
        // TODO add your handling code here:
        cboThang.setVisible(true);
        String nam = txtNam.getText();
        String thang = cboThang.getSelectedItem().toString();
        loadtimkiemthang(nam, thang);
        System.out.println(nam + "123");
        System.out.println(thang);

    }//GEN-LAST:event_cboThangActionPerformed

    private void cboThangPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cboThangPropertyChange

    }//GEN-LAST:event_cboThangPropertyChange

    private void txtNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamActionPerformed

    private void btnTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimkiemActionPerformed
        // TODO add your handling code here:
        if (txtTimKiem.getText().trim().equals("")) {
            MsgBox.alert(this, "Mời nhap tên SP");
        } else {
            listSP = thongKeController.timkiemThongKeTheoTenSP(txtTimKiem.getText());
            loadHangHoa();
        }
    }//GEN-LAST:event_btnTimkiemActionPerformed

    private void btnxuatXcelThongkeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxuatXcelThongkeActionPerformed
        // TODO add your handling code here:
        ExcelExporter.xuatFileExcelThongKe(listSP);
    }//GEN-LAST:event_btnxuatXcelThongkeActionPerformed

    private void btnLammoiThongkeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLammoiThongkeActionPerformed
        // TODO add your handling code here:
        txtTimKiem.setText("");
        listSP = thongKeController.timkiemThongKeTheoSanPham();
        loadHangHoa();
    }//GEN-LAST:event_btnLammoiThongkeActionPerformed

    private void btnLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocActionPerformed
        // TODO add your handling code here:
        Date ngayBD = txtNBD.getDate();
        Date ngayKT = txtNKT.getDate();
//        txtSoHoaDon.setText(thongKeController.LocHD(ngayBD, ngayKT));
        listSP = thongKeController.Loc(simpleDateFormat.format(ngayBD), simpleDateFormat.format(ngayKT));
        Loc();
    }//GEN-LAST:event_btnLocActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLammoiThongke;
    private javax.swing.JButton btnLoc;
    private javax.swing.JButton btnTimkiem;
    private javax.swing.JButton btnxuatXcelThongke;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboThang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JRadioButton rdoTatca;
    private javax.swing.JRadioButton rdoTheonam;
    private javax.swing.JRadioButton rdoTheothang;
    private javaswingdev.swing.table.Table tblHangHoa;
    private javaswingdev.swing.table.Table tblTop3;
    private javax.swing.JLabel txtDoanhThu;
    private com.toedter.calendar.JDateChooser txtNBD;
    private com.toedter.calendar.JDateChooser txtNKT;
    private javax.swing.JTextField txtNam;
    private javax.swing.JLabel txtSoHoaDon;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JLabel txtTongKhachHang;
    // End of variables declaration//GEN-END:variables
}
