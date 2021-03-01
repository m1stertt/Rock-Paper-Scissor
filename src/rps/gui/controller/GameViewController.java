package rps.gui.controller;

// Java imports
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 *
 * @author smsj
 */
public class GameViewController implements Initializable {

    @FXML
    private ImageView playerImageView;
    @FXML
    private Label resultInput;
    @FXML
    private ImageView computerImageView;
    @FXML
    private JFXButton rock;
    @FXML
    private JFXButton paper;
    @FXML
    private JFXButton scissor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void playsRock(ActionEvent actionEvent) {
    }

    public void playsPaper(ActionEvent actionEvent) {
    }

    public void playsScissor(ActionEvent actionEvent) {
    }
}
