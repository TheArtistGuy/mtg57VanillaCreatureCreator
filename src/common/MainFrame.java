package common;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private TextAreaPanel txtPanel;
    private Eingabefenster eingabefenster;
    private JSplitPane splitPane;

    MainFrame(){
        Model model = new Model();
        this.eingabefenster = new Eingabefenster(model, this);
        this.txtPanel = new TextAreaPanel(model);
        txtPanel.setPreferredSize(new Dimension(800,700));
        eingabefenster.setPreferredSize(new Dimension(500,700));
        txtPanel.revalidate();
        eingabefenster.revalidate();
        this.splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.add(eingabefenster);
        splitPane.add(txtPanel);

        JToolBar toolbar = inintialiseToolbar(model);

        this.add(splitPane);
        this.add(BorderLayout.NORTH, toolbar);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JToolBar inintialiseToolbar(Model model) {
        JToolBar toolbar = new JToolBar();
        JButton createViewButton = new JButton("Erschaffe Text");
        createViewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        eingabefenster.flushTextLabelsToModel();
                        txtPanel.setTxtArea(txtPanel.createTextFromModel());
                    }
                });
            }
        });
        toolbar.add(createViewButton);
        JButton clearactiveAbilitisButton = new JButton("AktFaehikgeiten zurücksetzen");
        clearactiveAbilitisButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.resetActiveAbilitys();
            }
        });
        toolbar.add(clearactiveAbilitisButton);
        return toolbar;
    }

    public static void main(String[] args){
        MainFrame mf = new MainFrame();
    }
}
