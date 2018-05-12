package com.krokky.pro0512;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DemonC extends JFrame {
    private JLabel name, pass, card, imageCard;
    private JTextField nameText, passText, cardText;
    private JButton login;
    private int width = 100, height = 30;
    private String str = "";

    public DemonC() {
        setTitle("登录窗体");
        setFont(new Font("", Font.BOLD, 24));
        setLayout(null);//自定义布局

        //负责产生验证码图片
        Icon icon = new ImageIcon(getCardImage(width, height));
        name = new JLabel("账 号");
        pass = new JLabel("密 码");
        card = new JLabel("验证码");
        imageCard = new JLabel(icon);

        nameText = new JTextField();
        passText = new JTextField();
        cardText = new JTextField();

        login = new JButton("登 录");

        name.setBounds(80, 20, 60, 30);
        pass.setBounds(80, 60, 60, 30);
        card.setBounds(80, 100, 60, 30);
        imageCard.setBounds(240, 100, width, height);

        nameText.setBounds(150, 20, 200, 30);
        passText.setBounds(150, 60, 200, 30);
        cardText.setBounds(150, 100, 80, 30);

        login.setBounds(120, 160, 220, 30);

        add(name);
        add(pass);
        add(card);
        add(imageCard);

        add(nameText);
        add(passText);
        add(cardText);

        add(login);

        //注册事件
        addMouseListener(new ChangeCard());

        setBounds(0, 0, 450, 260);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public Image getCardImage(int width, int height) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics g = image.getGraphics();
        int red1 = (int) (Math.random() * 256);
        int green1 = (int) (Math.random() * 256);
        int blue1 = (int) (Math.random() * 256);
        Color c1 = new Color(red1, green1, blue1);

        g.setColor(c1);
        g.fillRect(0, 0, width, height);


        //生成文字
        int red2 = (int) (Math.random() * 256);
        int green2 = (int) (Math.random() * 256);
        int blue2 = (int) (Math.random() * 256);
        Color c2 = new Color(red2, green2, blue2);
        str = "";
        for (int i = 0; i < 4; i++) {
            char ch = (char) ((int) (Math.random() * 26 + 65));
            str += ch;
        }
        g.setColor(c2);
        int x = (int) (Math.random() * (width / 3));
        int y = (int) (Math.random() * (height / 2) + 10);
        g.setFont(new Font("", Font.BOLD, 24));
        g.drawString(str, x, y);

        return image;
    }

    //监听类:鼠标单击时执行
    class ChangeCard implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            Icon icon = new ImageIcon(getCardImage(width, height));
            imageCard.setIcon(icon);
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

    }

    public static void main(String[] args) {
        new DemonC();
    }
}