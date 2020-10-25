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
        StringBuilder sb = new StringBuilder();
        String classname = spacesToUnderscores(model.nameDE);
        sb.append("\t#region " + classname + "\n\n");
        if (model.hasAktivAbility){
            String abilityname = "akt" + classname;
            sb.append("\n\tclass " + abilityname +" : TAktivierteFaehigkeit\n" +
                    "\t{\n" +
                    "\t\tpublic "+ abilityname +"(TMagicCard genitor, GameManager.GameManager manager) :\n" +
                    "\t\t\tbase(genitor, manager)\n" +
                    "\t\t{ }\n" +
                    "\n" +
                    "\t\tprotected override void initRule(TRegelText Rule)\n" +
                    "\t\t{\n" +
                    "\t\t\tRule.setRegelText(\""+model.nameEN+"\",\n" +
                    "\t\t\t\t  \""+model.ability+"\");\n" +
                    "\t\t}\n"
            );
            if(model.abilityManaCost != "") {
                sb.append(
                        "\t\tprotected override void initManaCost(TManakosten mana)\n" +
                                "\t\t{\n" +
                                "\t\t\tmana.AddMana(\""+model.abilityManaCost+"\");\n" +
                                "\t\t}\n" +
                                "\n"
                );
            }
            sb.append(
                    "\t\tpublic override void Resolve()\n" +
                    "\t\t{\n" +
                    "\t\t\t//TODO : Resolve schreiben\n"        +
                    "\t\t\tthis.GameManager.ExecuteAttribut(e);\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\tpublic override void makeCopy(ref TAktivierteFaehigkeit a)\n" +
                    "\t\t{\n" +
                    "\t\t\ta = new "+ abilityname +"(this.Genitor, this.GameManager);\n" +
                    "\t\t\tcopyto(a);\n" +
                    "\t\t}\n" +
                    "\t}\n\n");
        }

        sb.append("\t\tpublic class " + classname + "(TSpieler besitzer, GameManager.GameManager manager) :\n" );
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

    /**
     * wandelt Leerszeichen in Unterstriche
     * @return Der String mit den erstezten Leerzeichen.
     */
    private String spacesToUnderscores(String s){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i  < s.length(); i++){
            if (s.charAt(i) ==' '){
                builder.append("_");
            }else{
                builder.append(s.charAt(i));
            }
        }
        return builder.toString();
    }
}
