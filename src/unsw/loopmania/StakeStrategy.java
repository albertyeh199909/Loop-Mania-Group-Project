package unsw.loopmania;

public class StakeStrategy implements Damage{
    
    public DamageClass dealDamage(Character character, Entity entity) {
        int damage = //placeholder
        if(entity instanceof Vampire) {
            damage = //placeholder
        }
        return new DamageClass(character, damage, 0);
    }
    

}
