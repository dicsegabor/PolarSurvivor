package Karakterek;

import Szkeleton.Program;

public class Eszkimo extends Karakter {

    public void iglutEpit(){

        Program.writeToBuffer("Eszkiom.iglutEpit(){");
        Program.indent++;
        mezo.setIgluzott(true);
        munkaCsokkent();
    }
}
