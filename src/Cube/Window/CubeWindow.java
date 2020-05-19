package Cube.Window;



import Cube.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
public class CubeWindow {
    private JFrame frame;
    private BufferedImage image;
    private Canvas canvas;
    private BufferStrategy bs;
    private Graphics g;

    private String title;
    private int width, height;
    private Game game;
    public CubeWindow(Game game,String title, int width, int height){
        this.game = game;
        this.title = title;
        this.width = width;
        this.height = height;
        canvas = new Canvas();
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Dimension s = new Dimension((int)(width*game.getScale()),(int)(height*game.getScale()));

        canvas.setPreferredSize(s);
        canvas.setMaximumSize(s);
        canvas.setMinimumSize(s);
        canvas.setFocusable(true);

        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(canvas, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setVisible(true);

        canvas.createBufferStrategy(2);
        bs = canvas.getBufferStrategy();
        g = bs.getDrawGraphics();
    }

    public void update(){
        g.drawImage(image,0,0,width, height, null);
        bs.show();
    }
    public Canvas getCanvas(){
        return canvas;
    }

    public JFrame getFrame(){
        return frame;
    }
}
