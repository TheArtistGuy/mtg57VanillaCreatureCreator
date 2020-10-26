package common;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class TextAreaPanel extends JScrollPane {

    private JTextArea txtArea;
    private Model model;

    TextAreaPanel(Model model) {
        this.model = model;
        this.txtArea = new JTextArea();
        this.setViewportView(txtArea);
        setVisible(true);
    }

    /**
     * Setzt den Text der Text Area auf den übergebenen Text
     * @param s der Text
     */
    public void setTxtArea(String s) {
        System.out.println(s);
        txtArea.setText("");
        txtArea.append(s);
        revalidate();
    }

    /**
     * wandelt die im Model gespeicherten Informationen in einen KlassenText für Mtg57c um
     * @return der KlassenText
     */
    public String createTextFromModel() {
        StringBuilder sb = new StringBuilder();
        String classname = createClassNameFromName(model.nameDE);
        List<String> abilityNameList = new ArrayList<>();
        sb.append("\t#region " + classname + " - " + model.cardnumber + "\n\n");
        if (model.hasAktivAbility()) {
            for (int i = 0; i < model.activeAbilitys.size();i++) {
                abilityNameList.add("aktFaehig" + classname + (i+1));
                sb.append("\n\tclass " + abilityNameList.get(i) + " : TAktivierteFaehigkeit\n" +
                        "\t{\n" +
                        "\t\tpublic " + abilityNameList.get(i) + "(TMagicCard genitor, GameManager.GameManager manager) :\n" +
                        "\t\t\tbase(genitor, manager)\n" +
                        "\t\t{ }\n" +
                        "\n" +
                        "\t\tprotected override void initRule(TRegelText Rule)\n" +
                        "\t\t{\n" +
                        "\t\t\tRule.setRegelText(\"" + model.nameEN + "\",\n" +
                        "\t\t\t\t  \"" + model.activeAbilitys.get(i).getAbilityRuleText() + "\");\n" +
                        "\t\t}\n"
                );
                if (model.activeAbilitys.get(i).getAbilityManaCost() != "") {
                    sb.append(
                            "\t\tprotected override void initManaCost(TManakosten mana)\n" +
                                    "\t\t{\n" +
                                    "\t\t\tmana.AddMana(\"" + model.activeAbilitys.get(i).getAbilityManaCost() + "\");\n" +
                                    "\t\t}\n" +
                                    "\n"
                    );
                }
                sb.append(
                        "\t\tpublic override void Resolve()\n" +
                                "\t\t{\n" +
                                "\t\t\t//TODO : Resolve schreiben\n" +
                                "\t\t\tthis.GameManager.ExecuteAttribut(e);\n" +
                                "\t\t}\n" +
                                "\n" +
                                "\t\tpublic override void makeCopy(ref TAktivierteFaehigkeit a)\n" +
                                "\t\t{\n" +
                                "\t\t\ta = new " + abilityNameList.get(i) + "(this.Genitor, this.GameManager);\n" +
                                "\t\t\tcopyto(a);\n" +
                                "\t\t}\n" +
                                "\t}\n\n");
            }
        }
        sb.append("\tpublic class " + classname + " : TMagicCard\n" +
                "\t{\n");
        sb.append("\t\tpublic " + classname + "(TSpieler besitzer, GameManager.GameManager manager) :\n");
        sb.append("\t\t\tbase(besitzer, manager)\n" +
                "\t\t{ }\n\n");
        sb.append("\t\tprotected override void initRule(TRegelText Rule)\n" +
                "\t\t{\n" +
                "\t\tRule.setRegelText(\"" + model.nameEN + "\",\n" +
                "\t\t\t\"" + model.mana.trim() + "\",\n" +
                "\t\t\t\"Creature - " + model.cretureTypes + "\",\n" +
                "\t\t\t\"" + model.ability + "\",\n" +
                "\t\t\t\"" + model.stats + "\");\n" +
                "\t\t}\n\n");
        sb.append("\t\tpublic override void initNamen(TKartennamen Namen)\n" +
                "\t\t{\n" +
                "\t\t\tNamen.setNamen(\"" + model.nameDE + "\", \"" + model.nameEN + "\", \"" + model.nameFR + "\", \"" + model.nameIT +
                "\", \"" + model.nameSP + "\", \"" + model.namePO + "\");\n" +
                "\t\t}\n\n");
        sb.append("\t\tprotected override void initPrinting(TPrintingInfo info)\n" +
                "\t\t{\n" +
                "\t\t\tinfo.initInfo(" +
                (model.edition == null ? "" : ("EEditionen." + model.edition.getNameInEEditionClassFormat())) + ", " +
                model.cardnumber.trim() + ", " +
                (model.rarity == null ? "" : ("ESeltenheitsgrad." + model.rarity.getText())) + ", \"" + model.artist + "\");\n");
        sb.append("\t\t}\n" +
                "\n");
        if (model.hasAktivAbility()) {

                sb.append("\t\tprotected override void initFaehigkeiten(ArrayList liste, TSpieler spieler)\n" +
                        "\t\t{\n");
            for (int j = 0; j < model.activeAbilitys.size(); j++) {
                sb.append("\t\t\tliste.Add(new " + abilityNameList.get(j) + "(this, this.GameManager));\n");
            }
            sb.append("\t\t}\n");
        }
        sb.append(
                "\t}\n" +
                "\t#endregion // " + classname + "\n" +
                "\n");
        System.out.println(sb.toString());
        return sb.toString();

    }

    /**
     * Bearbeitet einen String:
     * wandelt Leerzeichen in Unterstriche, löscht  '-' und ersetzt Umlaute
     *
     * @return der bearbeitete String
     */
    private String createClassNameFromName(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                builder.append("_");
            } else if (s.charAt(i) == '-') {
            } else if(s.charAt(i) == 'ä'){
                builder.append("ae");
            } else if (s.charAt(i) == 'Ä') {
                builder.append("Ae");
            } else if (s.charAt(i) == 'ö'){
                builder.append("oe");
            } else if (s.charAt(i) == 'Ö') {
                builder.append("Oe");
            } else if (s.charAt(i) == 'ü') {
                builder.append("ue");
            } else if (s.charAt(i) == 'Ü') {
                builder.append("Ue");
            }else {
                    builder.append(s.charAt(i));
                }
            }
        return builder.toString();
    }
}