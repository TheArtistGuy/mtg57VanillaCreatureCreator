package common;

/**
 * Enum um die Rarität einer KArte anzugeben
 */
public enum Rarity {
    COMMON("Common"), UNCOMMON("Uncommon"), RARE("Rare"), MYTHICRARE("MythicRare");

    private String text;


    Rarity(String text){
        this.text = text;
    }

    /**
     * Übergibt das Zeichen des Enums
     * @return das Zeichen
     */
    public String getText() {
        return text;
    }
}
