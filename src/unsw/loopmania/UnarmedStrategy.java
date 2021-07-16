package unsw.loopmania;

public class UnarmedStrategy implements Damage{
    public DamageClass dealDamage(Character character, BasicEnemy entity) {
        int damage = 1;
        return new DamageClass(character, damage, 0);
    }
}
