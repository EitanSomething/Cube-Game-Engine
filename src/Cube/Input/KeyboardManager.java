package Cube.Input;

import Cube.Game;
import Cube.Window.CubeWindow;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyboardManager implements KeyListener {
    private final int NUM_KEYS = 256;
    private boolean[] keys = new boolean[NUM_KEYS];
    private boolean[] keysLast = new boolean[NUM_KEYS];


    private Game game;
    private CubeWindow window;

    public KeyboardManager(Game game){
        this.game = game;
        window = game.getWindow();
        window.getCanvas().addKeyListener(this);
    }
    public void update(){
        for(int i =0; i<NUM_KEYS;i++){
            keysLast[i] = keys[i];
        }
    }

    public boolean isKey(int keyCode){
        return keys[keyCode];
    }
    public boolean isKeyUp(int keyCode){
        return !keys[keyCode] && keysLast[keyCode];
    }
    public boolean isKeyDown(int keyCode){
        return keys[keyCode] && !keysLast[keyCode];
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        keys[keyEvent.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        keys[keyEvent.getKeyCode()] = false;
    }

}
