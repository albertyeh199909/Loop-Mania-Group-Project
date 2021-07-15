package unsw.loopmania;

import javafx.beans.property.SimpleIntegerProperty;

public class Gold extends Entity
{
    int number;
    PathPosition position;

    //Constructor
    /*
        @initNum is the initial gold that the main character should have
        @param postion is the postion of the current item
        note: the sell price for this item will be 1/2 of the pruchase price
    */
    public Gold(int initNum, PathPosition position)
    {
        this.number = initNum;
    }
    
    //Getters
    public int getGold()
    {
        return number;
    }

    //Setters
    public void setGold(int number)
    {
        this.number = number;
    }

    // display
    public void display()
    {

    }

     // implement the abstract functions in entites class
    public SimpleIntegerProperty x() {
        return position.getX();
    }

    public SimpleIntegerProperty y() {
        return position.getY();
    }

    public int getX() {
        return x().get();
    }

    public int getY() {
        return y().get();
    }
}
