package main;

import elements.Bead;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final int id;
    private final Bead bead;
    private int score;
    private final List<Integer> limits=new ArrayList();

    public Player( Bead bead) {
        this.id = bead.getId();
        this.bead = bead;
    }
    public void addLimit(int limit){
        limits.add(limit);
    }

    public int getId() {
        return id;
    }
    public Bead getBead() {
        return bead;
    }

    public List<Integer> getLimits() {
        return limits;
    }
}
