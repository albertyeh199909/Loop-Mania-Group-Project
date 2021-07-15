package unsw.loopmania.buildings;

public class Campfire extends Building {
    private int buffRadius;

    public Campfire() {
        super("Campfire", 2);
        buffRadius = 1;
    }

    public int getBuffRadius() {
        return buffRadius;
    }
}