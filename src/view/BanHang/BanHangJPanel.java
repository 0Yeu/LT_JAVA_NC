package view.BanHang;

import bean.DanhMucBean;
import controller.ChuyenManHinhController;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leanh
 */
public class BanHangJPanel extends javax.swing.JPanel {

        /**
         * Creates new form BanHangJPanel
         */
        public BanHangJPanel() {
                initComponents();

                ChuyenManHinhController controller = new ChuyenManHinhController(jPanelView62);
                controller.setViewMenu(jPanelBanHang62, jLabelBanHang62);

                List<DanhMucBean> listItem = new ArrayList<>();
                listItem.add(new DanhMucBean("BanHangMenu", jPanelBanHang62, jLabelBanHang62));
                listItem.add(new DanhMucBean("HoaDon", jPanelHoaDon62, jLabelHoaDon62));

                controller.setEvent(listItem);
        }

        /**
         * This method is called from within the constructor to initialize the
         * form. WARNING: Do NOT modify this code. The content of this method is
         * always regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jPanelRoot62 = new javax.swing.JPanel();
                jPanelMenu62 = new javax.swing.JPanel();
                jPanelBanHang62 = new javax.swing.JPanel();
                jLabelBanHang62 = new javax.swing.JLabel();
                jPanelHoaDon62 = new javax.swing.JPanel();
                jLabelHoaDon62 = new javax.swing.JLabel();
                jPanelView62 = new javax.swing.JPanel();

                setMinimumSize(new java.awt.Dimension(1247, 720));
                setPreferredSize(new java.awt.Dimension(1200, 655));
                setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                jPanelRoot62.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                jPanelMenu62.setBackground(new java.awt.Color(245, 219, 137));
                jPanelMenu62.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
                jPanelMenu62.setPreferredSize(new java.awt.Dimension(1201, 30));
                jPanelMenu62.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                jPanelBanHang62.setBackground(new java.awt.Color(51, 202, 187));
                jPanelBanHang62.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                jPanelBanHang62.setPreferredSize(new java.awt.Dimension(100, 28));
                jPanelBanHang62.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                jLabelBanHang62.setBackground(new java.awt.Color(51, 202, 187));
                jLabelBanHang62.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                jLabelBanHang62.setForeground(new java.awt.Color(255, 255, 255));
                jLabelBanHang62.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabelBanHang62.setText("Bán hàng");
                jLabelBanHang62.setPreferredSize(new java.awt.Dimension(100, 28));
                jPanelBanHang62.add(jLabelBanHang62, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

                jPanelMenu62.add(jPanelBanHang62, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 1, 100, 28));

                jPanelHoaDon62.setBackground(new java.awt.Color(255, 153, 0));
                jPanelHoaDon62.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                jPanelHoaDon62.setPreferredSize(new java.awt.Dimension(100, 28));
                jPanelHoaDon62.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                jLabelHoaDon62.setBackground(new java.awt.Color(255, 153, 0));
                jLabelHoaDon62.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                jLabelHoaDon62.setForeground(new java.awt.Color(255, 255, 255));
                jLabelHoaDon62.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabelHoaDon62.setText("Hóa đơn");
                jLabelHoaDon62.setPreferredSize(new java.awt.Dimension(100, 28));
                jPanelHoaDon62.add(jLabelHoaDon62, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

                jPanelMenu62.add(jPanelHoaDon62, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 1, 100, 28));

                jPanelRoot62.add(jPanelMenu62, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, 0, 1201, 30));

                jPanelView62.setBackground(new java.awt.Color(245, 219, 137));
                jPanelView62.setPreferredSize(new java.awt.Dimension(1200, 655));
                jPanelView62.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
                jPanelRoot62.add(jPanelView62, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1200, 655));

                add(jPanelRoot62, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, -1));
        }// </editor-fold>//GEN-END:initComponents


        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JLabel jLabelBanHang62;
        private javax.swing.JLabel jLabelHoaDon62;
        private javax.swing.JPanel jPanelBanHang62;
        private javax.swing.JPanel jPanelHoaDon62;
        private javax.swing.JPanel jPanelMenu62;
        private javax.swing.JPanel jPanelRoot62;
        private javax.swing.JPanel jPanelView62;
        // End of variables declaration//GEN-END:variables
}
