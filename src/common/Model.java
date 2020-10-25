package common;

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

    public Model(){
        this.edition = Editionen.RETURNTORAVNICA;
        this.rarity = Rarity.COMMON;
        this.cardnumber = new String();
        this.ability = new String();
        this.stats = new String();
        this.namePO = new String();
        this.nameSP = new String();
        this.nameIT = new String();
        this.nameFR = new String();
        this.nameEN = new String();
        this.nameDE = new String();
        this.cretureTypes = new String();
        this.mana = new String();
        this.artist = new String();
    }
}
