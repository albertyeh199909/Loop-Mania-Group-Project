package unsw.loopmania;

import org.json.JSONObject;
import org.json.JSONArray;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class victoryFinal {
    // Helper function for reading a JSON file
    public static JSONObject getJSONObject(String filename) {
        try {
            return new JSONObject(new String(Files.readAllBytes(Paths.get(filename))));
        } catch (IOException e) {
            return null;
        }
    }

    // Helper function that recursively check goals
    public static boolean victory(JSONObject goals, Character c) {
        JSONObject  goal = (JSONObject) goals.get("goal");

        // Recursive part
        // This section is skipped if it's a basic goal
        if (goal.equals("AND") || goal.equals("OR")) {
            // Get the JSONArray and subsequently the 2 subgoals
            JSONArray subgoals = (JSONArray) goal.get("subgoals");
            JSONObject firstGoal = new JSONObject(subgoals.getString(0));
            JSONObject secondGoal = new JSONObject(subgoals.getString(1));

            // Recursion to split the problem into subproblems
            boolean firstGoalAchieved = victory(firstGoal, c);
            boolean secondGoalAchieved = victory(secondGoal, c);

            if (goals.equals("AND") {
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
        victory v;
        if (goals.equals("gold")) {
            v = new victoryGold();
        } 
        else if (goals.equals("experience")) {
            v = new victoryExp();
        }
        else if (goals.equals("cycle")) {
            v = new victoryCycle();
        }
        int quantity = (int) goals.get("quantity");
        return v.checkVictoryCondition(c, quantity);
    }

    public static boolean victoryAchieved(Character c, String filename) {
        // Calls helper function to read the JSON file containing the world
        JSONObject file = getJSONObject(filename); 
        JSONObject goals = (JSONObject) file.get("goal-condition");
        // Calls helper function to recursively determine if the goals have been achieved
        return victory(goals, c);
    }
}