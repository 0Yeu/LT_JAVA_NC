package main;

import view.DangNhapJFrame;

public class Main {

        public static void main(String[] args) {
                DangNhapJFrame login = new DangNhapJFrame();
                login.showWindow();
        }

        public static void changLNF(String nameLNF) {
                try {
                        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                                if (nameLNF.equals(info.getName())) {
                                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                                        break;
                                }
                        }
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
                }
        }
}
