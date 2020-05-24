package Cube;

import Cube.Input.KeyboardManager;
import Cube.Input.MouseManager;
import Cube.Window.CubeWindow;
import Cube.Window.Renderer;


public class Game implements Runnable{
    private CubeWindow window;
    private final int width, height;
    public final String title;
    private float scale;
    private double UPDATE_CAP = 1.0 / 60.0;
    private boolean running = false;
    private Renderer renderer;
    private KeyboardManager keyManager;
    private MouseManager mouseManager;
    private Thread thread = new Thread(this);

    public Game(String title,float scale, int width, int height){
        this.scale = scale;
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
    public String getTitle(){
        return title;
    }
    public void start(){
        window = new CubeWindow(this);
        renderer = new Renderer(this);

        keyManager = new KeyboardManager(this);
        mouseManager = new MouseManager(this);

        thread = new Thread(this);

        thread.start();
    }
    public void stop(){

    }
    public void run(){
        running = true;

        boolean render = false;
        double firstTime = 0;
        double lastTime = System.nanoTime() / 1000000000.0;
        double passedTime = 0;
        double unprocessedTime = 0;

        double frameTime = 0;
        int frames = 0;
        int fps = 0;

        while(running){
            render = false;
            firstTime = System.nanoTime() / 1000000000.0;
            passedTime = firstTime - lastTime;
            lastTime = firstTime;

            unprocessedTime += passedTime;
            frameTime += passedTime;

            while(unprocessedTime >= UPDATE_CAP){
                unprocessedTime -= UPDATE_CAP;
                render = true;

                keyManager.update();
                mouseManager.update();
                if(frameTime >= 1.0){
                    frameTime = 0;
                    fps = frames;
                    frames = 0;
                    System.out.println("Fps" + fps);
                }
            }

            if(render){
                renderer.clear();
                window.update();
                frames++;
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
