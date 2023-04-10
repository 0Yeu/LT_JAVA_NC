package view.BanHang;

import view.BanHang.TimKhachJDialog;
import bus.CTHoaDonBUS;
import bus.HoaDonBUS;
import custom.MyDialog;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.print.PrinterException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JDialog;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ChiTietHoaDonJFrame extends JDialog {

    private HoaDonBUS hoadonBUS = new HoaDonBUS();
    private CTHoaDonBUS ctHoaDonBUS = new CTHoaDonBUS();
    private TimKhachJDialog timKhachUI = new TimKhachJDialog();

    public ChiTietHoaDonJFrame() {
        checkBanHang = false;
        initComponents();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setModal(true);
        Image icon = Toolkit.getDefaultToolkit().getImage("src/images/icon-app.png");
        this.setIconImage(icon);
        customEvents();
    }

    private ArrayList<Vector> dsGioHang;
    private int tongTien;
    private String nhanVien;

    public ChiTietHoaDonJFrame(ArrayList<Vector> dsGioHang, int tongTien, Object nhanVien) {
        this();
        this.tongTien = tongTien;
        this.dsGioHang = dsGioHang;
        this.nhanVien = (String) nhanVien;
        DecimalFormat dcf = new DecimalFormat("###,###");
        txtTongTien.setText(dcf.format(tongTien));
    }

    private void customEvents() {
        txtTenKhach.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                checkKhachMa();
            }

            public void removeUpdate(DocumentEvent e) {
                checkKhachMa();
            }

            public void insertUpdate(DocumentEvent e) {
                checkKhachMa();
            }
        });
    }

    private void checkKhachMa() {
        if (!txtTenKhach.getText().equals("")) {
            btnThanhToan.setEnabled(true);
        } else {
            btnThanhToan.setEnabled(false);
        }
    }

    private void xuLyHienThiHoaDon() {
        txtHoaDon.setContentType("text/html");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        DecimalFormat dcf = new DecimalFormat("###,### VND");

        String hd = "<style> "
                + "table {"
                + "border: 1px solid;"
                + "border-bottom: none"
                + "}"
                + "tr {"
                + "border-bottom: 1px solid;"
                + "}"
                + "td {"
                + "padding: 8px;"
                + "} "
                + "th {"
                + "font-size:16pt"
                + "}"
                + "</style>";
        hd += "<h1 style='text-align:center;'>HOÁ ĐƠN THANH TOÁN</h1>";
        hd += "Nhân viên: " + nhanVien + "<br/>";
        hd += "Ngày lập: " + dtf.format(now) + "<br/>";
        hd += "Khách hàng: " + txtTenKhach.getText() + "<br/>";
        hd += "<div style='text-align:center;'>==========================================</div><br/>";
        hd += "<div style='text-align:center'>";
        hd += "<table style='max-width:100%'>";
        hd += "<tr>"
                + "<th>Mã SP</th>"
                + "<th>Tên SP</th>"
                + "<th>Số lượng</th>"
                + "<th>Đơn giá</th>"
                + "<th>Thành tiền</th>"
                + "</tr>";
        for (Vector vec : dsGioHang) {
            hd += "<tr>";
            hd += "<td style='text-align:center;'>" + vec.get(0) + "</td>";
            hd += "<td style='text-align:left;'>" + vec.get(1) + "</td>";
            hd += "<td style='text-align:center;'>" + vec.get(2) + "</td>";
            hd += "<td style='text-align:center;'>" + vec.get(3) + "</td>";
            hd += "<td style='text-align:center;'>" + vec.get(4) + "</td>";
            hd += "</tr>";
        }
        hd += "<tr>";
        hd += "<td style='text-align:center;'>" + "</td>";
        hd += "<td style='text-align:left;'>" + "</td>";
        hd += "<td style='text-align:center;'>" + "</td>";
        hd += "<td style='text-align:center;font-weight:bold'>Tổng cộng</td>";
        hd += "<td style='text-align:center;'>" + dcf.format(tongTien) + "</td>";
        hd += "</tr>";
        hd += "<tr>";
        hd += "<td style='text-align:center;'>" + "</td>";
        hd += "<td style='text-align:left;'>" + "</td>";
        hd += "<td style='text-align:center;'>" + "</td>";
        hd += "<td style='text-align:center;font-weight:bold'>Thành tiền</td>";
        hd += "<td style='text-align:center;'>" + dcf.format(tongTien) + "</td>";
        hd += "</tr>";
        hd += "</table>";
        hd += "</div>";
        hd += "<div style='text-align:center;'>==========================================</div><br/>";
        txtHoaDon.setText(hd);
        txtTongTien.setText(dcf.format(tongTien));
    }

    @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jPanel1 = new javax.swing.JPanel();
                jLabel1 = new javax.swing.JLabel();
                jPanel2 = new javax.swing.JPanel();
                btnThanhToan = new javax.swing.JButton();
                btnInHoaDon = new javax.swing.JButton();
                jScrollPane1 = new javax.swing.JScrollPane();
                txtHoaDon = new javax.swing.JEditorPane();
                txtTenKhach = new javax.swing.JTextField();
                jLabel2 = new javax.swing.JLabel();
                btnTimKhach = new javax.swing.JButton();
                jLabel4 = new javax.swing.JLabel();
                txtTongTien = new javax.swing.JTextField();
                jPanel3 = new javax.swing.JPanel();

                jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
                jLabel1.setForeground(new java.awt.Color(255, 153, 0));
                jLabel1.setText("Chi tiết hoá đơn");
                jPanel1.add(jLabel1);

                btnThanhToan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                btnThanhToan.setText("Thanh toán");
                btnThanhToan.setEnabled(false);
                btnThanhToan.setPreferredSize(new java.awt.Dimension(128, 45));
                btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnThanhToanActionPerformed(evt);
                        }
                });
                jPanel2.add(btnThanhToan);

                btnInHoaDon.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                btnInHoaDon.setText("In hoá đơn");
                btnInHoaDon.setEnabled(false);
                btnInHoaDon.setPreferredSize(new java.awt.Dimension(128, 45));
                btnInHoaDon.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnInHoaDonActionPerformed(evt);
                        }
                });
                jPanel2.add(btnInHoaDon);

                txtHoaDon.setEditable(false);
                jScrollPane1.setViewportView(txtHoaDon);

                txtTenKhach.setEditable(false);
                txtTenKhach.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

                jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
                jLabel2.setText("Khách hàng");

                btnTimKhach.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
                btnTimKhach.setForeground(new java.awt.Color(255, 153, 0));
                btnTimKhach.setText("+");
                btnTimKhach.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                btnTimKhach.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                btnTimKhach.setMargin(new java.awt.Insets(0, 0, 0, 0));
                btnTimKhach.setVerticalAlignment(javax.swing.SwingConstants.TOP);
                btnTimKhach.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnTimKhachActionPerformed(evt);
                        }
                });

                jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
                jLabel4.setText("Tổng tiền");

                txtTongTien.setEditable(false);
                txtTongTien.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                                        .addComponent(txtTenKhach))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTimKhach, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtTenKhach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2)
                                        .addComponent(btnTimKhach, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

    public static boolean checkBanHang = false;

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {
        checkBanHang = false;
        if (txtTenKhach.getText().equals("")) {
            new MyDialog("Xin chọn khách hàng", MyDialog.ERROR_DIALOG);
            return;
        }
        xuLyHienThiHoaDon();
        btnInHoaDon.setEnabled(true);

        hoadonBUS.luuHoaDon(TimKhachJDialog.khachHangTimDuoc.getMaKH(), nhanVien, tongTien, "Đã thanh toán");

        for (Vector vec : dsGioHang) {
            String maSP = vec.get(0) + "";
            String soLuong = vec.get(2) + "";
            String donGia = vec.get(3) + "";
            String thanhTien = vec.get(4) + "";
            ctHoaDonBUS.addCTHoaDon(maSP, soLuong, donGia, thanhTien);
        }
        btnThanhToan.setEnabled(false);
        btnTimKhach.setEnabled(false);
        checkBanHang = true;
    }

    private void btnInHoaDonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            if (!txtHoaDon.getText().equals("")) {
                txtHoaDon.print();
                this.dispose();
            }
        } catch (PrinterException ex) {
        }
    }


    private void btnTimKhachActionPerformed(java.awt.event.ActionEvent evt) {
        timKhachUI.setVisible(true);
        if (timKhachUI.khachHangTimDuoc != null) {
            txtTenKhach.setText(timKhachUI.khachHangTimDuoc.getMaKH() + " - " + timKhachUI.khachHangTimDuoc.getHo() + " " + timKhachUI.khachHangTimDuoc.getTen());
        }
    }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton btnInHoaDon;
        private javax.swing.JButton btnThanhToan;
        private javax.swing.JButton btnTimKhach;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JPanel jPanel2;
        private javax.swing.JPanel jPanel3;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JEditorPane txtHoaDon;
        private javax.swing.JTextField txtTenKhach;
        private javax.swing.JTextField txtTongTien;
        // End of variables declaration//GEN-END:variables
}
