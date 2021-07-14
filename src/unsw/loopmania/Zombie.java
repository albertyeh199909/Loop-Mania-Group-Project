package unsw.loopmania;

import java.util.Random;

public class Zombie extends BasicEnemy {
    public Zombie(PathPosition pathPosition) {
        super(pathPosition, 10, 4, 10, 2);
    }

    @Override
    public void inflictDamage() {
        if (movingEntity instanceof AlliedSoldier) {
            int randomInt = new Random().nextInt(100);
            if (randomInt <= 10) {
                // Turn alliedSoldier to zombie
            } else {
                super.inflictDamage();
            }

        } else {
            super.inflictDamage();
        }
    }

}
