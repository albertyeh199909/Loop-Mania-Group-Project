package unsw.loopmania;

public class SwordStrategy implements Damage {
    

    public DamageClass dealDamage(Character character,BasicEnemy entity) {
        int damage = 4;
        return new DamageClass(character, damage, 0);
    }
    
}
