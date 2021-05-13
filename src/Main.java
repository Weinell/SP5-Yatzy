import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // write your code here
//        Dice dice = new Dice();
//        int[] diceRoll = dice.diceArray(5);
//        System.out.println(Arrays.toString(diceRoll));
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
        int[] diceTest = new int[]{5,5,5,5,5};
//        int[] diceTest = new int[]{6,6,6,6,6};

        //c.sortingDice(diceRoll);
        System.out.println("3 ens: " + c.nOfAKind(diceTest, 3));
        System.out.println("4 ens: " + c.nOfAKind(diceTest, 4));
        System.out.println("5 ens: " + c.nOfAKind(diceTest, 5));


//        System.out.println("3 ens: " + c.nOfAKind(diceRoll, 3));
//        System.out.println("4 ens: " + c.nOfAKind(diceRoll, 4));
//        System.out.println("5 ens: " + c.nOfAKind(diceRoll, 5));

    }
}
