package elements;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import static main.Config.*;

public class Bead extends JComponent{
    private int x,y;


    public int getBeadX() {
        return x;
    }

    public int getBeadY() {
        return y;
    }


    private final int id;
    private final boolean color;
    public Bead(int x, int y,int id,boolean color) {
        this.x = x;
        this.y = y;
        this.color=color;
        this.id=id;
        setBounds(getTile_Size()*x ,getTile_Size()*y ,getTile_Size(),getTile_Size());
    }

    public int getId() {
        return id;
    }
    public void move(int x, int y){
        this.x=x;
        this.y=y;
        setBounds(getTile_Size()*x ,getTile_Size()*y ,getTile_Size(),getTile_Size());
    }
    @Override
    public void paint(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        Ellipse2D[] ellipse2D = new Ellipse2D[getBeadCount()];
        ellipse2D[0] = new Ellipse2D.Double(5, 5, getTile_Size()-10, getTile_Size()-10);
        graphics2D.setPaint(color?Color.BLUE:Color.RED);
        graphics2D.fill(ellipse2D[0]);
        graphics2D.draw(ellipse2D[0]);
        super.paint(g);
    }

    @Override
    public Dimension getPreferredSize() {
        return super.getPreferredSize();
    }
}
