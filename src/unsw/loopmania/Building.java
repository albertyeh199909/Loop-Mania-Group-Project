package unsw.loopmania;



public abstract class Building extends StaticEntity {
    private String type;
    private int placement;
    
    /**
     * 
     * @param type      name of the building
     * @param placement where it can be placed
     *                  1 - Only on path tiles
     *                  2 - Any non-path tile
     *                  3 - Only on non-path tiles adjacent to the path
     *                  4 - Exists at the starting position of the Character 
     */
    public Building(int x, int y, String type, int placement) {
        setX(x);
        setY(y);
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