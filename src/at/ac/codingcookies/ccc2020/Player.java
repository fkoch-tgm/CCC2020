package at.ac.codingcookies.ccc2020;

/**
 * TODO doc
 *
 * @author Felix Koch
 * @version 2020-10-30
 */
public class Player {
    int id;
    int wins;
    int points;
    int rating;

    public void changeRating(int rating) {
        this.rating += rating;
    }

    public int getRating() {
        return rating;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void changePoints(int points) {
        this.points += points;
    }

    public int getId() {
        return id;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Player(int id) {
        this.id = id;
        this.wins = 0;
        this.points = 0;
        this.rating = 1000;
    }

    public String toString() {
        return id + " " + rating;
    }

    /**
     *
     * @param won aus Game
     * @param chance aus Game
     */
    public void updateRating(int won, int chance) {
        this.rating = rating + 32 * (won - chance);
    }
}
