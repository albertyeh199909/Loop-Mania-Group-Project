package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.javatuples.Pair;
import org.junit.Test;

import unsw.loopmania.*;
import unsw.loopmania.Character;

public class LoopManiaWorldTest {
    @Test
    public void testRunTickMoves() {
        // Test details are shared with CharacterTest
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

        LoopManiaWorld world = new LoopManiaWorld(5,5, path);

        PathPosition start = new PathPosition(1, path);
        Character player = new Character(start);



        world.setCharacter(player);

        assertNotNull(world.getCharacter());

        world.runTickMoves();

        assertEquals(player.getX(), 3);
        assertEquals(player.getY(), 2);

        assertNotNull(player);

        world.runTickMoves();

        assertEquals(player.getX(), 3);
        assertEquals(player.getY(), 1);




        Card card = null;

        while (card instanceof VillageCard) {
            card = world.Card();
        }

        world.convertCardToBuildingByCoordinates(0, 0, 1, 1);

        world.runTickMoves();
        world.runTickMoves();

        assertEquals(player.getX(), 1);
        assertEquals(player.getY(), 1);

        assertEquals(player.getHealth(), 20);



    }

}
