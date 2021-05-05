package elements;

import main.Config;
import main.Globals;
import main.Move;
import main.Player;
import pages.Board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Tile extends JPanel {
    int x, y;
    int starCounter=0;
    int snailCounter=0;
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
                        System.out.print(Board.getItem(x,y).toString() + " ");
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
                        String limiter =  JOptionPane.showInputDialog("please enter the limiter");
                        Board.snails[y*10+x].move(x,y);
                        Board.snails[y*10+x].setLimiter(Integer.parseInt(limiter));
                        System.out.println(Board.snails[y*10+x].getLimiter());
                        Board.setElement(ElementType.SNAIL,x,y);
                    }
                }
        );
        jDeleteItem.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        switch (Board.getItem(x,y)){
                            case STAR : {
                                Board.stars[y*10+x].move(-1,-1);
                                break;
                            }
                            case SNAIL: {
                                Board.snails[y*10+x].move(-1,-1);
                                break;
                            }
                            case WALL : {
                                Board.walls[y*10+x].move(-1,-1);
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
                        jDeleteItem.setEnabled(Board.getItem(x, y) != null);
                        if(Board.getItem(x,y)==ElementType.BEAD || Board.getItem(x,y)==ElementType.SNAIL || Board.getItem(x,y)==ElementType.WALL || Board.getItem(x,y)==ElementType.STAR){
                            jSnailItem.setEnabled(false);
                            jWallItem.setEnabled(false);
                            jStarItem.setEnabled(false);
                        }else {
                            jSnailItem.setEnabled(true);
                            jWallItem.setEnabled(true);
                            jStarItem.setEnabled(true);
                        }
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
