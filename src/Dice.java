public class Dice {


    public int[] diceArray(int numDice){

        for(int i = 0; i < numDice; i++)
        {
            fiveDice[i] = diceRoll();
        }
        return fiveDice;
    }

    public int diceRoll()
    {
        int diceRoll = (int)(Math.random()*6+1);
        return diceRoll;
    }

    

}
