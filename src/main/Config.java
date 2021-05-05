package main;

import elements.Tile;

public class Config {

    private final static int Tile_Size=40;
    private  static int WIDTH;
    private  static int HEIGHT;
    private static int beadCount = 2;


    public static int getTile_Size() {
        return Tile_Size;
    }
    public static int getBeadCount() {
        return beadCount;
    }
    public static void setBeadCount(int beadCount) {
        Config.beadCount = beadCount;
    }
    public static int getWIDTH() {
        return WIDTH;
    }
    public static int getHEIGHT() {
        return HEIGHT;
    }
    public static void setWIDTH(int WIDTH) {
        Config.WIDTH = WIDTH;
    }
    public static void setHEIGHT(int HEIGHT) {
        Config.HEIGHT = HEIGHT;
    }
}
