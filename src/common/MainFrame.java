package common;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private TextAreaPanel txtPanel;
    private Eingabefenster eingabefenster;
    private JSplitPane splitPane;

    MainFrame(){
        Model model = new Model();
        InputParser parser = new InputParser(model);
        this.eingabefenster = new Eingabefenster(parser);
        this.txtPanel = new TextAreaPanel();
        txtPanel.setPreferredSize(new Dimension(500,700));
        eingabefenster.setPreferredSize(new Dimension(500,700));
        txtPanel.revalidate();
        eingabefenster.revalidate();
        this.splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.add(eingabefenster);
        splitPane.add(txtPanel);
        this.add(splitPane);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args){
        MainFrame mf = new MainFrame();
    }
}
