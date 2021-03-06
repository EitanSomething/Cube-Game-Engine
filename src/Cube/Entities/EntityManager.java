package Cube.Entities;

import java.awt.*;
import java.util.ArrayList;
import java.util.logging.Handler;
public class EntityManager {
    private Handler handler;
    private ArrayList<Entity> entities;

    public EntityManager(Handler handler){
        this.handler = handler;
        entities = new ArrayList<>();
    }
    public void addEntity(Entity e){
        entities.add(e);
    }

    //Getters and Setters
    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }

}
