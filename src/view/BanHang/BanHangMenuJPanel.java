package view.BanHang;

import bus.DangNhapBUS;
import bus.LoaiBUS;
import bus.NhanVienBUS;
import bus.SanPhamBUS;
import custom.MyDialog;
import custom.MyTable;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.NumberFormatter;
import model.LoaiSP;
import model.NhanVien;
import model.SanPham;

/**
 *
 * @author leanh
 */
public class BanHangMenuJPanel extends javax.swing.JPanel {

        /**
         * Creates new form BanHangMenuJPanel
         */
        private DefaultTableModel dtmSanPham, dtmGioHang;
        private SanPhamBUS spBUS;
        private NhanVienBUS nvBUS;
        private LoaiBUS loaiBUS;
        private DecimalFormat dcf;

        public BanHangMenuJPanel() {
                initComponents();

                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(JLabel.CENTER);
                dcf = new DecimalFormat("###,###");
                loaiBUS = new LoaiBUS();
                spBUS = new SanPhamBUS();
                nvBUS = new NhanVienBUS();

                SpinnerNumberModel modeSpinner = new SpinnerNumberModel(1, 1, 100, 1);
                jSpinnerSoLuong36.setModel(modeSpinner);
                JFormattedTextField txtSpinner = ((JSpinner.NumberEditor) jSpinnerSoLuong36.getEditor()).getTextField();
                ((NumberFormatter) txtSpinner.getFormatter()).setAllowsInvalid(false);
                txtSpinner.setEditable(false);
                txtSpinner.setHorizontalAlignment(JTextField.LEFT);
                jTextFieldMaSP36.setEditable(false);
                jTextFieldTenSP36.setEditable(false);
                jTextFieldDonGia36.setEditable(false);

                new MyTable(jTableDSSP36);
                dtmSanPham = new DefaultTableModel() {
                        @Override
                        public boolean isCellEditable(int row, int column) {
                                return false;
                        }
                };
                jTableDSSP36.setModel(dtmSanPham);

                dtmSanPham.addColumn("Mã SP");
                dtmSanPham.addColumn("Tên SP");
                dtmSanPham.addColumn("Đơn giá");
                dtmSanPham.addColumn("Còn lại");
                dtmSanPham.addColumn("Đơn vị tính");
                dtmSanPham.addColumn("Ảnh");

                jTableDSSP36.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
                jTableDSSP36.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
                jTableDSSP36.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
                jTableDSSP36.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
                TableColumnModel columnModelBanHang = jTableDSSP36.getColumnModel();
                columnModelBanHang.getColumn(0).setPreferredWidth(77);
                columnModelBanHang.getColumn(1).setPreferredWidth(282);
                columnModelBanHang.getColumn(2).setPreferredWidth(82);
                columnModelBanHang.getColumn(3).setPreferredWidth(85);
                columnModelBanHang.getColumn(4).setPreferredWidth(138);
                columnModelBanHang.getColumn(5).setPreferredWidth(0);

                new MyTable(jTableGioHang36);
                dtmGioHang = new DefaultTableModel() {
                        @Override
                        public boolean isCellEditable(int row, int column) {
                                return false;
                        }
                };
                jTableGioHang36.setModel(dtmGioHang);

                dtmGioHang.addColumn("Mã SP");
                dtmGioHang.addColumn("Tên SP");
                dtmGioHang.addColumn("Số lượng");
                dtmGioHang.addColumn("Đơn giá");
                dtmGioHang.addColumn("Thành tiền");

                jTableGioHang36.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
                jTableGioHang36.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
                jTableGioHang36.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
                jTableGioHang36.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
                TableColumnModel columnModelGioHang = jTableGioHang36.getColumnModel();
                columnModelGioHang.getColumn(0).setPreferredWidth(81);
                columnModelGioHang.getColumn(1).setPreferredWidth(279);
                columnModelGioHang.getColumn(2).setPreferredWidth(111);
                columnModelGioHang.getColumn(3).setPreferredWidth(101);
                columnModelGioHang.getColumn(4).setPreferredWidth(100);

                loadLoaiSP();
                loadTableDataSP();
                loadDataComboboxNhanVienBan();
        }

