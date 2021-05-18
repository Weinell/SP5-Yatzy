import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GamePanel extends GUIPanel {

    private JLabel test;

    public GamePanel(GUI gui) {
        setupPanel();


    }

    @Override
    public void setupPanel() {
        this.setBackground(Color.white);
        this.setBounds(400, 400, 500, 200);
        test = new JLabel("GameBoard Panel");
        this.add(test);
    }

    @Override
    public void updatePanel() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

