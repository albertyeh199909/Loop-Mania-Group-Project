package unsw.loopmania;

public class victoryCycleStrategy implements victory {
    // check for a gold victory condtion
    public Boolean checkVictoryCondition(Character c, int quantity) {
        return c.getCycle() >= quantity;
    }
}
