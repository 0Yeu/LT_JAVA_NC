package dao;

import custom.MyDialog;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnect {

        private static String severName;
        private static String userName;
        private static String password;

        public static Connection getJDBCConnection() throws SQLException {
                docFileText();
                final String url = "jdbc:sqlserver://" + severName + ":1433;databaseName = EOE";

                try {
                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                        return DriverManager.getConnection(url, userName, password);
                } catch (ClassNotFoundException | SQLException e) {
                        new MyDialog("Không kết nối được tới CSDL!", MyDialog.ERROR_DIALOG);
                }

                return null;
        }

        private static void docFileText() {
                // Xử lý đọc file để lấy ra 4 tham số
                severName = "";
                userName = "";
                password = "";

                try {
                        FileInputStream fis = new FileInputStream("src/ConnectVariable.txt");
                        InputStreamReader isr = new InputStreamReader(fis);
                        BufferedReader br = new BufferedReader(isr);

                        severName = br.readLine();
                        userName = br.readLine();
                        password = br.readLine();

                        if (password == null) {
                                password = "";
                        }

                } catch (Exception e) {
                }
        }
}
