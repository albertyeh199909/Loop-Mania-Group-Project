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
    public void testRunBattles() {
        // List<Pair<Integer, Integer>> path and its subsequent details are taken from CharacterTest.java
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

        world.setCharacter(new Character(new PathPosition(2, path)));

        world.possiblySpawnEnemies();

        List<BasicEnemy> defeatedEnemy = world.runBattles();

        assert(defeatedEnemy.get(0) instanceof Slug);


    }
}
