package unsw.loopmania;

import java.util.Random;

public class Zombie extends BasicEnemy {
    int criticalChance = 10;
    public Zombie(PathPosition pathPosition) {
        super(pathPosition, 10, 4, 10, 2);
    }

    @Override
    public void inflictDamage() {
        
        DamageClass damage = entity.takeDamage(new DamageClass(this, damageValue, this.criticalChance));
        if (movingEntity instanceof AlliedSoldier && damage.getIsCritical()) {
                // Turn alliedSoldier to zombie
        }
    }

}
