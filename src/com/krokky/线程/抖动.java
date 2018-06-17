package com.krokky.线程;

import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class 抖动 extends JFrame {
    int x;
    int i = 1;

    public 抖动() {
        setBounds(0, 0, 420, 200);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);

        x = this.getX();

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                if (i % 2 == 0) {
                    x -= 10;
                } else {
                    x += 10;
                }
                setBounds(x, getY(), getWidth(), getHeight());
                i++;
            }
        }, 0, 10);

    }

    public static void main(String[] args) {
        new 抖动();
    }
}


