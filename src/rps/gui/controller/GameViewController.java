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
import rps.bll.game.GameManager;
import rps.bll.game.Move;
import rps.bll.game.Result;
import rps.bll.player.IPlayer;
import rps.bll.player.Player;
import rps.bll.player.PlayerType;

import java.net.URL;
import java.util.*;

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
    private Label aiName;
    @FXML
    private Label gameIntro;
    @FXML
    private ImageView computerImageView;
    @FXML
    private JFXButton rock;
    @FXML
    private JFXButton paper;
    @FXML
    private JFXButton scissors;

    Image image;
    GameManager ge;
    String playerName = "You";
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        IPlayer human = new Player(playerName, PlayerType.Human);

        String botName = getRandomBotName();
        IPlayer bot = new Player(botName, PlayerType.AI);
        aiName.setText(botName + " Chooses:");
        gameIntro.setText("Your opponent will be "+botName+". Have fun and try to beat "+botName+".");

        ge = new GameManager(human, bot);

        //System.out.println("Your opponent is " + bot.getPlayerName());
        //System.out.println("Starting game.... good luck both!");
    }

    @FXML
    private void setPlayedHandAsImage(ActionEvent ae) {
        Button b = (Button) ae.getSource();
        Move playerMove=Move.Rock;
        if (b.equals(paper)) {
            playerMove=Move.Paper;
        } else if (b.equals(scissors)) {
            playerMove=Move.Scissor;
        }
        setImageViewPlay(playerMove,playerImageView);
        ge.playRound(playerMove);


        ArrayList<Result> res= (ArrayList<Result>) ge.getGameState().getHistoricResults();
        Result last=res.get(res.size()-1);

        resultInput.setText(last.getWinnerPlayer().getPlayerName());
        if(last.getWinnerPlayer().getPlayerName()==playerName){
            setImageViewPlay(last.getLoserMove(),computerImageView);
        }else{
            setImageViewPlay(last.getWinnerMove(),computerImageView);
        }
    }

    private void setImageViewPlay(Move move, ImageView view){
        switch(move){
            case Rock:
                image = new Image(getClass().getResourceAsStream("../view/Images/rock.png"));
                break;
            case Paper:
                image = new Image(getClass().getResourceAsStream("../view/Images/paper.png"));
                break;
            case Scissor:
                image = new Image(getClass().getResourceAsStream("../view/Images/scissors.png"));
                break;

        }
        view.setImage(image);
    }

    /**
     * Famous robots...
     * @return
     */
    private String getRandomBotName() {
        String[] botNames = new String[] {
                "R2D2",
                "Mr. Data",
                "3PO",
                "Bender",
                "Marvin the Paranoid Android",
                "Bishop",
                "Robot B-9",
                "HAL"
        };
        int randomNumber = new Random().nextInt(botNames.length - 1);

        return botNames[randomNumber];
    }
}


