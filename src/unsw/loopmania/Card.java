package unsw.loopmania;

import java.util.List;

import javafx.beans.property.SimpleIntegerProperty;
import org.javatuples.Pair;

/**
 * a Card in the world
 * which doesn't move
 */
public abstract class Card extends StaticEntity {
    // TODO = implement other varieties of card than VampireCastleCard
    private String type;

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Card(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }
    /**
     * create building of the card 
     * @param x position on grid to place building
     * @param y
     * @return
     */
    public abstract Building createBuilding(int x, int y);
    /**
     * check if building can be placed on the x and y parameter of the grid
     * @param x
     * @param y
     * @param path orderedPath given by World
     * @return
     */
    public abstract boolean checkPlaceable(int x, int y, List<Pair<Integer,Integer>> path);
    public boolean checkAdjacentTile(int x, int y, List<Pair<Integer,Integer>> path) {
        if(path.contains(new Pair<Integer, Integer>(x,y))){
            return false;
        }
        for(int i = x-1; i < x+2; i++) {
            for(int j = y-1; j < y+2;j++) {
                
                if(i!=x && j!= y) {
                    if(path.contains(new Pair<Integer, Integer>(i,j))) {
                        
                        return true;
                    }
                }
            }
        }
        return false;
        
    }

    /**
     * Check if building is next to path tile
     * @param      x x-coordinate of a tile
     * @param      y y-coordinate of a tile
     * @param path list of path tiles
     */
    public boolean checkPathTile(int x, int y, List<Pair<Integer,Integer>> path) {
        if(path.contains(new Pair<Integer, Integer>(x,y))) {
            return true;
        }
        return false;
    }

    /**
     * Check if building is not next to path tile
     * @param      x x-coordinate of a tile
     * @param      y y-coordinate of a tile
     * @param path list of path tiles
     */
    public boolean checkNotPathTile(int x, int y, List<Pair<Integer,Integer>> path) {
        if(path.contains(new Pair<Integer, Integer>(x,y))) {
            return false;
        }
        return true;

    }
}
