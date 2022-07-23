package 连接数据库;

import java.sql.*;
public class Appmain {
    public static void main(String[] args) throws Exception {
        Connection con = null;
        Statement sql;
        ResultSet rs;

        try {
            Class.forName("com.mysql.cj.jdbc.Drivers");        
        } catch (Exception e) {
        e.printStackTrace();
        }
        String uri =
        "jdbc:mysql://localhost:3306/booklib";
       
        String user = "root";
        String password = "123456";

        try {
            con = DriverManager.getConnection(uri, user, password);// get link and sign in
            System.out.println(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {

            
            sql = con.createStatement();
            rs = sql.executeQuery("select * from book where score > 9.1");
            
            while(rs.next()){
                String name = rs.getString(1);
                String author = rs.getString(2);
                String publisher = rs.getString(3);
                String comment = rs.getString(6);
                String price = rs.getString(4);
                String link = rs.getString(7);
                System.out.printf("%s\t\t",name);
                System.out.printf("%s\t",author);
                System.out.printf("%s\t",publisher);
                System.out.printf("%s\t",price);
                System.out.printf("%s\t\t",comment);
                System.out.printf("%s\n",link);
            }
            con.close();
        } catch (SQLException e) {
        System.out.println("没有找到相关内容");
        }
    }
}
