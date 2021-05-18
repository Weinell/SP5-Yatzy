import javax.swing.*;
import java.awt.event.ActionListener;

public abstract class GUIPanel extends JPanel implements ActionListener {



    public abstract void setupPanel();

    public abstract void updatePanel();

    public void repaintPanel() {
        this.repaint();
    }


    public void removeAllContent() {
        this.removeAll();
    }

}
