package Cube.Window;
import Cube.Game;
import Cube.IO.Image;

import java.awt.image.DataBufferInt;
import java.util.Arrays;

public class Renderer {
    private int pixelWidth, pixelHeight;
    private int[] pixel;
    Game game;
    public Renderer(Game game){
        this.game = game;
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

        //Off Screen don't render
        if(offX <-image.getWidth())return;
        if(offY <-image.getHeight())return;
        if(offX >= pixelWidth) return;
        if(offY >= pixelHeight) return;

        int newY = 0;
        int newX =0;
        int newWidth = image.getWidth();
        int newHeight = image.getHeight();


        //Clipping code
        if(offX < 0){
            newX -=offX;
        }
        if(offY < 0){
            newY -=offY;
        }
        if(newWidth + offX >pixelWidth){
            newWidth-=newWidth+offX-pixelWidth;
        }
        if(newHeight + offY >pixelWidth){
            newHeight-=newHeight+offY-pixelHeight;
        }
        for(int y = newY; y< newHeight; y++){
            for(int x = newX; x < newWidth; x++){
                setPixel(x+offX,y+offY,image.getPixel()[x+y*image.getWidth()]);
            }
        }
    }
}
