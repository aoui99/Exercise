import java.nio.file.Path;
import java.sql.*;
import java.io.*;
import java.util.Scanner;

public class SetUpDB {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Connection connection = null;
        String menu = "";
        try {
            Class.forName("org.sqlite.JDBC");
            // 建立数据库连接
            connection = DriverManager.getConnection("jdbc:sqlite:kindlebooks.sqlite");

            System.out.println("连接到SQLite数据库成功！");
            Statement statement = connection.createStatement();
            String search = "txt";

            Path filePath = Path.of("kindlebooks_index.txt");
            Scanner scanner = new Scanner(filePath);
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                if (line.endsWith(":")) {
                    menu = line.replace(":","/");
                    menu = menu.replace(".","");
                }
                String regex = ".*\\.(txt|azw3|mobi|epub)$";
                boolean isMatch = line.matches(regex);
                if (isMatch){
                    String directory = menu + line;
                    System.out.println(directory);
                    String sql = "INSERT INTO books VALUES(null,\"" + directory + "\");";
                    statement.execute(sql);
                    /*ResultSet resultSet = statement.executeQuery(sql);
                    while (resultSet.next()){
                        int id = resultSet.getInt("ID");
                        String book = resultSet.getString("book");
                        System.out.println("id:"+id+"book:"+book);
                    }*/
                }
            }
            scanner.close();
            long endTime = System.currentTimeMillis();
            long executionTime = endTime - startTime;

            System.out.println("程序执行时间：" + executionTime + "毫秒");



        } catch (ClassNotFoundException e) {
            System.out.println("找不到SQLite JDBC驱动程序！");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("连接SQLite数据库失败！");
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
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
