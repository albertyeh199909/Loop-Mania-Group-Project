package unsw.loopmania.buildings;

public class Trap extends Building {
    private int attack;

    public Trap() {
        super("Trap", 1);
        attack = 1;
    }

    public int getAttack() {
        return attack;
    }
}