        private void loadTableDataSP() {
                dtmSanPham.setRowCount(0);
                ArrayList<SanPham> dssp = null;

                if (jComboBoxLoaiSP36.getItemCount() > 0) {
                        String loai = jComboBoxLoaiSP36.getSelectedItem() + "";
                        String loaiArr[] = loai.split("-");
                        String loaiSP = loaiArr[0].trim();

                        if (loaiSP.equals("0")) {
                                dssp = spBUS.getListSanPham();
                        } else {
                                dssp = spBUS.getSanPhamTheoLoai(loaiSP);
                        }
                } else {
                        dssp = spBUS.getListSanPham();
                }
                for (SanPham sp : dssp) {
                        Vector vec = new Vector();
                        vec.add(sp.getMaSP());
                        vec.add(sp.getTenSP());
                        vec.add(dcf.format(sp.getDonGia()).replace(",", "."));
                        vec.add(dcf.format(sp.getSoLuong()).replace(",", "."));
                        vec.add(sp.getDonViTinh());
                        vec.add(sp.getHinhAnh());
                        dtmSanPham.addRow(vec);
                }
        }

        private void loadLoaiSP() {
                jComboBoxLoaiSP36.removeAllItems();
                jComboBoxLoaiSP36.addItem("0 - Chọn loại");
                ArrayList<LoaiSP> dsl = loaiBUS.getDanhSachLoai();

                for (LoaiSP loai : dsl) {
                        jComboBoxLoaiSP36.addItem(loai.getMaLoai() + " - " + loai.getTenLoai());
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

        jPanelView62 = new javax.swing.JPanel();
        jLabelDSSP36 = new javax.swing.JLabel();
        jScrollPaneSanPham62 = new javax.swing.JScrollPane();
        jTableDSSP36 = new javax.swing.JTable();
        jLabelGioHang36 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableGioHang36 = new javax.swing.JTable();
        jLabelCTSP36 = new javax.swing.JLabel();
        jComboBoxLoaiSP36 = new javax.swing.JComboBox<>();
        jLabelImageSP36 = new javax.swing.JLabel();
        jButtonXoaChonGH36 = new javax.swing.JButton();
        jButtonXuatHD36 = new javax.swing.JButton();
        jPanelTTCTSP36 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldMaSP36 = new javax.swing.JTextField();
        jTextFieldTenSP36 = new javax.swing.JTextField();
        jTextFieldDonGia36 = new javax.swing.JTextField();
        jSpinnerSoLuong36 = new javax.swing.JSpinner();
        jComboBoxNhanVien36 = new javax.swing.JComboBox<>();
        jButtonThemGH36 = new javax.swing.JButton();
        jLabelRefreshDb62 = new javax.swing.JLabel();
        jTextFieldSearch62 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1200, 655));

