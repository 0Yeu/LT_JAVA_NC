/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import bus.DangNhapBUS;
import custom.MyDialog;
import java.awt.Image;
import java.awt.Toolkit;
import model.TaiKhoan;

/**
 *
 * @author luchu
 */
public class DangNhapJFrame extends javax.swing.JFrame {

        /**
         * Creates new form DangNhapJFram
         */
        public DangNhapJFrame() {
                initComponents();
                xuLyTaiKhoanDaGhiNho();
        }

        private void xuLyDangNhap() {
                DangNhapBUS dangNhapBUS = new DangNhapBUS();
                TaiKhoan tk = dangNhapBUS.getTaiKhoanDangNhap(jTextFieldTK30.getText(),
                        jPasswordFieldMK30.getText(), jCheckBoxSave30.isSelected());
                if (tk != null) {
                        this.dispose();
                        MainJFrame gui = new MainJFrame();
                        this.dispose();
                        gui.showWindow();
                }
        }

        private void xuLyTaiKhoanDaGhiNho() {
                DangNhapBUS dangNhapBUS = new DangNhapBUS();
                String line = dangNhapBUS.getTaiKhoanGhiNho();
                try {
                        String[] arr = line.split(" | ");
                        jCheckBoxSave30.setSelected(true);
                        jTextFieldTK30.setText(arr[0]);
                        jPasswordFieldMK30.setText(arr[2]);
                        jTextFieldTK30.requestFocus();
                } catch (Exception e) {
                        jTextFieldTK30.setText("");
                        jPasswordFieldMK30.setText("");
                        jTextFieldTK30.requestFocus();
                }
        }

