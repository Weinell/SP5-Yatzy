import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class DicePanel extends GUIPanel {


    private GameEngine gameEngine;
    private GUI gui;

    private JLabel test;

    private JButton rollButton;

    public DicePanel(GameEngine gameEngine, GUI gui) {

        this.gameEngine = gameEngine;
        this.gui = gui;
        setupPanel();


    }

    @Override
    public void setupPanel() {
        this.setBackground(Color.darkGray);
        this.setBounds(400, 0, 500, 400);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 50));
        test = new JLabel("DiceBoard Panel");
        this.add(test);

//        diceLabels = new Dice[5];
//        diceLabels = GameEngine.fiveDice;


//        for (int i = 1; i <= diceLabels.length; i++) {
//            diceLabels[i - 1] = new Dice(i);
//        }

        rollButton = new JButton("Roll");
        rollButton.addActionListener(this);
    }

    @Override
    public void updatePanel() {
        this.removeAll();

        for (Dice d : gameEngine.getFiveDice()) {
            this.add(d);
        }

        gui.setCurrentScore(valueOfAllDices());

        this.add(rollButton);

        this.repaint();
    }

    public int getRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(6) + 1;
    }

    public Dice getRandomDice() {
        return switch (getRandomNumber()) {
            case 1 -> new Dice(1);
            case 2 -> new Dice(2);
            case 3 -> new Dice(3);
            case 4 -> new Dice(4);
            case 5 -> new Dice(5);
            case 6 -> new Dice(6);
            default -> null;
        };
    }

    public int valueOfAllDices() {
        int tempInt = 0;
        for (Dice d : gameEngine.getFiveDice()) {
            tempInt += d.getValue();
        }
        return tempInt;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == rollButton) {
            for (Dice d : gameEngine.getFiveDice()) {
                Dice tempDice = new Dice(getRandomNumber());
                d.setIcon(tempDice.getIcon());
                d.setValue(tempDice.getValue());
            }




            this.repaint();
        }
    }
}
