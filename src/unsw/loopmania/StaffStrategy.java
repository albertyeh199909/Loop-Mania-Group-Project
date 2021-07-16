package unsw.loopmania;

public class StaffStrategy implements Damage {
    public DamageClass dealDamage(Character character, BasicEnemy entity) {
        int damage = 2;
        //calculate chance
        //entity.trance()
        return new DamageClass(character, damage, 0);
        
    }
}
