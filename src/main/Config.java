package main;

import elements.Tile;

public class Config {

    private final static int Tile_Size=40;
    private final static int WIDTH=10;
    private final static int HEIGHT =10;
    private final static int beadCount = 2;


    public static int getTile_Size() {
        return Tile_Size;
    }
    public static int getBeadCount() {
        return beadCount;
    }
    public static int getWIDTH() {
        return WIDTH;
    }
    public static int getHEIGHT() {
        return HEIGHT;
    }

}
