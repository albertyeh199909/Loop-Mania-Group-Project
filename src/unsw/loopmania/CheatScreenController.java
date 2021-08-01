package unsw.loopmania;


import javafx.fxml.FXML;

import java.io.IOException;
import javafx.scene.control.TextField;

// Reference: MainMenuController.java
public class CheatScreenController {
    /**
     * facilitates switching to main game
     */
    private MenuSwitcher gameSwitcher;

    private MenuSwitcher menuSwitcher;

    @FXML
    private TextField healthCheat;

    @FXML 
    private TextField goldCheat;
    
    @FXML
    private TextField expCheat;

    private LoopManiaWorld world;

    public CheatScreenController(LoopManiaWorld world) {
        this.world = world;
    } 

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

    @FXML
    public void addCheat() throws IOException{
        world.addHealth(Integer.parseInt(healthCheat.getText()));
        world.addGold(Integer.parseInt(goldCheat.getText()));
        world.addExp(Integer.parseInt(expCheat.getText()));
        switchToGame();
    }

   


}