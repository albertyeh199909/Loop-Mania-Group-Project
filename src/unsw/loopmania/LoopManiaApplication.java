package unsw.loopmania;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * the main application
 * run main method from this class
 */
public class LoopManiaApplication extends Application {
    // TODO = possibly add other menus?

    /**
     * the controller for the game. Stored as a field so can terminate it when click exit button
     */
    private LoopManiaWorldController mainController;

    @Override
    public void start(Stage primaryStage) throws IOException {
        // set title on top of window bar
        primaryStage.setTitle("Loop Mania");

        // prevent human player resizing game window (since otherwise would see white space)
        // alternatively, you could allow rescaling of the game (you'd have to program resizing of the JavaFX nodes)
        primaryStage.setResizable(false);

        // load the main game
        LoopManiaWorldControllerLoader loopManiaLoader = new LoopManiaWorldControllerLoader("world_with_twists_and_turns.json");
        mainController = loopManiaLoader.loadController();
        FXMLLoader gameLoader = new FXMLLoader(getClass().getResource("LoopManiaView.fxml"));
        gameLoader.setController(mainController);
        Parent gameRoot = gameLoader.load();

        // load the main menu
        MainMenuController mainMenuController = new MainMenuController();
        FXMLLoader menuLoader = new FXMLLoader(getClass().getResource("MainMenuView.fxml"));
        menuLoader.setController(mainMenuController);
        Parent mainMenuRoot = menuLoader.load();

        // load the lose menu
        LoseScreenController loseScreenController = new LoseScreenController();
        FXMLLoader loseScreenLoader = new FXMLLoader(getClass().getResource("loseScreen.fxml"));
        loseScreenLoader.setController(loseScreenController);
        Parent loseScreenRoot = loseScreenLoader.load();

        // load the win menu
        WinScreenController winScreenController = new WinScreenController();
        FXMLLoader winScreenLoader = new FXMLLoader(getClass().getResource("winScreen.fxml"));
        winScreenLoader.setController(winScreenController);
        Parent winScreenRoot = winScreenLoader.load();

        //load the goal menu
        GoalMenuController goalMenuController = new GoalMenuController("world_with_twists_and_turns.json");
        FXMLLoader goalMenuLoader = new FXMLLoader(getClass().getResource("goalView.fxml"));
        goalMenuLoader.setController(goalMenuController);
        Parent goalMenuRoot = goalMenuLoader.load();


        // create new scene with the main menu (so we start with the main menu)
        Scene scene = new Scene(mainMenuRoot);

        loseScreenController.setGameSwitcher(() -> {
            switchToRoot(scene, gameRoot, primaryStage);
            mainController.startTimer();
            }, () -> {switchToRoot(scene, mainMenuRoot, primaryStage);
        });

        winScreenController.setGameSwitcher(() -> {
            switchToRoot(scene, gameRoot, primaryStage);
            mainController.startTimer();
        }, () -> {switchToRoot(scene, mainMenuRoot, primaryStage);
        });

        goalMenuController.setGameSwitcher(() -> {
            switchToRoot(scene, gameRoot, primaryStage);
        });
        
        // set functions which are activated when button click to switch menu is pressed
        // e.g. from main menu to start the game, or from the game to return to main menu
        mainController.setMainMenuSwitcher(() -> {switchToRoot(scene, mainMenuRoot, primaryStage);}, () -> {switchToRoot(scene, loseScreenRoot, primaryStage);}, () -> {switchToRoot(scene, winScreenRoot, primaryStage);}, () -> {switchToRoot(scene, goalMenuRoot, primaryStage);});
        mainMenuController.setGameSwitcher(() -> {
            switchToRoot(scene, gameRoot, primaryStage);
            mainController.startTimer();
        });
        
        // deploy the main onto the stage
        gameRoot.requestFocus();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop(){
        // wrap up activities when exit program
        mainController.terminate();
    }

    /**
     * switch to a different Root
     */
    private void switchToRoot(Scene scene, Parent root, Stage stage){
        scene.setRoot(root);
        root.requestFocus();
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }

    public static void main(String[] args) {
        /*
        String bip = "bip.mp3";
        Media hit = new Media(new File(bip).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();
        */
        launch(args);
    }
}
