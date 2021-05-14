public class Dice {
    int[] fiveDice = new int[5];

    //Rewrite with for loop and use input from user -
    public void changeDice(boolean a, boolean b, boolean c,boolean d,boolean e)
    {
        if(a ==true)
        {
            fiveDice[0] = diceRoll();
        }else
        {
            System.out.println("Dice 1 is unchanged");
        }
        if(b == true)
        {
            fiveDice[1] = diceRoll();
        }else
        {
            System.out.println("Dice 2 is unchanged");
        }
        if(c == true)
        {
            fiveDice[2] = diceRoll();
        }else
        {
            System.out.println("Dice 3 is unchanged");
        }
        if(d == true)
        {
            fiveDice[3] = diceRoll();
        }else
        {
            System.out.println("Dice 4 is unchanged");
        }
        if(e == true)
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
