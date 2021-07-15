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

public class BasicEnemyTest {
    @Test
    public void testEnemyMovement() {
        BasicEnemy enemy = new BasicEnemy(new PathPosition(0, Arrays.asList(new Pair<>(0, 1), new Pair<>(0,2))), 2, 2, 2, 2);

        for (int i = 0; i < 100; i++) {
            assertNotNull(enemy.getX());
            assertNotNull(enemy.getY());
            assertTrue(enemy.getX() <= 32);
            assertTrue(enemy.getY() <= 32);
            enemy.move();
        }
    }

    @Test
    public void testEnemyBasicDamage() {
        BasicEnemy enemy = new BasicEnemy(new PathPosition(0, Arrays.asList(new Pair<>(0, 1), new Pair<>(0,2))), 2, 2, 2, 2);
        enemy.takeDamage(new DamageClass(enemy, 1, 0));
        assertEquals(enemy.getHealth(), 1);
    }
}
