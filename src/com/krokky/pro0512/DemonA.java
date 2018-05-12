package com.krokky.pro0512;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class DemonA {
    public static void main(String[] args) {
        try {
            File file = new File("E://1.png");//图片文件
            OutputStream os = new FileOutputStream(file);
            int width = 400;
            int height = 320;
            int imageType = BufferedImage.TYPE_INT_RGB;
            //图片流
            BufferedImage image = new BufferedImage(width, height, imageType);

            //动笔
            Graphics g = image.getGraphics();
            Color color1 = new Color(10, 255, 255);
            g.setColor(color1);
            g.fillRect(0, 0, width, height);

            //画一条线
            Color color2 = new Color(0, 0, 255);
            g.setColor(color2);
            g.drawLine(0, 0, 400, 320);

            //写入内容
            Color color3 = new Color(255, 0, 0);
            Font font = new Font("黑体", Font.PLAIN, 40);
            g.setFont(font);
            g.setColor(color3);
            g.drawString("krokky", 30, 50);
            //生成
            ImageIO.write(image, "png", os);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
