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
