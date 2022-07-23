package 登陆注册;

import 连接数据库.basicDao;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static java.lang.System.in;

public class sign_up_window extends JFrame {
    private JFrame jf1 = new JFrame("注册新用户");

    private JTextField name=new JTextField();//设置文本框
    private JPasswordField pass=new JPasswordField();
    private JPasswordField pass2= new JPasswordField();
    private JLabel jl1=new JLabel("用户名:");
    private JLabel jl2=new JLabel("密   码:");
    private JLabel jl3=new JLabel("再次输入密码");
    private JButton jb1=new JButton("确认");


    public sign_up_window(){
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            String uname = name.getText();
            String upass = new String(pass.getPassword());
            String upass2 = new String(pass2.getPassword());
                Connection conn = null;
                Statement st = null;
                int count = 0;
                try {
                    conn = basicDao.getConn();
                    st = conn.createStatement();
                    String sql = "insert into info(name,passwd) values('" + uname + "','" + upass + "')";
                    count = st.executeUpdate(sql);
                } catch (Exception ex) {

                    ex.printStackTrace();
                } finally {
                    if (st != null) {
                        try {
                            st.close();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                    if (conn != null) {
                        try {
                            conn.close();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
                if (count == 1 && upass.equals(upass2) ) {
                    System.out.println("注册成功!!!");
                   // jf1.dispose();
                    new signwindow();
                } else {
                    System.out.println("注册失败!!!");
                }
                try {
                    in.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }

        });
        jf1.setLayout(null);
        jl1.setBounds(80, 40 , 80,30);
        name.setBounds(140,42, 120, 25);    //
        jl2.setBounds(80, 80 , 80,30);
        pass.setBounds(140,82, 120, 25);
        jl3.setBounds(40, 120 , 80,30);
        pass2.setBounds(140, 120 , 120,25);
        jb1.setBounds(140,180,60,30);
        jf1.setSize(400,330);
        jf1.setLocation(300, 200);
        jf1.add(jb1);
        jf1.add(jl1);
        jf1.add(name);
        jf1.add(pass);
        jf1.add(jl2);
        jf1.add(jl3);
        jf1.add(pass2);
        jf1.setVisible(true);

    }
}
