package Mezok;

import Karakterek.Karakter;
import Szkeleton.Program;

public class Lyuk extends Mezo {

    @Override
    public void befogad(Karakter karakter) {

        Program.writeToBuffer("Lyuk.befogad()");
    }

    @Override
    public void setIgluzott(boolean igluzott) {}
}
