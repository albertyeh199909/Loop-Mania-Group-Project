package unsw.loopmania;

public class Zombie extends BasicEnemy {
    public Zombie(PathPosition pathPosition) {
        super(pathPosition, 10, 4, 10, 2);
    }

    @Override
    public void inflictDamage() {}

    @Override
    public void takeDamage() {}
}
