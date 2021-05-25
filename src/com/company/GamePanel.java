package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel {
    private int keyPressed = 0;
    private Snake snake1 = new Snake(0, 0);
    private Bonus apple = new Bonus((int)(Math.random()*10) * 40, (int)(Math.random()*10) * 40, 40, 40);

    class GameKey implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            keyPressed = e.getKeyCode();
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    public GamePanel() {
        addKeyListener(new GameKey());
        setFocusable(true);
        new Timer(250, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (keyPressed) {
                    case 37: snake1.moveTo(Snake.LEFT); break;
                    case 39: snake1.moveTo(Snake.RIGHT); break;
                    case 38: snake1.moveTo(Snake.UP); break;
                    case 40: snake1.moveTo(Snake.DOWN); break;
                }

                if (snake1.list.getFirst().x == apple.x && snake1.list.getFirst().y == apple.y) {
                    snake1.list.addLast(snake1.list.getFirst());
                    apple = new Bonus((int)(Math.random()*10)*40, (int)(Math.random()*10)*40, 40, 40);
                }

                repaint();
            }
        }).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        snake1.draw(g);
        apple.draw(g);
        g.drawString("" + keyPressed, 10, 10);
    }

}
