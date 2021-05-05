package main;

import elements.Bead;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final int id;
    private final Bead bead;
    private int score;
    private List<Integer> limits=new ArrayList<>();

    public Player( Bead bead) {
        this.id = bead.getId();
        this.bead = bead;
    }

    public int getId() {
        return id;
    }
    public Bead getBead() {
        return bead;
    }

    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }

    public void addLimit(int limit){
        limits.add(limit);
    }
    public Integer getLimits(int i) {
        return limits.get(i);
    }
    public List<Integer> getLimits() {
        return limits;
    }
    public int getSumLimits(){
        int sum = 0;
        for (Integer limit : limits) sum += limit;
        return sum;
    }
    public void setLimits(List<Integer> limits) {
        this.limits = limits;
    }
}
