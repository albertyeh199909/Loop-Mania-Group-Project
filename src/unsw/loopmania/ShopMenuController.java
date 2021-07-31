package unsw.loopmania;

import javafx.fxml.FXML;

import java.io.IOException;

public class ShopMenuController {
    private MenuSwitcher gameSwitcher;

    public void setGameSwitcher(MenuSwitcher gameSwitcher) {
        this.gameSwitcher = gameSwitcher;
    }

    @FXML
    private void returnToGame() throws IOException {
        gameSwitcher.switchMenu();
    }
}
