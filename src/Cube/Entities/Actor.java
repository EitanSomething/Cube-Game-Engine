package Cube.Entities;

import Cube.Handler;

public abstract class Actor extends Entity{
    public Actor(Handler handler, float x, float y, float accX, float accY, int width, int height) {
        super(handler, x, y, accX, accY, width, height);

    }

}
