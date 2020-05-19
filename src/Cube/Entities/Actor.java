package Cube.Entities;


import Cube.Game;

public abstract class Actor extends Entity {
    public Actor(Game game, float x, float y, float accX, float accY, int width, int height) {
        super(game, x, y, accX, accY, width, height);

    }

}
