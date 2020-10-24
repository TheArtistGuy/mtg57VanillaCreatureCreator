package common;

import java.awt.*;

public class EditionChoice extends Choice {
    EditionChoice(){
        this.add("Return to Ravnica");
    }

    public Editionen getEditionName(){
        switch (this.getSelectedItem()){
            case ("Return to Ravnica") :
                return Editionen.RETURNTORAVNICA;

            default:
                return null;
        }
    }


}
