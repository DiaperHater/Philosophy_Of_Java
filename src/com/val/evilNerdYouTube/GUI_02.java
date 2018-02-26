package com.val.evilNerdYouTube;

import javax.swing.*;
import java.awt.*;

public class GUI_02 extends JFrame {
    private JLabel label;

    GUI_02(){
        setTitle("val.inc");

        setLayout(new FlowLayout());
        label = new JLabel("Yo");
        label.setToolTipText("Nigga");
        add(label);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200, 100);

        setVisible(true);
    }

    public static void main(String[] args) {
        GUI_02 wnd = new GUI_02();
    }
}
