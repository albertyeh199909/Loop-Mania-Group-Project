package unsw.loopmania;


import java.util.List;

import javafx.beans.property.SimpleIntegerProperty;
import org.javatuples.Pair;


public class BarracksCard extends Card {
    
    public BarracksCard(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }    
    public Building createBuilding(int x, int y) {
        return new Barracks(x, y);
    } 

    public boolean checkPlaceable(int x, int y,  List<Pair<Integer,Integer>> path) {
        return checkPathTile(x, y, path);
    }
    
}