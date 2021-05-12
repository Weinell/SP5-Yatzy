public class Dice {
    int[] fiveDice = new int[5];

    //Rewrite with for loop and use input from user -
    public void changeDice(int a, int b, int c, int d, int e)
    {
        if(a ==1)
        {
            fiveDice[0] = diceRoll();
        }else
        {
            System.out.println("Dice 1 is unchanged");
        }
        if(b == 1)
        {
            fiveDice[1] = diceRoll();
        }else
        {
            System.out.println("Dice 2 is unchanged");
        }
        if(c == 1)
        {
            fiveDice[2] = diceRoll();
        }else
        {
            System.out.println("Dice 3 is unchanged");
        }
        if(d == 1)
        {
            fiveDice[3] = diceRoll();
        }else
        {
            System.out.println("Dice 4 is unchanged");
        }
        if(e == 1)
        {
            fiveDice[4] = diceRoll();
        }else
        {
            System.out.println("Dice 5 is unchanged");
        }


    }


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
