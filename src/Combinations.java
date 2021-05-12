import java.util.Scanner;

public class Combinations {

    Scanner s = new Scanner();

    public int singles(int[] dice, int n) {
        int sum = 0;

        for (int die : dice) {

            if (die == n) {

                sum += n;
            }
        }
        return sum;
    }


    public int threeSame(int[] dice)    {
        int sum = 0;

        if (dice)

        for (int die : dice)    {


        }
    }

    public int three(int[] dice) {
        int sum = 0;
        int[] tempArr = new int[6];

        for(int i = 1; i < dice.length; i++) {

            tempArr[dice[i-1]] = dice[i];
        }

        System.out.println(tempArr);
        return sum;
    }


}
