package view;

import controller.EventListener;
import model.Direction;
import model.GameObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Set;

public class Field extends JPanel {
    private View view;
    private EventListener eventListener;

    public Field(View view) {
        this.view = view;
        addKeyListener(new KeyHandler());
        setFocusable(true);
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.setColor(Color.PINK);
        graphics.fillRect(0, 0, getWidth(), getHeight());

        Set<GameObject> gameObjects = view.getGameObjects().getAll();

        for (GameObject gameObject : gameObjects) {
            gameObject.draw(graphics);
        }
    }

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public class KeyHandler extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_LEFT) {
                eventListener.move(Direction.LEFT);
            } else if (key == KeyEvent.VK_RIGHT) {
                eventListener.move(Direction.RIGHT);
            } else if (key == KeyEvent.VK_UP) {
                eventListener.move(Direction.UP);
            } else if (key == KeyEvent.VK_DOWN) {
                eventListener.move(Direction.DOWN);
            } else if (key == KeyEvent.VK_R) {
                eventListener.restart();
            }
        }
    }
}
