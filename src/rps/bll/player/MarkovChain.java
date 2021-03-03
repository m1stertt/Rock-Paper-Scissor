package rps.bll.player;

import rps.bll.game.Move;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class MarkovChain {

    private static final Random RANDOM = new Random();

    private HashMap<Move, Move> losesToMap = new HashMap<>();

    // This is used to predict
    // we use a Markov Chain for the AI of our computer
    private int[][] markovChain; // Stores the position numbers from
    private int nbThrows = 0;
    private Move last = null;


    public MarkovChain() {
        losesToMap.put(Move.Rock, Move.Paper);
        losesToMap.put(Move.Paper, Move.Scissor);
        losesToMap.put(Move.Scissor, Move.Rock);


        int length = Move.values().length;
        // Initialize the two-dimensional array with 0 values to make sure the AI is ready to learn.
        // The two-dimensional array has 3 rows and 3 columns.
        markovChain = new int[length][length];
        System.out.println("--------");
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                markovChain[i][j] = 0;
                System.out.println(Arrays.toString(markovChain[i]));
            }
        }
    }

    public void updateMarkovChain(Move prev, Move next) {
        markovChain[prev.ordinal()][next.ordinal()]++; // The position of the Move in the Enum class gets incremented.
    }

    public Move nextMove(Move prev) {
        if (nbThrows < 1) {
            nbThrows++;
            // First move. We can't use MarkovChain prediction yet.
            // A random seed is used.
            return Move.values()[RANDOM.nextInt(Move.values().length)];
        }

        // We try to predict next Move by reading the data in our MarkovChain two-dimensional array.
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
        nbThrows++;
        // we choose the next predicted move we expect will lose to the next user move.
        return losesToMap.get(predictedNext);
    }

}
