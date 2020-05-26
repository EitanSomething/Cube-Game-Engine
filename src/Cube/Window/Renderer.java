package Cube.Window;
import Cube.Game;
import Cube.IO.Image;

import java.awt.image.DataBufferInt;
import java.util.Arrays;

public class Renderer {
    private int pixelWidth, pixelHeight;
    private int[] pixel;
    public Renderer(Game game){
        pixelWidth = game.getWidth();
        pixelHeight = game.getHeight();
        pixel = ((DataBufferInt)game.getWindow().getImage().getRaster().getDataBuffer()).getData();
    }
    public void clear(){
        Arrays.fill(pixel, 0);
    }
    public  void setPixel(int x, int y, int value){
        if((x < 0 || x>= pixelWidth || y < 0 || y >=pixelHeight) || value == 0xffff){
            return;
        }
        pixel[x+y *pixelWidth] = value;
    }
    public void drawImage(Image image, int offX, int offY){
        for(int y =0;y<image.getHeight(); y++){
            for(int x =0; x<image.getWidth(); x++){
                setPixel(x+offX,y+offY,image.getPixel()[x+y*image.getWidth()]);
            }
        }
    }
}
