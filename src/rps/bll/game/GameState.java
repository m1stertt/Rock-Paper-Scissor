package rps.bll.game;

//Java imports
import java.util.ArrayList;

/**
 * Keeps track of game state including historic results
 *
 * @author smsj
 */
public class GameState implements IGameState {

    private ArrayList<Result> historicResults;
    private int roundNumber;

    /**
     *
     * @param historicResults
     * @param roundNumber
     */
    public GameState(ArrayList<Result> historicResults, int roundNumber) {
        this.historicResults = new ArrayList<>();
        this.roundNumber = roundNumber;
    }

    @Override
    public int getRoundNumber() {
        return roundNumber;
    }

    @Override
    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    @Override
    public ArrayList<Result> getHistoricResults() {
        return historicResults;
    }
}
