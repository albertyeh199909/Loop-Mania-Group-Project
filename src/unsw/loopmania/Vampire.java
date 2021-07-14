package unsw.loopmania;

public class Vampire extends BasicEnemy {
    public Vampire(PathPosition pathPosition) {
        super(pathPosition, 10, 4, 10, 2);
    }

    @Override
    public void inflictDamage() {}

    @Override
    public void takeDamage() {}
}
