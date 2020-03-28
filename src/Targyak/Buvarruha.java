package Targyak;

import Mezok.Mezo;
import Szkeleton.Program;

public class Buvarruha implements Targy {

    @Override
    public void hasznal(Mezo mezo) {

        Program.writeToBuffer("Buvarruha.hasznal()");
    }

    @Override
    public void tipus() {}
}
