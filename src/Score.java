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
    chance
    Yatzy
    sum
     */

    private ScoreboardField[] scores;
    private String nameOfPlayer;


    public Score(String nameOfPlayer)  {

        scores = new ScoreboardField[18];
        for (int i = 0; i < scores.length; i++) {
            scores[i] = new ScoreboardField();
        }
        this.nameOfPlayer = nameOfPlayer;


    }

    public ScoreboardField[] getScores() {
        return scores;
    }

    public ScoreboardField getScores(int combination)  {
        return scores[combination];
    }

    public void setScores(int combination, int value) {
        this.scores[combination].setValue(value);
        this.scores[combination].setAlreadyUsed(true);
    }


    @Override
    public String toString() {
        return "\n" + nameOfPlayer + ": Score" + Arrays.toString(scores);
    }
}
