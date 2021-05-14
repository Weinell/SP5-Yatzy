import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Scoreboard {


    private Score[] scoreboard;

    public Scoreboard(int numPlayers) {

        scoreboard = new Score[numPlayers];
        for (int i = 0; i < scoreboard.length; i++) {

            scoreboard[i] = new Score();
        }

    }

    public void addPoints(int playerID, int combination, int points) {

        scoreboard[playerID].setScores(combination,points);
        subSum();
        totalSum();
    }

    public void subSum()    {

        int sum = 0;

        for (int i = 0; i < scoreboard.length; i++) {

            for (int j = 0; j < 6; j++) {

                sum += scoreboard[i].getScores(j);

            }
            scoreboard[i].setScores(6,sum);
            sum = 0;
        }
    }


    public void totalSum()    {

        int sum = 0;

        for (int i = 0; i < scoreboard.length; i++) {

            for (int j = 6; j < 17; j++) {

                sum += scoreboard[i].getScores(j);

            }
            scoreboard[i].setScores(17,sum);
            sum = 0;
        }
    }



    public Score[] getScoreboard() {
        return scoreboard;
    }

    public void setScoreboard(Score[] scoreboard) {
        this.scoreboard = scoreboard;
    }

    @Override
    public String toString() {
        return "Scoreboard:"+ Arrays.toString(scoreboard);
    }
}
