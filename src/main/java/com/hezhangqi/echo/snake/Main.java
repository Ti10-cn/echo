package com.hezhangqi.echo.snake;

/**
 * @author hezhangqi
 * @description 开始
 * @date 2024/6/18 16:08:18
 */
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        GamePanel gamePanel = new GamePanel();
        frame.add(gamePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Snake Game");
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}