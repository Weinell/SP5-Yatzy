import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GameEngine {
    public static ArrayList<Player> players = new ArrayList<>();
    Dice dice = new Dice();

//User Input
    public int getUserInt(String msg)
    {
        System.out.print(msg);
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        return input;
    }

    public String getUserString(String msg)
    {
        System.out.print(msg);
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        return input;
    }

    public void UI()
    {
        initialMenu();
        System.out.println(players.toString()); //Test arraylist gets names and players

    }

    //Initial menu presented to player
    public void initialMenu()
    {
        int menuChoice = getUserInt("Welcome to Yatzy! Make your choice: \n 1. Start new game \n 2. Continue game \n 3. Exit \n 4. Roll Dice");

        switch (menuChoice)
        {
            case 1:
                System.out.println("Start new game");
                startNewGameMenu();
                break;
            case 2:
                System.out.println("Continue game"); //TODO Make IO and save player highscore
                break;
            case 3:
                System.out.println("Exit"); // Exist gameloop
                break;
            case 4:
                int[] diceArr = dice.diceArray(5);
                System.out.println(Arrays.toString(diceArr));
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
        //System.out.println(player.getName() + "'s turn");


        switch (getUserInt("Choices: \n 1. Roll Dice \n 2. Add score to board\n"))
        {
            case 1:
                int[] diceArr = dice.diceArray(5);
                System.out.println(Arrays.toString(diceArr));

                for (int i = 0; i < 5; i++) {
                    String input = getUserString("Do you want to re-roll dice no. "+ (i+1) + " Y/N ");
                    if(input.equalsIgnoreCase("y"))
                    {
                        dice.changeDice(i);
                    }
                }
                System.out.println(Arrays.toString(diceArr));
                break;

            case 2:
                System.out.println("Adding result to scoreboard");
                break;
        }
    }

    public void startNewGameMenu()
    {
        //Get number of players
        //get names of players
        int numPlayers = getUserInt("Enter number of players: ");
        makePlayerArray(numPlayers); //returns players arraylist

        //Start round?
    }

    //Takes number of players and fills players with names from input
    private ArrayList<Player> makePlayerArray (int numberOfPlayers)
    {
        for (int i = 0; i < numberOfPlayers; i++)
        {
            String nameOfPlayer = getUserString("Enter Player name: ");
            Player player = new Player(nameOfPlayer);
            players.add(player);
        }

        return players;
    }
}
