package unsw.loopmania;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;


/**
 * represents a non-moving entity
 * unlike the moving entities, this can be placed anywhere on the game map
 */
public abstract class StaticEntity extends Entity {
    /**
     * x and y coordinates represented by IntegerProperty, so ChangeListeners can be added
     */
    private IntegerProperty x = new SimpleIntegerProperty();
    private IntegerProperty y = new SimpleIntegerProperty();

    public StaticEntity() {
        super();
    }

    public StaticEntity(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super();
        this.x = x;
        this.y = y;
    }

    public IntegerProperty x() 
    {
        return x;
    }

    public IntegerProperty y() 
    {
        return y;
    }

    public int getX() 
    {
        return x.get();
    }

    public int getY() 
    {
        return y.get();
    }

    public void setX(int x)
    {
        this.x.set(x);
    }

    public void setY(int y)
    {
        this.y.set(y);
    }
}
