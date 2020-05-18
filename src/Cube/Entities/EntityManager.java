package Cube.Entities;

import java.awt.*;
import java.util.ArrayList;
import java.util.logging.Handler;

public class EntityManager {
    private Handler handler;
    private ArrayList<Entity> entities;


    public EntityManager(Handler handler){
        this.handler = handler;
        entities = new ArrayList<Entity>();
    }

    public void tick(){
        for(Entity entity:entities) {
            entity.tick();

        }
    }
    public void render(Graphics g){
        for(Entity e : entities){
            e.render(g);
        }
    }
    public void addEntity(Entity e){
        entities.add(e);
    }


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
