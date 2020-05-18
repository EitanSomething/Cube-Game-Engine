package Cube.Entities;

import java.awt.*;
import Cube.Handler;

public abstract class Entity {
    protected Handler handler;
    protected float x, y;
    protected float accX, accY;
    protected int width, height;
    protected int health;
    protected boolean active = true;
    protected Rectangle bounds;

    public Entity(Handler handler, float x, float y, float accX, float accY, int width, int height){
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        bounds = new Rectangle(0, 0, width, height);

    }
    public abstract void tick();

    public abstract void render(Graphics g);
    public float getLocX(){
        return x;
    }
    public float getLocY(){
        return y;
    }
}
