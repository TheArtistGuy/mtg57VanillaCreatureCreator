package common;

public enum Editionen {
    RETURNTORAVNICA ("RueckkehrNachRavnica");

    private String name;

    Editionen(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
