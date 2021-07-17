package unsw.loopmania.goals;
import unsw.loopmania.world;

public abstract class victoryCycle extends victory{
   // check for a specific victory condtion
   @Override
   public Boolean checkVictoryCondition(Character c, world w)
   {
       return true;
   }
}
