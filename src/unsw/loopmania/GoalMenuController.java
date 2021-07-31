package unsw.loopmania;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GoalMenuController {
    @FXML
    private Text displayWindow;

    private JSONObject goalFile;

    private MenuSwitcher gameSwitcher;

    public GoalMenuController() throws FileNotFoundException {
        goalFile = new JSONObject(new JSONTokener(new FileReader("worlds/basic_world_with_player.json")));
    }

    public void displayGoal() {
        displayWindow.setText(goalFile.getString("goal-condition"));
    }

    public void setGameSwitcher(MenuSwitcher gameSwitcher) {
        this.gameSwitcher = gameSwitcher;
    }

    @FXML
    private void returnToGame() throws IOException {
        gameSwitcher.switchMenu();
    }


}
