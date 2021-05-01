package elements;

import main.Config;
import main.Move;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Tile extends JPanel {
    int x,y;
    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
        setBounds(Config.getTile_Size()*x,Config.getTile_Size()*y,Config.getTile_Size(),Config.getTile_Size());
        if((x+y)%2==0)
            setBackground(new Color(128, 0, 255, 190));
        else
            setBackground(new Color(2, 114, 0, 174));

        addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                Move.set(x,y);
            }
        });


    }
//    @Override
//    public void paint(Graphics g) {
//        super.paint(g);
//    }
//    public int getX() {
//        return x;
//    }
    public void setX(int x) {
        this.x = x;
    }
//    public int getY() {
//        return y;
//    }
    public void setY(int y) {
        this.y = y;
    }
}
