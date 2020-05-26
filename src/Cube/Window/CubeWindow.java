package Cube.Window;



import Cube.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
public class CubeWindow {
    private final JFrame frame;
    private final BufferedImage image;
    private final Canvas canvas;
    private final BufferStrategy bs;
    private final Graphics g;


    public CubeWindow(Game game){
        image = new BufferedImage(game.getWidth(), game.getHeight(), BufferedImage.TYPE_INT_RGB);
        canvas = new Canvas();
        Dimension s = new Dimension((int)(game.getWidth() * game.getScale()),(int)(game.getHeight() * game.getScale()));

        canvas.setPreferredSize(s);
        canvas.setMaximumSize(s);
        canvas.setMinimumSize(s);
        canvas.setFocusable(true);

        frame = new JFrame(game.getTitle());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(canvas, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        canvas.createBufferStrategy(3);
        bs = canvas.getBufferStrategy();
        g = bs.getDrawGraphics();

    }

    public void update(){
        g.drawImage(image,0,0,canvas.getWidth(), canvas.getHeight(), null);
        bs.show();
    }
    public Canvas getCanvas(){
        return canvas;
    }

    public JFrame getFrame(){
        return frame;
    }
    public BufferedImage getImage(){
        return image;
    }
}
