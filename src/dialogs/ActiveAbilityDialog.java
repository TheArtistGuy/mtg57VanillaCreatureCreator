package dialogs;

import common.Model;
import datatypes.ActiveAbility;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActiveAbilityDialog extends JDialog {
    JTextField manacostField;
    JTextField ruletextField;

    /**
     * Konstruktor
     * @param owner zu dem der Dialog in Position gesetzt wird
     * @param model das Daten Model, auf das Informationen gespeichert werden
     */
    public ActiveAbilityDialog(Frame owner, Model model){
        super(owner);
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(350,150));
        JLabel label1 = new JLabel("ManaKosten : ");
        manacostField = new JTextField(5);
        JLabel label2 = new JLabel("RegelText : ");
        ruletextField = new JTextField(30);
        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.activeAbilitys.add(new ActiveAbility(manacostField.getText(), ruletextField.getText()));
                setVisible(false);
            }
        });
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        panel.add(label1);
        panel.add(manacostField);
        panel.add(label2);
        panel.add(ruletextField);
        panel.add(okButton);
        panel.add(cancelButton);
        panel.revalidate();
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(owner);
        this.setVisible(true);
    }

    /**
     * Setzt das TextField des Regeltextes auf den übergebenen String
     * @param ruletext der String
     */
    public void setRuletext(String ruletext) {
        this.ruletextField.setText(ruletext);
    }
}
