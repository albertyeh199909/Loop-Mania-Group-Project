package unsw.loopmania;

public class AndurilStrategy implements Damage {
 
    public DamageClass dealDamage(Character character, BasicEnemy entity) {
        int damage = 15;
        if(entity instanceof ElanMuske || entity instanceof Doggie) {
            damage = damage * 3;
        }
        return new DamageClass(character, damage, 0);
    }
}
