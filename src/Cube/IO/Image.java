package Cube.IO;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Image {
    private int width, height;
    private int[] pixel;
    public Image(String path){
        BufferedImage image = null;
        try{
            image = ImageIO.read(Image.class.getResourceAsStream(path));
        }
        catch(IOException e){
            e.printStackTrace();
        }
        if(image!=null) {
            width = image.getWidth();
            height = image.getHeight();
            pixel = image.getRGB(0, 0, width, height, null, 0, width);
            image.flush();
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int[] getPixel() {
        return pixel;
    }
}
