package main;

import elements.Bead;

import static main.Globals.*;

public class Move {
    public static void set(int x,int y){
        Bead b=players[TURN%2].getBead();
        Bead b2=players[(TURN+1)%2].getBead();
        if(((b.getBeadY()==y && b.getBeadX()!=x)||(b.getBeadY()!=y && b.getBeadX()==x) ||PREPARE)
           && (b2.getBeadX()!=x || b2.getBeadY()!=y))
            players[TURN++%2].getBead().move(x,y);
    }
}
