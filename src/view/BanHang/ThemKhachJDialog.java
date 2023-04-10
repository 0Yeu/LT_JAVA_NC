package view.BanHang;

import bus.KhachHangBUS;

public class ThemKhachJDialog extends javax.swing.JDialog {

        public ThemKhachJDialog() {
                this.setTitle("Thêm khách hàng");
                initComponents();
                cmbGioiTinh.removeAllItems();
                cmbGioiTinh.addItem("Chọn giới tính");
                cmbGioiTinh.addItem("Nam");
                cmbGioiTinh.addItem("Nữ");
                this.setModal(true);
                this.setLocationRelativeTo(null);
                this.setResizable(false);
        }

        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jLabel1 = new javax.swing.JLabel();
                txtHo = new javax.swing.JTextField();
                txtTen = new javax.swing.JTextField();
                jLabel2 = new javax.swing.JLabel();
                jLabel3 = new javax.swing.JLabel();
                cmbGioiTinh = new javax.swing.JComboBox<>();
                jPanel1 = new javax.swing.JPanel();
                jButton1 = new javax.swing.JButton();
                jButton2 = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

                jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                jLabel1.setForeground(new java.awt.Color(102, 51, 0));
                jLabel1.setText("Họ đệm");

                txtHo.setBackground(new java.awt.Color(255, 255, 255));
                txtHo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                txtHo.setForeground(new java.awt.Color(0, 0, 0));

                txtTen.setBackground(new java.awt.Color(255, 255, 255));
                txtTen.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                txtTen.setForeground(new java.awt.Color(0, 0, 0));

                jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                jLabel2.setForeground(new java.awt.Color(102, 51, 0));
                jLabel2.setText("Tên");

                jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                jLabel3.setForeground(new java.awt.Color(102, 51, 0));
                jLabel3.setText("Giới tính");

                cmbGioiTinh.setBackground(new java.awt.Color(255, 255, 255));
                cmbGioiTinh.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                cmbGioiTinh.setForeground(new java.awt.Color(0, 0, 0));
                cmbGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

                jButton1.setBackground(new java.awt.Color(255, 153, 0));
                jButton1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
                jButton1.setForeground(new java.awt.Color(255, 255, 255));
                jButton1.setText("Thêm");
                jButton1.setBorder(null);
                jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                jButton1.setFocusPainted(false);
                jButton1.setPreferredSize(new java.awt.Dimension(100, 30));
                jButton1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton1ActionPerformed(evt);
                        }
                });
                jPanel1.add(jButton1);

                jButton2.setBackground(new java.awt.Color(255, 153, 0));
                jButton2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
                jButton2.setForeground(new java.awt.Color(255, 255, 255));
                jButton2.setText("Thoát");
                jButton2.setBorder(null);
                jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                jButton2.setFocusPainted(false);
                jButton2.setPreferredSize(new java.awt.Dimension(100, 30));
                jButton2.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton2ActionPerformed(evt);
                        }
                });
                jPanel1.add(jButton2);

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                                .addComponent(txtHo, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel3))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(txtTen, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                                                        .addComponent(cmbGioiTinh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap())
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(txtHo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(cmbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

        public boolean checkThemKhach = false;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            checkThemKhach = false;
            KhachHangBUS khachHangBUS = new KhachHangBUS();
            boolean flag = khachHangBUS.themKhachHang(txtHo.getText(), txtTen.getText(), cmbGioiTinh.getSelectedItem() + "");
            checkThemKhach = flag;
            if (flag) {
                    this.dispose();
            }
    }//GEN-LAST:event_jButton1ActionPerformed

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JComboBox<String> cmbGioiTinh;
        private javax.swing.JButton jButton1;
        private javax.swing.JButton jButton2;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JTextField txtHo;
        private javax.swing.JTextField txtTen;
        // End of variables declaration//GEN-END:variables
}
