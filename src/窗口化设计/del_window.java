package 窗口化设计;

import org.junit.Test;
import 连接数据库.basicDao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Thread.sleep;
//删除图书窗口
public class del_window extends JFrame {
    private JFrame frame=new JFrame("删除图书");
    private JTextField bookname=new JTextField();//设置文本框
    private JLabel jl1=new JLabel("书名");

    private JLabel jl2=new JLabel("目前仅支持通过书名来删除图书");
    private JButton but1=new JButton("删除");



    public del_window(){
        but1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bname=  bookname.getText();

                basicDao.deleteBook(bname);
            }
        });
        frame.setLayout(null);
        but1.setBounds(340, 120 , 80,30);
        bookname.setBounds(130, 120 , 150,35);
        jl2.setBounds(150,300,180,30);
        jl1.setBounds(80,120,45,30);

        frame.setSize(500,380);
        frame.setLocation(300, 200);
        frame.add(but1);
        frame.add(jl2);
        frame.add(bookname);

        frame.add(jl1);
        frame.setVisible(true);
    }
    @Test
    public  void Test() throws InterruptedException {
        new del_window();
        sleep(90000);
    }
}
