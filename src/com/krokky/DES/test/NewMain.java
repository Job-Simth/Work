package com.krokky.DES.test;

import com.krokky.DES.ProcessingInput;
import com.krokky.DES.util.DecriptOpenFile;
import com.krokky.DES.util.EncriptOpenFile;
import com.krokky.DES.util.PropertiesUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class NewMain extends JFrame implements WindowListener {
    public static void main(String[] args) {
        new com.krokky.DES.test.NewMain();
    }

    private JLabel Input, Output, SecretKey;
    private JTextField inputText, secretKeyText, outputText;
    private JButton Encrypt, Decrypt, EncryptPic, DecryptPic;


    public NewMain() {
        setTitle("DES加密系统");
        setFont(new Font("", Font.BOLD, 24));
        setLayout(null);

        Input = new JLabel("输入:");
        SecretKey = new JLabel("秘钥:");
        Output = new JLabel("输出:");

        inputText = new JTextField();
        secretKeyText = new JTextField();
        outputText = new JTextField();

        Encrypt = new JButton("加密");
        Decrypt = new JButton("解密");
        EncryptPic = new JButton("加密图片");
        DecryptPic = new JButton("解密图片");

        Input.setBounds(80, 20, 60, 30);
        SecretKey.setBounds(80, 60, 60, 30);
        Output.setBounds(80, 100, 60, 30);

        inputText.setBounds(150, 20, 200, 30);
        secretKeyText.setBounds(150, 60, 200, 30);
        outputText.setBounds(150, 100, 200, 30);

        Encrypt.setBounds(50, 160, 60, 30);
        Decrypt.setBounds(120, 160, 60, 30);
        EncryptPic.setBounds(190, 160, 90, 30);
        DecryptPic.setBounds(290, 160, 90, 30);

        add(Input);
        add(SecretKey);
        add(Output);

        add(inputText);
        add(secretKeyText);
        add(outputText);

        add(Encrypt);
        add(Decrypt);
        add(EncryptPic);
        add(DecryptPic);

        Encrypt.addActionListener(new doEncrypt());
        Decrypt.addActionListener(new doDecrypt());
        EncryptPic.addActionListener(new EncriptOpenFile(this, inputText, secretKeyText, outputText));
        DecryptPic.addActionListener(new DecriptOpenFile(this, inputText, secretKeyText, outputText));

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

    private class doEncrypt implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String input = inputText.getText();
            String keys = secretKeyText.getText();
            try {
                outputText.setText(ProcessingInput.runCipherEncrypt(input, keys));
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    private class doDecrypt implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String input = inputText.getText();
            String keys = secretKeyText.getText();
            try {
                outputText.setText(ProcessingInput.runCipherDecrypt(input, keys));
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
}
