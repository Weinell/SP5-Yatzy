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
            //System.out.println(n);
        }

        return tempArr;
    }

    public int nOfAKind(int[] dice, float n)   {

        int sum = 0;
        int[] tempArr = sortingDice(dice);

        for (int i = 0; i < tempArr.length; i++) {

            if (tempArr[i]/n == i+1) {
                sum = tempArr[i];
            }
            else if (tempArr[i]/4 == i+1)    {
                sum = tempArr[i]-i-1;
            }
            else if (tempArr[i]/5 == i+1)    {
                sum = tempArr[i]-(i*2)-1;
            }

        }
        return sum;
    }

}
