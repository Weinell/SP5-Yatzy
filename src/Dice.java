import javax.swing.*;

public class Dice extends JLabel {

    private ImageIcon icon;
    private JLabel dice;

    private int value;
    private boolean locked;    // Not used yet.

    public Dice() {
        value = diceRoll();
        icon = getDiceIcon();
        dice = new JLabel();
        dice.setIcon(icon);
        locked = false;
    }

    public Dice(int value) {
        this.value = value;
        icon = getDiceIcon();
        dice = new JLabel();
        dice.setIcon(icon);
        locked = false;
    }

    private ImageIcon getDiceIcon() {
        if (value==1) {
            return new ImageIcon("src/resources/dice1.png");
        } else if(value==2) {
            return new ImageIcon("src/resources/dice2.PNG");
        }else if(value==3) {
            return new ImageIcon("src/resources/dice3.png");
        }else if(value==4) {
            return new ImageIcon("src/resources/dice4.PNG");
        }else if(value==5) {
            return new ImageIcon("src/resources/dice5.PNG");
        }else {
            return new ImageIcon("src/resources/dice6.PNG");
        }
    }

    public static int diceRoll() {
        return(int)(Math.random()*6+1);
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    public ImageIcon getIcon() {
        return icon;
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

    public JLabel getDice() {
        return dice;
    }
}