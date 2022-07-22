package 登陆注册;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class choose_window {
    private JFrame frame=new JFrame("选择用户");
    private JButton but1=new JButton("超级用户");
    private JButton but2=new JButton("普通用户");

    public choose_window(){
        but2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            new signwindow();
            }
        });
        but1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new super_window();
            }
        });
        frame.setLayout(null);
        but1.setBounds(140, 50 , 110,30);
          //
        but2.setBounds(140, 120 , 110,30);
        frame.setSize(400,330);
        frame.setLocation(300, 200);
        frame.add(but1);
        frame.add(but2);
        frame.setVisible(true);

           }
}
