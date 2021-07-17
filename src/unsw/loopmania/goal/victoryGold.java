package unsw.loopmania.goals;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;

import unsw.loopmania.world;

public abstract class victoryGold extends victory{
   // check for a specific victory condtion
   @Override
   public Boolean checkVictoryCondition(Character c, world w)
   {
       return true;
   }
}