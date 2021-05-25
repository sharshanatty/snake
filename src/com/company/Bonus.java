package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Bonus extends Rectangle{
    public Bonus(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public void draw(Graphics g) {
        //g.setColor(Color.green);
        File file = new File("apple.png");
        Image image = null;
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        g.drawImage(image, this.x, this.y, this.width, this.height, null);
       // g.drawRect(this.x, this.y, this.width, this.height);
    }
}
