package unsw.loopmania;

import javafx.fxml.FXML;

import java.io.IOException;

public class ShopMenuController {
    private MenuSwitcher gameSwitcher;

    private LoopManiaWorld world;

    public void setGameSwitcher(MenuSwitcher gameSwitcher) {
        this.gameSwitcher = gameSwitcher;
    }

    public void setWorld(LoopManiaWorld world) {this.world = world; }

    @FXML
    private void returnToGame() throws IOException {
        gameSwitcher.switchMenu();
    }
}
