package com.krokky.pro0421.扩展;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

public class Surface extends JFrame {

    private JButton button;
    public Surface(){
        //设置标题
        this.setTitle("我的第一个窗口");
        //处理控件
        button = new JButton("确定");
        this.add(button);
        //点击的时候，执行函数(动作)
        button.addActionListener(new ActionA(this));
        //设置位置(x轴，y轴，长，宽)
        this.setBounds(500,300,400,220);
        this.setLocationRelativeTo(null);
        //设置关闭
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //显示界面
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Surface();
    }
    class ActionA implements ActionListener{
        //声明了一个属性
        JFrame frame;
        //通过构造器对这个属性传值
        public ActionA(JFrame frame){
            this.frame=frame;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.setTitle("修改了");
        }
    }
}
