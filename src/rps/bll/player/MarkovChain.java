package rps.bll.player;

import rps.bll.game.Move;

import java.util.HashMap;
import java.util.Random;

public class MarkovChain {

    private static final Random RANDOM = new Random();

    private HashMap<Move, Move> losesToMap = new HashMap<>();


    // we use a Markov Chain for the AI of our computer
    private int[][] markovChain; // used just for the prev to current throws prediction
    private int nbThrows = 0;
    private Move last = null;


    public MarkovChain() {
        losesToMap.put(Move.Scissor, Move.Rock);
        losesToMap.put(Move.Rock, Move.Paper);
        losesToMap.put(Move.Paper, Move.Scissor);

        int length = Move.values().length;
        markovChain = new int[length][length];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                markovChain[i][j] = 0;
            }
        }
    }

    public void updateMarkovChain(Move prev, Move next) {
        markovChain[prev.ordinal()][next.ordinal()]++;
    }

    public Move nextMove(Move prev) {
        if (nbThrows < 1) {
            // First move. We can't use MarkovChain prediction yet.
            // A random seed is used.
            return Move.values()[RANDOM.nextInt(Move.values().length)];
        }

        // We try to predict next Move by reading the date in our MarkovChain
        // for the prev entry in the array.
        int nextIndex = 0;

        for (int i = 0; i < Move.values().length; i++) {
            int prevIndex = prev.ordinal();

            if (markovChain[prevIndex][i] > markovChain[prevIndex][nextIndex]) {
                nextIndex = i;
            }
        }

        // The Move that is probably played by the user is in the nextIndex.
        Move predictedNext = Move.values()[nextIndex];

        // we choose the next predicted move we except will lose to the next user move.
        return losesToMap.get(predictedNext);
    }

}
