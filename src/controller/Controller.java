package controller;

import model.Direction;
import model.GameObjects;
import model.Model;
import view.View;

public class Controller implements EventListener{
    private View view;
    private Model model;

    public Controller() {
        view = new View(this);
        model = new Model();

        view.init();
        model.restart();

        model.setEventListener(this);
        view.setEventListener(this);
    }

    public static void main(String[] args) {
        new Controller();
    }
    
    
    @Override
    public void move(Direction direction) {
        model.move(direction);
        view.update();
    }

    @Override
    public void restart() {
        model.restart();
        view.update();
    }

    @Override
    public void startNextLevel() {
        model.startNextLevel();
        view.update();
    }

    @Override
    public void levelCompleted(int level) {
        view.completed(level);
    }

    public GameObjects getGameObjects() {
        return model.getGameObjects();
    }
}
