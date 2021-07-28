package unsw.loopmania;
import java.util.*;

public class DoggieCoin {
    private int amount = 0;
    private int sellValue = 0;

    
    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getSellValue() {
        return this.sellValue;
    }

    public void setSellValue(int sellValue) 
    {
        this.sellValue = sellValue;
    }

    /**
     * randomly increases doggiecoin value
     */
    public void inflation()
    {
        int random = new Random().nextInt(50);
        sellValue = sellValue + random;
    }

    /**
     * randomly decreases doggiecoin value
     */
     public void deflation()
    {
        int random = new Random().nextInt(50);
        if(sellValue > random)
            sellValue = sellValue - random;
        else
            sellValue = 0;
    }
}
