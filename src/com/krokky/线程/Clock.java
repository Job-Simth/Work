package com.krokky.线程;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Clock extends JFrame {
    private JLabel jl;
    public Clock(){
        jl = new JLabel(getNowDate(),SwingConstants.CENTER);
        jl.setFont(new Font("",Font.BOLD,40));
        jl.setForeground(new Color(0xCF5BFF));
        add(jl);
        int width = 165;
        setBounds(1920-width,0,width,40);
//        setLocationRelativeTo(null);
        setUndecorated(true);
        setBackground(new Color(0,0,0,0));
        setAlwaysOnTop(true);
        setVisible(true);

        Timer timer = new Timer();
        timer.schedule(new LabelChange(jl,this),0,1000);
    }

    public static void main(String[] args) {
        new Clock();
    }
    public String getNowDate(){
        Date date =new Date();
        SimpleDateFormat ft = new SimpleDateFormat("HH:mm:ss");
        return ft.format(date);
    }
}
class LabelChange extends TimerTask {
    private JLabel jl;
    private Clock t;

    public LabelChange(JLabel jl, Clock t) {
        this.jl = jl;
        this.t = t;
    }

    @Override
    public void run() {
        jl.setText(t.getNowDate());
    }
}