        jPanelView62.setBackground(new java.awt.Color(245, 219, 137));
        jPanelView62.setPreferredSize(new java.awt.Dimension(1200, 655));
        jPanelView62.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelDSSP36.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDSSP36.setForeground(new java.awt.Color(102, 51, 0));
        jLabelDSSP36.setText("Danh sách sản phẩm");
        jPanelView62.add(jLabelDSSP36, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        jTableDSSP36.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTableDSSP36.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableDSSP36.setGridColor(new java.awt.Color(128, 128, 128));
        jTableDSSP36.setRowHeight(25);
        jTableDSSP36.setSelectionBackground(new java.awt.Color(50, 154, 114));
        jTableDSSP36.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTableDSSP36.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableDSSP36.setShowHorizontalLines(true);
        jTableDSSP36.getTableHeader().setReorderingAllowed(false);
        jTableDSSP36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDSSP36MouseClicked(evt);
            }
        });
        jScrollPaneSanPham62.setViewportView(jTableDSSP36);

        jPanelView62.add(jScrollPaneSanPham62, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 590, 200));

        jLabelGioHang36.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelGioHang36.setForeground(new java.awt.Color(102, 51, 0));
        jLabelGioHang36.setText("Giỏ hàng");
        jPanelView62.add(jLabelGioHang36, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 270, -1, -1));

        jTableGioHang36.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTableGioHang36.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableGioHang36.setFocusable(false);
        jTableGioHang36.setGridColor(new java.awt.Color(128, 128, 128));
        jTableGioHang36.setRowHeight(25);
        jTableGioHang36.setSelectionBackground(new java.awt.Color(50, 154, 114));
        jTableGioHang36.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTableGioHang36.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableGioHang36.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableGioHang36.setShowHorizontalLines(true);
        jTableGioHang36.getTableHeader().setReorderingAllowed(false);
        jTableGioHang36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableGioHang36MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableGioHang36);

        jPanelView62.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 590, 230));

        jLabelCTSP36.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelCTSP36.setForeground(new java.awt.Color(102, 51, 0));
        jLabelCTSP36.setText("Chi tiết sản phẩm");
        jPanelView62.add(jLabelCTSP36, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 20, -1, -1));

        jComboBoxLoaiSP36.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBoxLoaiSP36.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxLoaiSP36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxLoaiSP36ActionPerformed(evt);
            }
        });
        jPanelView62.add(jComboBoxLoaiSP36, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jLabelImageSP36.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 1, true));
        jLabelImageSP36.setPreferredSize(new java.awt.Dimension(200, 200));
        jPanelView62.add(jLabelImageSP36, new org.netbeans.lib.awtextra.AbsoluteConstraints(835, 50, 200, 200));

        jButtonXoaChonGH36.setBackground(new java.awt.Color(255, 153, 0));
        jButtonXoaChonGH36.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonXoaChonGH36.setForeground(new java.awt.Color(255, 255, 255));
        jButtonXoaChonGH36.setText("Xóa");
        jButtonXoaChonGH36.setBorder(null);
        jButtonXoaChonGH36.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonXoaChonGH36.setFocusPainted(false);
        jButtonXoaChonGH36.setPreferredSize(new java.awt.Dimension(70, 30));
        jButtonXoaChonGH36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXoaChonGH36ActionPerformed(evt);
            }
        });
        jPanelView62.add(jButtonXoaChonGH36, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 540, 70, 30));

        jButtonXuatHD36.setBackground(new java.awt.Color(255, 153, 0));
        jButtonXuatHD36.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonXuatHD36.setForeground(new java.awt.Color(255, 255, 255));
        jButtonXuatHD36.setText("Xuất hóa đơn");
        jButtonXuatHD36.setBorder(null);
        jButtonXuatHD36.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonXuatHD36.setFocusPainted(false);
        jButtonXuatHD36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXuatHD36ActionPerformed(evt);
            }
        });
        jPanelView62.add(jButtonXuatHD36, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 590, 150, 40));

        jPanelTTCTSP36.setBackground(new java.awt.Color(245, 219, 137));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 51, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Mã sản phẩm");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 51, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Nhân viên");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 51, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Tên sản phẩm");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 51, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Đơn giá");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 51, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Số lượng");

        jTextFieldMaSP36.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jTextFieldTenSP36.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jTextFieldDonGia36.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldDonGia36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDonGia36ActionPerformed(evt);
            }
        });

        jSpinnerSoLuong36.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jSpinnerSoLuong36.setModel(new javax.swing.SpinnerNumberModel(1, 0, null, 1));
        jSpinnerSoLuong36.setToolTipText("");

        jComboBoxNhanVien36.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBoxNhanVien36.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxNhanVien36.setEnabled(false);

        javax.swing.GroupLayout jPanelTTCTSP36Layout = new javax.swing.GroupLayout(jPanelTTCTSP36);
        jPanelTTCTSP36.setLayout(jPanelTTCTSP36Layout);
        jPanelTTCTSP36Layout.setHorizontalGroup(
            jPanelTTCTSP36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTTCTSP36Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTTCTSP36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(38, 38, 38)
                .addGroup(jPanelTTCTSP36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSpinnerSoLuong36, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxNhanVien36, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldMaSP36, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTenSP36, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDonGia36, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
        );
        jPanelTTCTSP36Layout.setVerticalGroup(
            jPanelTTCTSP36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTTCTSP36Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanelTTCTSP36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldMaSP36, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(28, 28, 28)
                .addGroup(jPanelTTCTSP36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldTenSP36, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanelTTCTSP36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldDonGia36, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanelTTCTSP36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jSpinnerSoLuong36, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanelTTCTSP36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTTCTSP36Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel6))
                    .addGroup(jPanelTTCTSP36Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxNhanVien36, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jPanelView62.add(jPanelTTCTSP36, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 260, 410, 270));

        jButtonThemGH36.setBackground(new java.awt.Color(255, 153, 0));
        jButtonThemGH36.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonThemGH36.setForeground(new java.awt.Color(255, 255, 255));
        jButtonThemGH36.setText("Thêm vào giỏ");
        jButtonThemGH36.setBorder(null);
        jButtonThemGH36.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonThemGH36.setFocusPainted(false);
        jButtonThemGH36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonThemGH36ActionPerformed(evt);
            }
        });
        jPanelView62.add(jButtonThemGH36, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 560, 140, 30));

        jLabelRefreshDb62.setBackground(new java.awt.Color(245, 219, 137));
        jLabelRefreshDb62.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelRefreshDb62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mdi_database-refresh.png"))); // NOI18N
        jLabelRefreshDb62.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelRefreshDb62.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelRefreshDb62MouseClicked(evt);
            }
        });
        jPanelView62.add(jLabelRefreshDb62, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 5, 30, 30));

        jTextFieldSearch62.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldSearch62.setPreferredSize(new java.awt.Dimension(130, 30));
        jTextFieldSearch62.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldSearch62KeyReleased(evt);
            }
        });
        jPanelView62.add(jTextFieldSearch62, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 22, 130, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bx_search-alt.png"))); // NOI18N
        jLabel1.setToolTipText("");
        jPanelView62.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 22, 30, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelView62, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelView62, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

        private void jTextFieldDonGia36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDonGia36ActionPerformed
                // TODO add your handling code here:
        }//GEN-LAST:event_jTextFieldDonGia36ActionPerformed

        private void jComboBoxLoaiSP36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxLoaiSP36ActionPerformed
                // TODO add your handling code here:
                loadTableDataSP();
        }//GEN-LAST:event_jComboBoxLoaiSP36ActionPerformed

        private void jTableDSSP36MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDSSP36MouseClicked
                // TODO add your handling code here:
                int row = jTableDSSP36.getSelectedRow();
                if (row > -1) {
                        String ma = jTableDSSP36.getValueAt(row, 0) + "";
                        String ten = jTableDSSP36.getValueAt(row, 1) + "";
                        String donGia = jTableDSSP36.getValueAt(row, 2) + "";
                        String anh = jTableDSSP36.getValueAt(row, 5) + "";
                        int soLuong = Integer.parseInt(jTableDSSP36.getValueAt(row, 3) + "");
                        if (soLuong < 1) {
                                MyDialog dlg = new MyDialog("Sản phẩm đã hết hàng", MyDialog.ERROR_DIALOG);
                                return;
                        }

                        SpinnerNumberModel modeSpinner = new SpinnerNumberModel(1, 1, soLuong, 1);
                        jSpinnerSoLuong36.setModel(modeSpinner);
                        JFormattedTextField txtSpinner = ((JSpinner.NumberEditor) jSpinnerSoLuong36.getEditor()).getTextField();
                        ((NumberFormatter) txtSpinner.getFormatter()).setAllowsInvalid(false);
                        txtSpinner.setEditable(false);
                        txtSpinner.setHorizontalAlignment(JTextField.LEFT);

                        jTextFieldMaSP36.setText(ma);
                        jTextFieldTenSP36.setText(ten);
                        jTextFieldDonGia36.setText(donGia);
                        loadAnh(anh);
                }
        }//GEN-LAST:event_jTableDSSP36MouseClicked

        private void loadAnh(String anh) {
                jLabelImageSP36.setIcon(getAnhSP(anh));
        }

        File fileAnhSP;

        private ImageIcon getAnhSP(String src) {
                src = src.trim().equals("") ? "default.png" : src;
                //Xử lý ảnh
                BufferedImage img = null;
                File fileImg = new File("src/images/SanPham/" + src);

                if (!fileImg.exists()) {
                        src = "default.png";
                        fileImg = new File("src/images/SanPham/" + src);
                }

                try {
                        img = ImageIO.read(fileImg);
                        fileAnhSP = new File("src/images/SanPham/" + src);
                } catch (IOException e) {
                        fileAnhSP = new File("src/images/SanPham/default.png");
                }

                if (img != null) {
                        Image dimg = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);

                        return new ImageIcon(dimg);
                }
                return null;
        }

        private void jButtonThemGH36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThemGH36ActionPerformed
                // TODO add your handling code here:
                int row = jTableDSSP36.getSelectedRow();
                if (row < 0) {
                        return;
                }

                String ma = jTextFieldMaSP36.getText();
                String ten = jTextFieldTenSP36.getText();
                String donGia = jTextFieldDonGia36.getText();
                int soLuong = Integer.parseInt(jSpinnerSoLuong36.getValue() + "");
                int soLuongConLai = Integer.parseInt(jTableDSSP36.getValueAt(jTableDSSP36.getSelectedRow(), 3) + "");

                if (soLuong > soLuongConLai || soLuongConLai <= 0) {
                        new MyDialog("Sản phẩm đã hết hàng", MyDialog.ERROR_DIALOG);
                        return;
                }
                jTextFieldMaSP36.setText("");
                jTextFieldTenSP36.setText("");
                jTextFieldDonGia36.setText("");
                jSpinnerSoLuong36.setValue(0);

                if (ma.trim().equalsIgnoreCase("")) {
                        return;
                }
                int key = Integer.parseInt(ma);
                for (int i = 0; i < jTableGioHang36.getRowCount(); i++) {
                        int maTbl = Integer.parseInt(jTableGioHang36.getValueAt(i, 0) + "");
                        if (maTbl == key) {
                                int soLuongAdd = Integer.parseInt(jTableGioHang36.getValueAt(i, 2) + "");
                                soLuongAdd += soLuong;
                                donGia = donGia.replace(".", "");
                                int donGiaSP = Integer.parseInt(donGia);

                                jTableGioHang36.setValueAt(soLuongAdd, i, 2);
                                jTableGioHang36.setValueAt(dcf.format(soLuongAdd * donGiaSP), i, 4);

                                // cập nhật lại số lượng trong db
                                spBUS.capNhatSoLuongSP(key, -soLuong);
                                spBUS.docListSanPham();
                                loadTableDataSP();
                                return;
                        }
                }

                Vector vec = new Vector();
                vec.add(ma);
                vec.add(ten);
                vec.add(soLuong);
                vec.add(donGia);
                donGia = donGia.replace(".", "");
                int donGiaSP = Integer.parseInt(donGia);
                vec.add(dcf.format(soLuong * donGiaSP));
                // cập nhật lại số lượng trong db
                spBUS.capNhatSoLuongSP(key, -soLuong);
                spBUS.docListSanPham();
                loadTableDataSP();
                dtmGioHang.addRow(vec);
        }//GEN-LAST:event_jButtonThemGH36ActionPerformed

        private void jButtonXoaChonGH36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXoaChonGH36ActionPerformed
                // TODO add your handling code here:
                int row = jTableGioHang36.getSelectedRow();
                if (row > -1) {
                        int ma = Integer.parseInt(jTableGioHang36.getValueAt(row, 0) + "");
                        int soLuong = Integer.parseInt(jTableGioHang36.getValueAt(row, 2) + "");
                        spBUS.capNhatSoLuongSP(ma, soLuong);
                        spBUS.docListSanPham();
                        loadTableDataSP();
                        dtmGioHang.removeRow(row);
                }
        }//GEN-LAST:event_jButtonXoaChonGH36ActionPerformed

        private void jTableGioHang36MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableGioHang36MouseClicked
                // TODO add your handling code here:
                int row = jTableGioHang36.getSelectedRow();
                if (row < 0) {
                        return;
                }
                String ma = jTableGioHang36.getValueAt(row, 0) + "";
                loadAnh(spBUS.getAnh(ma));
        }//GEN-LAST:event_jTableGioHang36MouseClicked

        private void jButtonXuatHD36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXuatHD36ActionPerformed
                // TODO add your handling code here:
                ArrayList<Vector> dsGioHang = new ArrayList<>();
                int row = jTableGioHang36.getRowCount();
                if (row == 0) {
                        return;
                }
                int tongTien = 0;
                for (int i = 0; i < row; i++) {
                        Vector vec = new Vector();
                        vec.add(jTableGioHang36.getValueAt(i, 0));
                        vec.add(jTableGioHang36.getValueAt(i, 1));
                        vec.add(jTableGioHang36.getValueAt(i, 2));
                        vec.add(jTableGioHang36.getValueAt(i, 3));
                        vec.add(jTableGioHang36.getValueAt(i, 4));
                        tongTien += Integer.parseInt((jTableGioHang36.getValueAt(i, 4) + "").replace(".", ""));
                        dsGioHang.add(vec);
                }

                ChiTietHoaDonJFrame hoaDonUI = new ChiTietHoaDonJFrame(dsGioHang, tongTien, jComboBoxNhanVien36.getSelectedItem());
                hoaDonUI.setVisible(true);
                if (hoaDonUI.checkBanHang) {
                        dtmGioHang.setRowCount(0);
                }
        }//GEN-LAST:event_jButtonXuatHD36ActionPerformed

        private void jLabelRefreshDb62MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRefreshDb62MouseClicked
                // TODO add your handling code here:
                loadLoaiSP();
                jComboBoxLoaiSP36.setSelectedIndex(0);
                loadDataComboboxNhanVienBan();
        }//GEN-LAST:event_jLabelRefreshDb62MouseClicked

        private void jTextFieldSearch62KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearch62KeyReleased
                // TODO add your handling code here:
                searchTable(jTextFieldSearch62.getText());
        }//GEN-LAST:event_jTextFieldSearch62KeyReleased

        public void searchTable(String value) {
                TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(dtmSanPham);
                jTableDSSP36.setRowSorter(trs);
                trs.setRowFilter(RowFilter.regexFilter(value));
        }
        
        private void loadDataComboboxNhanVienBan() {
                jComboBoxNhanVien36.removeAllItems();
                ArrayList<NhanVien> dsnv = nvBUS.getDanhSachNhanVien();
                if (dsnv != null) {
                        for (NhanVien nv : dsnv) {
                                jComboBoxNhanVien36.addItem(nv.getMaNV() + " - " + nv.getHo() + " " + nv.getTen());
                        }
                }

                for (int i = 0; i < jComboBoxNhanVien36.getItemCount(); i++) {
                        String[] cmbValue = jComboBoxNhanVien36.getItemAt(i).split(" - ");
                        if (cmbValue[0].equals(DangNhapBUS.taiKhoanLogin.getMaNhanVien() + "")) {
                                jComboBoxNhanVien36.setSelectedIndex(i);
                                break;
                        }
                }
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonThemGH36;
    private javax.swing.JButton jButtonXoaChonGH36;
    private javax.swing.JButton jButtonXuatHD36;
    private javax.swing.JComboBox<String> jComboBoxLoaiSP36;
    private javax.swing.JComboBox<String> jComboBoxNhanVien36;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelCTSP36;
    private javax.swing.JLabel jLabelDSSP36;
    private javax.swing.JLabel jLabelGioHang36;
    private javax.swing.JLabel jLabelImageSP36;
    private javax.swing.JLabel jLabelRefreshDb62;
    private javax.swing.JPanel jPanelTTCTSP36;
    private javax.swing.JPanel jPanelView62;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPaneSanPham62;
    private javax.swing.JSpinner jSpinnerSoLuong36;
    private javax.swing.JTable jTableDSSP36;
    private javax.swing.JTable jTableGioHang36;
    private javax.swing.JTextField jTextFieldDonGia36;
    private javax.swing.JTextField jTextFieldMaSP36;
    private javax.swing.JTextField jTextFieldSearch62;
    private javax.swing.JTextField jTextFieldTenSP36;
    // End of variables declaration//GEN-END:variables
}
