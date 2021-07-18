package unsw.loopmania;

public class victoryGoldStrategy implements victory {
    // check for a gold victory condtion
    public Boolean checkVictoryCondition(Character c, int quantity) {
        return c.getGold() >= quantity;
    }
}
