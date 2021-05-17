import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CombinationsTest {
    Combinations comb = new Combinations(null);
    int [] testSmallStraightPass = {1,2,3,4,5}; //Return 15
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

    @Test
    void straight() {
        int testPass = comb.straight(testSmallStraightPass);
        assertEquals(15, testPass);

        int testPass2 = comb.straight(testLargeStraightPass);
        assertEquals(20, testPass2);

        int testFail = comb.straight(testFailArray);
        assertEquals(0, testFail);

        int testFail2 = comb.straight(testFailArray);
        assertEquals(0, testFail2);
    }
}