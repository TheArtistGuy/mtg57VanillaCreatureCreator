package common;

public enum Rarity {
    COMMON("Common"), UNCOMMON("Uncommon"), RARE("Rare"), MYTHICRARE("MythicRare");

    private String text;

    Rarity(String text){
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
