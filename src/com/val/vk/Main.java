package com.val.vk;


import com.google.gson.Gson;
import com.val.vk.exceptions.SendMessageErrorException;

import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

       VkMethods vk = new VkMethods(
               "fab62099e0c37da9e4d265129ef7d98735ee8982e96ad4b2c30447c148d36d888fc248b4979df4735b724",
               "204437607");

        System.out.println("new branch");

    }

    private static void showMessageDialog(String message) {
        JOptionPane.showMessageDialog(
                null,
                 message,
                "val.inc",
                JOptionPane.PLAIN_MESSAGE
        );
    }

}
