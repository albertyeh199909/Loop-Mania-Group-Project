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
        List<Pair<Integer, Integer>> path = new ArrayList<Pair<Integer, Integer>>();
        path.add(new Pair(4,3));
        path.add(new Pair(4,2));
        path.add(new Pair(3,2));
        path.add(new Pair(3,1));
        path.add(new Pair(2,1));
        path.add(new Pair(1,1));
        path.add(new Pair(1,2));
        path.add(new Pair(1,3));
        path.add(new Pair(2,3));
        path.add(new Pair(3,3));
        PathPosition start = new PathPosition(0, path);
        PathPosition start2 = new PathPosition(1, path);
        BasicEnemy enemy = new Slug(start);
        Character player = new Character(start2);

        
            
        //assumes player not moving because this test is designed to test move method in basicenemy
        //will fail sometimes since movement is random
            
        enemy.move(player);
        assertTrue(enemy.getInBattle());
        
    }

    @Test
    public void testEnemyBasicDamage() {
        List<Pair<Integer, Integer>> path = new ArrayList<Pair<Integer, Integer>>();
        path.add(new Pair(4,3));
        path.add(new Pair(4,2));
        path.add(new Pair(3,2));
        path.add(new Pair(3,1));
        path.add(new Pair(2,1));
        path.add(new Pair(1,1));
        path.add(new Pair(1,2));
        path.add(new Pair(1,3));
        path.add(new Pair(2,3));
        path.add(new Pair(3,3));
        PathPosition start = new PathPosition(0, path);
        PathPosition start2 = new PathPosition(1, path);
        Vampire enemy = new Vampire(start);
        Character player = new Character(start2);

        
            
        //assumes player not moving because this test is designed to test move method in basicenemy
        //will fail sometimes since movement is random
        boolean result = false;
        for(int i = 0; i < 1000; i++) {   
            enemy.inflictDamage(player);
            if(enemy.getIsCrit()) {
                result = true;
            }
        }
        assertTrue(result);
    }
}
