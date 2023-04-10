package custom;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

public class MyTable {

        public MyTable(JTable tbl) {
                JTableHeader header = tbl.getTableHeader();
                header.setBackground(new Color(242, 153, 74));
                header.setFont(new Font("Tahoma", Font.BOLD, 14));
                header.setOpaque(false);
                header.setForeground(Color.WHITE);
                header.setReorderingAllowed(false);
                ((DefaultTableCellRenderer) header.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
                tbl.setRowHeight(25);
        }
}
