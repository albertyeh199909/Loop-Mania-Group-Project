package unsw.loopmania;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class ShopMenuController {
    private MenuSwitcher gameSwitcher;

    private LoopManiaWorld world;

    private LoopManiaWorldController loopManiaWorldController;

    @FXML
    private Label outputFeedback;

    public void setGameSwitcher(MenuSwitcher gameSwitcher) {
        this.gameSwitcher = gameSwitcher;
    }

    public void setWorld(LoopManiaWorld world) {this.world = world; }

    public void setLoopManiaWorldController(LoopManiaWorldController loopManiaWorldController) {
        this.loopManiaWorldController = loopManiaWorldController;
    }

    @FXML
    private void buySword() {
        if (world.purchase("sword")) {
            outputFeedback.setText("Success!");
            loopManiaWorldController.onLoad(ItemFactory.generateBasicItems(eItems.Sword,world.getFirstAvailableSlotForItem().getValue0(),world.getFirstAvailableSlotForItem().getValue1()));
        } else {
            outputFeedback.setText("Sorry, you cannot do that yet...");
        }
    }

    @FXML
    private void sellSword() {
        if (world.sell("Sword")) {
            outputFeedback.setText("Success!");
        } else {
            outputFeedback.setText("Sorry, you cannot do that yet...");
        }
    }

    @FXML
    private void buyStake() {
        if (world.purchase("stake")) {
            outputFeedback.setText("Success!");
            loopManiaWorldController.onLoad(ItemFactory.generateBasicItems(eItems.Stake,world.getFirstAvailableSlotForItem().getValue0(),world.getFirstAvailableSlotForItem().getValue1()));
        } else {
            outputFeedback.setText("Sorry, you cannot do that yet...");
        }
    }

    @FXML
    private void sellStake() {
        if (world.sell("Stake")) {
            outputFeedback.setText("Success!");
        } else {
            outputFeedback.setText("Sorry, you cannot do that yet...");
        }
    }

    @FXML
    private void buyStaff() {
        if (world.purchase("staff")) {
            outputFeedback.setText("Success!");
            loopManiaWorldController.onLoad(ItemFactory.generateBasicItems(eItems.Staff,world.getFirstAvailableSlotForItem().getValue0(),world.getFirstAvailableSlotForItem().getValue1()));
        }
        else {
            outputFeedback.setText("Sorry, you cannot do that yet...");
        }
    }

    @FXML
    private void sellStaff() {
        if (world.sell("Staff")) {
            outputFeedback.setText("Success!");
        }
        else {
            outputFeedback.setText("Sorry, you cannot do that yet...");
        }
    }

    @FXML
    private void buyArmour() {
        if (world.purchase("armour")) {
            outputFeedback.setText("Success!");
            loopManiaWorldController.onLoad(ItemFactory.generateBasicItems(eItems.Armour,world.getFirstAvailableSlotForItem().getValue0(),world.getFirstAvailableSlotForItem().getValue1()));
        } else {
            outputFeedback.setText("Sorry, you cannot do that yet...");
        }
    }

    @FXML
    private void sellArmour() {
        if (world.sell("Armour")) {
            outputFeedback.setText("Success!");
        } else {
            outputFeedback.setText("Sorry, you cannot do that yet...");
        }
    }

    @FXML
    private void buyShield() {
        if (world.purchase("shield")) {
            outputFeedback.setText("Success!");
            loopManiaWorldController.onLoad(ItemFactory.generateBasicItems(eItems.Shield,world.getFirstAvailableSlotForItem().getValue0(),world.getFirstAvailableSlotForItem().getValue1()));
        } else {
            outputFeedback.setText("Sorry, you cannot do that yet...");
        }
    }

    @FXML
    private void sellShield() {
        if (world.sell("Shield")) {
            outputFeedback.setText("Success!");
        } else {
            outputFeedback.setText("Sorry, you cannot do that yet...");
        }
    }

    @FXML
    private void buyHelmet() {
        if (world.purchase("helmet")) {
            outputFeedback.setText("Success!");
            loopManiaWorldController.onLoad(ItemFactory.generateBasicItems(eItems.Helmet,world.getFirstAvailableSlotForItem().getValue0(),world.getFirstAvailableSlotForItem().getValue1()));
        } else {
            outputFeedback.setText("Sorry, you cannot do that yet...");
        }
    }

    @FXML
    private void sellHelmet() {
        if (world.sell("Helmet")) {
            outputFeedback.setText("Success!");
        } else {
            outputFeedback.setText("Sorry, you cannot do that yet...");
        }
    }

    @FXML
    private void buyPotion() {
        if (world.purchase("potion")) {
            outputFeedback.setText("Success!");
            loopManiaWorldController.onLoad(ItemFactory.generateBasicItems(eItems.Potion,world.getFirstAvailableSlotForItem().getValue0(),world.getFirstAvailableSlotForItem().getValue1()));
        } else {
            outputFeedback.setText("Sorry, you cannot do that yet...");
        }
    }

    @FXML
    private void sellPotion() {
        if (world.sell("Potion")) {
            outputFeedback.setText("Success!");
        } else {
            outputFeedback.setText("Sorry, you cannot do that yet...");
        }
    }

    @FXML
    private void returnToGame() throws IOException {
        outputFeedback.setText("");
        gameSwitcher.switchMenu();
    }
}
