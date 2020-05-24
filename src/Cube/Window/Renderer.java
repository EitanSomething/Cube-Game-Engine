package Cube.Window;
import Cube.Game;

import java.awt.image.DataBufferInt;

public class Renderer {
    private int pixelWidth, pixelHeight;
    private int[] pixel;
    public Renderer(Game game){
        pixelWidth = game.getWidth();
        pixelHeight = game.getHeight();
        pixel = ((DataBufferInt)game.getWindow().getImage().getRaster().getDataBuffer()).getData();
    }
    public void clear(){
        for(int i = 0; i< pixel.length; i++){
            pixel[i] = 0;
        }
    }
}
