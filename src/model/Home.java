package model;

import java.awt.*;

public class Home extends GameObject{
    private static final int SIZE = 2;
    
    public Home(int x, int y) {
        super(x, y, SIZE, SIZE);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.magenta);

        int xc = getX();
        int yc = getY();
        int height = getHeight();
        int width = getWidth();
        
        graphics.drawOval(xc - width / 2, yc - height / 2, width, height);
    }
}
