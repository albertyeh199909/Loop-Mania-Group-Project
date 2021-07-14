package unsw.loopmania;

public class Slug extends BasicEnemy{
    public Slug(PathPosition pathPosition) {
        super(pathPosition, 10, 2, 5, 2);
    }


    @Override
    public void inflictDamage() {}

    @Override
    public void takeDamage() {}
}
