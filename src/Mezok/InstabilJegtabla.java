package Mezok;

import Karakterek.Karakter;
import Szkeleton.Program;

public class InstabilJegtabla extends Jegtabla {

    @Override
    public void befogad(Karakter karakter) {

        Program.writeToBuffer("InstabilJegtabla.befogad()");
    }
}
