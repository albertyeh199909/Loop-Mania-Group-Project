package unsw.loopmania;

import java.util.Random;

public class StaffStrategy implements Damage {
    public DamageClass dealDamage(Character character, BasicEnemy entity) {
        int damage = 2;
        //calculate chance
        Random random = new Random();
        if(random.nextInt(3) > 1) {
            entity.setTrance(3);
        }
       
        
        return new DamageClass(character, damage, 0);
        
    }
}
