import java.util.Arrays;
import java.util.Scanner;

public class UI implements DisplaySource {
    private GameEngine gameEngine;

    public UI(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    @Override
    public void updateGame() {
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
        gameEngine.makePlayerArray(numbPlayers); //returns players arraylist
        gameEngine.numberOfPlayers = numbPlayers;
        gameEngine.scoreboard = new Scoreboard(numbPlayers, gameEngine.players);
        gameEngine.combi = new Combinations(gameEngine, gameEngine.scoreboard);

        doRound();
    }

    // A round consist of x amount of player turns. This method loops through all 15 rounds, and displays a winner at the end.
    public void doRound() {
        gameEngine.currentRound = 1;
        while (gameEngine.currentRound < gameEngine.numberOfRounds || gameEngine.currentPlayer != gameEngine.numberOfPlayers) {   // TODO: Make a game is running boolean. incase we need the ability to start a new game.
            if (gameEngine.currentPlayer == gameEngine.numberOfPlayers) {  // When the last player had his turn, currentplayer is set to player 1.
                gameEngine.currentRound++;
                gameEngine.currentPlayer = 0;

                System.out.println("\nCurrent round: " + gameEngine.currentRound);
                System.out.println("\n====================================================================");
            }
            playerTurn();
            System.out.println("\n====================================================================");
        }
        findWinner();
    }

    public void playerTurn() {
        for (int i = 0; i < gameEngine.fiveDice.length; i++) {
            gameEngine.fiveDice[i] = new Dice();
        }
        System.out.println("\nFirst roll: " + Arrays.toString(gameEngine.fiveDice));

        gameEngine.turn = 1;   // Resets to this default each player round.
        gameEngine.turnsLeft = 2;  // Makes sure player can only roll three times.
        while (gameEngine.turnsLeft > 0) {
            System.out.println("\nPlayer: " + gameEngine.players.get(gameEngine.currentPlayer).getName());
            System.out.println("Turn " + gameEngine.turn + ":");

            switch (messageDoTurn()) {
                case 1 -> rollDiceDuringTurn();
                case 2 -> addScoreDuringTurn();
                case 3 -> printScoreboard();
            }
        }
    }

    public int messageDoTurn() {
        return getUserInt("\n" +
                "Choices: \n\n " +
                "1. Roll Dice " + "(" + gameEngine.turnsLeft + " left)\n " +
                "2. Add score to board \n " +
                "3. Print Scoreboard \n\n" +
                "input: ");
    }

    public void rollDiceDuringTurn() {


        gameEngine.changeNumberOfDiceArray(gameEngine.fiveDice);

        gameEngine.turn++;

        if (gameEngine.turn != 3) System.out.println("\nNew dice: " + Arrays.toString(gameEngine.fiveDice));

        if (gameEngine.turnsLeft <= 0) { // If the player uses all his rolls, the game automatically ask the player to add the value to the scoreboard.
            gameEngine.valueAndCombi = gameEngine.combi.eventCombination(gameEngine.fiveDice, gameEngine.currentPlayer); // This starts a long chain of code, to add score to the proper field.
            gameEngine.scoreboard.addPoints(gameEngine.currentPlayer, gameEngine.valueAndCombi);
            System.out.println(gameEngine.scoreboard);
            gameEngine.currentPlayer++;  // Next players turn
        }
    }

    public void addScoreDuringTurn() {
        System.out.println("Adding result to scoreboard");
        gameEngine.valueAndCombi = gameEngine.combi.eventCombination(gameEngine.fiveDice, gameEngine.currentPlayer); // This starts a long chain of code, to add score to the proper field.
        gameEngine.scoreboard.addPoints(gameEngine.currentPlayer, gameEngine.valueAndCombi);
        System.out.println(gameEngine.scoreboard);
        gameEngine.turnsLeft = 0;
        gameEngine.currentPlayer++;
    }

    public void printScoreboard() {
        gameEngine.scoreboard.subSum();
        gameEngine.scoreboard.totalSum();
        System.out.println(gameEngine.scoreboard);
    }


    public void findWinner() {
        int winnerID = 0;
        int winnerScore = 0;
        Score[] tempSB = gameEngine.scoreboard.getScoreboard();
        if (gameEngine.numberOfPlayers == 1) {
            winnerScore = tempSB[0].getScores(17).getValue();
        } else {
            for (int i = 0; i < tempSB.length - 1; i++) {
                if (tempSB[i].getScores(17).getValue() < tempSB[i + 1].getScores(17).getValue()) {
                    winnerID = i + 1;
                    winnerScore = tempSB[i + 1].getScores(17).getValue();
                } else {
                    winnerID = i;
                    winnerScore = tempSB[i].getScores(17).getValue();
                }
            }
        }
        System.out.println("\n And the winner is " + gameEngine.players.get(winnerID).getName() +
                " with " + winnerScore + " points.");
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

    public static String getUserString(String msg) {
        System.out.print(msg);
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }


}
