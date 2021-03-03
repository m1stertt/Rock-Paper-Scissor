package rps.bll.player;

//Project imports

import rps.bll.game.Move;

//Java imports

/**
 * Example implementation of a player.
 *
 * @author smsj
 */
public class Player implements IPlayer {

    private Move previousHumanMove;

    private MarkovChain markovChain;

    private String name;
    private PlayerType type;

    /**
     * @param name
     */
    public Player(String name, PlayerType type) {
        this.markovChain = new MarkovChain();
        this.name = name;
        this.type = type;
    }


    @Override
    public String getPlayerName() {
        return name;
    }


    @Override
    public PlayerType getPlayerType() {
        return type;
    }


    /**
     * Decides the next move for the bot...
     *
     * @param humanMove Contains the current move of the game.
     * @return Next move
     */
    @Override
    public Move doMove(Move humanMove) {
        Move nextMove = markovChain.nextMove(previousHumanMove); // We grab the nextMove.
        if (previousHumanMove != null) { // After the initial move, every move
            markovChain.updateMarkovChain(previousHumanMove, humanMove); // we will update the markovChain with the previous and current humanMove.
        }
        previousHumanMove = humanMove; // We update previousMove to the current move after all above statements have executed.

        return nextMove; // Finally return the nextMove.
    }
}
