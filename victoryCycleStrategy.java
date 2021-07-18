package unsw.loopmania;

public class victoryCycleStrategy implements victory {
    // check for a gold victory condtion
    public Boolean checkVictoryCondition(LoopManiaWorld w, Character c, int quantity) {
        return w.getTurnCounter() >= quantity;
    }
}
