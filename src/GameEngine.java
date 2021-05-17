import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GameEngine {

    private final Dice[] fiveDice;  // Moved fiveDice from the class to Game Engine. So we can make new dice objects.
    private static final ArrayList<Player> players = new ArrayList<>();

    private int numberOfPlayers, currentPlayer, numberOfRounds, currentRound;

    int[] valueAndCombi;  // Used for adding the score to the board. Smart way to send two integers in the same variable.

    private Scoreboard scoreboard;
    private Combinations combi;
    private int turnsLeft, turn;

    public GameEngine() {
        fiveDice = new Dice[5];     // The game engine starts up with a random range of dice.
        for (int i = 0; i < fiveDice.length; i++) {
            fiveDice[i] = new Dice();
        }
        currentPlayer = 0;  // Always sets it to the first player in the array when starting a new game.
        numberOfRounds = 15;
    }

    public void UI() {
        initialMenu();
    }

    //Initial menu presented to player
    public void initialMenu() {
        int menuChoice = getUserInt(
                "Welcome to Yatzy! Make your choice: \n\n " +
                        "1. Start new game \n " +
                        "2. Highscore \n " +
                        "3. Exit \n\n " +
                        "input: ");

        switch (menuChoice) {
            case 1 -> startNewGameMenu();
            case 2 -> System.out.println("Continue game"); //TODO Make IO and save player highscore
            case 3 -> System.out.println("Exit"); // Exist gameloop
            default -> {
                System.out.println("Input not understood, please try again");
                initialMenu();
            }
        }
    }

    public void startNewGameMenu() {
        System.out.println("\nStart new game");
        int numbPlayers = getUserInt("Enter number of players: ");
        makePlayerArray(numbPlayers); //returns players arraylist
        numberOfPlayers = numbPlayers;
        scoreboard = new Scoreboard(numbPlayers, players);
        combi = new Combinations(this, scoreboard);

        doRound();
    }

    // A round consist of x amount of player turns. This method loops through all 15 rounds, and displays a winner at the end.
    public void doRound() {
        currentRound = 1;
        while (currentRound < numberOfRounds || currentPlayer != numberOfPlayers) {   // TODO: Make a game is running boolean. incase we need the ability to start a new game.
            if (currentPlayer == numberOfPlayers) {  // When the last player had his turn, currentplayer is set to player 1.
                currentRound++;
                currentPlayer = 0;

                System.out.println("\nCurrent round: " + currentRound);
                System.out.println("\n====================================================================");
            }
            playerTurn();
            System.out.println("\n====================================================================");
        }
        findWinner();
    }

    public void playerTurn() {
        for (int i = 0; i < fiveDice.length; i++) {
            fiveDice[i] = new Dice();
        }
        System.out.println("\nFirst roll: " + Arrays.toString(fiveDice));

        turn = 1;   // Resets to this default each player round.
        turnsLeft = 2;  // Makes sure player can only roll three times.
        while (turnsLeft > 0) {
            System.out.println("\n" + players.get(currentPlayer).getName() + " turn:");

            switch (messageDoTurn()) {
                case 1 -> rollDiceDuringTurn();
                case 2 -> addScoreDuringTurn();
                case 3 -> System.out.println(scoreboard);
            }
        }
    }

    public int messageDoTurn() {
        return getUserInt("\n" +
                "Choices: \n\n " +
                "1. Roll Dice " + "(" + turnsLeft + " left)\n " +
                "2. Add score to board \n " +
                "3. Print Scoreboard \n\n" +
                "input: ");
    }

    public void rollDiceDuringTurn() {
        System.out.println("\nTurn " + turn + ":");

        changeNumberOfDiceArray(fiveDice);

        turn++;

        System.out.println("\nNew dice: " + Arrays.toString(fiveDice));

        if (turnsLeft <= 0) { // If the player uses all his rolls, the game automatically ask the player to add the value to the scoreboard.
            valueAndCombi = combi.eventCombination(fiveDice, currentPlayer); // This starts a long chain of code, to add score to the proper field.
            scoreboard.addPoints(currentPlayer, valueAndCombi);
            System.out.println(scoreboard);
            currentPlayer++;  // Next players turn
        }
    }

    public void addScoreDuringTurn() {
        System.out.println("Adding result to scoreboard");
        valueAndCombi = combi.eventCombination(fiveDice, currentPlayer); // This starts a long chain of code, to add score to the proper field.
        scoreboard.addPoints(currentPlayer, valueAndCombi);
        System.out.println(scoreboard);
        turnsLeft = 0;
        currentPlayer++;
    }

    public void findWinner() {
        int winnerID = 0;
        int winnerScore = 0;

        Score[] tempSB = scoreboard.getScoreboard();

        for (int i = 0; i < tempSB.length - 1; i++) {
            if (tempSB[i].getScores(17).getValue() < tempSB[i + 1].getScores(17).getValue()) {
                winnerID = i + 1;
                winnerScore = tempSB[i + 1].getScores(17).getValue();
            } else {
                winnerID = i;
                winnerScore = tempSB[i].getScores(17).getValue();
            }
        }
        System.out.println("\n And the winner is " + players.get(winnerID).getName() +
                " with " + winnerScore + " points.");
    }

    //Takes number of players and fills players with names from input
    private void makePlayerArray(int numberOfPlayers) {
        for (int i = 0; i < numberOfPlayers; i++) {
            String nameOfPlayer = getUserString("Enter Player name: ");
            Player player = new Player(nameOfPlayer);
            players.add(player);
        }
    }

    //Takes user input and changes a specific number of dice
    private int userChangeNumDice() {
        int numberOfDiceToChange = getUserInt("How many dice do you want to change? If you wish to save your current rolls, press '0': ");

        if (numberOfDiceToChange == 0) {
            turnsLeft = -1;
            numberOfDiceToChange = 0;
        } else if (numberOfDiceToChange > 5 || numberOfDiceToChange < 0) {
            System.out.println("Number has to be within 1-5: ");
            numberOfDiceToChange = getUserInt("How many dice do you want to change? If you wish to save your current rolls, press '0': ");
        }
        return numberOfDiceToChange;
    }

    //Loop runs the number of times the user wants to change a dice - Changed method to only change value of dice instead of calling a Dice object.
    public void changeNumberOfDiceArray(Dice[] diceArray) {
        int num = userChangeNumDice();
        for (int i = 0; i < num; i++) {
            int diceNumToChange = getUserInt("What dice do you want to change? ");
            fiveDice[diceNumToChange - 1].setValue(Dice.diceRoll());
        }
        turnsLeft--;
    }

    // TODO: maybe move to a UI class?
//User Input
    public static int getUserInt(String msg) {
        System.out.print(msg);
        Scanner scan = new Scanner(System.in);
        while (!scan.hasNextInt()) {
            System.out.println("Wrong input");
            System.out.print(msg);
            scan.nextLine();
        }
        return scan.nextInt();
    }

    public String getUserString(String msg) {
        System.out.print(msg);
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    public Dice[] getFiveDice() {
        return fiveDice;
    }
}
