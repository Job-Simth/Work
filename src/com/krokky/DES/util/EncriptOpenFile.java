package com.krokky.DES.util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class EncriptOpenFile implements ActionListener {

    private JFrame frame;
    private JTextField inputText;
    private JTextField SecretKeyText;
    private JTextField outputText;

    public EncriptOpenFile(JFrame frame, JTextField inputText, JTextField secretKeyText, JTextField outputText) {
        this.frame = frame;
        this.inputText = inputText;
        this.SecretKeyText = secretKeyText;
        this.outputText = outputText;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //将文件选择窗体show出来
        FileDialog fileDialog = new FileDialog(frame, "打开", FileDialog.LOAD);
        fileDialog.setVisible(true);
        String path = fileDialog.getDirectory() + fileDialog.getFile();

        File file = new File(path);
        String newPath = "D:\\图片\\cache\\En" + file.getName();

        inputText.setText(path);
        outputText.setText(newPath);
        String keys = SecretKeyText.getText();
        cipherPic.EncriptPic(file, newPath, keys);
    }
}

