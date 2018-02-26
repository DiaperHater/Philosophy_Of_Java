package com.val.evilNerdYouTube.GUI_03_JFrame_JOptionPane_JTextField_JPasswordField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {

    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JPasswordField passwordField;

    public Main(){
        textField1 = new JTextField(10);
        textField2 = new JTextField("Enter you'r password!");
        textField3 = new JTextField("Static field", 20);
        textField3.setEditable(false);
        passwordField = new JPasswordField("password");

        setLayout(new FlowLayout());

        add(textField1);
        add(textField2);
        add(textField3);
        add(passwordField);

        Handler handler = new Handler();
        textField1.addActionListener(handler);
        textField2.addActionListener(handler);
        textField3.addActionListener(handler);
        passwordField.addActionListener(handler);

        setTitle("Val.inc");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 100);
        setVisible(true);
    }

    private class Handler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String string = "";

            if(e.getSource() == textField1){
                string = String.format("textField1: %s", e.getActionCommand());
            }
            else if(e.getSource() == textField2){
                string = String.format("textField2: %s", e.getActionCommand());
            }
            else if(e.getSource() == textField3){
                string = String.format("textField3: %s", e.getActionCommand());
            }
            else if(e.getSource() == passwordField){
                string = String.format("passwordField: %s", e.getActionCommand());
            }

            JOptionPane.showMessageDialog(null, string);
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
