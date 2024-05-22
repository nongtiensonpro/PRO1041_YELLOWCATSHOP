/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view_2;

import controller.NhaSanXuatController;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.NhaSanXuatModel;
import utilities.MsgBox;

/**
 *
 * @author Khanh
 */
public class NSXView2 extends javax.swing.JPanel {

    NhaSanXuatController nsxController = new NhaSanXuatController();
    List<NhaSanXuatModel> danhSachNSX = nsxController.timkiemNSX();
    public static NhaSanXuatModel nsxStatic = new NhaSanXuatModel();
    public NSXView2() {
        initComponents();
        hienThiNSX();
        hienThiNgayTao();
    }
    
    private void hienThiNgayTao(){
        java.time.LocalDate ngaySuaLocalDate = java.time.LocalDate.now();
//        txtNgaytao.setDate(java.sql.Date.valueOf(ngaySuaLocalDate));
        txtNgaysua.setDate(java.sql.Date.valueOf(ngaySuaLocalDate));
    }
private void hienThiNSX(){
    DefaultTableModel dtm = (DefaultTableModel) tblNSX.getModel();
        dtm.setRowCount(0);
        for (NhaSanXuatModel mauSacModel : danhSachNSX) {
            dtm.addRow(new Object[]{
                mauSacModel.getMaNSX(),
                mauSacModel.getTenNSX(),
                mauSacModel.getNgayTao(),
                mauSacModel.getNgaySua(),
                mauSacModel.getMoTa(),
                mauSacModel.isTrangThai()? "Hoạt động" : "Không hoạt động",
                    mauSacModel.getQuocGia()
            });
        }
}

private void lammoiForm(){
       txtMaNSX.setText("");
       txtTenNSX.setText("");
       txtMota.setText("");
       txtQuocgia.setText("");
    }
public Boolean kiemTraTrong(){
        
        if (txtMaNSX.getText().trim().equals("")) {
            MsgBox.alert(this, "Bạn chưa nhập mã NSX!");
            return false;
        }
//        if (txtNgayTao.getDate().toString().equals("")) {
//            MsgBox.alert(this, "Bạn hãy chọn ngày tạo!");
//            return false;
//        }
//        if (txtNgaySua.getDate().toString().equals("")) {
//            MsgBox.alert(this, "Bạn hãy chọn ngày sửa!");
//        }
        if (rdoHD.isSelected() == false) {
            if (rdoKhongHD.isSelected() == false) {
                MsgBox.alert(this, "Mời bạn chọn trạng thái!");
                return false;
            }
        }
        if (txtMota.getText().trim().equals("")) {
            MsgBox.alert(this, "Bạn hãy nhập mô tả!");
            return false;
        }
        if (txtTenNSX.getText().trim().equals("")) {
            MsgBox.alert(this, "Bạn chưa nhập tên NSX   !");
            return false;
        }
        if (txtQuocgia.getText().trim().equals("")) {
            MsgBox.alert(this, "Bạn chưa nhập Quốc gia NSX    !");
            return false;
        }
        return true;
    }
    
