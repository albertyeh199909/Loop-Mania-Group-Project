package unsw.loopmania;

public class ShieldStrategy implements Defense {
    
    public void defense(DamageClass damage) {
        
    }
    public void specialEffect(DamageClass damage){
        if(damage.getDamagedealer() instanceof Vampire) {
            damage.setCriticalChance(damage.getCriticalChance()-6);
        }
    }
}