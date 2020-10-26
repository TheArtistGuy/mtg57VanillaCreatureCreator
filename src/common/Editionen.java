package common;

/**
 * Enum um Editionen von Mtg anzugeben.
 */
public enum Editionen {
    RETURNTORAVNICA ("RueckkehrNachRavnica");

    private String name;

    Editionen(String name){
        this.name = name;
    }

    /**
     * Der Name der Edition in formatierter Form um dem Enum in mtg57c zu entsprechen
     * @return der Name
     */
    public String getNameInEEditionClassFormat() {
        return name;
    }
}
