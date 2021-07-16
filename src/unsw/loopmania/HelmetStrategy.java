package unsw.loopmania;

public class HelmetStrategy implements Defense {
    
    public void defense(DamageClass damage) {
        damage.setValue(damage.getDamage()-2);
    }
    public void specialEffect(DamageClass damage){
        if(damage.getDamagedealer() instanceof Character) {
            damage.setValue(damage.getValue() - 1);
        }
    }
}
