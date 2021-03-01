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
    private ImageView computerImageView;
    @FXML
    private JFXButton rock;
    @FXML
    private JFXButton paper;
    @FXML
    private JFXButton scissor;

    //boolean rock false;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void playsRock() {

    }

    public void playsPaper() {
    }

    public void playsScissor() {
    }

    public void onAction(ActionEvent ae) {
        Image image;
        Button b = (Button) ae.getSource();
        if (b.equals(rock)) {
            image = new Image(getClass().getResourceAsStream("../view/Images/Rock.png"));
            playerImageView.setImage(image);
        } else if (b.equals(paper)) {
            image = new Image(getClass().getResourceAsStream("../view/Images/Paper.png"));
            playerImageView.setImage(image);
        } else if (b.equals(paper)) {
            image = new Image(getClass().getResourceAsStream("../view/Images/Scissors.png"));
            playerImageView.setImage(image);
        } else {
            return;
        }
    }
}

/*
    public void setPlayedHandAsImage(){
        Image image;
        if(rock.isPressed()){
            image = new Image(getClass().getResourceAsStream("../view/Images/Rock.png"));
            playerImageView.setImage(image);
        }
        else if(paper.isPressed()){
            image = new Image(getClass().getResourceAsStream("../view/Images/Paper.png"));;
            playerImageView.setImage(image);
        }
        else if(scissor.isPressed()){
            image = new Image(getClass().getResourceAsStream("../view/Images/Scissors.png"));;
            playerImageView.setImage(image);
        }
        else{
            return;
        }
    }
*/

