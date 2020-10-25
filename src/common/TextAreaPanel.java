package common;

import javax.swing.*;
import java.awt.*;

public class TextAreaPanel extends JScrollPane {

    private JTextArea txtArea;
    private Model model;

    TextAreaPanel(Model model) {
        this.model = model;
        this.txtArea = new JTextArea();
        this.setViewportView(txtArea);
        setVisible(true);
    }

    public void setTxtArea(String s) {
        System.out.println(s);
        txtArea.setText("");
        txtArea.append(s);
        revalidate();
    }

    public String createTextFromModel() {
        System.out.println("createTextFromModel()");
        StringBuilder sb = new StringBuilder();
        sb.append("\t#region " + model.nameDE.trim() + "\n\n");
        sb.append("\t\tpublic class " + model.nameDE.trim() + "(TSpieler besitzer, GameManager.GameManager manager) :\n" );
        sb.append("\t\t\tbase(besitzer, manager)\n" +
                "\t\t{ }\n\n");
        sb.append("\t\tprotected override void initRule(TRegelText Rule)\n" +
                "\t\t{\n" +
                "\t\t\tRule.setRegelText(\"" + model.nameEN + "\",\n" +
                "\t\t\t\t\"" + model.mana.trim() + "\",\n" +
                "\t\t\t\t\"Creature - " + model.cretureTypes + "\",\n" +
                "\t\t\t\t\" " + model.ability + "\",\n" +
                "\t\t\t\t\"" + model.stats + "\");\n" +
                "\t\t}\n\n");
        sb.append("\t\tpublic override void initNamen(TKartennamen Namen)\n" +
                "\t\t{\n" +
                "\t\t\tNamen.setNamen(\"" + model.nameDE + "\", \"" + model.nameEN + "\", \"" + model.nameFR +"\", \"" + model.nameIT +
                "\", \"" + model.nameSP + "\", \"" + model.namePO + "\");\n" +
                "\t\t}\n\n");
        sb.append("\t\tprotected override void initPrinting(TPrintingInfo info)\n" +
                "\t\t{\n" +
                "\t\t\tinfo.initInfo(" +
                model.edition != null ? "" : ("EEditionen." + model.edition.getName()) + ", " +
                model.cardnumber.trim() + ", " +
                model.rarity != null ? "" : ("ESeltenheitsgrad." + model.rarity.getText()) + ", \"" + model.artist + "\");\n" );
        sb.append("\t\t}\n\n\n" +
                "\t}\n" +
                "\t#endregion\n" +
                "\n");
        System.out.println(sb.toString());
        return sb.toString();

    }
}
