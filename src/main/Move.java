package main;

import elements.Bead;
import elements.ElementType;
import pages.Board;

import static main.Globals.*;

public class Move {
    public static void set(int x,int y){
        Bead[] b = new Bead[Config.getBeadCount()];
        b[0]=players[TURN%Config.getBeadCount()].getBead();
        b[1]=players[(TURN+1)%Config.getBeadCount()].getBead();
        if(PREPARE && ((b[1].getBeadX()!=x || b[1].getBeadY()!=y) && (b[0].getBeadX()!=x || b[0].getBeadY()!=y))
            && Board.getItem(x,y)!= ElementType.WALL && Board.getItem(x,y)!= ElementType.SNAIL && Board.getItem(x,y)!= ElementType.STAR)
                      players[TURN++%Config.getBeadCount()].getBead().move(x,y);
        else if(!PREPARE && ((b[1].getBeadX()!=x || b[1].getBeadY()!=y) && (b[0].getBeadX()!=x || b[0].getBeadY()!=y)) &&
                (b[0].getBeadY()==y && b[0].getBeadX()!=x)||(b[0].getBeadY()!=y && b[0].getBeadX()==x)
                  && Board.getItem(x,y)!=ElementType.WALL)
                      players[TURN++%Config.getBeadCount()].getBead().move(x,y);
    }
}