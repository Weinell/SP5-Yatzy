import java.util.Arrays;

public class Combinations {

    private GameEngine gameEngine;
    private Scoreboard scoreboard;
    int[] valueAndCombi;

    public Combinations(GameEngine gameEngine, Scoreboard scoreboard) {
        this.gameEngine = gameEngine;
        this.scoreboard = scoreboard;
        this.valueAndCombi = new int[2];  // This way you can return different values in the same return methode
    }

    public int[] eventCombination(Dice[] diceRoll, int playerID) {
        System.out.println(Arrays.toString(gameEngine.getFiveDice()));
        System.out.println("\nWhat do you wish to do? ");
        String input = gameEngine.getUserString("""

                 1.  Aces\s
                 2.  Twos\s
                 3.  Threes\s
                 4.  Fours\s
                 5.  Fives\s
                 6.  Sixes\s               
                 9.  One pair\s
                 10. Two pair\s
                 11. 3 of a kind\s
                 12. 4 of a kind\s
                 13. Small straight\s
                 14. Large straight\s
                 15. Full house\s
                 16. Chance\s
                 17. Yatzy\s

                Choices:\s""");

        valueAndCombi[0] = getCombination(input, diceRoll, playerID);   // Value
        valueAndCombi[1] = Integer.parseInt(input)-1;     // Combination
        return valueAndCombi;

    }


    private int getCombination(String input, Dice[] diceRoll, int playerID) {
        int output = 0;

        // The tempSF loads the field the player wants to add score to.
        ScoreboardField tempSF = scoreboard.getScoreboard()[playerID].getScores(Integer.parseInt(input)-1);
        // This if statement makes sure not to add the score if the field has already been used.
        if (!tempSF.isAlreadyUsed()) {
            switch (input) {
                case "1" -> output = singles(diceRoll, 1);
                case "2" -> output = singles(diceRoll, 2);
                case "3" -> output = singles(diceRoll, 3);
                case "4" -> output = singles(diceRoll, 4);
                case "5" -> output = singles(diceRoll, 5);
                case "6" -> output = singles(diceRoll, 6);
                case "9" -> output = onePair(diceRoll);
                case "10" -> output = twoPair(diceRoll);
                case "11" -> output = nOfAKind(diceRoll, 3);
                case "12" -> output = nOfAKind(diceRoll, 4);
                case "13" -> output = smallStraight(diceRoll);
                case "14" -> output = largeStraight(diceRoll);
                case "15" -> output = fullHouse(diceRoll);
                case "16" -> output = chance(diceRoll);
                case "17" -> output = gotYatzy(diceRoll);




                // TODO the rest of the combinations

            }
        } else {
            System.out.println("Already used");
            output = tempSF.getValue();

            valueAndCombi = eventCombination(diceRoll, playerID);
            scoreboard.addPoints(playerID, valueAndCombi);
        }
        return output;
    }


    public int singles(Dice[] diceRoll, int n) {
        int sum = 0;
        for (Dice die : diceRoll) {
            if (die.getValue() == n) {
                sum += n;
            }
        }
        return sum;
    }

    public int onePair(Dice[] diceRoll) {
        int[] tempArr = new int[5];
        for (int k = 0; k < diceRoll.length; k++) {
            tempArr[k] = diceRoll[k].getValue();
        }

//Sorting the dice array
        Arrays.sort(tempArr);

//Looking for the highest pair
        for (int i = tempArr.length - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (tempArr[i] == tempArr[j]) {
                    return tempArr[i]*2;
                }
            }
        }
        return 0;
    }

    public int twoPair(Dice[] diceRoll) {
        int[] arr = new int[5];
        for (int k = 0; k < diceRoll.length; k++) {
            arr[k] = diceRoll[k].getValue();
        }

        int sumFirstPair = 0;
        int sumSeconPair = 0;
        int sumTwoPair = 0;
        boolean foundPair = false;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j] && foundPair == false) //Finds the first pair
                {
                    sumFirstPair = arr[i] + arr[j];
                    foundPair = true;

                } else if (arr[i] == arr[j] && foundPair == true && sumFirstPair != arr[i] * 2) //Finds the second pair
                {
                    sumSeconPair = arr[i] + arr[j];
                }
                sumTwoPair = sumFirstPair + sumSeconPair;

            }
        }
        if (sumTwoPair > 0 && sumSeconPair != 0) //Returns the sum of two pairs or 0 if no two pairs exist.
        {
            return sumTwoPair;
        } else {
            return 0;
        }
    }



    public int nOfAKind(Dice[] diceRoll, int n) {   // n is how many kinds we are looking for.
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

    public int gotYatzy(Dice[] diceRoll) {   // Always return 50 point if we hit 5 of the same kind.
        int[] arr = sortingDice(diceRoll);   // First it sorts the dice into how many of each value.
        for (int i = 1; i < arr.length + 1; i++) {
            if (arr[i - 1] == i * 5) {
                return 50 + chance(diceRoll);
            }
        }
        return 0;
    }

    public int fullHouse(Dice[] diceRoll) {
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

    public int smallStraight(Dice[] diceRoll) {
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

    public int largeStraight(Dice[] diceRoll) {
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


    public int[] sortingDice(Dice[] unSortedDice) {
        // The dice gets sorted into separate values 1 - 6.
        int[] arr = new int[6];
        for (Dice value : unSortedDice) {
            arr[value.getValue() - 1] += value.getValue();
        }
        return arr;
    }


    public int chance(Dice[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i].getValue();
        }
        return sum;
    }

    public int straight(Dice[] arr) {
        int sum = chance(arr);

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {

                if (arr[i] != arr[j] && (sum == 15 || sum == 20)) {
                    return sum;
                }
            }
        }
        return 0;
    }
}