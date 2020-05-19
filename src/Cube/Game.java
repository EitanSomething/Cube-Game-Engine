package Cube;

import Cube.Input.KeyboardManager;
import Cube.Input.MouseManager;
import Cube.Window.CubeWindow;

import java.awt.event.KeyEvent;

public class Game implements Runnable{
    private CubeWindow window;
    private int width, height;
    public String title;
    private float scale = 2.0f;

    private boolean running = false;
    private final double UPDATE_CAP = 1.0/30.0;

    private Thread thread;

    private KeyboardManager keyManager;
    private MouseManager mouseManager;

    public Game(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;
    }

    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    public float getScale(){
        return scale;
    }

    public CubeWindow getWindow(){
        return window;
    }
    public void start(){
        window = new CubeWindow(this, title,width,height);
        keyManager = new KeyboardManager(this);
        mouseManager = new MouseManager(this);
        thread = new Thread(this);
        thread.run();
    }
    public void stop(){

    }
    public void run(){
        running = true;
        boolean render = false;
        double firstTime = 0;
        double lastTime = System.nanoTime() / 100000000.0;
        double passedTime = 0;
        double unprocessedTime = 0;

        double frameTime = 0;
        int frames = 0;
        int fps = 0;
        while(running){
            firstTime = System.nanoTime() / 100000000.0;
            passedTime = firstTime - lastTime;
            lastTime = firstTime;
            frameTime+=passedTime;
            unprocessedTime += passedTime;
            while(unprocessedTime >= UPDATE_CAP){
                unprocessedTime-=UPDATE_CAP;
                render = true;
                System.out.println("x: " + mouseManager.getMouseX());
                System.out.println("y: " + mouseManager.getMouseY());

                keyManager.update();
                mouseManager.update();
                if(frameTime >=1.0){
                    frameTime = 0;
                    fps = frames;
                    frames = 0;
                    System.out.println("FPS " + fps);
                }
            }
            if(render){
                frames++;
                window.update();
            }
            else{
                try{
                    Thread.sleep(1);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
        stop();
    }
}
