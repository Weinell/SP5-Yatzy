import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//Update tests to take a Dice object instead of an array

class CombinationsTest {
    Dice d1 = new Dice(4);
    Combinations comb = new Combinations(null, null);
    Dice [] testSmallStraightPass = {new Dice(3), new Dice(),new Dice(),new Dice(),new Dice()}; //Return 15
    int [] testLargeStraightPass = {6,2,3,4,5}; // Return 20
    int [] testOnePairPass = {1,5,4,3,1}; //Sum 2;
    int [] testFailArray = {1,2,5,4,6}; // Return 0 (Chance returns 18)
    int [] testTwoPairPass = {5,2,4,5,2}; // Return 14
    int[] testTwoPairFail = {4,3,5,4,6}; // Return 0

    @Test
    void onePair() {
        int testPass = comb.onePair(testOnePairPass);
        assertEquals(2, testPass);

        int testFail = comb.onePair(testFailArray);
        assertEquals(0, testFail);


    }

    @Test
    void twoPair() {
        int testPass = comb.twoPair(testTwoPairPass);
        assertEquals(14, testPass);

        int testFail = comb.twoPair(testTwoPairFail);
        assertEquals(0, testFail);
    }


    @Test
    void chance() {
        int testPass = comb.chance(testTwoPairPass);
        assertEquals(18, testPass);

        int testPass2 = comb.chance(testFailArray);
        assertEquals(18, testPass2); //Return 18
    }

    //Test updated straight methods

    @Test
    void smallStraight() {
    }

    @Test
    void largeStraight() {
    }
}