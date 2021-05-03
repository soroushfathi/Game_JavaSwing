package elements;

import main.Config;
import main.Globals;
import main.Move;
import pages.Board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Tile extends JPanel {
    int x, y;

    JPopupMenu jPopupMenu = new JPopupMenu();
    JMenuItem jStarItem = new JMenuItem("Star");
    JMenuItem jWallItem = new JMenuItem("Wall");
    JMenuItem jSnailItem = new JMenuItem("Snail");
    JMenuItem jDeleteItem = new JMenuItem("Delete");

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
        setBounds(Config.getTile_Size() * x, Config.getTile_Size() * y, Config.getTile_Size(), Config.getTile_Size());
        if ((x + y) % 2 == 0)
            setBackground(new Color(128, 0, 255, 190));
        else
            setBackground(new Color(2, 114, 0, 174));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                if (e.getButton() == MouseEvent.BUTTON1){
                    try{
                        System.out.println(Board.getItem(x,y).toString());
                    } catch (NullPointerException nullPointerException){
                        System.err.println(nullPointerException.getMessage());
                    }
                    Move.set(x, y);
                }
            }
        });

        //event handling for each popup menu item
        jStarItem.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Board.stars[y*10+x].move(x,y);
                        Board.setElement(ElementType.STAR,x,y);
                    }
                });

        jWallItem.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Board.walls[y*10+x].move(x,y);
                        Board.setElement(ElementType.WALL,x,y);
                    }
                });
        jSnailItem.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Board.snails[y*10+x].move(x,y);
                        Board.setElement(ElementType.SNAIL,x,y);
                    }
                }
        );
        jDeleteItem.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        switch (Board.getItem(x,y)){
                            case STAR :
                            case SNAIL:
                            case WALL : {
                                Board.stars[y*10+x].move(-1,-1);
                                break;
                            }
                        }
                        Board.setElement(null,x,y);
                    }
                }
        );
        //adding items to popup menu
        jPopupMenu.add(jStarItem);
        jPopupMenu.add(jWallItem);
        jPopupMenu.add(jSnailItem);
        jPopupMenu.add(jDeleteItem);
        addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseReleased(MouseEvent e) {
                        super.mouseReleased(e);
                        if(Board.getItem(x,y)==null || Board.getItem(x,y)==)
                            jDeleteItem.setEnabled(false);
                        else
                            jDeleteItem.setEnabled(true);
                        if (e.getButton() == MouseEvent.BUTTON3 && Globals.PREPARE)
                            jPopupMenu.show(e.getComponent(), e.getX(), e.getY());
                    }
                }
        );
        add(jPopupMenu);
    }

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
