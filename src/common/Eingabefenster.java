package common;

import dialogs.ActiveAbilityDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

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
    private JTextField artistField;


    /**
     * Konstruktor
     * @param model das Model
     * @param owner Frame zu dem eventuelle Dialogfenster ausgerichtet werden sollen.
     */
    public Eingabefenster(Model model, JFrame owner){
        this.model = model;
        JLabel inputLabel1 = new JLabel("Informationen aus dem Deckeditor, um automatisch in Felder zu schreiben ");
        JLabel inputLabel2 = new JLabel("Fehler, wenn nicht alle Sprachen gesetzt sind.");
        JLabel inputLabel3 = new JLabel("mit TABULATOR getrennte Zeichen zur ergänzung einfügen");
        this.add(inputLabel1);
        this.add(inputLabel2);
        this.add(inputLabel3);
        JTextField inputField = new JTextField(40);

        this.add(inputField);
        JButton useInfoButton = new JButton("Informationen in Felder schreiben");
        useInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parseDeckviewerInfosToTextFieldsExtended(inputField.getText());
            }
        });
        add(useInfoButton);
        initialiseAndAddNameFields();
        initialiseAndAddCreatureInfos();
        initialiseAndAddCreatureInfoFields();
        initialiseAndAddActiveAbilitiesButton(model, owner);
    }

    private void initialiseAndAddCreatureInfoFields() {
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

    private void initialiseAndAddActiveAbilitiesButton(Model model, JFrame owner) {
        JButton addActiveAbilityButton = new JButton("Füge Aktive Fähigkeit hinzu");
        addActiveAbilityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ActiveAbilityDialog aktiveAbilityDialog = new ActiveAbilityDialog(owner, model);
                aktiveAbilityDialog.setRuletext(faeigTxtField.getText());
            }
        });
        add(addActiveAbilityButton);
    }

    private void parseDeckviewerInfosToTextFields(String text) {
        //StringTokenizer tokenizer = new StringTokenizer(text, ",");
        StringTokenizer tokenizer = new StringTokenizer(text, "\t");
        if(tokenizer.hasMoreTokens()) nameDEField.setText(tokenizer.nextToken());
        if(tokenizer.hasMoreTokens()) nameENField.setText(tokenizer.nextToken());
        if(tokenizer.hasMoreTokens()) nameFRField.setText(tokenizer.nextToken());
        if(tokenizer.hasMoreTokens()) nameITField.setText(tokenizer.nextToken());
        if(tokenizer.hasMoreTokens()) nameSPField.setText(tokenizer.nextToken());
        if(tokenizer.hasMoreTokens()) namePOField.setText(tokenizer.nextToken());

        if(tokenizer.hasMoreTokens()) tokenizer.nextToken();
        if(tokenizer.hasMoreTokens()) rarityChoice.select(choiceTranslator(tokenizer.nextToken()));
        if(tokenizer.hasMoreTokens()) cardNumberField.setText(tokenizer.nextToken());
        if(tokenizer.hasMoreTokens()) artistField.setText(tokenizer.nextToken());

    }


    private void parseDeckviewerInfosToTextFieldsExtended(String text) {
        //StringTokenizer tokenizer = new StringTokenizer(text, ",");
        StringTokenizer tokenizer = new StringTokenizer(text, "\t");
        if(tokenizer.hasMoreTokens()) nameDEField.setText(tokenizer.nextToken());
        if(tokenizer.hasMoreTokens()) nameENField.setText(tokenizer.nextToken());
        if(tokenizer.hasMoreTokens()) nameFRField.setText(tokenizer.nextToken());
        if(tokenizer.hasMoreTokens()) nameITField.setText(tokenizer.nextToken());
        if(tokenizer.hasMoreTokens()) nameSPField.setText(tokenizer.nextToken());
        if(tokenizer.hasMoreTokens()) namePOField.setText(tokenizer.nextToken());

        if(tokenizer.hasMoreTokens()) editionChoice.select(editionChoiceTranslator(tokenizer.nextToken()));
        if(tokenizer.hasMoreTokens()) tokenizer.nextToken();
        if(tokenizer.hasMoreTokens()) tokenizer.nextToken();

        StringBuilder statsBuilder = new StringBuilder();
        if(tokenizer.hasMoreTokens()) statsBuilder.append(tokenizer.nextToken().trim());
        statsBuilder.append("/");
        if(tokenizer.hasMoreTokens()) statsBuilder.append(tokenizer.nextToken().trim());
        statsField.setText(statsBuilder.toString());
        if(tokenizer.hasMoreTokens()) manaField.setText(tokenizer.nextToken());

        if(tokenizer.hasMoreTokens()) tokenizer.nextToken();
        if(tokenizer.hasMoreTokens()) tokenizer.nextToken();

        if(tokenizer.hasMoreTokens()) rarityChoice.select(choiceTranslator(tokenizer.nextToken()));
        if(tokenizer.hasMoreTokens()) cardNumberField.setText(tokenizer.nextToken());

        if(tokenizer.hasMoreTokens()) faeigTxtField.setText(tokenizer.nextToken());

        if(tokenizer.hasMoreTokens()) tokenizer.nextToken();
        if(tokenizer.hasMoreTokens()) tokenizer.nextToken();
        if(tokenizer.hasMoreTokens()) tokenizer.nextToken();
        if(tokenizer.hasMoreTokens()) tokenizer.nextToken();
        if(tokenizer.hasMoreTokens()) tokenizer.nextToken();
        if(tokenizer.hasMoreTokens()) tokenizer.nextToken();


        if(tokenizer.hasMoreTokens()) tokenizer.nextToken();
        if(tokenizer.hasMoreTokens()) tokenizer.nextToken();
        if(tokenizer.hasMoreTokens()) tokenizer.nextToken();
        if(tokenizer.hasMoreTokens()) tokenizer.nextToken();
        if(tokenizer.hasMoreTokens()) tokenizer.nextToken();
        if(tokenizer.hasMoreTokens()) tokenizer.nextToken();

        if(tokenizer.hasMoreTokens()) tokenizer.nextToken();
        if(tokenizer.hasMoreTokens()) creatureInfoField.setText(removeInvalidStringFromCreatureInfoToken(tokenizer.nextToken()));
        if(tokenizer.hasMoreTokens()) tokenizer.nextToken();
        if(tokenizer.hasMoreTokens()) tokenizer.nextToken();
        if(tokenizer.hasMoreTokens()) tokenizer.nextToken();
        if(tokenizer.hasMoreTokens()) tokenizer.nextToken();

        if(tokenizer.hasMoreTokens()) artistField.setText(tokenizer.nextToken());

    }

    private String removeInvalidStringFromCreatureInfoToken(String s){
        StringBuilder stringbuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            if (i == 9) {
                stringbuilder.append('-');
            }else{
                stringbuilder.append(s.charAt(i));
            }
        }
        return stringbuilder.toString();
    }

    private String editionChoiceTranslator(String nextToken) {
        switch (nextToken) {
            case "Rückkehr nach Ravnica":
                return "Return to Ravnica";
            default:
                return "Return to Ravnica";
        }
    }

    private int choiceTranslator(String s) {
        s.trim();
        switch (s.toUpperCase()){
            case "C" : return 0;
            case "U" : return 1;
            case "R" : return 2;
            case "M" : return 3;
            default : return 0;
        }
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
        this.faeigTxtField = new JTextField(20);
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
        this.nameDEField = new JTextField(15);
        namePanel.add(nameDELabel);
        namePanel.add(nameDEField);

        JLabel nameENLabel = new JLabel("Name(EN):");
        this.nameENField = new JTextField(15);
        namePanel.add(nameENLabel);
        namePanel.add(nameENField);

        JLabel nameFRLabel = new JLabel("Name(FR):");
        this.nameFRField = new JTextField(15);
        namePanel.add(nameFRLabel);
        namePanel.add(nameFRField);

        JLabel nameITLabel = new JLabel("Name(IT):");
        this.nameITField = new JTextField(15);
        namePanel.add(nameITLabel);
        namePanel.add(nameITField);

        JLabel nameSPLabel = new JLabel("Name(SP):");
        this.nameSPField = new JTextField(15);
        namePanel.add(nameSPLabel);
        namePanel.add(nameSPField);

        JLabel namePOLabel = new JLabel("Name(PO):");
        this.namePOField = new JTextField(15);
        namePanel.add(namePOLabel);
        namePanel.add(namePOField);
        namePanel.revalidate();
        add(namePanel);
    }

    /**
     * setzt die Text-Felder auf die im Model gespeicherten Informationen
     */
    public void updateFieldsFromModel() {
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

    /**
     * setzt die Informationen des Models auf die Informationen der Felder
     */
    public void flushTextLabelsToModel() {
        model.edition = editionChoice.getEditionName();
        model.rarity = rarityChoice.getRarity();
        model.cardnumber = cardNumberField.getText();
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
