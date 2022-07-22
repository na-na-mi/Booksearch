package 登陆注册;

import 窗口化设计.main_window;
import 连接数据库.basicDao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class super_window extends JFrame{
    private JFrame frame=new JFrame("超级用户登陆");
    private JTextField name=new JTextField();//设置文本框
    private JPasswordField pass=new JPasswordField();
    private JLabel but1=new JLabel("用户名:");
    private JLabel but2=new JLabel("密   码:");
    private JButton but3=new JButton("登录");
    private boolean flag=false;
    public super_window(){


        System.out.println("正在核对中。。。");

        //Statement st=null;
        //3.获取数据库操作对象
        //st=conn.createStatement();
        //4.执行sql语句
        //String sql="select username from t_user where username='"+name+"' and password='"+pwd+"'";
        //定义sql语句框架


        but3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sname=name.getText();
                //System.out.println("请输入您的密码");
                String spass=pass.getText();
                if(basicDao.signin(sname, spass))
                {
                    System.out.println("登陆成功!!!");
                    new main_window();
                    frame.dispose();
                }
                else
                {

                    System.out.println("您输入的用户名或密码错误");
                }
            }
        });
        frame.setLayout(null);
        but1.setBounds(80, 40 , 80,30);
        but3.setBounds(140,160,80,30);
        but2.setBounds(80, 80 , 80,30);
        name.setBounds(140,42, 120, 25);
        pass.setBounds(140,82, 120, 25);
        frame.setSize(400,330);
        frame.setLocation(300, 200);
        frame.add(but1);
        frame.add(but2);
        frame.add(but3);
        frame.add(name);
        frame.add(pass);
        frame.setVisible(true);
    }

    }

