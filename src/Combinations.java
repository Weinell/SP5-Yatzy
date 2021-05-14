import java.util.Arrays;

public class Combinations {

    public int singles(int[] diceRoll, int n) {
        int sum = 0;
        for (int die : diceRoll) {
            if (die == n) {
                sum += n;
            }
        }
        return sum;
    }

    public int nOfAKind(int[] diceRoll, int n) {   // n is how many kinds we are looking for.
        int[] arr = sortingDice(diceRoll);   // First it sorts the dice into how many of each value.
        for (int i = 1; i < arr.length + 1; i++) {
            if (arr[i - 1] == i * n) {
                return i * n;
            } else if (arr[i - 1] == i * (n + 1)) { // This makes sure if n + 1 is true, it still only return the value of n
                return i * n;
            } else if (arr[i - 1] == i * (n + 2)) { // The same with n + 2
                return i * n;
            }
        }
        return 0;
    }

    public int gotYatzy(int[] diceRoll) {   // Always return 50 point if we hit 5 of the same kind.
        int[] arr = sortingDice(diceRoll);   // First it sorts the dice into how many of each value.
        for (int i = 1; i < arr.length + 1; i++) {
            if (arr[i - 1] == i * 5) {
                return 50 + chance(diceRoll);
            }
        }
        return 0;
    }

    public int fullHouse(int[] diceRoll) {
        int[] arr = sortingDice(diceRoll);   // First it sorts the dice into how many of each value.
        for (int i = 1; i < arr.length + 1; i++) {
            if (arr[i - 1] == i * 5) {
                return 0;
            } else if (arr[i - 1] == i * 4) {
                return 0;
            } else if (arr[i - 1] == i * 3) {
                // If there is exactly 3 of a kinds. Then it checks if there is exactly 2 of a kind of any other values.
                for (int j = 1; j < arr.length + 1; j++) {
                    if (arr[j - 1] == j * 2) {
                        return (i * 3) + (j * 2);
                    }
                }
            }
        }
        return 0;
    }

    public int smallStraight(int[] diceRoll) {
        int[] arr = sortingDice(diceRoll);   // First it sorts the dice into how many of each value.
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] == i) {
                if (arr[4] == i) {
                    return 15;
                }
            } else {
                return 0;
            }
        }
        return 0;
    }

    public int largeStraight(int[] diceRoll) {
        int[] arr = sortingDice(diceRoll);   // First it sorts the dice into how many of each value.
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == i + 1) {
                if (arr[5] == i + 1) {
                    return 20;
                }
            } else {
                return 0;
            }
        }
        return 0;
    }


    public int[] sortingDice(int[] unSortedDice) {
        // The dice gets sorted into separate values 1 - 6.
        int[] arr = new int[6];
        for (int value : unSortedDice) {
            arr[value - 1] += value;
        }
        return arr;
    }

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
