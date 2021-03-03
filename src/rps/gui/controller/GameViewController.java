package rps.gui.controller;

// Java imports
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
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
    private Label scoreInput;
    @FXML
    private ImageView computerImageView;
    @FXML
    private JFXButton rock;
    @FXML
    private JFXButton paper;
    @FXML
    private JFXButton scissors;

    Image image;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    String input;
    @FXML
    private void setRock(ActionEvent ae) {
        setRock();
        input = "Rock";
    }
    @FXML
    private void setPaper(ActionEvent ae) {
        setPaper();
        input = "Paper";
    }
    @FXML
    private void setScissors(ActionEvent ae) {
        setScissors();
        input = "Scissors";

    }

    private void setRock(){
        image = new Image(getClass().getResourceAsStream("../view/Images/rock.png"));
        playerImageView.setImage(image);
    }
    private void setPaper(){
        image = new Image(getClass().getResourceAsStream("../view/Images/paper.png"));
        playerImageView.setImage(image);
    }
    private void setScissors(){
        image = new Image(getClass().getResourceAsStream("../view/Images/scissors.png"));
        playerImageView.setImage(image);
    }
}


    /*FXML
    private String setPlayedHandAsImage(ActionEvent ae) {
        String input;
        Button b = (Button) ae.getSource();
        if (b.equals(rock)) {
            setRock();
            input = "Rock";
        } else if (b.equals(paper)) {
            setPaper();
            input = "Paper";
        } else if (b.equals(scissors)) {
            setScissors();
            input = "Scissors";
        } else {
            return null;
        }
        return input;
    }*/