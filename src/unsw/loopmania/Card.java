package unsw.loopmania;

import javafx.beans.property.SimpleIntegerProperty;

/**
 * a Card in the world
 * which doesn't move
 */
public class Card extends StaticEntity {
    // TODO = implement other varieties of card than VampireCastleCard
    private String type;

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Card(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }
}
