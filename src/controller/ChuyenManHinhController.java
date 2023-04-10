package controller;

import bean.DanhMucBean;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import view.BanHang.BanHangJPanel;
import view.BanHang.BanHangMenuJPanel;
import view.HoaDon.HoaDonJPanel;
import view.KhachHang.KhachHangJPanel;
import view.SanPham.SanPhamJPanel;

public class ChuyenManHinhController {

        private JPanel root;
        private String kindSelected = "";

        private List<DanhMucBean> listItem = null;

        public ChuyenManHinhController(JPanel jPanelRoot) {
                this.root = jPanelRoot;
        }

        public void setView(JPanel jPanelItem, JLabel jLabelItem) {
                kindSelected = "BanHang";
                jPanelItem.setBackground(new Color(51, 202, 187));
                jLabelItem.setBackground(new Color(51, 202, 187));

                root.removeAll();
                root.setLayout(new BorderLayout());
                root.add(new BanHangJPanel());
                root.validate();
                root.repaint();
        }

        public void setViewMenu(JPanel jPanelItem, JLabel jLabelItem) {
                kindSelected = "BanHangMenu";

                root.removeAll();
                root.setLayout(new BorderLayout());
                root.add(new BanHangMenuJPanel());
                root.validate();
                root.repaint();
        }

        public void setEvent(List<DanhMucBean> listItem) {
                this.listItem = listItem;
                for (DanhMucBean item : listItem) {
                        item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
                }
        }

        class LabelEvent implements MouseListener {

                private JPanel node;

                private String kind;
                private JPanel jPanelItem;
                private JLabel jLabelItem;

                public LabelEvent(String kind, JPanel jPanelItem, JLabel jLabelItem) {
                        this.kind = kind;
                        this.jPanelItem = jPanelItem;
                        this.jLabelItem = jLabelItem;
                }

                @Override
                public void mouseClicked(MouseEvent e) {
                        switch (kind) {
                                case "BanHang":
                                        node = new BanHangJPanel();
                                        break;
                                case "BanHangMenu":
                                        node = new BanHangMenuJPanel();
                                        break;
                                case "HoaDon":
                                        node = new HoaDonJPanel();
                                        break;
                                case "SanPham":
                                        node = new SanPhamJPanel();
                                        break;
                                case "NhanVien":
                                        node = new BanHangJPanel();
                                        break;
                                case "KhachHang":
                                        node = new KhachHangJPanel();
                                        break;
                                case "ThongKe":
                                        node = new BanHangJPanel();
                                        break;
                                // more
                                default:
                                        node = new BanHangJPanel();
                                        break;
                        }
                        root.removeAll();
                        root.setLayout(new BorderLayout());
                        root.add(node);
                        root.validate();
                        root.repaint();
                        setChangeBackground(kind);
                }

                @Override
                public void mousePressed(MouseEvent e) {
                        kindSelected = kind;
                        jPanelItem.setBackground(new Color(51, 202, 187));
                        jLabelItem.setBackground(new Color(51, 202, 187));
                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {
                        if (!jPanelItem.getBackground().equals(new Color(51, 202, 187)) && !jLabelItem.getBackground().equals(new Color(51, 202, 187))) {
                                jPanelItem.setBackground(new Color(72, 88, 107));
                                jLabelItem.setBackground(new Color(72, 88, 107));
                        }
                }

                @Override
                public void mouseExited(MouseEvent e) {
                        if (!kindSelected.equalsIgnoreCase(kind)) {
                                jPanelItem.setBackground(new Color(255, 153, 0));
                                jLabelItem.setBackground(new Color(255, 153, 0));
                        }
                }

        }

        private void setChangeBackground(String kind) {
                for (DanhMucBean item : listItem) {
                        if (item.getKind().equalsIgnoreCase(kind)) {
                                item.getJpn().setBackground(new Color(51, 202, 187));
                                item.getJlb().setBackground(new Color(51, 202, 187));
                        } else {
                                item.getJpn().setBackground(new Color(255, 153, 0));
                                item.getJlb().setBackground(new Color(255, 153, 0));
                        }
                }
        }

}
