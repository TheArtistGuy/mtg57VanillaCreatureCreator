package common;

import java.awt.*;

public class RarityChoice extends Choice {

    RarityChoice(){
        this.add("Common");
        this.add("Uncommon");
        this.add("Rare");
        this.add("MythicRare");
    }

    public Rarity getRarity(){
        switch(this.getSelectedItem()){
            case ("Common") : return Rarity.COMMON;
            case("Uncommon") : return Rarity.UNCOMMON;
            case("Rare")    : return Rarity.RARE;
            case ("MythicRare") : return Rarity.MYTHICRARE;
            default: return null;
        }
    }

}
