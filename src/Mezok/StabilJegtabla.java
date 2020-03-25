package Mezok;

import Karakterek.Karakter;
import Szkeleton.Program;

public class StabilJegtabla extends  Jegtabla {

    @Override
    public void befogad(Karakter karakter) {

        Program.write("StabilJegtabla.befogad()");
    }
}
