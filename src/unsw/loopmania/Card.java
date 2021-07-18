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

    public abstract Building createBuilding(int x, int y);
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

    public boolean checkPathTile(int x, int y, List<Pair<Integer,Integer>> path) {
        if(path.contains(new Pair<Integer, Integer>(x,y))) {
            return true;
        }
        return false;
    }
    
    public boolean checkNotPathTile(int x, int y, List<Pair<Integer,Integer>> path) {
        if(path.contains(new Pair<Integer, Integer>(x,y))) {
            return false;
        }
        return true;

    }
}
