package Cube.Entities;

import Cube.Game;
import Cube.Timer.Tick;

import java.awt.*;

public abstract class Entity implements Tick {
    protected Game game;
    protected float x;
    protected float y;
    protected float accX, accY;
    protected int width;
    protected int height;
    protected Rectangle bounds;

    public Entity(Game game, float x, float y, float accX, float accY, int width, int height){
        this.game = game;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        bounds = new Rectangle(0, 0, width, height);

    }
    @Override
    public void Tick(){
    }

    public void useTick(boolean tickable){
        if(tickable){
            Game.AddToList(this);
        }
        else{
            Game.RemoveFromList(this);
        }
    }
    //Getters and Setters
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
