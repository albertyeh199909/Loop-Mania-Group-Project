package unsw.loopmania;

import javafx.fxml.FXML;

import java.io.IOException;

// Reference: MainMenuController.java
public class LoseScreenController {
    /**
     * facilitates switching to main game
     */
    private MenuSwitcher gameSwitcher;

    private MenuSwitcher menuSwitcher;

    public void setGameSwitcher(MenuSwitcher gameSwitcher, MenuSwitcher menuSwitcher){
        this.gameSwitcher = gameSwitcher;
        this.menuSwitcher = menuSwitcher;
    }

    /**
     * facilitates switching to main game upon button click
     * @throws IOException
     */
    @FXML
    private void switchToGame() throws IOException {
        gameSwitcher.switchMenu();
    }

    @FXML
    private void switchToMainMenu() throws IOException {
        menuSwitcher.switchMenu();
    }
}
