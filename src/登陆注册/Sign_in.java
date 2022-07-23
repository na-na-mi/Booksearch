package 登陆注册;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.Scanner;

public class Sign_in {  
          public static void main(String[] args) throws ClassNotFoundException, SQLException {
            Scanner in =new Scanner(System.in);
            System.out.println("欢迎来控制台进行登录");
            System.out.println("请输入您的用户名");
            String name=in.nextLine();
            System.out.println("请输入您的密码");
            String pwd=in.nextLine();
            //Statement st=null;
            Connection conn=null;
            ResultSet rs=null;
            PreparedStatement ps=null;
            boolean flag=false;
             try {
                 Class.forName("com.mysql.cj.jdbc.Driver");
                    //2.获取数据库连接
                    String url="jdbc:mysql://localhost:3306/booklib";
                    String user="root";
                    String password="123456";
                conn=DriverManager.getConnection(url, user, password);
                //3.获取数据库操作对象
                //st=conn.createStatement();
                //4.执行sql语句
                //String sql="select username from t_user where username='"+name+"' and password='"+pwd+"'";
                //定义sql语句框架
                String sql="select name from info where name= ? and passwd = ?";
                //sql语句进行预编译
                ps=conn.prepareStatement(sql);
                //对sql语句进行赋值
                ps.setString(1, name);
                ps.setString(2, pwd);
                rs=ps.executeQuery();
                //rs=st.executeQuery(sql);
                if(rs.next())
                {
                    flag=true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally
             {
                if(rs!=null)
                {
                    rs.close();
                }
                if(ps!=null)//st!=null
                {
                    //st.close();
                    ps.close();
                }
                if(conn!=null)
                {
                    conn.close();
                }
             }
             if(flag)
             {
                 System.out.println("登陆成功!!!");
             }
             else
             {
                 System.out.println("您输入的用户名或密码错误");
             }
            in.close();
        }
     
    }

