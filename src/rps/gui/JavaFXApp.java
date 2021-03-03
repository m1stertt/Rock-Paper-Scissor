package rps.gui;

// Java imports
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX implementation of the RPS game
 *
 * @author smsj
 */
public class JavaFXApp extends Application {

    private static Scene scene;
    private static String username;

    public static void launch() {
        Application.launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        scene = new Scene(loadFXML("HomeView"));
        stage.setScene(scene);
        stage.setTitle("ROCK-PAPER-SCISSORS");
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(JavaFXApp.class.getResource("/rps/gui/view/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        JavaFXApp.username = username;
    }
}