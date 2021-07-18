package unsw.loopmania;

public class victoryExpStrategy implements victory {
    // check for a gold victory condtion
    public Boolean checkVictoryCondition(LoopManiaWorld w, Character c, int quantity) {
        return c.getExperience() >= quantity;
    }
}
