package at.ac.codingcookies.ccc2020;

public class Play {
    private Player player;
    private int score;

    public Play(Player player, int score) {
        this.player = player;
        this.score = score;
    }

    public int getId() {
        return player.getId();
    }

    public int getScore() {
        return score;
    }

}