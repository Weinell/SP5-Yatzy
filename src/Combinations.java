import java.util.Arrays;
import java.util.Collections;

public class Combinations {

    public int onePair(int[] arr)
    {
        int[] tempArr = new int[5];
        tempArr = arr;

//Sorting the dice array
        Arrays.sort(tempArr);

//Looking for the highest pair
        for (int i = tempArr.length-1; i > 0; i--)
        {
            for (int j = i-1; j >= 0; j--)
            {
                if (arr[i] == arr[j])
                {
                    return arr[i] + arr[j];
                }
            }
        }
        return 0;
    }


    public int twoPair(int[] arr)
    {
        int sumFirstPair = 0;
        int sumSeconPair = 0;
        int sumTwoPair = 0;
        boolean foundPair = false;

        for (int i = 0; i < arr.length - 1; i++)
        {
            for (int j = i+1; j < arr.length; j++)
            {
                if (arr[i] == arr[j] && foundPair == false) //Finds the first pair
                {
                    sumFirstPair = arr[i] + arr[j];
                    foundPair = true;

                } else if (arr[i] == arr[j] && foundPair == true && sumFirstPair != arr[i]*2) //Finds the second pair
                {
                    sumSeconPair = arr[i] + arr[j];
                }
                sumTwoPair = sumFirstPair+sumSeconPair;

            }
        }
        if(sumTwoPair > 0 && sumSeconPair != 0) //Returns the sum of two pairs or 0 if no two pairs exist.
        {
            return sumTwoPair;
        }else
        {
            return 0;
        }
    }

    public int chance(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public int straight(int[] arr)
    {
        int sum = chance(arr);

        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {

                if (arr[i] != arr[j] && (sum == 15 || sum == 20)) {
                    return sum;
                }
            }
        }
        return 0;
    }


}