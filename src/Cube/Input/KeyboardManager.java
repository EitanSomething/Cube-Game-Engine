package Cube.Input;

import Cube.Game;
import Cube.Window.CubeWindow;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyboardManager implements KeyListener {
    private final int NUM_KEYS = 256;
    private final boolean[] keys = new boolean[NUM_KEYS];
    private boolean[] keysLast = new boolean[NUM_KEYS];

    public KeyboardManager(Game game){
        CubeWindow window = game.getWindow();
        window.getCanvas().addKeyListener(this);
    }

    public void update(){
        keysLast = keys;
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        keys[keyEvent.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        keys[keyEvent.getKeyCode()] = false;
    }

    //Getters and Setters
    public boolean isKey(int keyCode){
        return keys[keyCode];
    }
    public boolean isKeyUp(int keyCode){
        return !keys[keyCode] && keysLast[keyCode];
    }
    public boolean isKeyDown(int keyCode){
        return keys[keyCode] && !keysLast[keyCode];
    }


    //UNUSED
    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }
}
