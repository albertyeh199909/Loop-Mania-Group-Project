package unsw.loopmania;

public class ArmorStrategy implements Defense {
    public void defense(DamageClass damage) {
        damage.setValue(damage.getDamage()/2);
    }
    public void specialEffect(DamageClass damage){}
    
}
