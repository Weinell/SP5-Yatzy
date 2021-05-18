import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GameEngine {
    UI ui;

    protected final Dice[] fiveDice;  // Moved fiveDice from the class to Game Engine. So we can make new dice objects.
    protected static final ArrayList<Player> players = new ArrayList<>();

    protected int numberOfPlayers, currentPlayer, numberOfRounds, currentRound;

    int[] valueAndCombi;  // Used for adding the score to the board. Smart way to send two integers in the same variable.

    protected Scoreboard scoreboard;
    protected Combinations combi;
    protected int turnsLeft, turn;

    public GameEngine() {
        ui = new UI(this);
        fiveDice = new Dice[5];     // The game engine starts up with a random range of dice.
        for (int i = 0; i < fiveDice.length; i++) {
            fiveDice[i] = new Dice();
        }
        currentPlayer = 0;  // Always sets it to the first player in the array when starting a new game.
        numberOfRounds = 15;
    }

    public void run() {
        ui.initialMenu();
    }

    //Takes number of players and fills players with names from input
    public void makePlayerArray(int numberOfPlayers) {
        for (int i = 0; i < numberOfPlayers; i++) {
            String nameOfPlayer = UI.getUserString("Enter Player name: ");
            Player player = new Player(nameOfPlayer);
            players.add(player);
        }
    }

    //Takes user input and changes a specific number of dice
    public int userChangeNumDice() {
        int numberOfDiceToChange = UI.getUserInt("How many dice do you want to change? If you wish to save your current rolls, press '0': ");

        if (numberOfDiceToChange == 0) {
            turnsLeft = -1;
            numberOfDiceToChange = 0;
        } else if (numberOfDiceToChange > 5 || numberOfDiceToChange < 0) {
            System.out.println("Number has to be within 1-5: ");
            numberOfDiceToChange = UI.getUserInt("How many dice do you want to change? If you wish to save your current rolls, press '0': ");
        }
        return numberOfDiceToChange;
    }

    //Loop runs the number of times the user wants to change a dice - Changed method to only change value of dice instead of calling a Dice object.
    public void changeNumberOfDiceArray(Dice[] diceArray) {
        int num = userChangeNumDice();
        for (int i = 0; i < num; i++) {
            int diceNumToChange = UI.getUserInt("What dice do you want to change? ");
            fiveDice[diceNumToChange - 1].setValue(Dice.diceRoll());
        }
        turnsLeft--;
    }



    public Dice[] getFiveDice() {
        return fiveDice;
    }
}
