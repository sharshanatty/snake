package com.company;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Snake");
        jFrame.setBounds(10, 10, 500, 500);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add(new GamePanel());
        jFrame.setVisible(true);
    }
}
