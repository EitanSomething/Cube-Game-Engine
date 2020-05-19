package Cube;

import Cube.Input.KeyboardManager;
import Cube.Input.MouseManager;
import Cube.Window.CubeWindow;
import Cube.State.State;

import java.awt.event.KeyEvent;

public class Game implements Runnable{

    private CubeWindow window;
    private int width, height;
    public String title;

    private boolean running = false;
    private final double UPDATE_CAP = 1.0/60.0;


    private Thread thread;
    private Handler handler;
    private KeyboardManager keyManager;
    private MouseManager mouseManager;
    public Game(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;
        handler = new Handler(this);
        keyManager = new KeyboardManager(handler);
        mouseManager = new MouseManager(handler);
    }

    private void tick(){
        if(keyManager.isKeyDown(KeyEvent.VK_X)){
            System.out.println("Key");
        }
        keyManager.update();

    }

    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    public CubeWindow getWindow(){
        return window;
    }
    public synchronized void start(){
        window = new CubeWindow(this, title, width, height);

        thread = new Thread(this);
        thread.start();
    }
    public synchronized void stop(){

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

            unprocessedTime += passedTime;
            while(unprocessedTime >= UPDATE_CAP){
                unprocessedTime-=UPDATE_CAP;
                render = true;
                if(keyManager.isKeyDown((KeyEvent.VK_A))){
                    System.out.println("A is pressed");
                }
                keyManager.update();
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
