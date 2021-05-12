import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Dice dice = new Dice();
        int[] diceRoll = dice.diceArray(5);
        System.out.println(Arrays.toString(diceRoll));
//        for (int i = 0; i < 10; i ++) {
//            int num = dice.diceRoll();
//
//            System.out.println(num);
//        }

//        dice.changeDice(0,0,1,1,0);
//        System.out.println(Arrays.toString(diceRoll));
//
        Combinations comb = new Combinations();
//        int[] testArr = {1,1,3,4,2};
//
//        System.out.println(comb.onePair(testArr));
        int [] testTwoPairPass = {5,2,4,5,2};
        int [] testLargeStraightPass = {6,2,3,4,5}; // Return 20
        System.out.println(comb.straight(testLargeStraightPass));
        //System.out.println(comb.twoPair(testTwoPairPass));
        // System.out.println(comb.twoPair(testArr));

    }
}
