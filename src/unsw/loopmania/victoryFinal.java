package unsw.loopmania;

import org.json.JSONObject;
import org.json.JSONArray;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.util.*;
import org.javatuples.Pair;

public class victoryFinal {
    // Helper function for reading a JSON file
    private JSONObject json;
    public victoryFinal(String filename) throws FileNotFoundException {
        json = new JSONObject(new JSONTokener(new FileReader("worlds/" + filename)));
    }

    // Helper function that recursively check goals
    public boolean victory(JSONObject goal, Character c, LoopManiaWorld w) {

    
        // Recursive part
        // This section is skipped if it's a basic goal
        if (goal.getString("goal").equals("AND") || goal.getString("goal").equals("OR")) {
            // Get the JSONArray and subsequently the 2 subgoals
            JSONArray subgoals = (JSONArray) goal.get("subgoals");
            JSONObject firstGoal = new JSONObject(subgoals.getString(0));
            JSONObject secondGoal = new JSONObject(subgoals.getString(1));

            // Recursion to split the problem into subproblems
            boolean firstGoalAchieved = victory(firstGoal, c, w);
            boolean secondGoalAchieved = victory(secondGoal, c, w);

            if (goal.getString("goal").equals("AND")) {
                // Must achieve both goals to satisfy AND condition
                return firstGoalAchieved && secondGoalAchieved;
            }
            else {
                // Must achieve at least 1 goal to satisfy OR condition
                return firstGoalAchieved || secondGoalAchieved;
            }
        }

        // Recursion resulted in splitting complex goals into 
        // basic goals
        victory v = null;
        if (goal.getString("goal").equals("gold")) {
            v = new victoryGoldStrategy();
        } 
        else if (goal.getString("goal").equals("experience")) {
            v = new victoryExpStrategy();
        }
        else if (goal.getString("goal").equals("cycle")) {
            v = new victoryCycleStrategy();
        }
        int quantity = (int) goal.get("quantity");
        return v.checkVictoryCondition(w,c,quantity);
    }

    // caller ----> calls everything
    public boolean victoryAchieved(Character c, LoopManiaWorld w) {
        // Calls helper function to read the JSON file containing the world
        JSONObject goals = new JSONObject();
        goals = json.getJSONObject("goal-condition");
        // Calls helper function to recursively determine if the goals have been achieved
        return victory(goals, c,w);
    }

    public JSONObject getj()
    {
        return json;
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
        c.setExperience(123455);
        c.setGold(2000);

        System.out.println(w.victoryAchieved(c,w1));
    }
}