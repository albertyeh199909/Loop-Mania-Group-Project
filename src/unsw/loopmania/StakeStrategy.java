package unsw.loopmania;

public class StakeStrategy implements Damage{
    
    public DamageClass dealDamage(Character character, BasicEnemy entity) {
        int damage = 3;
        if(entity instanceof Vampire) {
            damage = 6;
        }
        return new DamageClass(character, damage, 0);
    }
    

}
