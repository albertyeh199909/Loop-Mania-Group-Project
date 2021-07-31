package unsw.loopmania;

public class Slug extends BasicEnemy{
    public Slug(PathPosition pathPosition) {
        super(pathPosition, 1, 3, 1);
        setMaximumHealth(3);
        setHealth(getMaximumHealth());
    }
    
    @Override
    public void move(Character character) {
        //Twice as fast as zombies
        super.move(character);
        super.move(character);
    }
}
