package com.krokky.DES.UI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ui extends JFrame implements WindowListener {
    public static void main(String[] args) {
        new ui();
    }

    private JLabel input, output, SecretKey;
    private JTextField inputText, outputText, SecretKeyText;
    private JButton Action;


    public ui() {
        setTitle("DES加密系统");
        setFont(new Font("", Font.BOLD, 24));
        setLayout(null);

        input = new JLabel("输入:");
        SecretKey = new JLabel("秘钥:");
        output = new JLabel("输出:");

        inputText = new JTextField();
        SecretKeyText = new JTextField();
        outputText = new JTextField();

        Action = new JButton("加密");

        input.setBounds(80, 20, 60, 30);
        SecretKey.setBounds(80, 60, 60, 30);
        output.setBounds(80, 100, 60, 30);

        inputText.setBounds(150, 20, 200, 30);
        SecretKeyText.setBounds(150, 60, 200, 30);
        outputText.setBounds(150, 100, 200, 30);

        Action.setBounds(140, 160, 180, 30);

        add(input);
        add(SecretKey);
        add(output);

        add(inputText);
        add(SecretKeyText);
        add(outputText);

        add(Action);

        Action.addActionListener(new Encrypt());

        setBounds(0, 0, PropertiesUtil.getWidth(), PropertiesUtil.getHeigth());
        setLocationRelativeTo(null);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addWindowListener(this);
        setVisible(true);
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        // 当点击关闭时执行
        System.out.println("执行关闭操作");
        // 修改配置文件中的宽和高
        PropertiesUtil.setWidth(this.getWidth());
        PropertiesUtil.setHeight(this.getHeight());
//        PropertiesUtil.setSize(textArea.getFont().getSize());

        // 释放内存
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    class Encrypt implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String s = SecretKeyText.getText();
            outputText.setText(s + "完成");
        }
    }

}
