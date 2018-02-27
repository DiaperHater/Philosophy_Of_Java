package com.val.vk;


import com.google.gson.Gson;
import com.val.vk.exceptions.SendMessageErrorException;
import javafx.application.Application;
import javafx.stage.Stage;

import javax.swing.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println(Login.getTokenUrl());

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
