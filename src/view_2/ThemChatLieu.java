/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to ccle this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view_2;

import controller.ChatLieuController;
import java.util.Date;
import model.ChatLieuModel;
import utilities.MsgBox;

/**
 *
 * @author LENHATLINH
 */
public class ThemChatLieu extends javax.swing.JFrame {
    ChatLieuController chatLieuController = new ChatLieuController();

    /**
     * Creates new form ThemChatLieu
     */
    public ThemChatLieu() {
        initComponents();
        hienThiNgayTao();
    }
    private void hienThiNgayTao(){
        java.time.LocalDate ngaySuaLocalDate = java.time.LocalDate.now();
        txtNgayTao.setDate(java.sql.Date.valueOf(ngaySuaLocalDate));
        txtNgaySua.setDate(java.sql.Date.valueOf(ngaySuaLocalDate));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMaChatLieu = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNgayTao = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        rdHoatDong = new javax.swing.JRadioButton();
        rdKhongHoatDong = new javax.swing.JRadioButton();
        txtNgaySua = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        btnAdd = new javax.swing.JToggleButton();
        jLabel7 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("THÊM CHẤT LIỆU");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(168, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(156, 156, 156))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("Mã Chất Liệu");

        jLabel3.setText("Ngày tạo");

        txtNgayTao.setEnabled(false);

        jLabel4.setText("Ngày Sửa");

        jLabel5.setText("Trạng Thái");

        rdHoatDong.setText("Hoạt động");
        rdHoatDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdHoatDongActionPerformed(evt);
            }
        });

        rdKhongHoatDong.setText("Không hoạt động");
        rdKhongHoatDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdKhongHoatDongActionPerformed(evt);
            }
        });

        txtNgaySua.setEnabled(false);

        jLabel6.setText("Mô tả");

        txtMoTa.setColumns(20);
        txtMoTa.setRows(5);
        jScrollPane1.setViewportView(txtMoTa);

        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel7.setText("Tên Chất Liệu");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel2)
                                        .addComponent(txtMaChatLieu)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtNgayTao, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                                        .addComponent(txtTen)
                                        .addComponent(jLabel7))
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGap(28, 28, 28)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtNgaySua, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(rdHoatDong, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(rdKhongHoatDong)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(56, 56, 56)))))
                            .addGap(0, 0, Short.MAX_VALUE))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtMaChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdHoatDong)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdKhongHoatDong)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgaySua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(btnAdd)
                .addGap(74, 74, 74))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rdHoatDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdHoatDongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdHoatDongActionPerformed

    private void rdKhongHoatDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdKhongHoatDongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdKhongHoatDongActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if(kiemTraTrong()){
            boolean ketQua = chatLieuController.themChatLieu(taoDoituong());
            if(ketQua){
                MsgBox.alert(this, "Bạn đã thêm chất liệu thành công");
            }else{
                MsgBox.alert(this, "Bạn đã thêm chất liệu thất bại");
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed
    public ChatLieuModel taoDoituong() {
        ChatLieuModel cl = new ChatLieuModel();
        cl.setMaChatLieu(txtMaChatLieu.getText());
        cl.setTrangThai(rdHoatDong.isSelected() ? true : false);
        cl.setTen(txtTen.getText());
        java.util.Date utilDate = txtNgayTao.getCalendar().getTime();
        java.sql.Date ngayTao = new java.sql.Date(utilDate.getTime());
        cl.setNgayTao(ngayTao);

        // Lấy ngày hiện tại cho ngaySua:
        java.sql.Date ngaySua = new java.sql.Date(new Date().getTime()); // Sử dụng java.util.Date
        // Hoặc:
        // java.sql.Date ngaySua = new java.sql.Date(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli()); // Sử dụng java.time.LocalDate

        cl.setNgaySua(ngaySua);
        System.out.println(ngaySua + "GauGau");
        cl.setMoTa(txtMoTa.getText());

        return cl;
    }
    /**
     * @param args the command line arguments
     */
    private boolean kiemTraTrong(){
        
        if (txtMaChatLieu.getText().trim().equals("")) {
            MsgBox.alert(this, "Bạn chưa nhập mã chất liệu!");
            return false;
        }
        if (txtNgayTao.getDate().toString().equals("")) {
            MsgBox.alert(this, "Bạn hãy chọn ngày tạo!");
            return false;
        }
        if (txtNgaySua.getDate().toString().equals("")) {
            MsgBox.alert(this, "Bạn hãy chọn ngày sửa!");
        }
        if (rdHoatDong.isSelected() == false) {
            if (rdKhongHoatDong.isSelected() == false) {
                MsgBox.alert(this, "Mời bạn chọn trạng thái!");
                return false;
            }
        }
        if (txtMoTa.getText().trim().equals("")) {
            MsgBox.alert(this, "Bạn hãy nhập mô tả!");
            return false;
        }
        if (txtTen.getText().trim().equals("")) {
            MsgBox.alert(this, "Bạn chưa nhập tên chất liệu!");
            return false;
        }
        return true;
    }
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ThemChatLieu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ThemChatLieu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ThemChatLieu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ThemChatLieu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ThemChatLieu().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnAdd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdHoatDong;
    private javax.swing.JRadioButton rdKhongHoatDong;
    private javax.swing.JTextField txtMaChatLieu;
    private javax.swing.JTextArea txtMoTa;
    private com.toedter.calendar.JDateChooser txtNgaySua;
    private com.toedter.calendar.JDateChooser txtNgayTao;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}
