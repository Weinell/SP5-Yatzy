import java.util.Scanner;

public class GameEngine {
    Dice dice = new Dice();


    public int getUserInput(String msg)
    {
        System.out.println(msg);
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        return input;
    }

    public void UI()
    {
        switch (menu())
        {
            case 1:
                System.out.println("Start new game");
                break;
            case 2:
                System.out.println("Continue game");
            case 3:
                System.out.println("Exit");
            case 4:
                dice.
        }
    }

    public int menu()
    {
        //System.out.println("Welcome to Yatzy! Make your choice: \n 1. Start new game \n 2. Continue game \n 3. Exit");
        int menuChoice = getUserInput("Welcome to Yatzy! Make your choice: \n 1. Start new game \n 2. Continue game \n 3. Exit \n 4. Roll Dice");
        return menuChoice;
    }

}
