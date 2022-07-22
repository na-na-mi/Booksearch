package 窗口化设计;

import org.junit.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Thread.sleep;

//查找图书窗口
public class search_main_window extends JFrame{
    private JFrame frame = new JFrame("查找主页面");

    private JButton jb1 = new JButton("书名");
    private JButton jb2 = new JButton("作者名");
    private JButton jb3 = new JButton("评分高于某一分数的作品");
    private JButton jb4 = new JButton("通过出版社查找");
    private JLabel jl1 = new JLabel("请选择你要查找的方式");



    public search_main_window() {
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new search_name_window();
            }
        });
        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { new search_author_window();

            }
        });
        jb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { new search_score_window();

            }
        });
        jb4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            new search_publisher_window();
            }
        });
        frame.setLayout(null);
        jb1.setBounds(100, 60, 180, 30);
        jb2.setBounds(100, 130, 180, 30);
        jb3.setBounds(100,200,180,30);
        jb4.setBounds(100,270,180,30);
        jl1.setBounds(150, 15, 200, 35);

        frame.setSize(450, 380);
        frame.setLocation(300, 200);
        frame.add(jb1);
        frame.add(jb2);
        frame.add(jb3);
        frame.add(jb4);
        frame.add(jl1);
        frame.setVisible(true);
    }
    @Test
    public void Test() throws InterruptedException {
        new search_main_window();
        sleep(90000);
    }
}
