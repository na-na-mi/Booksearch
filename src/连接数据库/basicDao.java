package 连接数据库;

import org.junit.Test;


import java.sql.*;

public class basicDao {
    public static Connection getConn() {
        Connection con = null;
        Statement sql;
        ResultSet rs;

        try {
            Class.forName("com.mysql.cj.jdbc.Drivers");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String uri =
                "jdbc:mysql://localhost:3306/booklib";

        String user = "root";
        String password = "123456";

        try {
            con = DriverManager.getConnection(uri, user, password);// get link and sign in
            return con;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Test
    public void Test() {
        System.out.println(getConn());
    }


    public static void insertBook(String name, String author,String publisher,String price, float score,String comment,String link) {//添加书
        Connection connection = null;
        connection = getConn();
        try {
            String sql = "insert into book (name, author,publisher,price,score,comment,link) values (?, ?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, author);
            preparedStatement.setString(3, publisher);
            preparedStatement.setString(4, price);
            preparedStatement.setFloat(5, score);
            preparedStatement.setString(6, comment);
            preparedStatement.setString(7, link);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




    public static void deleteBook(String name) { //删除书
        Connection connection = null;
        connection = getConn();
        try {
            String sql = "delete from book  where name = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Object[][] searchBookName(String m_name) { //查找书
        Connection connection = null;
        connection = getConn();
        try {
            String sql = "select * from book  where name=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, m_name);
            ResultSet rs = preparedStatement.executeQuery();
            Object [][]a = new Object[1][7];
            if(rs.next()) {
                a[0][0] = rs.getString(1);
                //System.out.println(rs.getString(1));
                a[0][1] = rs.getString(2);
                a[0][2] = rs.getString(3);
                a[0][3] = rs.getString(4);
                a[0][4] = rs.getString(5);
                a[0][5] = rs.getString(6);
                a[0][6] = rs.getString(7);
            }
            //System.out.println(a[0][0]);
            return a;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static Object[][] searchAuthorName(String m_name) { //查找作者
        Connection connection = null;
        connection = getConn();
        try {
            String sql = "select * from book where author = trim(?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, m_name);
            ResultSet rs = preparedStatement.executeQuery();
            Object[][] a = new Object[5][7];
            int i = 0;
            while (rs.next()) {
                a[i][0] = rs.getString(1);

                //iystem.out.println(rs.getString(1));
                a[i][1] = rs.getString(2);

                a[i][2] = rs.getString(3);
                a[i][3] = rs.getString(4);
                a[i][4] = rs.getString(5);
                a[i][5] = rs.getString(6);
                a[i][6] = rs.getString(7);
                i++;
                //
            }
            return a;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static Object[][] searchScore(String m_name) { //查找评分
        Connection connection = null;
        connection = getConn();
        try {
            String sql = "select * from book where score > ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, m_name);
            ResultSet rs = preparedStatement.executeQuery();
            Object[][] a = new Object[1000][7];
            int i = 0;
            while (rs.next()) {
                a[i][0] = rs.getString(1);
                a[i][1] = rs.getString(2);
                a[i][2] = rs.getString(3);
                a[i][3] = rs.getString(4);
                a[i][4] = rs.getString(5);
                a[i][5] = rs.getString(6);
                a[i][6] = rs.getString(7);
                i++;
            }
            return a;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static Object[][] searchPublisherName(String m_name) { //查找作者
        Connection connection = null;
        connection = getConn();
        try {
            String sql = "select * from book where publisher = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, m_name);
            ResultSet rs = preparedStatement.executeQuery();
            Object[][] a = new Object[50][7];
            int i = 0;
            while (rs.next()) {
                a[i][0] = rs.getString(1);
                a[i][1] = rs.getString(2);
                a[i][2] = rs.getString(3);
                a[i][3] = rs.getString(4);
                a[i][4] = rs.getString(5);
                a[i][5] = rs.getString(6);
                a[i][6] = rs.getString(7);
                i++;
            }
            return a;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static boolean signin(String name, String pwd) {
        String sql="select * from admin where name= ? and passwd = ?";
        //sql语句进行预编译
        Connection conn=null;
        ResultSet rs=null;
        PreparedStatement ps=null;
        boolean flag = false;
        try {
            conn = basicDao.getConn();
            ps=conn.prepareStatement(sql);
            //对sql语句进行赋值
            ps.setString(1, name);
            ps.setString(2, pwd);
            rs=ps.executeQuery();
            //rs=st.executeQuery(sql);
            if(rs.next())
            {
                flag = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally
        {
            if(rs!=null)
            {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            if(ps!=null)//st!=null
            {
                //st.close();
                try {
                    ps.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            if(conn!=null)
            {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        return flag;
    }
    @Test
    public void test() {
        System.out.println(signin("root", "12345678"));
    }
}



