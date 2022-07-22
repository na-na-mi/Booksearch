package 窗口化设计;

import org.junit.Test;
import 连接数据库.basicDao;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Thread.sleep;

public class search_publisher_window extends JFrame {
    private JLabel jl1 = new JLabel("出版社名");
    private JTextField bookname=new JTextField();//设置文本框
    private JButton jb1 = new JButton("查找");
    private TableColumn column;


    Object[][] a;


    public search_publisher_window(){
        setLayout(null);
        JPanel jp = new JPanel();
        setSize(800,600);
        jp.setLayout(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);


//        jp.setLocation(300, 200);
        jp.add(jl1);
        jp.add(bookname);
        jp.add(jb1);
        jl1.setBounds(40,50,50,30);
        bookname.setBounds(95,50,90,30);
        jb1.setBounds(280,50,70,30);
        setLocationRelativeTo(null);
        setContentPane(jp);
        setVisible(true);
        validate();

        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bname = bookname.getText();
                a = basicDao.searchPublisherName(bname);
                Object[] name1 = {"name", "author", "publisher", "price", "score", "comment", "Link"};
                JTable jt = new JTable(a, name1);
                jp.add(jt);
                jt.setBounds(0, 150, 800, 400);

                jt.getColumnModel().getColumn(0).setPreferredWidth(100);
                jt.getColumnModel().getColumn(1).setPreferredWidth(85);
                jt.getColumnModel().getColumn(2).setPreferredWidth(125);
                jt.getColumnModel().getColumn(3).setPreferredWidth(65);
                jt.getColumnModel().getColumn(4).setPreferredWidth(25);
                jt.getColumnModel().getColumn(5).setPreferredWidth(280);
                jt.getColumnModel().getColumn(6).setPreferredWidth(300);

            }
        });
    }
    @Test
    public void Test() throws InterruptedException {
        new search_publisher_window();
        sleep(90000);
    }


}
