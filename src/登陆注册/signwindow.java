package 登陆注册;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Scanner;

import 窗口化设计.search_main_window;
import 连接数据库.basicDao;

public class signwindow {
    private JFrame frame=new JFrame("图书管理");
    private JTextField name=new JTextField();//设置文本框
    private JPasswordField pass=new JPasswordField();
    private JLabel but1=new JLabel("用户名:");
    private JLabel but2=new JLabel("密   码:");
    private JButton but3=new JButton("登录");
    private JButton but4=new JButton("注册");
//验证登陆信息。
    public signwindow(){
        but3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Scanner in =new Scanner(System.in);

                System.out.println("正在核对中。。。");
                String sname=name.getText();
                //System.out.println("请输入您的密码");
                String spass=new String(pass.getPassword());
                //Statement st=null;
                    //3.获取数据库操作对象
                    //st=conn.createStatement();
                    //4.执行sql语句
                    //String sql="select username from t_user where username='"+name+"' and password='"+pwd+"'";
                    //定义sql语句框架
                    String sql="select name from info where name= ? and passwd = ?";
                    //sql语句进行预编译
                    Connection conn=null;
                    ResultSet rs=null;
                    PreparedStatement ps=null;
                    boolean flag=false;
                    try {
                        conn = basicDao.getConn();
                        ps=conn.prepareStatement(sql);
                    //对sql语句进行赋值
                    ps.setString(1, sname);
                    ps.setString(2, spass);
                    rs=ps.executeQuery();
                    //rs=st.executeQuery(sql);
                    if(rs.next())
                    {
                        flag=true;
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
                if(flag)
                {
                    System.out.println("登陆成功!!!");
                    new search_main_window();
                    frame.dispose();
                }
                else
                {
                    System.out.println("您输入的用户名或密码错误");
                }
                in.close();
            }
        });


        //注册

        but4.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        new sign_up_window();
                    }

                });

        frame.setLayout(null);
        but1.setBounds(80, 40 , 80,30);
        name.setBounds(140,42, 120, 25);
        but2.setBounds(80, 80 , 80,30);
        pass.setBounds(140,82, 120, 25);
        but3.setBounds(130, 150 , 60,30);
        but4.setBounds(210, 150 , 60,30);
        frame.setSize(400,330);
        frame.setLocation(300, 200);
        frame.add(but1);
        frame.add(name);
        frame.add(pass);
        frame.add(but2);
        frame.add(but3);
        frame.add(but4);
        frame.setVisible(true);
    }
}

