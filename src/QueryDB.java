import java.nio.file.Path;
import java.sql.*;
import java.io.*;
import java.util.Scanner;

public class QueryDB {
    public static void main(String[] args) {
        Connection connection = null;
        Scanner scanner = new Scanner(System.in);
        int pieces;
        try {
            Class.forName("org.sqlite.JDBC");
            // 建立数据库连接
            connection = DriverManager.getConnection("jdbc:sqlite:kindlebooks.sqlite");

            System.out.println("Please input search keywords:");
            Statement statement = connection.createStatement();

            String search = scanner.nextLine();
            String sql = "SELECT * FROM books where book like '%" + search + "%'";
            ResultSet resultSet = statement.executeQuery(sql);
            pieces = 0;
            // 处理返回记录
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String book = resultSet.getString("book");
                System.out.println("id: " + id + ", book: " + book);
                pieces++;
            }
            System.out.printf("Total %d records found.\n",pieces);
            scanner.close();


        } catch (ClassNotFoundException e) {
            System.out.println("找不到SQLite JDBC驱动程序！");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("连接SQLite数据库失败！");
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("关闭SQLite数据库连接失败！");
                e.printStackTrace();
            }
        }
    }
}
