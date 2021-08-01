package unsw.loopmania;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;

/**
 * controller for the main menu.
 * TODO = you could extend this, for example with a settings menu, or a menu to load particular maps.
 */
public class MainMenuController {
    /**
     * facilitates switching to main game
     */
    private MenuSwitcher gameSwitcher;

    @FXML
    private CheckBox standardModeCheckBox;

    @FXML
    private CheckBox survivalModeCheckBox;

    @FXML
    private CheckBox berserkerModeCheckBox;

    @FXML
    private CheckBox confusingModeCheckBox;

    public void setGameSwitcher(MenuSwitcher gameSwitcher){
        this.gameSwitcher = gameSwitcher;
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
    public void initialize() {
        LoopManiaWorld.standardMode.bindBidirectional(standardModeCheckBox.selectedProperty());
        LoopManiaWorld.survivalMode.bindBidirectional(survivalModeCheckBox.selectedProperty());
        LoopManiaWorld.berserkerMode.bindBidirectional(berserkerModeCheckBox.selectedProperty());
        LoopManiaWorld.confusingMode.bindBidirectional(confusingModeCheckBox.selectedProperty());
    }
}
