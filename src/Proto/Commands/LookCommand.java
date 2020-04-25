package Proto.Commands;

import Mezo.Mezo;
import Mozgathato.Karakter;
import Mozgathato.Kutato;
import Proto.Commander.Commands.Command;
import Proto.Commander.Exceptions.WrongArgumentException;

import java.util.HashMap;
import java.util.List;

public class LookCommand extends Command {
    HashMap<String, Karakter> karakterek;
    HashMap<String, Mezo> mezok;

    public LookCommand(HashMap<String, Karakter> karakterek, HashMap<String, Mezo> mezok) {
        this.karakterek = karakterek;
        this.mezok = mezok;
    }

    @Override
    public void execute(String[] args) throws WrongArgumentException {
        if(args.length < 2)
            throw new WrongArgumentException("Tul keves parameter volt megadva");
        if(!karakterek.containsKey(args[0]))
            throw new WrongArgumentException("A megadott karakter nem letezik.");
        if(!mezok.containsKey(args[1]))
            throw new WrongArgumentException("A megadott mezo nem letezik.");

        ((Kutato)karakterek.get(args[0])).jegetNez(mezok.get(args[1]));
    }

    @Override
    public String getName() {
        return "look";
    }

    @Override
    protected String usage() {
        return "look [karakter] [mezo]";
    }

    @Override
    protected List<String> argumentsHelp() {
        return null;
    }

    @Override
    protected String otherInfo() {
        return "Pl.: look k2 m2";
    }

    @Override
    public String getDescription() {
        return "A parameterul kapott mezorol a kutato megallapitja a mezo kapacitasat.";
    }
}
