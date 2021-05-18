import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ScoreboardPanel extends GUIPanel {

    private JLabel test;

    private GUI gui;


    public ScoreboardPanel(GUI gui) {
        this.gui = gui;
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


//        test.setText("Current score: " + gui.getCurrentScore());
//        this.add(test);

        addScoreFields();

        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void addScoreFields() {




        this.setVisible(true);

    }

}