package Cube.Entities;

import Cube.Game;

import java.awt.*;

public abstract class Entity {
    protected Game game;
    protected float x, y;
    protected float accX, accY;
    protected int width, height;
    protected int health;
    protected boolean active = true;
    protected Rectangle bounds;

    public Entity(Game game, float x, float y, float accX, float accY, int width, int height){
        this.game = game;
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
    public float getAccXX(){
        return accX;
    }
    public float getAccYY(){
        return accY;
    }
    public Rectangle getBounds(){
        return bounds;
    }
}
