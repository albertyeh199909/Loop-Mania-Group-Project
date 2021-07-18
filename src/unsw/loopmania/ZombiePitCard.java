package unsw.loopmania;

import java.util.List;

import javafx.beans.property.SimpleIntegerProperty;
import org.javatuples.Pair;

/**
 * represents a vampire castle card in the backend game world
 */
public class ZombiePitCard extends Card {
    
    public ZombiePitCard(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }    
    public Building createBuilding(int x, int y) {
        return new ZombiePit(x, y);
    } 

    public boolean checkPlaceable(int x, int y,  List<Pair<Integer,Integer>> path) {
        return checkAdjacentTile(x, y, path);
    }
    
}