package 窗口化设计;

import org.junit.Test;
import 连接数据库.basicDao;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Thread.sleep;
//增加图书窗口
public class add_window extends JFrame{
    private JFrame frame=new JFrame("添加图书");
    private JTextField bookname=new JTextField();//设置文本框
    private JTextField author=new JTextField();//设置文本框
    private JTextField publisher=new JTextField();
    private JTextField price=new JTextField();
    private JTextField score=new JTextField();
    private JTextField comment=new JTextField();
    private JTextField link=new JTextField();
    private JLabel jl1=new JLabel("书名");
    private JLabel jl2=new JLabel("作者");

    private JLabel jl3=new JLabel("出版社");
    private JLabel jl4=new JLabel("价格");
    private JLabel jl5=new JLabel("评分");
    private JLabel jl6=new JLabel("评论");
    private JLabel jl7=new JLabel("链接");

    private JButton but1=new JButton("添加");


    public add_window(){

        but1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bname=  bookname.getText();
                String zuozhe = author.getText();
                String bpublisher = publisher.getText();
                String bprice = price.getText();
                float bscore = Float.parseFloat(score.getText());
                String bcomment = comment.getText();
                String blink = link.getText();

                basicDao.insertBook(bname, zuozhe,bpublisher,bprice,bscore,bcomment,blink);
            }
        });
        frame.setLayout(null);
        but1.setBounds(400, 350 , 80,30);
        bookname.setBounds(120, 50 , 150,38);
        author.setBounds(120, 92, 150,38);
        publisher.setBounds(120,133,150,40);
        price.setBounds(120,181,150,40);
        score.setBounds(120,222,150,40);
        comment.setBounds(120,263,200,40);
        link.setBounds(120,304,200,40);
        jl1.setBounds(70,50,45,30);
        jl2.setBounds(70,90,45,30);
        jl3.setBounds(70,140,45,30);
        jl4.setBounds(70,190,45,30);
        jl5.setBounds(70,235,45,30);
        jl6.setBounds(70,270,45,30);
        jl7.setBounds(70,300,45,30);
        frame.setSize(600,520);
        frame.setLocation(400, 340);
        frame.add(publisher);
        frame.add(price);
        frame.add(score);
        frame.add(comment);
        frame.add(link);
        frame.add(jl3);
        frame.add(jl4);
        frame.add(jl5);
        frame.add(jl6);
        frame.add(jl7);
        frame.add(but1);
        frame.add(bookname);
        frame.add(author);
        frame.add(jl1);
        frame.add(jl2);
        frame.setVisible(true);
    }
    @Test
    public void Test() throws InterruptedException {
        new add_window();
        sleep(90000);
    }
}
