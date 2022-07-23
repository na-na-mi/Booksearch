package 窗口化设计;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//图书管理选择窗口
public class main_window extends JFrame{
    private  JFrame frame=new JFrame("图书管理");

    private  JLabel jl1 = new JLabel("请选择你要执行的操作：");
    private  JButton but1=new JButton("增添图书");
    private  JButton but2=new JButton("删除图书");
    private JButton but3=new JButton("查找图书");



    public main_window() {
        but1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {new add_window();
            }
        });

        but2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new del_window();
            }

        });
        but3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new search_main_window();
            }
        });

        frame.setLayout(null);
        jl1.setBounds(150,60,140,35);
        but1.setBounds(60, 150 , 100,30);
        but2.setBounds(170, 150 , 100,30);
        but3.setBounds(280, 150 , 100,30);
        frame.setSize(500,330);
        frame.setLocation(300, 200);
        frame.add(jl1);
        frame.add(but1);
        frame.add(but2);
        frame.add(but3);
        frame.setVisible(true);

    }

}

