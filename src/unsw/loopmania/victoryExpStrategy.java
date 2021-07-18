package unsw.loopmania;

public class victoryExpStrategy implements victory {
    // check for a gold victory condtion
    public Boolean checkVictoryCondition(Character c, int quantity) {
        return c.getExperience() >= quantity;
    }
}
