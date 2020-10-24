package common;

import javax.swing.*;
import java.awt.*;

public class TextAreaPanel extends JPanel {

    private JTextArea txtArea;

    TextAreaPanel(){
        this.txtArea = new JTextArea();
        add(txtArea);
        setVisible(true);
    }
}
