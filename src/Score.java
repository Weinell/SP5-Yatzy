import java.util.Arrays;

public class Score {

    /*
    aces
    twos
    threes
    fours
    fives
    sixes
    subsum
    bonus
    1pair
    2pair
    3ofakind
    4ofakind
    smallstraight
    largestraight
    fullhouse
    yatzy
    chance
    sum
     */

    private int[] scores;

    public Score()  {

        scores = new int[18];

    }

    public int[] getScores() {
        return scores;
    }

    public int getScores(int combination)  {
        return scores[combination];
    }

    public void setScores(int combination, int value) {
        this.scores[combination] = value;
    }

    @Override
    public String toString() {
        return "\n Player " + "Score" + Arrays.toString(scores);
    }
}
