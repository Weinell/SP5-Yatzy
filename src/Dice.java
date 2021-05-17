public class Dice {

    private int value;
    private boolean locked;    // Not used yet.

    public Dice() {
        value = diceRoll();
        locked = false;
    }

    public Dice(int value, boolean locked) {
        this.value = value;
        this.locked = locked;
    }


    public int diceRoll() {
        return(int)(Math.random()*6+1);
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }
}