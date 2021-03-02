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
     * @param humanMove Contains the current game state including historic moves/results
     * @return Next move
     */
    @Override
    public Move doMove(Move humanMove) {
        Move nextMove = markovChain.nextMove(previousHumanMove);
        if (previousHumanMove != null) {
            markovChain.updateMarkovChain(previousHumanMove, humanMove);
        }
        previousHumanMove = humanMove;

        return nextMove;
    }
}
