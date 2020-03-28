package Targyak;

import Mezok.Mezo;
import Szkeleton.Program;

public class Jelzofeny implements Targy {

    @Override
    public void hasznal(Mezo mezo) {

        Program.writeToBuffer("Jelzofeny.hasznal()");
    }

    @Override
    public void tipus() {}
}
