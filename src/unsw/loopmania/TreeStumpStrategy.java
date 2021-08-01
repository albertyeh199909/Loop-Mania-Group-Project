package unsw.loopmania;

public class TreeStumpStrategy implements Defense  {
    /**
    * Implements defense against bosses
    * @param damage The damage class of the attack
    */
    public void defense(DamageClass damage) {
        
        if(damage.getDamagedealer() instanceof Doggie || damage.getDamagedealer() instanceof ElanMuske) {
            damage.setValue(damage.getDamage()/2);
        }
        
    }

    /**
    * Implements crit damage of vampire
    * @param damage The damage class of the attack
    */
    public void specialEffect(DamageClass damage){
        if(damage.getDamagedealer() instanceof Vampire) {
            damage.setCriticalChance(damage.getCriticalChance()-6);
        }
    }
}
