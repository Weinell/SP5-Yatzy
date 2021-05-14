import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GameEngine {
    public static ArrayList<Player> players = new ArrayList<>();
    Dice dice = new Dice();

//User Input
    public int getUserInt(String msg)
    {
        System.out.println(msg);
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        return input;
    }

    public String getUserString(String msg)
    {
        System.out.println(msg);
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        return input;
    }

    public void UI()
    {
        initialMenu();
        System.out.println(players.toString()); //Test arraylist gets names and players

    }

    private int menu()
    {
        //System.out.println("Welcome to Yatzy! Make your choice: \n 1. Start new game \n 2. Continue game \n 3. Exit");
        int menuChoice = getUserInt("Welcome to Yatzy! Make your choice: \n 1. Start new game \n 2. Continue game \n 3. Exit \n 4. Roll Dice");
        return menuChoice;
    }

    //Initial menu presented to player
    public void initialMenu()
    {
        switch (menu())
        {
            case 1:
                System.out.println("Start new game");
                startNewGameMenu();
                break;
            case 2:
                System.out.println("Continue game");
            case 3:
                System.out.println("Exit");
            case 4:
                int[] diceArr = dice.diceArray(5);
                System.out.println(Arrays.toString(diceArr));
        }
    }

    public void startNewGameMenu()
    {
        //Get number of players
        //get names of players
        int numPlayers = getUserInt("Enter number of players: ");
        makePlayerArray(numPlayers);
    }

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