        /**
         * This method is called from within the constructor to initialize the
         * form. WARNING: Do NOT modify this code. The content of this method is
         * always regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jPanelBackground30 = new javax.swing.JPanel();
                jPanelMainLogin30 = new javax.swing.JPanel();
                jPanelBackLogo30 = new javax.swing.JPanel();
                jLabelLogo30 = new javax.swing.JLabel();
                jLabelImage30 = new javax.swing.JLabel();
                jPanelForm30 = new javax.swing.JPanel();
                jLabelClose30 = new javax.swing.JLabel();
                jLabelDN30 = new javax.swing.JLabel();
                jLabelHi30 = new javax.swing.JLabel();
                jLabelLet30 = new javax.swing.JLabel();
                jTextFieldTK30 = new javax.swing.JTextField();
                jPasswordFieldMK30 = new javax.swing.JPasswordField();
                jCheckBoxSave30 = new javax.swing.JCheckBox();
                jButtonDN30 = new javax.swing.JButton();
                jLabelForgot30 = new javax.swing.JLabel();
                jLabelBackground30 = new javax.swing.JLabel();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                setUndecorated(true);
                setPreferredSize(new java.awt.Dimension(1440, 720));
                setResizable(false);
                setSize(new java.awt.Dimension(1440, 720));

                jPanelBackground30.setPreferredSize(new java.awt.Dimension(1440, 720));
                jPanelBackground30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                jPanelMainLogin30.setForeground(new java.awt.Color(255, 255, 255));
                jPanelMainLogin30.setDoubleBuffered(false);
                jPanelMainLogin30.setMinimumSize(new java.awt.Dimension(1100, 600));
                jPanelMainLogin30.setPreferredSize(new java.awt.Dimension(1100, 600));
                jPanelMainLogin30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                jPanelBackLogo30.setForeground(new java.awt.Color(255, 255, 255));
                jPanelBackLogo30.setPreferredSize(new java.awt.Dimension(653, 599));
                jPanelBackLogo30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                jLabelLogo30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/heroLogo.png"))); // NOI18N
                jPanelBackLogo30.add(jLabelLogo30, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 230, 140, 140));

                jLabelImage30.setFont(new java.awt.Font("Cascadia Mono", 0, 48)); // NOI18N
                jLabelImage30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/heroSection.png"))); // NOI18N
                jLabelImage30.setPreferredSize(new java.awt.Dimension(653, 599));
                jPanelBackLogo30.add(jLabelImage30, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 653, 598));

                jPanelMainLogin30.add(jPanelBackLogo30, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 653, 599));

                jPanelForm30.setBackground(new java.awt.Color(255, 255, 255));
                jPanelForm30.setForeground(new java.awt.Color(255, 255, 255));
                jPanelForm30.setPreferredSize(new java.awt.Dimension(446, 600));
                jPanelForm30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                jLabelClose30.setBackground(new java.awt.Color(255, 255, 255));
                jLabelClose30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/CloseButton.png"))); // NOI18N
                jLabelClose30.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                jLabelClose30.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                jLabelClose30MouseClicked(evt);
                        }
                });
                jPanelForm30.add(jLabelClose30, new org.netbeans.lib.awtextra.AbsoluteConstraints(415, 10, -1, -1));

                jLabelDN30.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
                jLabelDN30.setForeground(new java.awt.Color(255, 255, 255));
                jLabelDN30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabelDN30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FormBtn.png"))); // NOI18N
                jLabelDN30.setText("ĐĂNG NHẬP");
                jLabelDN30.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                jPanelForm30.add(jLabelDN30, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 50, -1, -1));

                jLabelHi30.setFont(new java.awt.Font("Tahoma", 0, 32)); // NOI18N
                jLabelHi30.setText("Xin Chào!");
                jPanelForm30.add(jLabelHi30, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 180, -1));

                jLabelLet30.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
                jLabelLet30.setText("Hãy đăng nhập tài khoản!");
                jPanelForm30.add(jLabelLet30, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));

                jTextFieldTK30.setBackground(new java.awt.Color(255, 255, 255));
                jTextFieldTK30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
                jTextFieldTK30.setForeground(new java.awt.Color(0, 0, 0));
                jTextFieldTK30.setToolTipText("");
                jTextFieldTK30.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tài khoản", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
                jTextFieldTK30.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
                jTextFieldTK30.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jTextFieldTK30ActionPerformed(evt);
                        }
                });
                jPanelForm30.add(jTextFieldTK30, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 330, 70));

                jPasswordFieldMK30.setBackground(new java.awt.Color(255, 255, 255));
                jPasswordFieldMK30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
                jPasswordFieldMK30.setForeground(new java.awt.Color(0, 0, 0));
                jPasswordFieldMK30.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mật khẩu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
                jPasswordFieldMK30.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jPasswordFieldMK30ActionPerformed(evt);
                        }
                });
                jPanelForm30.add(jPasswordFieldMK30, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 330, 70));

                jCheckBoxSave30.setBackground(new java.awt.Color(255, 255, 255));
                jCheckBoxSave30.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
                jCheckBoxSave30.setForeground(new java.awt.Color(153, 153, 153));
                jCheckBoxSave30.setSelected(true);
                jCheckBoxSave30.setText("Ghi nhớ đăng nhập");
                jCheckBoxSave30.setFocusPainted(false);
                jPanelForm30.add(jCheckBoxSave30, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, -1, -1));

                jButtonDN30.setBackground(new java.awt.Color(255, 255, 255));
                jButtonDN30.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                jButtonDN30.setForeground(new java.awt.Color(255, 255, 255));
                jButtonDN30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FormBtn.png"))); // NOI18N
                jButtonDN30.setText("Đăng nhập");
                jButtonDN30.setBorder(null);
                jButtonDN30.setBorderPainted(false);
                jButtonDN30.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                jButtonDN30.setFocusPainted(false);
                jButtonDN30.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                jButtonDN30.setInheritsPopupMenu(true);
                jButtonDN30.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButtonDN30ActionPerformed(evt);
                        }
                });
                jPanelForm30.add(jButtonDN30, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 445, -1, -1));

                jLabelForgot30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
                jLabelForgot30.setForeground(new java.awt.Color(153, 153, 153));
                jLabelForgot30.setText("Quên mật khẩu?");
                jLabelForgot30.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                jLabelForgot30.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                jLabelForgot30MouseClicked(evt);
                        }
                });
                jPanelForm30.add(jLabelForgot30, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 490, -1, -1));

                jPanelMainLogin30.add(jPanelForm30, new org.netbeans.lib.awtextra.AbsoluteConstraints(654, 0, 446, 600));

                jPanelBackground30.add(jPanelMainLogin30, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 1100, 600));

                jLabelBackground30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/DeskBg.png"))); // NOI18N
                jPanelBackground30.add(jLabelBackground30, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1440, 720));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanelBackground30, javax.swing.GroupLayout.PREFERRED_SIZE, 1440, javax.swing.GroupLayout.PREFERRED_SIZE)
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanelBackground30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                );

                getAccessibleContext().setAccessibleDescription("");

                pack();
                setLocationRelativeTo(null);
        }// </editor-fold>//GEN-END:initComponents

        private void jTextFieldTK30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTK30ActionPerformed
                // TODO add your handling code here:
                jPasswordFieldMK30.requestFocus();
        }//GEN-LAST:event_jTextFieldTK30ActionPerformed

        private void jLabelClose30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelClose30MouseClicked
                // TODO add your handling code here:
                System.exit(0);
        }//GEN-LAST:event_jLabelClose30MouseClicked

        private void jButtonDN30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDN30ActionPerformed
                // TODO add your handling code here:
                xuLyDangNhap();
        }//GEN-LAST:event_jButtonDN30ActionPerformed

        private void jLabelForgot30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelForgot30MouseClicked
                // TODO add your handling code here:
                new MyDialog("Xin liên hệ Admin để giải quyết!", MyDialog.INFO_DIALOG);
        }//GEN-LAST:event_jLabelForgot30MouseClicked

        private void jPasswordFieldMK30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldMK30ActionPerformed
                // TODO add your handling code here:
                xuLyDangNhap();
        }//GEN-LAST:event_jPasswordFieldMK30ActionPerformed

        public void showWindow() {
                Image icon = Toolkit.getDefaultToolkit().getImage("src/images/icon-app.png");
                this.setIconImage(icon);
                this.setVisible(true);
        }

        /**
         * @param args the command line arguments
         */

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton jButtonDN30;
        private javax.swing.JCheckBox jCheckBoxSave30;
        private javax.swing.JLabel jLabelBackground30;
        private javax.swing.JLabel jLabelClose30;
        private javax.swing.JLabel jLabelDN30;
        private javax.swing.JLabel jLabelForgot30;
        private javax.swing.JLabel jLabelHi30;
        private javax.swing.JLabel jLabelImage30;
        private javax.swing.JLabel jLabelLet30;
        private javax.swing.JLabel jLabelLogo30;
        private javax.swing.JPanel jPanelBackLogo30;
        private javax.swing.JPanel jPanelBackground30;
        private javax.swing.JPanel jPanelForm30;
        private javax.swing.JPanel jPanelMainLogin30;
        private javax.swing.JPasswordField jPasswordFieldMK30;
        private javax.swing.JTextField jTextFieldTK30;
        // End of variables declaration//GEN-END:variables
}
