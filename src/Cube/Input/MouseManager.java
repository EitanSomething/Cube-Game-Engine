package Cube.Input;

import Cube.Game;
import Cube.Window.CubeWindow;

import java.awt.event.*;

public class MouseManager implements MouseListener, MouseMotionListener, MouseWheelListener {
    private final int NUM_BUTTONS = 5;
    private boolean[] buttons = new boolean[NUM_BUTTONS];
    private boolean[] buttonsLast = new boolean[NUM_BUTTONS];

    private int mouseX, mouseY;
    private int scroll;

    private Game game;
    private CubeWindow window;

    public MouseManager(Game game){
        this.game = game;
        window = game.getWindow();
        window.getFrame().addMouseListener(this);
        window.getFrame().addMouseMotionListener(this);
        window.getCanvas().addMouseListener(this);
        window.getCanvas().addMouseMotionListener(this);
    }

    public void update(){
        scroll = 0;
        buttonsLast = buttons;
    }
    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        buttons[mouseEvent.getButton()] = true;
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        buttons[mouseEvent.getButton()] = false;
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        mouseX = (int)(mouseEvent.getX() / game.getScale());
        mouseY = (int)(mouseEvent.getY() / game.getScale());
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        mouseX = (int)(mouseEvent.getX() / game.getScale());
        mouseY = (int)(mouseEvent.getY() / game.getScale());
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent mouseWheelEvent) {
        scroll = mouseWheelEvent.getWheelRotation();
    }

    //Getters and Setters.
    public boolean isButton(int keyCode){
        return buttons[keyCode];
    }
    public boolean isButtonUp(int keyCode){
        return !buttons[keyCode] && buttonsLast[keyCode];
    }
    public boolean isButtonDown(int keyCode){
        return buttons[keyCode] && !buttonsLast[keyCode];
    }
    public int getMouseX(){
        return mouseX;
    }
    public int getMouseY(){
        return mouseY;
    }
    public int getScroll(){
        return scroll;
    }


    //UNUSED
    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }
}
