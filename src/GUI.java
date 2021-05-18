import javax.swing.*;

public class GUI extends JFrame implements DisplaySource{

    private GameEngine gameEngine;

    private GUIPanel scoreboardPanel, dicePanel, gamePanel;
    private int currentScore;

    public GUI(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
        currentScore = 0;
        dicePanel = new DicePanel(gameEngine, this);
        scoreboardPanel = new ScoreboardPanel(this);
        gamePanel = new GamePanel(this);

        startGUI();
    }



    public void startGUI() {
        this.setTitle("Throw the dice");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon image = new ImageIcon("src/resources/dice3.png");
        this.setIconImage(image.getImage());
        this.setSize(900, 600); // set frame size
        this.setResizable(false); // Again fixed window size
        this.setLocationRelativeTo(null);  // So the window spawns in the middle of the screen and not in the upper left corner.
        this.setLayout(null);

        this.add(dicePanel);
        this.add(scoreboardPanel);
        this.add(gamePanel);


        this.setVisible(true);
    }

    @Override
    public void updateGame() {
        dicePanel.updatePanel();
        scoreboardPanel.updatePanel();

    }


    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }
}
