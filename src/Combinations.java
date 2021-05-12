import java.util.Scanner;

public class Combinations {

    //Scanner s = new Scanner();

    public int singles(int[] dice, int n) {
        int sum = 0;

        for (int die : dice) {

            if (die == n) {

                sum += n;
            }
        }
        return sum;
    }

    public int[] sortingDice(int[] dice) {

        int[] tempArr = new int[6];

        for (int value : dice) {

            tempArr[value - 1] += value;

        }

        for (int n:tempArr) {
            System.out.println(n);
        }

        return tempArr;
    }

    public int nOfAKind(int[] dice, int n)   {

        int[] tempArr = sortingDice(dice);

        for (int d:tempArr) {

            if (d/n == n) {
                return d;
            }
        }
        return 0;
    }

}
