package Cube;

import Cube.Input.KeyboardManager;
import Cube.Input.MouseManager;
import Cube.Window.CubeWindow;
import Cube.Window.Renderer;


public class Game implements Runnable{
    private CubeWindow window;
    private Renderer renderer;
    private KeyboardManager keyManager;
    private MouseManager mouseManager;
    private Thread thread;
    private AbstractGame game;

    private float scale;
    private double UPDATE_CAP = 1.0 / 60.0;
    private boolean running = false;

    private final int width, height;
    private final String title;

    public Game(AbstractGame game, String title, float scale, int width, int height){
        this.game = game;
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
                game.update(this,(float)UPDATE_CAP);
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
                frames++;
                render();
            }
            else{
                try{
                    Thread.sleep(2);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
        stop();
    }
    private void render(){
        renderer.clear();
        game.render(this,renderer);
        window.update();
    }
}
