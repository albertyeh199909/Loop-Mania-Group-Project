package unsw.loopmania.buildings;

public abstract class Spawner extends Building {
    private int interval;
    
    public Spawner(String type, int placement, int interval) {
        super(type, placement);
        this.interval = interval;
    }

    public int getInterval() {
        return interval;
    }
}