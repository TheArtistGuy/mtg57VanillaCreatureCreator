package common;

import datatypes.ActiveAbility;

import java.util.ArrayList;
import java.util.List;

public class Model {
    public Editionen edition;
    public Rarity rarity;
    public String cardnumber;
    public String ability;
    public String stats;
    public String namePO;
    public String nameSP;
    public String nameIT;
    public String nameFR;
    public String nameEN;
    public String cretureTypes;
    public String mana;
    public String nameDE;
    public String artist;
    public List<ActiveAbility> activeAbilitys;

    /**
     * Konstruktor
     */
    public Model(){
        resetModel();
     }

    /**
     * @return ist die Liste aktiver Fähigkeiten leer?
     */
    public boolean hasAktivAbility(){
        return !activeAbilitys.isEmpty();
    }

    /**
     * ersetzt die Liste Aktiver Fähigkeiten mit einer neuen leeren Liste
     */
    public void resetActiveAbilitys(){
        this.activeAbilitys = new ArrayList<>();
    }

    /**
     * Setzt das Model auf einen leeren Zustand zurück
     */
    public void resetModel(){
        Editionen edition = Editionen.RETURNTORAVNICA;
        Rarity rarity = Rarity.COMMON;
        String cardnumber = "";
        String ability = "";
        String stats = "";
        String namePO = "";
        String nameSP = "";
        String nameIT = "";
        String nameFR = "";
        String nameEN = "";
        String creaturetypes = "";
        String mana = "";
        String nameDE = "";
        String artist = "";
        activeAbilitys = new ArrayList<>();
    }
}
