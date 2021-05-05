package main;

import elements.Bead;
import elements.ElementType;
import elements.Snail;
import pages.Board;

import static main.Globals.*;

public class Move {
    public static void set(int x,int y){
        int[] scores  = new int[Config.getBeadCount()];
        scores[0]=0;
        scores[1]=0;
        Bead[] b = new Bead[Config.getBeadCount()];
        b[0]=players[TURN%Config.getBeadCount()].getBead();
        b[1]=players[(TURN+1)%Config.getBeadCount()].getBead();
        int[] snails = new int[Config.getBeadCount()];
        snails[0] = players[TURN%Config.getBeadCount()].getSumLimits();
        snails[1] = players[TURN%Config.getBeadCount()].getSumLimits();
        if(PREPARE && ((b[1].getBeadX()!=x || b[1].getBeadY()!=y) && (b[0].getBeadX()!=x || b[0].getBeadY()!=y))
            && Board.getItem(x,y)!= ElementType.WALL && Board.getItem(x,y)!= ElementType.SNAIL && Board.getItem(x,y)!= ElementType.STAR)
                      players[TURN++%Config.getBeadCount()].getBead().move(x,y);
        else if(!PREPARE && ((b[1].getBeadX()!=x || b[1].getBeadY()!=y) && (b[0].getBeadX()!=x || b[0].getBeadY()!=y)) &&
                (b[0].getBeadY()==y && b[0].getBeadX()!=x)||(b[0].getBeadY()!=y && b[0].getBeadX()==x)
                  && Board.getItem(x,y)!=ElementType.WALL){
                      // collecting stars and adding scores
                      if(b[0].getBeadY()==y && b[0].getBeadX()!=x && x>=b[0].getBeadX()){
                          for (int i = b[0].getBeadX();i<=x;i++){
                              Board.stars[b[0].getBeadY()*10+i].move(-1,-1);
                              Board.setElement(null,i,y);
                              if(Board.getItem(i,b[0].getBeadY())==ElementType.STAR)
                                  players[0].setScore(scores[0]++);
                          }
                      } else if (b[0].getBeadY()!=y && b[0].getBeadX()==x && y>=b[0].getBeadY()){
                          for (int j = b[0].getBeadY();j<=y;j++){
                              Board.stars[j*10+b[0].getBeadX()].move(-1,-1);
                              Board.setElement(null,x,j);
                              if(Board.getItem(b[0].getBeadX(),j)==ElementType.STAR)
                                  players[0].setScore(scores[0]++);
                          }
                      }
                      if(b[0].getBeadY()==y && b[0].getBeadX()!=x && x<b[0].getBeadX()){
                          for(int i=x;i<=b[0].getBeadX();i++){
                              Board.stars[b[0].getBeadY()*10+i].move(-1,-1);
                              Board.setElement(null,i,y);
                              if(Board.getItem(i,b[0].getBeadY())==ElementType.STAR)
                                  players[0].setScore(scores[0]++);
                          }
                      } else if(b[0].getBeadY()!=y && b[0].getBeadX()==x && y<b[0].getBeadY()){
                          for(int j=y;j<=b[0].getBeadY();j++){
                              Board.stars[j*10+b[0].getBeadX()].move(-1,-1);
                              Board.setElement(null,x,j);
                              if(Board.getItem(b[0].getBeadX(),j)==ElementType.STAR)
                                  players[0].setScore(scores[0]++);
                          }
                      }
                      players[TURN++%Config.getBeadCount()].getBead().move(x,y);
                      System.out.println("player 1:"+scores[0]+" player 2:"+scores[1]);
        }
    }
}