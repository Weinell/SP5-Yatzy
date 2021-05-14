import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GameEngine {

    private final Dice[] fiveDice;  // Moved fiveDice from the class to Game Engine. So we can make new dice objects.
    private static final ArrayList<Player> players = new ArrayList<>();
    private int numberOfPlayers, currentPlayer;
    private Scoreboard scoreboard;
    private Combinations combi;

    public GameEngine() {
        fiveDice = new Dice[5];     // The game engine starts up with a random range of dice.
        for (int i = 0; i < fiveDice.length; i++) {
            fiveDice[i] = new Dice();
        }
        currentPlayer = 0;

    }

    // TODO: maybe move to a UI class?
//User Input
    public int getUserInt(String msg) {
        System.out.print(msg);
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        return input;
    }

    public String getUserString(String msg) {
        System.out.print(msg);
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        return input;
    }

    public void UI() {
        initialMenu();
    }

    //Initial menu presented to player
    public void initialMenu() {
        int menuChoice = getUserInt("Welcome to Yatzy! Make your choice: \n\n 1. Start new game \n 2. Continue game \n 3. Exit \n 4. Roll Dice\n\ninput: ");

        switch (menuChoice) {
            case 1:
                System.out.println("\nStart new game");
                startNewGameMenu();
                break;
            case 2:
                System.out.println("Continue game"); //TODO Make IO and save player highscore
                break;
            case 3:
                System.out.println("Exit"); // Exist gameloop
                break;
            case 4:

                System.out.println(Arrays.toString(fiveDice));
                break;
            default:
                System.out.println("Input not understood, please try again");
                initialMenu();
        }
    }

    // Choose how many dice to re-roll
    //create new arraylist
    //re-roll the amount of dice
    //

    public void doTurn() //input player object
    {
        while (true) {

            if(currentPlayer==numberOfPlayers) currentPlayer = 0;

            for (int i = 0; i < fiveDice.length; i++) {
                fiveDice[i] = new Dice();
            }

            //System.out.println(player.getName() + "'s turn");
            int[] valueAndCombi = new int[2];  // Used for adding the score to the board

            int turn = 1;
            int turnsLeft = 3;
            while (turnsLeft != 0) {
                switch (getUserInt("\nChoices: \n\n 1. Roll Dice \n 2. Add score to board \n 3. Print Scoreboard \n\ninput: ")) {
                    case 1:
//                    Dice[] diceArr = diceArray(5);

                        System.out.println("\nTurn " + turn + ":");
                        System.out.println(Arrays.toString(fiveDice) + "\n");

                        for (int i = 0; i < 5; i++) {
                            String input = getUserString("Do you want to re-roll dice no. " + (i + 1) + " Y/N ");
                            if (input.equalsIgnoreCase("y")) {
                                changeDice(i);
                            }
                        }
                        turnsLeft--;
                        turn++;
                        System.out.println("\nNew dice: " + Arrays.toString(fiveDice));
                        System.out.println("Turnsleft: " + turnsLeft);

                        if (turnsLeft == 0) {
                            valueAndCombi = combi.eventCombination(fiveDice);
                            scoreboard.addPoints(currentPlayer, valueAndCombi);
                            System.out.println(scoreboard);
                            currentPlayer++;
                        }

                        break;

                    case 2:
                        System.out.println("Adding result to scoreboard");

                        valueAndCombi = combi.eventCombination(fiveDice);
                        scoreboard.addPoints(currentPlayer, valueAndCombi);
                        System.out.println(scoreboard);
                        turnsLeft = 0;
                        currentPlayer++;

                        break;
                    case 3:
                        System.out.println(scoreboard);
                }
            }
        }
    }

    public void startNewGameMenu() {
        //Get number of players
        //get names of players
        int numbPlayers = getUserInt("Enter number of players: ");
        makePlayerArray(numbPlayers); //returns players arraylist
        numberOfPlayers = numbPlayers;
        scoreboard = new Scoreboard(numbPlayers, players);
        combi = new Combinations(this);

        //Start round?
        doTurn();
    }

    //Takes number of players and fills players with names from input
    private ArrayList<Player> makePlayerArray(int numberOfPlayers) {
        for (int i = 0; i < numberOfPlayers; i++) {
            String nameOfPlayer = getUserString("Enter Player name: ");
            Player player = new Player(nameOfPlayer);
            players.add(player);
        }

        return players;
    }

    //Rewrite with for loop and use input from user -
    public void changeDice(int diceNum) {

        for (int i = 0; i < 5; i++) {
            if (diceNum == i) {
                fiveDice[i] = new Dice();
            }
        }
    }

    public Dice[] getFiveDice() {
        return fiveDice;
    }
}
