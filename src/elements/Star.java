package elements;

import main.Config;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static main.Config.getTile_Size;

public class Star extends JPanel {
    private int x,y;

    public Star(int x, int y) {
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
            Image image = new ImageIcon("E:\\University\\Semester 2\\Advance Programming\\Projects\\Game_JavaSwing\\src\\elements\\assets\\star.png").getImage();
            img = ImageIO.read(new File("src/elements/assets/star.png"));
            resizedImage = new BufferedImage(getTile_Size(), getTile_Size(),BufferedImage.TYPE_INT_BGR);
            Graphics2D graphics2D = resizedImage.createGraphics();
            graphics2D.drawImage(img,0,0, getTile_Size(), getTile_Size(),null);
//            graphics2D.drawImage(image,x,y,Config.getTile_Size()-1,Config.getTile_Size()-1,this);
//            graphics2D.dispose();
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(resizedImage,0,0,this);
    }


    public int getBeadX() {
        return x;
    }

    public int getBeadY() {
        return y;
    }
}
