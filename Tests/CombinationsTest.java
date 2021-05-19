import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//Update tests to take a Dice object instead of an array

class CombinationsTest {


    Combinations comb = new Combinations(null, null);

    @Test
    void onePair() {
        Dice[] diceTestOnePairPass = new Dice[5];
        diceTestOnePairPass[0] = new Dice(5,false);
        diceTestOnePairPass[1] = new Dice(2,false);
        diceTestOnePairPass[2] = new Dice(4,false);
        diceTestOnePairPass[3] = new Dice(5,false);
        diceTestOnePairPass[4] = new Dice(2,false); //returns 14
        int testPass = comb.twoPair(diceTestOnePairPass);
        assertEquals(14, testPass);

        Dice[] diceTestOnePairFail = new Dice[5];
        diceTestOnePairFail[0] = new Dice(6,false);
        diceTestOnePairFail[1] = new Dice(2,false);
        diceTestOnePairFail[2] = new Dice(4,false);
        diceTestOnePairFail[3] = new Dice(3,false);
        diceTestOnePairFail[4] = new Dice(1,false); //returns 0
        int testFail = comb.twoPair(diceTestOnePairFail);
        assertEquals(0, testFail);

    }

    @Test
    void twoPair() {
        Dice[] diceTestTwoPairPass = new Dice[5];
        diceTestTwoPairPass[0] = new Dice(5,false);
        diceTestTwoPairPass[1] = new Dice(2,false);
        diceTestTwoPairPass[2] = new Dice(4,false);
        diceTestTwoPairPass[3] = new Dice(5,false);
        diceTestTwoPairPass[4] = new Dice(2,false); //returns 14
        int testPass = comb.twoPair(diceTestTwoPairPass);
        assertEquals(14, testPass);

        Dice[] diceTestTwoPairFail = new Dice[5];
        diceTestTwoPairFail[0] = new Dice(1,false);
        diceTestTwoPairFail[1] = new Dice(2,false);
        diceTestTwoPairFail[2] = new Dice(4,false);
        diceTestTwoPairFail[3] = new Dice(5,false);
        diceTestTwoPairFail[4] = new Dice(2,false);
        int testFail = comb.twoPair(diceTestTwoPairFail);
        assertEquals(0, testFail);
    }


    @Test
    void chance() {
        Dice[] diceTestChance = new Dice[5];
        diceTestChance[0] = new Dice(1,false);
        diceTestChance[1] = new Dice(2,false);
        diceTestChance[2] = new Dice(4,false);
        diceTestChance[3] = new Dice(5,false);
        diceTestChance[4] = new Dice(6,false); //returns 8 chance
        int testPass = comb.chance(diceTestChance);
        assertEquals(18, testPass);
    }

    //Test updated straight methods

    @Test
    void smallStraight() {
        Dice[] diceTestSmallStraightPass = new Dice[5];
        diceTestSmallStraightPass[0] = new Dice(1,false);
        diceTestSmallStraightPass[1] = new Dice(2,false);
        diceTestSmallStraightPass[2] = new Dice(3,false);
        diceTestSmallStraightPass[3] = new Dice(4,false);
        diceTestSmallStraightPass[4] = new Dice(5,false);
        int testPass = comb.smallStraight(diceTestSmallStraightPass);
        assertEquals(15, testPass);

        Dice[] diceTestSmallStraightFail = new Dice[5];
        diceTestSmallStraightPass[0] = new Dice(1,false);
        diceTestSmallStraightPass[1] = new Dice(2,false);
        diceTestSmallStraightPass[2] = new Dice(3,false);
        diceTestSmallStraightPass[3] = new Dice(5,false);
        diceTestSmallStraightPass[4] = new Dice(5,false);
        int testFailSmall = comb.smallStraight(diceTestSmallStraightPass);
        assertEquals(0, testFailSmall);
    }

    @Test
    void largeStraight() {
        Dice[] diceTestLargeStraightPass = new Dice[5];
        diceTestLargeStraightPass[0] = new Dice(6,false);
        diceTestLargeStraightPass[1] = new Dice(2,false);
        diceTestLargeStraightPass[2] = new Dice(3,false);
        diceTestLargeStraightPass[3] = new Dice(4,false);
        diceTestLargeStraightPass[4] = new Dice(5,false);
        int testPass = comb.largeStraight(diceTestLargeStraightPass);
        assertEquals(20, testPass);

        Dice[] diceTestLargeStraightFail = new Dice[5];
        diceTestLargeStraightFail[0] = new Dice(6,false);
        diceTestLargeStraightFail[1] = new Dice(2,false);
        diceTestLargeStraightFail[2] = new Dice(3,false);
        diceTestLargeStraightFail[3] = new Dice(3,false);
        diceTestLargeStraightFail[4] = new Dice(5,false);
        int testFail = comb.largeStraight(diceTestLargeStraightFail);
        assertEquals(0, testFail);
    }
}