     public NhaSanXuatModel taoDoituong() {
        NhaSanXuatModel hang = new NhaSanXuatModel();
        hang.setMaNSX(txtMaNSX.getText());
        hang.setTrangThai(rdoHD.isSelected() ? true : false);
        hang.setTenNSX(txtTenNSX.getText());
        hang.setQuocGia(txtQuocgia.getText());
        java.util.Date utilDate = txtNgaytao.getCalendar().getTime();
        java.sql.Date ngayTao = new java.sql.Date(utilDate.getTime());
        hang.setNgayTao(ngayTao);

        // Lấy ngày hiện tại cho ngaySua:
        java.sql.Date ngaySua = new java.sql.Date(new Date().getTime()); // Sử dụng java.util.Date
        // Hoặc:
        // java.sql.Date ngaySua = new java.sql.Date(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli()); // Sử dụng java.time.LocalDate

        hang.setNgaySua(ngaySua);
        System.out.println(ngaySua + "GauGau");
        hang.setMoTa(txtMota.getText());

        return hang;
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
        jLabel2 = new javax.swing.JLabel();
        txtMaNSX = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTenNSX = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNgaytao = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        txtNgaysua = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMota = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        rdoHD = new javax.swing.JRadioButton();
        rdoKhongHD = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        txtQuocgia = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblNSX = new javaswingdev.swing.table.Table();
        jPanel2 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnlammoi = new javax.swing.JButton();
        txtTimkiem = new javax.swing.JTextField();
        btnTimkiem = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jLabel2.setText("Mã NSX");

        jLabel3.setText("Tên NSX ");

        jLabel4.setText("Ngày tạo");

        jLabel5.setText("Ngày sửa");

        txtNgaysua.setEnabled(false);

        jLabel6.setText("Mô tả");

        txtMota.setColumns(20);
        txtMota.setRows(5);
        jScrollPane1.setViewportView(txtMota);

        jLabel7.setText("Trạng thái ");

        buttonGroup1.add(rdoHD);
        rdoHD.setText("Hoạt động");
        rdoHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoHDActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoKhongHD);
        rdoKhongHD.setText("Không hoạt động");
        rdoKhongHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoKhongHDActionPerformed(evt);
            }
        });

        jLabel8.setText("Quốc gia");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtMaNSX, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtNgaytao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(181, 181, 181)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTenNSX, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNgaysua, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtQuocgia))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(rdoHD)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(rdoKhongHD))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaNSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenNSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNgaysua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgaytao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdoHD)
                            .addComponent(rdoKhongHD))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtQuocgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        tblNSX.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã màu ", "Tên màu ", "Ngày tạo", "Ngày sửa", "Mô tả", "Trạng thái ", "Quốc gia"
            }
        ));
        tblNSX.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNSXMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblNSX);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnlammoi.setText(" Làm mới");
        btnlammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlammoiActionPerformed(evt);
            }
        });

        btnTimkiem.setText("Tìm kiếm");
        btnTimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimkiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(btnThem)
                .addGap(41, 41, 41)
                .addComponent(btnSua)
                .addGap(57, 57, 57)
                .addComponent(btnlammoi)
                .addGap(116, 116, 116)
                .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btnTimkiem)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnlammoi)
                    .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimkiem))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("QUẢN LÝ NHÀ SẢN XUẤT");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(276, 276, 276)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 84, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rdoHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoHDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoHDActionPerformed

    private void rdoKhongHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoKhongHDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoKhongHDActionPerformed

    private void tblNSXMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNSXMouseClicked
        // TODO add your handling code here:
        if(tblNSX.getSelectedRow() > -1){
            NhaSanXuatModel nhaSanXuatModel = nsxController.timkiemNSX().get(tblNSX.getSelectedRow());
            txtMaNSX.setText(nhaSanXuatModel.getMaNSX());
            txtTenNSX.setText(nhaSanXuatModel.getTenNSX());
            txtMota.setText(nhaSanXuatModel.getMoTa());
            txtQuocgia.setText(nhaSanXuatModel.getQuocGia());
            txtNgaytao.setDate(nhaSanXuatModel.getNgayTao());
            if(nhaSanXuatModel.isTrangThai()){
                rdoHD.setSelected(true);
            }else{
                rdoKhongHD.setSelected(true);
            }
        }
    }//GEN-LAST:event_tblNSXMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        if(kiemTraTrong()){
            boolean ketqua = nsxController.themNSX(taoDoituong());
            if(ketqua){
                MsgBox.alert(this, "Bạn đã thêm thành công");
                danhSachNSX = nsxController.timkiemNSX();
                hienThiNSX();
            }else{
                MsgBox.alert(this, "Đã trùng mã mời bạn nhập mã khác");
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        if(tblNSX.getSelectedRow()> -1){
            boolean luachon = MsgBox.confirm(this, "Bạn có muốm sửa không?");
            if(kiemTraTrong()){
                if(luachon){
                    boolean ketqua = nsxController.suaNSX(taoDoituong());
                    if(ketqua){
                        MsgBox.alert(this, "Bạn đã sửa thành công");
                        danhSachNSX = nsxController.timkiemNSX();
                        hienThiNSX();
                    }else{
                        MsgBox.alert(this, "Bạn đã sửa không thành công");
                    }
                }
            }
        }else{
            MsgBox.alert(this, "Mời bạn chọn dòng cần sửa");
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnlammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlammoiActionPerformed
        // TODO add your handling code here:
        danhSachNSX = nsxController.timkiemNSX();
        lammoiForm();
        hienThiNSX();
    }//GEN-LAST:event_btnlammoiActionPerformed

    private void btnTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimkiemActionPerformed
        // TODO add your handling code here:
        if(txtTimkiem.getText().trim().equals("")){
            MsgBox.alert(this, "Mời nhập Mã NSX ");
        }else{
            danhSachNSX = nsxController.timKiemNSXTheoMa(txtTimkiem.getText());
            hienThiNSX();
        }
    }//GEN-LAST:event_btnTimkiemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimkiem;
    private javax.swing.JButton btnlammoi;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rdoHD;
    private javax.swing.JRadioButton rdoKhongHD;
    private javaswingdev.swing.table.Table tblNSX;
    private javax.swing.JTextField txtMaNSX;
    private javax.swing.JTextArea txtMota;
    private com.toedter.calendar.JDateChooser txtNgaysua;
    private com.toedter.calendar.JDateChooser txtNgaytao;
    private javax.swing.JTextField txtQuocgia;
    private javax.swing.JTextField txtTenNSX;
    private javax.swing.JTextField txtTimkiem;
    // End of variables declaration//GEN-END:variables
}
