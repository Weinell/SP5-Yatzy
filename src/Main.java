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

        dice.changeDice(0,0,1,1,0);
        System.out.println(Arrays.toString(diceRoll));
    }
}
