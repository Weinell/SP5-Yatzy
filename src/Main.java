import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // write your code here
//        Dice dice = new Dice();
//        int[] diceRoll = dice.diceArray(5);
//        System.out.println("We roll: " + Arrays.toString(diceRoll));
//        for (int i = 0; i < 10; i ++) {
//            int num = dice.diceRoll();
//
//            System.out.println(num);
//        }

//        dice.changeDice(0,0,1,1,0);
//        System.out.println(Arrays.toString(diceRoll));

        Combinations c = new Combinations();

//        System.out.println(c.singles(diceRoll, 1));
//        System.out.println(c.singles(diceRoll, 2));
//        System.out.println(c.singles(diceRoll, 3));
//        System.out.println(c.singles(diceRoll, 4));
//        System.out.println(c.singles(diceRoll, 5));
//        System.out.println(c.singles(diceRoll, 6));

//        int[] diceTest = new int[]{1,1,1,1,1};
//        int[] diceTest = new int[]{2,2,2,2,2};
//        int[] diceTest = new int[]{3,3,3,3,3};
//        int[] diceTest = new int[]{4,4,4,4,4};
//        int[] diceTest = new int[]{5,5,5,5,5};
        int[] diceTest = new int[]{6,6,6,6,6};
//        int[] diceTest = new int[]{2, 3, 4, 5, 6};
//
        System.out.print("We roll: ");
//        for (int i : diceTest) {
//            System.out.print(i + " ");
//        }

        System.out.println("\nSearching for: ");

//        System.out.println("3 of a kind: " + c.nOfAKind(diceTest, 3));
//        System.out.println("4 of a kind: " + c.nOfAKind(diceTest, 4));
        System.out.println("Yatzy: " + c.gotYatzy(diceTest));
//        System.out.println("Full house: " + c.fullHouse(diceTest));
//        System.out.println("Small straight: " + c.smallStraight(diceTest));
//        System.out.println("Large straight: " + c.largeStraight(diceTest));

//
//
//        System.out.println("Aces (5): " + c.singles(diceRoll, 1));
//        System.out.println("Twos (10): " + c.singles(diceRoll, 2));
//        System.out.println("Threes (15): " + c.singles(diceRoll, 3));
//        System.out.println("Fours (20): " + c.singles(diceRoll, 4));
//        System.out.println("Fives (25): " + c.singles(diceRoll, 5));
//        System.out.println("Sixes (30): " + c.singles(diceRoll, 6));
//        System.out.println("SUM: N/A");
//        System.out.println("Bonus: N/A");
//
//        System.out.println("One pair (12): N/A");
//        System.out.println("Two pair (22): N/A");
//
//        System.out.println("3 of a kind (18): " + c.nOfAKind(diceRoll, 3));
//        System.out.println("4 of a kind (24): " + c.nOfAKind(diceRoll, 4));
//
//        System.out.println("Small straight (15): " + c.smallStraight(diceRoll));
//        System.out.println("Large straight: (20)" + c.largeStraight(diceRoll));
//
//        System.out.println("Full house: " + c.fullHouse(diceRoll));
//        System.out.println("Chance: N/A");
//        System.out.println("Yatzy: " + c.gotYatzy(diceRoll));


    }
}
