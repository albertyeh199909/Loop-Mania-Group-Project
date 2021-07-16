package unsw.loopmania;

public class Campfire extends Building {
    private int buffRadius;

    public Campfire(int x, int y) {
        super(x,y,"Campfire", 2);
        buffRadius = 2;
    }

    public int getBuffRadius() {
        return buffRadius;
    }
}