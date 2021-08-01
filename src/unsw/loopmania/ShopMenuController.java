package unsw.loopmania;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class ShopMenuController {
    private MenuSwitcher gameSwitcher;

    private LoopManiaWorld world;

    @FXML
    private Label outputFeedback;

    public void setGameSwitcher(MenuSwitcher gameSwitcher) {
        this.gameSwitcher = gameSwitcher;
    }

    public void setWorld(LoopManiaWorld world) {this.world = world; }

    @FXML
    private void buySword() {
        if (world.purchase("sword")) {
            outputFeedback.setText("Success!");
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
        } else {
            outputFeedback.setText("Sorry, you cannot do that yet...");
        }
    }

    @FXML
    private void sellShield() {
        if (world.purchase("Shield")) {
            outputFeedback.setText("Success!");
        } else {
            outputFeedback.setText("Sorry, you cannot do that yet...");
        }
    }

    @FXML
    private void buyHelmet() {
        if (world.purchase("helmet")) {
            outputFeedback.setText("Success!");
        } else {
            outputFeedback.setText("Sorry, you cannot do that yet...");
        }
    }

    @FXML
    private void sellHelmet() {
        if (world.purchase("Helmet")) {
            outputFeedback.setText("Success!");
        } else {
            outputFeedback.setText("Sorry, you cannot do that yet...");
        }
    }

    @FXML
    private void buyPotion() {
        if (world.purchase("potion")) {
            outputFeedback.setText("Success!");
        } else {
            outputFeedback.setText("Sorry, you cannot do that yet...");
        }
    }

    @FXML
    private void sellPotion() {
        if (world.purchase("Potion")) {
            outputFeedback.setText("Success!");
        } else {
            outputFeedback.setText("Sorry, you cannot do that yet...");
        }
    }

    @FXML
    private void returnToGame() throws IOException {
        gameSwitcher.switchMenu();
    }
}
