package unsw.loopmania.buildings;

public class Village extends Building {
    private int heal;

    public Village() {
        super("Village", 1);
        heal = 1;
    }

    public int getHeal() {
        return heal;
    }
}