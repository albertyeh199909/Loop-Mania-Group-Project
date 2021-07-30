package unsw.loopmania;

public class TreeStumpStrategy implements Defense  {
    public void defense(DamageClass damage) {
        
        if(damage.getDamagedealer() instanceof Doggie || damage.getDamagedealer() instanceof ElanMuske) {
            damage.setValue(damage.getDamage()/2);
        }
        
    }
    public void specialEffect(DamageClass damage){
        if(damage.getDamagedealer() instanceof Vampire) {
            damage.setCriticalChance(damage.getCriticalChance()-6);
        }
    }
}
