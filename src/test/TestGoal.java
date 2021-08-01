package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import unsw.loopmania.Character;
import unsw.loopmania.LoopManiaWorld;
import unsw.loopmania.PathPosition;
import unsw.loopmania.victoryFinal;

import java.util.*;
import org.javatuples.Pair;
import org.json.JSONObject;

import java.io.FileNotFoundException;

/**
 * this class is a dummy class demonstrating how to setup tests for the project
 * you should setup additional test classes in a similar fashion, aiming to achieve high coverage.
 * A clickable "Run Test" link should appear if you have installed the Java Extension Pack properly.
 */
public class TestGoal {
    //private victoryFinal w;
    @Test
    public void Testcase1(){
        //readJson("world_with_twists_and_turns.json");
        victoryFinal w = null;

        try{
            w = new victoryFinal("world_with_twists_and_turns.json");
        } catch(FileNotFoundException e) {
            System.out.println("error");
        }

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
        PathPosition start = new PathPosition(2, path);
        Character c = new Character(start);
        LoopManiaWorld w1 = null;
        c.setExperience(1234567);
        c.setGold(2000);

        System.out.println(w.victoryAchieved(c,w1));
        assertEquals(true, w.victoryAchieved(c,w1));
    }

    /*private void readJson(String filename)
    {
        victoryFinal w = null;
        try{
            w = new victoryFinal(filename);
        }
        catch(FileNotFoundException e){
            System.out.println("error");
        }
        this.w = w;
    }*/
    
    @Test
    public void blahTest2(){
        LoopManiaWorld d = new LoopManiaWorld(1, 2, new ArrayList<>());
        assertEquals(d.getWidth(), 1);
    }

    public static void main(String[] args)
    {
        victoryFinal w = null;
        try{
            w = new victoryFinal("world_with_twists_and_turns.json");
        }
        catch(FileNotFoundException e){
            System.out.println("error");
        }

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
        PathPosition start = new PathPosition(2, path);
        Character c = new Character(start);
        LoopManiaWorld w1 = null;
        c.setExperience(1234567);
        c.setGold(2000);

        System.out.println(w.victoryAchieved(c,w1));
        assertEquals(true, w.victoryAchieved(c,w1));
    }
}
