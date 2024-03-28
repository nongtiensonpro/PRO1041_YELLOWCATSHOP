/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package javaswingdev.form;

import controller.ChiTietHoaDonController;
import controller.HoaDonController;
import controller.KhachHangController;
import controller.KhuyenMaiController;
import controller.PdfPrinter;
import controller.SanPhamController;
import static controller.PdfPrinter.createInvoicePdf;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import static javaswingdev.form.DangNhap.Ma_NhanVienstatic;
import static javaswingdev.main.MainTaoFrom.taiKhoanNhanVienControllerStatic;
import javax.swing.table.DefaultTableModel;
import model.ChiTietHoaDonModel;
import model.HoaDonModel;
import model.KhachHangModel;
import model.KhuyenMai;
import model.SanPhamModel;
import model.TaiKhoanNhanVIenFull;
import utilities.MsgBox;
import view_2.ThemKhachHang;

/**
 *
 * @author Nong_Tien_Son
 */
public class BanHang extends javax.swing.JPanel {

    private TaiKhoanNhanVIenFull tknvif = taiKhoanNhanVienControllerStatic.selectNhanVienFull(Ma_NhanVienstatic).get(0);
    DefaultTableModel defaultTableModel = new DefaultTableModel();

    KhachHangController khachHangController = new KhachHangController();
    SanPhamController sanPhamController = new SanPhamController();
    KhuyenMaiController khuyenMaiController = new KhuyenMaiController();
    HoaDonController hoaDonController = new HoaDonController();
    ChiTietHoaDonController hoaChiTietHoaDonController = new ChiTietHoaDonController();

    List<SanPhamModel> listSanPham = sanPhamController.getAllSanPhamChiTiet();
    List<HoaDonModel> listHoaDonTreo = hoaDonController.timKiemTatCaHoaTreo();
    List<KhachHangModel> listKhachHang = khachHangController.timKiemTatCaKhachHang();
    List<ChiTietHoaDonModel> listChiTietHoaDon = hoaChiTietHoaDonController.timtatCatChiTietHoaDon();
    List<ChiTietHoaDonModel> listHoaDonChiTietTheoMa = null;

    /**
     * Creates new form BanHang
     */
    public BanHang() {
        initComponents();
        hienThiBangSanPhamCuaHang();
        hienThiLenHoaDonTreo();
    }

    private void hienThiLenHoaDonTreo() {
        defaultTableModel = (DefaultTableModel) tblHoaDonTreo.getModel();
        defaultTableModel.setRowCount(0);

        for (HoaDonModel hoaDonModel : listHoaDonTreo) {
            defaultTableModel.addRow(new Object[]{
                hoaDonModel.getMaHoaDon(),
                hoaDonModel.getSoDienThoaiKH(),
                hoaDonModel.getTongTien()
            });
        }
    }

