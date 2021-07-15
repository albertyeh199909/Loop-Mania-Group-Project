package unsw.loopmania.buildings;

public abstract class Building {
    private String type;
    private int placement;
    
    public Building(String type, int placement) {
        this.type = type;
        this.placement = placement;
    }

    public String getType() {
        return type;
    }

    public int getPlacement() {
        return placement;
    }
}