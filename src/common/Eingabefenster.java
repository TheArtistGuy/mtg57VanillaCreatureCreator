package common;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Eingabefenster extends JPanel {
    private EditionChoice editionChoice;
    private RarityChoice rarityChoice;
    private JTextField cardNumberField;
    private JTextField faeigTxtField;
    private JTextField statsField;
    private JTextField namePOField;
    private JTextField nameSPField;
    private JTextField nameITField;
    private JTextField nameFRField;
    private JTextField nameENField;
    private JTextField creatureInfoField;
    private JTextField manaField;
    private JTextField nameDEField;
    private Model model;
    private InputParser parser;
    private JTextField artistField;

    public Eingabefenster(InputParser parser){
        JLabel inputLabel = new JLabel("Informationen aus dem DeckViewer");
        this.add(inputLabel);
        JTextField inputField = new JTextField(40);

        this.add(inputField);
        JButton useInfoButton = new JButton("Informationen in Felder schreiben");
        useInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parser.parseDeckviewerInfosToModel(inputField.getText());
                updateFieldsFromModel();
            }
        });
        add(useInfoButton);

        initialiseAndAddNameFields();


        initialiseAndAddCreatureInfos();

        JLabel editionLabel = new JLabel("Edition:");
        editionChoice = new EditionChoice();
        add(editionLabel);
        add(editionChoice);

        JLabel numberLabel = new JLabel("Kartennummer");
        this.cardNumberField = new JTextField(3);
        add(numberLabel);
        add(cardNumberField);

        JLabel rarityLabel = new JLabel("Rarity");
        this.rarityChoice = new RarityChoice();
        add(rarityLabel);
        add(rarityChoice);

        JLabel artistLabel = new JLabel("Künstler:");
        this.artistField = new JTextField(10);
        add(artistLabel);
        add(artistField);

    }

    private void initialiseAndAddCreatureInfos() {
        JLabel manaLabel = new JLabel("Manakosten:");
        this.manaField = new JTextField(5);
        add(manaLabel);
        add(manaField);

        JLabel creatureInfoLabel = new JLabel("Kreaturentypen:");
        this.creatureInfoField = new JTextField(20);
        add(creatureInfoLabel);
        add(creatureInfoField);

        JLabel faeigTextLabel = new JLabel("Fähigkeiten-Text:");
        this.faeigTxtField = new JTextField(15);
        add(faeigTextLabel);
        add(faeigTxtField);

        JLabel statsLabel = new JLabel("Angriff/Verteidigung :");
        this.statsField = new JTextField(4);
        add(statsLabel);
        add(statsField);


    }

    private void initialiseAndAddNameFields() {
        JPanel namePanel = new JPanel();
        namePanel.setPreferredSize(new Dimension(500, 250));

        JLabel nameDELabel = new JLabel("Name(DE):");
        this.nameDEField = new JTextField(10);
        namePanel.add(nameDELabel);
        namePanel.add(nameDEField);

        JLabel nameENLabel = new JLabel("Name(EN):");
        this.nameENField = new JTextField(10);
        namePanel.add(nameENLabel);
        namePanel.add(nameENField);

        JLabel nameFRLabel = new JLabel("Name(FR):");
        this.nameFRField = new JTextField(10);
        namePanel.add(nameFRLabel);
        namePanel.add(nameFRField);

        JLabel nameITLabel = new JLabel("Name(IT):");
        this.nameITField = new JTextField(10);
        namePanel.add(nameITLabel);
        namePanel.add(nameITField);

        JLabel nameSPLabel = new JLabel("Name(SP):");
        this.nameSPField = new JTextField(10);
        namePanel.add(nameSPLabel);
        namePanel.add(nameSPField);

        JLabel namePOLabel = new JLabel("Name(PO):");
        this.namePOField = new JTextField(10);
        namePanel.add(namePOLabel);
        namePanel.add(namePOField);
        namePanel.revalidate();
        add(namePanel);
    }

    private void updateFieldsFromModel() {
        editionChoice.select(model.edition.ordinal());
        rarityChoice.select(model.rarity.ordinal());
        cardNumberField.setText(model.cardnumber);
        faeigTxtField.setText(model.ability);
        statsField.setText(model.stats);
        namePOField.setText(model.namePO);
        nameSPField.setText(model.nameSP);
        nameITField.setText(model.nameIT);
        nameFRField.setText(model.nameFR);
        nameENField.setText(model.nameEN);
        creatureInfoField.setText(model.cretureTypes);
        manaField.setText(model.mana);
        nameDEField.setText(model.nameDE);
        artistField.setText(model.artist);
    }

    private void flushTextLabelsToModel(String text) {
        model.edition = editionChoice.getEditionName();
        model.rarity = rarityChoice.getRarity();
        model.cardnumber =cardNumberField.getText();
        model.ability = faeigTxtField.getText();
        model.stats = statsField.getText();
        model.namePO = namePOField.getText();
        model.nameSP = nameSPField.getText();
        model.nameIT = nameITField.getText();
        model.nameFR = nameFRField.getText();
        model.nameEN = nameENField.getText();
        model.cretureTypes = creatureInfoField.getText();
        model.mana = manaField.getText();
        model.nameDE = nameDEField.getText();
        model.artist = artistField.getText();
    }
}
