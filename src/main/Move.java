package main;

import elements.Bead;
import elements.ElementType;
import elements.Snail;
import elements.Wall;
import pages.Board;

import javax.swing.*;

import static main.Globals.*;

public class Move {
    static int[] scores = new int[Config.getBeadCount()];
    static int turn = 0;

    public static void set(int x, int y) {
        Bead[] b = new Bead[Config.getBeadCount()];
        b[0] = players[TURN % Config.getBeadCount()].getBead();
        b[1] = players[(TURN + 1) % Config.getBeadCount()].getBead();
        int[] snails = new int[Config.getBeadCount()];
        snails[0] = players[TURN % Config.getBeadCount()].getSumLimits();
        snails[1] = players[TURN % Config.getBeadCount()].getSumLimits();
        if (PREPARE && ((b[1].getBeadX() != x || b[1].getBeadY() != y) && (b[0].getBeadX() != x || b[0].getBeadY() != y))
                && Board.getItem(x, y) != ElementType.WALL && Board.getItem(x, y) != ElementType.SNAIL && Board.getItem(x, y) != ElementType.STAR)
            players[TURN++ % Config.getBeadCount()].getBead().move(x, y);
        else if (!PREPARE && ((b[1].getBeadX() != x || b[1].getBeadY() != y) && (b[0].getBeadX() != x || b[0].getBeadY() != y)) &&
                (b[0].getBeadY() == y && b[0].getBeadX() != x) || (b[0].getBeadY() != y && b[0].getBeadX() == x)
                && Board.getItem(x, y) != ElementType.WALL) {
            // check the wall between move
            boolean validWay = true;
            if (b[0].getBeadY() == y && b[0].getBeadX() != x && x <= b[0].getBeadX())
                for (int f=x;f<=b[0].getBeadX();f++)
                    if(Board.getItem(f, y) == ElementType.WALL){
                        JOptionPane.showMessageDialog(null,"there is wall in your move, try again");
                        validWay = false;
                    }
            else if (b[0].getBeadY() == y && b[0].getBeadX() != x && x > b[0].getBeadX())
                for (int s=b[0].getBeadX();s<=x;s++)
                    if(Board.getItem(s, y) == ElementType.WALL){
                        JOptionPane.showMessageDialog(null,"there is wall in your move, try again");
                        validWay = false;
                    }
            if(b[0].getBeadY() !=y && b[0].getBeadX() == x && y <= b[0].getBeadY())
                for(int q=y;q<b[0].getBeadY();q++)
                    if(Board.getItem(x,q) == ElementType.WALL){
                        JOptionPane.showMessageDialog(null,"there is wall in your move, try again");
                        validWay = false;
                    }
            else if (b[0].getBeadY() !=y && b[0].getBeadX()==x && y > b[0].getBeadY())
                for(int t=b[0].getBeadY();t<y;t++)
                    if(Board.getItem(x,t) ==ElementType.WALL){
                        JOptionPane.showMessageDialog(null,"there is wall in your move, try again");
                        validWay = false;
                    }
            // collecting stars and adding scores
            if (b[0].getBeadY() == y && b[0].getBeadX() != x && x >= b[0].getBeadX() && validWay) {
                for (int i = b[0].getBeadX(); i <= x; i++) {
                    Board.stars[b[0].getBeadY() * Config.getHEIGHT() + i].move(-1, -1);
                    if (Board.getItem(i, b[0].getBeadY()) == ElementType.STAR)
                        try {
                            scores[turn]++;
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.err.println(e.getMessage());
                        }
                    Board.setElement(null, i, y);
                }
            } else if (b[0].getBeadY() != y && b[0].getBeadX() == x && y >= b[0].getBeadY() && validWay)
                for (int j = b[0].getBeadY(); j <= y; j++) {
                    Board.stars[j * Config.getHEIGHT() + b[0].getBeadX()].move(-1, -1);
                    if (Board.getItem(b[0].getBeadX(), j) == ElementType.STAR)
                        try {
                            scores[turn++%Config.getBeadCount()]++;
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.err.println(e.getMessage());
                        }
                    Board.setElement(null, x, j);
                }
            if (b[0].getBeadY() == y && b[0].getBeadX() != x && x < b[0].getBeadX() && validWay) {
                for (int i = x; i <= b[0].getBeadX(); i++) {
                    Board.stars[b[0].getBeadY() * Config.getHEIGHT() + i].move(-1, -1);
                    if (Board.getItem(i, b[0].getBeadY()) == ElementType.STAR)
                        try {
                            scores[turn++%Config.getBeadCount()]++;
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.err.println(e.getMessage());
                        }
                    Board.setElement(null, i, y);
                }
            } else if (b[0].getBeadY() != y && b[0].getBeadX() == x && y < b[0].getBeadY() && validWay)
                for (int j = y; j <= b[0].getBeadY(); j++) {
                    Board.stars[j * Config.getHEIGHT() + b[0].getBeadX()].move(-1, -1);
                    if (Board.getItem(b[0].getBeadX(), j) == ElementType.STAR)
                        try {
                            scores[turn++%Config.getBeadCount()]++;
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.err.println(e.getMessage());
                        }
                    Board.setElement(null, x, j);
                }
            if(validWay)
                players[TURN++ % Config.getBeadCount()].getBead().move(x, y);
                System.out.println("player 1:" + scores[0] + " player 2:" + scores[1]);
        } else
            JOptionPane.showMessageDialog(null, "!error \n choose valid Tile ;)");
    }
}