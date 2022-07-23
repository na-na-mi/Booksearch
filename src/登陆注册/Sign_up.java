package 登陆注册;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class Sign_up {
 
	public static void main(String[] args) throws SQLException {

Scanner in =new Scanner(System.in);
System.out.println("欢迎来控制台进行注册");
System.out.println("请输入您要注册的用户名");
String name=in.nextLine();
System.out.println("请输入您的密码");
String pwd=in.nextLine();
Connection conn=null;
Statement st=null;
int count=0;
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	String url="jdbc:mysql://localhost:3306/booklib";
	String user="root";
	String password="123456";
	conn=DriverManager.getConnection(url, user, password);
	st=conn.createStatement();
	String sql="insert into info(name,passwd) values('"+name+"','"+pwd+"')";
	count=st.executeUpdate(sql);
} catch (ClassNotFoundException e) {

	e.printStackTrace();
}finally
{
	if(st!=null)
	{
		st.close();
	}
	if(conn!=null)
	{
		conn.close();
	}
}
if(count==1)
{
	System.out.println("注册成功!!!");
	}
else
{
	System.out.println("注册失败!!!");
}
in.close();
	}

}