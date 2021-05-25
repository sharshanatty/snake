package com.company;

import java.awt.*;
import java.util.LinkedList;

public class Snake {
    LinkedList<Rectangle> list = new LinkedList<>();
    private int w = 40, h = 40;
    public static final int LEFT = 0, RIGHT = 1, UP = 2, DOWN = 3;

    public Snake(int x, int y) {
        list.add(new Rectangle(x, y, w, h));
        list.add(new Rectangle(x + w, y, w, h));
        list.add(new Rectangle(x + 2 * w, y, w, h));
        list.add(new Rectangle(x + 3 * w, y, w, h));
    }

    public void moveTo(int to) {
        Rectangle head = (Rectangle) list.getFirst().clone();
        list.pollLast();
        switch (to) {
            case LEFT:
                head.x -= w;
                break;
            case RIGHT:
                head.x += w;
                break;
            case UP:
                head.y -= h;
                break;
            case DOWN:
                head.y += w;
                break;
        }
        list.addFirst(head);
    }

    public void draw(Graphics g) {
        for(Rectangle r : list) {
            g.setColor(Color.red);
            g.drawRect(r.x, r.y, w, h);
        }
    }
}
