package rps.gui.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import rps.gui.JavaFXApp;

import java.io.IOException;

public class HomeViewController{
    @FXML
    private JFXButton openApplication;
    @FXML
    private JFXTextField userName;

    public void opensApplication() throws IOException {
        if(getUserName().isEmpty()){
            alertWarn();
            return;
        }
        JavaFXApp.setUsername(getUserName());
        JavaFXApp.setRoot("GameView");
    }
    public String getUserName(){
        String username = userName.getText();
        return username;
    }

    private void alertWarn(){
        Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter a username, it is currently blank.", ButtonType.OK);
        alert.setTitle("No Username Error");
        alert.setHeaderText("Unable to launch the game.");
        alert.showAndWait();

    }
}
