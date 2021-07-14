package unsw.loopmania;

public class Slug extends BasicEnemy{
    public Slug(PathPosition pathPosition) {
        super(pathPosition, 10, 2, 5, 2);
    }

    @Override
    public void move() {
        //Twice as fast as zombies
        super.move();
        super.move();
    }
}
