package unsw.loopmania;

public class AndurilStrategy implements Damage {
 
    /**
    *  @param character  the character that is attacking
    *  @param entity     the entity that the character is attacking
    */
    public DamageClass dealDamage(Character character, BasicEnemy entity) {
        int damage = 15;
        if(entity instanceof ElanMuske || entity instanceof Doggie) {
            damage = damage * 3;
        }
        return new DamageClass(character, damage, 0);
    }
}
