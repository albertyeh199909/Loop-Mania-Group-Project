package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.javatuples.Pair;
import org.junit.Test;

import unsw.loopmania.BasicEnemy;
import unsw.loopmania.LoopManiaWorld;
import unsw.loopmania.PathPosition;

public class BasicEnemyTest {
    @Test
    public void testEnemyMovement() {
        BasicEnemy enemy = new BasicEnemy(new PathPosition(2, new List<Pair<Integer, Integer>>() {
        }))

        for (int i = 0; i < 100; i++) {
            enemy.move();
        }

        assertNotNull(enemy.getX());
        assertNotNull(enemy.getY());

        //assert not out of bounds

    }
}
