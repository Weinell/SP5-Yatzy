import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ScoreboardPanel extends GUIPanel {

    private JLabel test;

    private GUI gui;


    public ScoreboardPanel(GUI gui) {
        this.gui = gui;


        test = new JLabel();
        setupPanel();
    }

    @Override
    public void setupPanel() {
        this.setBackground(Color.lightGray);
        this.setBounds(0, 0, 400, 600);

        addScoreFields();
    }

    @Override
    public void updatePanel() {
        this.removeAll();

        addScoreFields();

        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void addScoreFields() {

        test.setText("Scoreboard");

        this.add(test);


        this.setVisible(true);

    }
}