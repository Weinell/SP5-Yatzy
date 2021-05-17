import java.util.ArrayList;
import java.util.Arrays;

public class Scoreboard {


    private Score[] scoreboard;

    public Scoreboard(int numPlayers, ArrayList<Player> players) {

        scoreboard = new Score[numPlayers];
        for (int i = 0; i < scoreboard.length; i++) {

            scoreboard[i] = new Score(players.get(i).getName());
        }
    }

    // Used in UI
    public void addPoints(int playerID, int[] valueAndCombi) {

        scoreboard[playerID].setScores(valueAndCombi[1], valueAndCombi[0]);
        subSum();  // Everytime a value is added to a field, we want the game to update the sub and total sum.
        totalSum();
    }

    // We need this for GUI
    public void addPoints(int playerID, int combination, int points) {

        scoreboard[playerID].setScores(combination,points);
        subSum();
        totalSum();
    }

    public void subSum()    {

        int sum = 0;

        for (int i = 0; i < scoreboard.length; i++) {   // Number of players

            for (int j = 0; j < 6; j++) {       // Number of combinations from 1 - 6.

                sum += scoreboard[i].getScores(j).getValue();

            }
            scoreboard[i].setScores(6,sum);

            if(sum >= 63) scoreboard[i].setScores(7,50);  // set the bonus field to 50.

            sum = 0;
        }
    }

    public void totalSum()    {

        int sum = 0;

        for (Score score : scoreboard) {

            for (int j = 6; j < 17; j++) {

                sum += score.getScores(j).getValue();

            }
            score.setScores(17, sum);
            sum = 0;
        }
    }

    public Score[] getScoreboard() {
        return scoreboard;
    }

    // Todo toString format. To allign the labels with the values.
    @Override
    public String toString() {
        return "Scoreboard: [1,2,3,4,5,6,Sum,Bonus,1pair,2pair,3kind,4kind,sStraight,bStraight,house,chance,Yatzy,Total] "
                + Arrays.toString(scoreboard);
    }
}
