package 窗口化设计;

import org.junit.Test;
import 连接数据库.basicDao;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Thread.sleep;

public class search_score_window extends JFrame {

    private JLabel jl1 = new JLabel("评分高于");
    private JLabel jl2 =new JLabel("分数处于1~10之间");
    private JTextField bookscore=new JTextField();//设置文本框
    private JButton jb1 = new JButton("查找");
    private TableColumn column;


    Object[][] a;


    public search_score_window(){
        setLayout(null);
        JPanel jp = new JPanel();
        setSize(800,600);
        jp.setLayout(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(jp);
        setVisible(true);
        validate();

//        jp.setLocation(300, 200);
        jp.add(jl1);
        jp.add(jl2);
        jp.add(bookscore);
        jp.add(jb1);
        jl1.setBounds(40,50,50,30);
        jl2.setBounds(90,70,140,30);
        bookscore.setBounds(95,50,90,30);
        jb1.setBounds(240,50,70,30);

        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 String score = bookscore.getText();
                 //float f =Float.valueOf(score);
                a = basicDao.searchScore(score);
                Object[] name1 = {"name", "author", "publisher", "price", "score", "comment", "Link"};
                JTable jt = new JTable(a, name1);
                jp.add(jt);
                jt.setBounds(0, 100, 800, 500);

                jt.getColumnModel().getColumn(0).setPreferredWidth(80);
                jt.getColumnModel().getColumn(1).setPreferredWidth(100);
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
        new search_score_window();
        sleep(90000);
    }

}