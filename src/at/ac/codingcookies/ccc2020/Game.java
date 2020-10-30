package at.ac.codingcookies.ccc2020;

import java.util.List;

/**
 * TODO doc
 *
 * @author Felix Koch
 * @version 2020-10-30
 */
public class Game {
    private Play playA;
    private Play playB;
    private List<Play> plays;

    public Game(List<Play> playlist) {
        plays = playlist;
    }

    /**
     *
     * @return id of the winner
     */
    public int winner() {
        return plays.stream().max((o1, o2) -> o1.getScore() > o2.getScore() ?1:-1).get().getId();
    }

    public int loser() {
        return plays.stream().min((o1, o2) -> o1.getScore() > o2.getScore() ?1:-1).get().getId();
    }

    public int chanceOfWinning_A() {
        double Ea=1/(1)
    }
}
