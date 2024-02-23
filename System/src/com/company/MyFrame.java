package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {

    public static void main(String[] args) {
        new MyFrame();
    }

    public MyFrame() {
        JPanel jp1 = new JPanel();
        JLabel jl1 = new JLabel("学号:");
        JTextField stuIdText = new JTextField(15);

        jp1.setLayout(new FlowLayout());
        jp1.add(jl1);
        jp1.add(stuIdText);

        JPanel jp2 = new JPanel();
        JLabel jl2 = new JLabel("课程代码:");
        JTextField courseIdText = new JTextField(15);

        jp2.setLayout(new FlowLayout());
        jp2.add(jl2);
        jp2.add(courseIdText);

        JPanel jp3 = new JPanel();
        JLabel jl3 = new JLabel("成绩:");
        JTextField score = new JTextField(15);

        jp3.setLayout(new FlowLayout());
        jp3.add(jl3);
        jp3.add(score);

        JButton search = new JButton("查询");
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String stuId = stuIdText.getText();
                String courseId = courseIdText.getText();
                int res = StudentService.search(stuId,courseId);

                if (res == -1) {
                    score.setText("无此人或课程");
                } else {
                    score.setText(res + "");
                }
            }
        });
        JPanel jp4 = new JPanel();
        jp4.setLayout(new FlowLayout());
        jp4.add(search);

        setLayout(new GridLayout(4, 1));
        add(jp1);
        add(jp2);
        add(jp3);
        add(jp4);
        setSize(500, 300);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
