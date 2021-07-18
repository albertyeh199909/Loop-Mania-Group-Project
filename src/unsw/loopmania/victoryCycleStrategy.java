package unsw.loopmania;

public class victoryCycleStrategy implements victory {
    public Boolean checkVictoryCondition(LoopManiaWorld w, Character c, int quantity) {
        return w.getCycleCounter() >= quantity;
    }
}
