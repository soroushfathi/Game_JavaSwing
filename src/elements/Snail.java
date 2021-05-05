package elements;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static main.Config.getTile_Size;

public class Snail extends JPanel {
    private int limiter;
    private int x,y;
    public Snail(int x, int y) {
        this.x = x;
        this.y = y;
        setBounds(getTile_Size()*x ,getTile_Size()*y ,getTile_Size(),getTile_Size());
    }
    public void move(int x, int y){
        this.x=x;
        this.y=y;
        setBounds(getTile_Size()*x ,getTile_Size()*y ,getTile_Size(),getTile_Size());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        BufferedImage img = null, resizedImage = null;
        try {
            img = ImageIO.read(new File("src/elements/assets/slow.png"));
            resizedImage = new BufferedImage(getTile_Size(), getTile_Size(),BufferedImage.TYPE_INT_BGR);
            Graphics2D graphics2D = resizedImage.createGraphics();
            graphics2D.drawImage(img,0,0, getTile_Size(), getTile_Size(),null);
            graphics2D.dispose();
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(resizedImage,0,0,this);
    }

    public int getLimiter() {
        return limiter;
    }
    public void setLimiter(int slower) {
        this.limiter = slower;
    }
    public int getBeadX() {
        return x;
    }
    public int getBeadY() {
        return y;
    }
}