    private void hienThiTableDonHangChiTiet() {
        defaultTableModel = (DefaultTableModel) tblDonHangChiTiet.getModel();
        defaultTableModel.setRowCount(0);
        listHoaDonChiTietTheoMa = hoaChiTietHoaDonController.timtatCatChiTietHoaDonTheoMa(tblHoaDonTreo.getValueAt(tblHoaDonTreo.getSelectedRow(), 0).toString());
        int tongTien = 0;

        for (ChiTietHoaDonModel chiTietHoaDonModel : listHoaDonChiTietTheoMa) {
            defaultTableModel.addRow(new Object[]{
                chiTietHoaDonModel.getMaSanPhamChiTiet(),
                chiTietHoaDonModel.getTenSanPham(),
                chiTietHoaDonModel.getDonGia(),
                chiTietHoaDonModel.getSoLuong(),
                chiTietHoaDonModel.getTongTien()
            });
            tongTien += chiTietHoaDonModel.getTongTien();
            txtTongTienHoaDon.setText(String.valueOf(tongTien));
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        roundPanel1 = new javaswingdev.swing.RoundPanel();
        roundPanel2 = new javaswingdev.swing.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPhamCuaHang = new javaswingdev.swing.table.Table();
        roundPanel7 = new javaswingdev.swing.RoundPanel();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        roundPanel3 = new javaswingdev.swing.RoundPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDonHangChiTiet = new javaswingdev.swing.table.Table();
        roundPanel4 = new javaswingdev.swing.RoundPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMaHoaDon = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();
        txtSoDienThoaiKhachHang = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtSoDienThoaiNV = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTongTienHoaDon = new javax.swing.JTextField();
        txtSoTienKhachDua = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMaGiamGia = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        txtSoTienThua = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        txtSoTienConThieu = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        jButton9 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        txtGiaTriGiamGia = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtSoTienPhaiTra = new javax.swing.JTextField();
        jToggleButton2 = new javax.swing.JToggleButton();
        roundPanel5 = new javaswingdev.swing.RoundPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblHoaDonTreo = new javaswingdev.swing.table.Table();

        roundPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("SẢN PHẨM"));

        tblSanPhamCuaHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Giá bán", "Kho"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Byte.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblSanPhamCuaHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamCuaHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSanPhamCuaHang);

        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel7Layout = new javax.swing.GroupLayout(roundPanel7);
        roundPanel7.setLayout(roundPanel7Layout);
        roundPanel7Layout.setHorizontalGroup(
            roundPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel7Layout.createSequentialGroup()
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTimKiem)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        roundPanel7Layout.setVerticalGroup(
            roundPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(roundPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(roundPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(146, 146, 146))
        );

        roundPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("ĐƠN HÀNG"));

        tblDonHangChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Giá", "Số lượng", "Tổng tiền"
            }
        ));
        tblDonHangChiTiet.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tblDonHangChiTietAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tblDonHangChiTiet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDonHangChiTietMouseClicked(evt);
            }
        });
        tblDonHangChiTiet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblDonHangChiTietKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblDonHangChiTiet);

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                .addContainerGap())
        );

        roundPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Hóa đơn chi tiết"));

        jLabel1.setText("Mã hóa đơn ");

        txtMaHoaDon.setEnabled(false);

        jToggleButton1.setText("NEW");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("SDT khách hàng");

        txtSoDienThoaiKhachHang.setEnabled(false);

        jButton1.setText("Find");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("ADD");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setText("SDT nhân viên");

        txtSoDienThoaiNV.setEnabled(false);

        jLabel4.setText("Tổng tiền");

        txtTongTienHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongTienHoaDonActionPerformed(evt);
            }
        });

        txtSoTienKhachDua.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtSoTienKhachDuaPropertyChange(evt);
            }
        });

        jLabel5.setText("Số tiền khách đưa");

        jLabel6.setText("Mã giảm giá");

        txtMaGiamGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaGiamGiaActionPerformed(evt);
            }
        });

        jButton3.setText("FIND");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        txtSoTienThua.setText("Số tiền còn thiếu");

        jButton5.setText("Hủy");

        jButton6.setText("Thanh toán");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        txtSoTienConThieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoTienConThieuActionPerformed(evt);
            }
        });

        jLabel8.setText("Ghi chú");

        txtGhiChu.setColumns(20);
        txtGhiChu.setRows(5);
        jScrollPane4.setViewportView(txtGhiChu);

        jButton9.setText("Lưu");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton4.setText("Tính tiền");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel9.setText("Số tiền được giảm");

        jLabel7.setText("Số tiền phải trả");

        jToggleButton2.setText("Xóa ");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel4Layout = new javax.swing.GroupLayout(roundPanel4);
        roundPanel4.setLayout(roundPanel4Layout);
        roundPanel4Layout.setHorizontalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel4Layout.createSequentialGroup()
                        .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                            .addComponent(txtMaHoaDon)
                            .addComponent(txtSoDienThoaiKhachHang)
                            .addComponent(txtSoDienThoaiNV))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(roundPanel4Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2))
                            .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(roundPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGiaTriGiamGia)
                        .addGap(129, 129, 129))
                    .addGroup(roundPanel4Layout.createSequentialGroup()
                        .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(roundPanel4Layout.createSequentialGroup()
                                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jButton5)
                                        .addComponent(txtSoTienThua)))
                                .addGap(18, 18, 18)
                                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSoTienKhachDua)
                                    .addComponent(txtSoTienConThieu, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4))
                            .addGroup(roundPanel4Layout.createSequentialGroup()
                                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTongTienHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(roundPanel4Layout.createSequentialGroup()
                                        .addComponent(txtMaGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton3))))
                            .addGroup(roundPanel4Layout.createSequentialGroup()
                                .addGap(115, 115, 115)
                                .addComponent(jButton9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(roundPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(23, 23, 23)
                                .addComponent(txtSoTienPhaiTra, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 39, Short.MAX_VALUE))))
        );
        roundPanel4Layout.setVerticalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSoDienThoaiKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSoDienThoaiNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTongTienHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtMaGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtGiaTriGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtSoTienPhaiTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtSoTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoTienConThieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton9)
                    .addComponent(jButton6)
                    .addComponent(jToggleButton2))
                .addContainerGap())
        );

        roundPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Hóa đơn treo"));

        tblHoaDonTreo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "Số điện thoại KH", "Tổng tiền"
            }
        ));
        tblHoaDonTreo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonTreoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblHoaDonTreo);

        javax.swing.GroupLayout roundPanel5Layout = new javax.swing.GroupLayout(roundPanel5);
        roundPanel5.setLayout(roundPanel5Layout);
        roundPanel5Layout.setHorizontalGroup(
            roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        roundPanel5Layout.setVerticalGroup(
            roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(roundPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(roundPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(roundPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(roundPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(125, 125, 125))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblHoaDonTreoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonTreoMouseClicked
        hienThiHoaDonTreo();
    }//GEN-LAST:event_tblHoaDonTreoMouseClicked

    private void hienThiHoaDonTreo() {
        // TODO add your handling code here:
        int dongDuocChon = tblHoaDonTreo.getSelectedRow();

        if (dongDuocChon > -1) {
            HoaDonModel donModel = listHoaDonTreo.get(dongDuocChon);
            txtMaHoaDon.setText(donModel.getMaHoaDon());
            txtSoDienThoaiKhachHang.setText(donModel.getSoDienThoaiKH());
            txtSoDienThoaiNV.setText(donModel.getSoDienThoaiNV());
            txtGhiChu.setText(donModel.getGhiChu());
            txtMaGiamGia.setText(donModel.getMaKhuyenMai());
            txtTongTienHoaDon.setText(String.valueOf(donModel.getTongTien()));
            hienThiTableDonHangChiTiet();
            tinhTien();
        }
    }

    private void txtSoTienConThieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoTienConThieuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoTienConThieuActionPerformed

    private void txtMaGiamGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaGiamGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaGiamGiaActionPerformed

    private void txtTongTienHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongTienHoaDonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongTienHoaDonActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        try {
            Date currentTime = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("ssHHmmddMMyyyy");
            String formattedTime = formatter.format(currentTime);
            HoaDonModel hoaDonMoi = new HoaDonModel();
            hoaDonMoi.setMaHoaDon("HD" + formattedTime);
            hoaDonMoi.setSoDienThoaiKH(listKhachHang.get(0).getSoDienThoai());
            hoaDonMoi.setSoDienThoaiNV(tknvif.getSoDienThoai());
            java.time.LocalDate ngayHomNay = java.time.LocalDate.now();
            hoaDonMoi.setNgaySua(java.sql.Date.valueOf(ngayHomNay));
            hoaDonMoi.setNgayTao(java.sql.Date.valueOf(ngayHomNay));
            hoaDonMoi.setTrangThai(true);
            hoaDonController.themHoaDonMoi(hoaDonMoi);
            listHoaDonTreo = hoaDonController.timKiemTatCaHoaTreo();
            hienThiLenHoaDonTreo();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void tblDonHangChiTietKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblDonHangChiTietKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblDonHangChiTietKeyPressed

    private void tblDonHangChiTietMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDonHangChiTietMouseClicked
        // TODO add your handling code here:
        try {
            int indexSanPham = tblDonHangChiTiet.getSelectedRow();
            String hoaDonChiTietMuonSua = listChiTietHoaDon.get(indexSanPham).getMaHoaDonChiTiet();
            String maSanPhamMuonSua = (String) tblDonHangChiTiet.getValueAt(indexSanPham, 0);
            int soSanPhamMuonLay = 0;
//        valide

            int soLuongSanPhamDangLay = (int) tblDonHangChiTiet.getValueAt(indexSanPham, 3);
            System.out.println(soLuongSanPhamDangLay);
            try {
                soSanPhamMuonLay = Integer.parseInt(MsgBox.promt(this, "Mời bạn nhập số sản phẩm"));
            } catch (NumberFormatException numberFormatException) {
                MsgBox.alert(this, "Số sản phẩm bạn nhập không hợp lệ");
                return;
            }
            int soLuongSanPhamTrongKho = sanPhamController.timSanPhamChiTietChinhXac(maSanPhamMuonSua).getSoLuong();
            if (soLuongSanPhamTrongKho < soSanPhamMuonLay) {
                MsgBox.alert(this, "Sản phẩm trong kho không đủ hãy kiểm tra lại !");
                return;
            }
            //xoa hoadon chi tiet neu so luong bang 0
            if (soSanPhamMuonLay == 0) {
                boolean ketQua = hoaChiTietHoaDonController.xoaChiTietHoaDonTheoMa(hoaDonChiTietMuonSua);
                if (ketQua) {
                    hienThiHoaDonTreo();
                } else {
                    MsgBox.alert(this, "Đã xóa sản phẩm khỏi hóa đơn thất bại");
                }
            }
//        valide            
            // them hoac bot so luong trong hoa don chi tiet
            ChiTietHoaDonModel ch1 = new ChiTietHoaDonModel();
            ch1.setMaHoaDonChiTiet(hoaDonChiTietMuonSua);
            ch1.setSoLuong(soSanPhamMuonLay);
            hoaChiTietHoaDonController.ThemSLChiTietHoaDonTheoMa(ch1);
            hienThiHoaDonTreo();

            if (soSanPhamMuonLay > soLuongSanPhamDangLay) {
                SanPhamModel sp = new SanPhamModel();
                sp.setMa_SanPhamChiTiet(maSanPhamMuonSua);
                sp.setSoLuong(soLuongSanPhamTrongKho - (soSanPhamMuonLay - soLuongSanPhamDangLay));
                sanPhamController.truSoLuongSanPhamChiTiet(sp);
                hienThiBangSanPhamCuaHang();
            } else if (soSanPhamMuonLay < soLuongSanPhamDangLay) {
                SanPhamModel sp = new SanPhamModel();
                sp.setMa_SanPhamChiTiet(maSanPhamMuonSua);
                sp.setSoLuong(soLuongSanPhamTrongKho + (soLuongSanPhamDangLay - soSanPhamMuonLay));
                sanPhamController.truSoLuongSanPhamChiTiet(sp);
                hienThiBangSanPhamCuaHang();
            }

        } catch (Exception e) {

        }
    }//GEN-LAST:event_tblDonHangChiTietMouseClicked

    private void tblDonHangChiTietAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tblDonHangChiTietAncestorAdded
        // TODO add your handling code here:


    }//GEN-LAST:event_tblDonHangChiTietAncestorAdded

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        if (txtTimKiem.getText().trim().equals("")) {
            MsgBox.alert(this, "Bạn cần nhập mã hoặc tên sản phẩm cần tìm");
            listSanPham = sanPhamController.getAllSanPhamChiTiet();
            hienThiBangSanPhamCuaHang();
        } else {
            listSanPham = sanPhamController.timSanPhamChiTietGanDung(txtTimKiem.getText());
            hienThiBangSanPhamCuaHang();
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void tblSanPhamCuaHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamCuaHangMouseClicked
        // TODO add your handling code here:
        try {
            int indexSanPhamMuonThem = tblSanPhamCuaHang.getSelectedRow();

            if (txtMaHoaDon.getText().trim().equals("")) {
                MsgBox.alert(this, "Bạn cần phải tạo hóa đơn hoặc chọn hóa đơn trước khi thêm sản phẩm vào hóa đơn !");
                return;
            }
            try {
                int soLuong = Integer.parseInt(MsgBox.promt(this, "Mời nhập bạn nhập số lượng hàng"));

                if (soLuong > (int) tblSanPhamCuaHang.getValueAt(indexSanPhamMuonThem, 3)) {
                    MsgBox.alert(this, "Số lượng sản phẩm trong kho không đủ ! Cần kiểm tra lại");
                    return;
                }

                SanPhamModel sanPhamTru = new SanPhamModel();
                int soLuongSanPhamSauTru = (int) tblSanPhamCuaHang.getValueAt(indexSanPhamMuonThem, 3) - soLuong;
                System.out.println(soLuongSanPhamSauTru + "Soluong san pham con lai ne huhu");
                String maSanPhamTru = (String) tblSanPhamCuaHang.getValueAt(indexSanPhamMuonThem, 0);
                sanPhamTru.setSoLuong(soLuongSanPhamSauTru);
                sanPhamTru.setMa_SanPhamChiTiet(maSanPhamTru);
                if (sanPhamController.truSoLuongSanPhamChiTiet(sanPhamTru)) {
                    listSanPham = sanPhamController.getAllSanPhamChiTiet();
                    hienThiBangSanPhamCuaHang();
                    listChiTietHoaDon = hoaChiTietHoaDonController.timtatCatChiTietHoaDon();
                    int tongTien = soLuong * (int) tblSanPhamCuaHang.getValueAt(indexSanPhamMuonThem, 2);
                    System.out.println(tongTien);
                    Date currentTime = new Date();
                    SimpleDateFormat formatter = new SimpleDateFormat("ssHHmmddMMyyyy");
                    String formattedTime = formatter.format(currentTime);
                    ChiTietHoaDonModel chiTietHoaDonModel = new ChiTietHoaDonModel(
                            "HD" + formattedTime,
                            txtMaHoaDon.getText(),
                            (String) tblSanPhamCuaHang.getValueAt(indexSanPhamMuonThem, 0),
                            (String) tblSanPhamCuaHang.getValueAt(indexSanPhamMuonThem, 1),
                            soLuong,
                            (int) tblSanPhamCuaHang.getValueAt(indexSanPhamMuonThem, 2),
                            tongTien);

                    boolean ketQua = hoaChiTietHoaDonController.themHoaDonChiTiet(chiTietHoaDonModel);
                    if (ketQua) {

                        hienThiHoaDonTreo();
                        tinhTien();
                    } else {
                        MsgBox.alert(this, "Đã có lỗi khi thêm sản phẩm");
                    }
                } else {
                    MsgBox.alert(this, "Đã có lỗi xảy ra");
                    return;
                }

            } catch (NumberFormatException numberFormatException) {
                MsgBox.alert(this, "Bạn cần nhập số lượng là số");
            }
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Bạn cần tạo hóa đơn trước khi thêm sản phẩm vào");
        }
    }//GEN-LAST:event_tblSanPhamCuaHangMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String soDienThoaiKH = MsgBox.promt(this, "Mời bạn nhập số điện thoại khách hàng");

        try {
            KhachHangModel khachHangModel = khachHangController.timKiemKhachHangTheoSDT(soDienThoaiKH).get(0);
            txtSoDienThoaiKhachHang.setText(khachHangModel.getSoDienThoai());
        } catch (Exception e) {
            MsgBox.alert(this, "Không tìm thấy khách hàng");
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtSoTienKhachDuaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtSoTienKhachDuaPropertyChange
        // TODO add your handling code here:

    }//GEN-LAST:event_txtSoTienKhachDuaPropertyChange

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:

        if (txtSoTienPhaiTra.getText().trim().equals("")) {
        } else {
            int soTienThua = 0;
            try {
                int tongTienPhaiTra = Integer.parseInt(txtSoTienPhaiTra.getText());
                int soTienKhachDua = Integer.parseInt(txtSoTienKhachDua.getText());
                soTienThua = soTienKhachDua - tongTienPhaiTra;
                txtSoTienConThieu.setText(String.valueOf(soTienThua));
                System.out.println(soTienThua);
            } catch (NumberFormatException numberFormatException) {
                MsgBox.alert(this, "Bạn cần nhập số tiền khách hàng đưa !");
            }
            if (soTienThua >= 0) {
                txtSoTienThua.setText("Tiền trả cho khách");
            } else {
                txtSoTienThua.setText("Tiền khách thiếu");
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        if (true) {
            int ketQua = hoaDonController.capNhatHoaDonTreo(layGiaTriHoaDon());
            if (ketQua > 0) {
                MsgBox.alert(this, "Cập nhật hóa đơn" + layGiaTriHoaDon().getMaHoaDon() + " thành công");
                listHoaDonTreo = hoaDonController.timKiemTatCaHoaTreo();
                hienThiLenHoaDonTreo();
            } else {
                MsgBox.alert(this, "Cập nhật hóa đơn" + layGiaTriHoaDon().getMaHoaDon() + " thất bại có thể vì hóa đơn không tồn tại");
            }
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        tinhTien();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tinhTien() {
        // TODO add your handling code here:
        try {
            KhuyenMai maKhuyenMai = khuyenMaiController.timKiemKhuyenMaitheoMaTrangThai(txtMaGiamGia.getText()).get(0);
            int tongTien = Integer.parseInt(txtTongTienHoaDon.getText());
            int soTienDuocGiam = tinhToanGiamGia(tongTien, maKhuyenMai.getGiaTri());
            txtGiaTriGiamGia.setText(String.valueOf(soTienDuocGiam));
            txtSoTienPhaiTra.setText(String.valueOf(tongTien - soTienDuocGiam));
        } catch (Exception e) {
            txtSoTienPhaiTra.setText(String.valueOf(txtTongTienHoaDon.getText()));
            txtMaGiamGia.setText("");
            txtGiaTriGiamGia.setText("0");
//            MsgBox.alert(this, "Không tìm thấy mã khuyến mãi !");
        }
    }

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        boolean luaChon = MsgBox.confirm(this, "Xác nhận thanh toán hóa đơn");
        if (luaChon) {
                             hoaDonController.capNhatHoaDonTreo(layGiaTriHoaDon());
            boolean ketQua = hoaDonController.capNhatHoaDonThanhToanHoaDon(layGiaTriHoaDon());
            if (ketQua) {
                HoaDonModel donModel = layGiaTriHoaDon();
                listHoaDonChiTietTheoMa = hoaChiTietHoaDonController.timtatCatChiTietHoaDonTheoMa(tblHoaDonTreo.getValueAt(tblHoaDonTreo.getSelectedRow(), 0).toString());
                int soTienGiam;
                if (txtGiaTriGiamGia.getText().trim().equals("0") == true) {
                    soTienGiam = 0;
                } else {
                    soTienGiam = Integer.parseInt(txtGiaTriGiamGia.getText());
                }
                boolean luaChonIn = MsgBox.confirm(this, "Bạn có muốn in hoa đơn");
                if (luaChonIn) {
                    createInvoicePdf(listHoaDonChiTietTheoMa, donModel, soTienGiam);
                }
                MsgBox.alert(this, "Thanh toán và lưu hóa đơn thành công !");
                listHoaDonTreo = hoaDonController.timKiemTatCaHoaTreo();
                hienThiLenHoaDonTreo();
                txtMaHoaDon.setText("");
                txtSoDienThoaiNV.setText("");
                txtSoDienThoaiKhachHang.setText("");
                txtGhiChu.setText("");
                txtTongTienHoaDon.setText("");
                txtMaGiamGia.setText("");
                txtSoTienPhaiTra.setText("");
                txtSoTienKhachDua.setText("");
                txtSoTienConThieu.setText("");

            } else {
                MsgBox.alert(this, "Thanh toán và lưu hóa đơn thất bại !");
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        ThemKhachHang themKhachHang = new ThemKhachHang();
        themKhachHang.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        // TODO add your handling code here:
        boolean luaChon = MsgBox.confirm(this, "Bạn có chắc chắn muốn xóa hóa đơn");
        if (luaChon) {
            String maHoaDonMuonXoa = txtMaHoaDon.getText();

            hoaChiTietHoaDonController.xoaChiTietHoaDonTheoMaGoc(maHoaDonMuonXoa);
            hoaDonController.xoaHoaDonTheoMaGoc(maHoaDonMuonXoa);
            listHoaDonTreo = hoaDonController.timKiemTatCaHoaTreo();
            listHoaDonChiTietTheoMa = null;
            hienThiLenHoaDonTreo();
            hienThiTableDonHangChiTiet();
        }
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void lamMoiTextField() {
        tblHoaDonTreo.changeSelection(0, 0, true, true);
        hienThiTableDonHangChiTiet();
    }

    private HoaDonModel layGiaTriHoaDon() {
        HoaDonModel hoaDonModel = new HoaDonModel();
        hoaDonModel.setMaHoaDon(txtMaHoaDon.getText());
        hoaDonModel.setSoDienThoaiKH(txtSoDienThoaiKhachHang.getText());
        hoaDonModel.setSoDienThoaiNV(txtSoDienThoaiNV.getText());
        hoaDonModel.setMaKhuyenMai(txtMaGiamGia.getText());
        hoaDonModel.setTongTien(Integer.parseInt(txtSoTienPhaiTra.getText()));
        hoaDonModel.setGhiChu(txtGhiChu.getText());
        LocalDateTime.now();
        java.time.LocalDate ngayTao = java.time.LocalDate.now();
        hoaDonModel.setNgayTao(java.sql.Date.valueOf(ngayTao));
        System.out.println(txtSoTienPhaiTra.getText() + "Tong tien ne");
        return hoaDonModel;
    }

    private void hienThiBangSanPhamCuaHang() {
        defaultTableModel = (DefaultTableModel) tblSanPhamCuaHang.getModel();
        defaultTableModel.setRowCount(0);
        listSanPham = sanPhamController.getAllSanPhamChiTiet();
        for (SanPhamModel sanPhamModel : listSanPham) {
            defaultTableModel.addRow(new Object[]{
                sanPhamModel.getMa_SanPhamChiTiet(),
                sanPhamModel.getTen(),
                sanPhamModel.getGiaBan(),
                sanPhamModel.getSoLuong()
            });
        }
    }

    public static int tinhToanGiamGia(int tongTien, int giaTriMaGiamGia) {

        if (giaTriMaGiamGia > 1 && giaTriMaGiamGia <= 100) {
            return tongTien * (giaTriMaGiamGia / 100);
        }
        return giaTriMaGiamGia;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javaswingdev.swing.RoundPanel roundPanel1;
    private javaswingdev.swing.RoundPanel roundPanel2;
    private javaswingdev.swing.RoundPanel roundPanel3;
    private javaswingdev.swing.RoundPanel roundPanel4;
    private javaswingdev.swing.RoundPanel roundPanel5;
    private javaswingdev.swing.RoundPanel roundPanel7;
    private javaswingdev.swing.table.Table tblDonHangChiTiet;
    private javaswingdev.swing.table.Table tblHoaDonTreo;
    private javaswingdev.swing.table.Table tblSanPhamCuaHang;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtGiaTriGiamGia;
    private javax.swing.JTextField txtMaGiamGia;
    private javax.swing.JTextField txtMaHoaDon;
    private javax.swing.JTextField txtSoDienThoaiKhachHang;
    private javax.swing.JTextField txtSoDienThoaiNV;
    private javax.swing.JTextField txtSoTienConThieu;
    private javax.swing.JTextField txtSoTienKhachDua;
    private javax.swing.JTextField txtSoTienPhaiTra;
    private javax.swing.JLabel txtSoTienThua;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTongTienHoaDon;
    // End of variables declaration//GEN-END:variables
}
