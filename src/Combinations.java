import java.util.Arrays;
import java.util.Collections;

public class Combinations {

    public int onePair(int[] arr)
    {
        int[] tempArr = new int[5];
        tempArr = arr;

        Arrays.sort(tempArr);

        for (int i = tempArr.length-1; i > 0; i--)
        {
            for (int j = i-1; j > 0; j--)
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
                if (arr[i] == arr[j] && foundPair == false)
                {
                    sumFirstPair = arr[i] + arr[j];
                    foundPair = true;

                } else if (arr[i] == arr[j] && foundPair == true && sumFirstPair != arr[i]*2)
                {
                    sumSeconPair = arr[i] + arr[j];
                }
                sumTwoPair = sumFirstPair+sumSeconPair;

            }
        }
        if(sumTwoPair > 0 && sumSeconPair != 0)
        {
            return sumTwoPair;
        }else
        {
            return 0;
        }
    }
}