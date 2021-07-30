package unsw.loopmania;

public class victoryBossStrategy implements victory {
    public Boolean checkVictoryCondition(LoopManiaWorld w, Character c, int quantity) {
        return w.getBossesKilled() >= quantity;
    }
}
