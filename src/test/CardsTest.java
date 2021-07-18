package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;


import unsw.loopmania.*;

import java.util.*;
import org.javatuples.Pair;

import javafx.beans.property.SimpleIntegerProperty;

public class CardsTest {
    @Test
    public void testPlaceable() {
        List<Pair<Integer, Integer>> path = new ArrayList<Pair<Integer, Integer>>();
        path.add(new Pair<Integer, Integer>(4,3));
        path.add(new Pair<Integer, Integer>(4,2));
        path.add(new Pair<Integer, Integer>(3,2));
        path.add(new Pair<Integer, Integer>(3,1));
        path.add(new Pair<Integer, Integer>(2,1));
        path.add(new Pair<Integer, Integer>(1,1));
        path.add(new Pair<Integer, Integer>(1,2));
        path.add(new Pair<Integer, Integer>(1,3));
        path.add(new Pair<Integer, Integer>(2,3));
        path.add(new Pair<Integer, Integer>(3,3));

        Card vampireCastleCard = new VampireCastleCard(new SimpleIntegerProperty(1),new SimpleIntegerProperty(4));
        assertFalse(vampireCastleCard.checkPlaceable(3, 3, path));
        assertFalse(vampireCastleCard.checkPlaceable(4, 5, path));
        assertTrue(vampireCastleCard.checkPlaceable(4, 4, path));
        assertTrue(vampireCastleCard.createBuilding(4, 4) instanceof VampireCastle);

        Card campfireCard= new CampfireCard(new SimpleIntegerProperty(1),new SimpleIntegerProperty(4));
        assertFalse(campfireCard.checkPlaceable(3, 3, path));
        assertTrue(campfireCard.checkPlaceable(4, 5, path));
        assertTrue(campfireCard.checkPlaceable(4, 4, path));
        assertTrue(campfireCard.createBuilding(4, 4) instanceof Campfire);

        Card villageCard = new VillageCard(new SimpleIntegerProperty(1),new SimpleIntegerProperty(4));
        assertTrue(villageCard.checkPlaceable(3, 3, path));
        assertFalse(villageCard.checkPlaceable(4, 5, path));
        assertFalse(villageCard.checkPlaceable(4, 4, path));
        assertTrue(villageCard.createBuilding(3, 3) instanceof Village );

    }
    
}
