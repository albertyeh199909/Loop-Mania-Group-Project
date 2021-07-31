package unsw.loopmania;
import java.util.*;

import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;


public class DoggieCoin {
    private int amount = 0;
    private int sellValue = 0;

    private StringProperty amountDisplay = new SimpleStringProperty();
    private StringProperty sellValueDisplay = new SimpleStringProperty();

    public StringProperty getAmountDisplay() {
        return this.amountDisplay;
    }

 
    public StringProperty getSellValueDisplay() {
        return this.sellValueDisplay;
    }

    public DoggieCoin() {
        setAmount(0);
        setSellValue(0);
    }





    
    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
        this.amountDisplay.set("Amount:"+String.valueOf(amount));

    }

    public int getSellValue() {
        return this.sellValue;
    }

    public void setSellValue(int sellValue) 
    {
        this.sellValue = sellValue;
        this.sellValueDisplay.set("Value:"+String.valueOf(sellValue));
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
