package unsw.loopmania;
import java.io.FileNotFoundException;

public class whatever extends LoopManiaWorldLoader {
    public whatever() throws FileNotFoundException
    {
        super("world_with_twists_and_turns.json");
    }
    public void onLoad(Character character)
    {
        return;
    }
    public  void onLoad(PathTile pathTile, PathTile.Direction into, PathTile.Direction out)
    {
        return;
    }
    public static void main(String[] Args)
    {
        whatever w = null;
        try{
            w = new whatever();
        }
        catch(FileNotFoundException e){
            System.out.println("error");
        }
        LoopManiaWorld w1;
        w1 = w.load();
        System.out.println(w1.getHeight());

    }

}