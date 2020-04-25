package Proto.Commands;

import Mezo.Mezo;
import Mozgathato.Karakter;
import Proto.Commander.Commands.Command;
import Proto.Commander.Exceptions.WrongArgumentException;

import java.util.HashMap;
import java.util.List;

public class DigCommand extends Command {
    private HashMap<String, Karakter> karakterek;

    public DigCommand(HashMap<String, Karakter> karakterek) {
        this.karakterek = karakterek;
    }

    @Override
    public void execute(String[] args) throws WrongArgumentException {
        if(args.length < 1)
            throw new WrongArgumentException("A karakter nem volt megadva.");
        if(!karakterek.containsKey(args[0]))
            throw new WrongArgumentException("A megadott karakter nem letezik.");
        karakterek.get(args[0]).as();
    }

    @Override
    public String getName() {
        return "dig";
    }

    @Override
    protected String usage() {
        return "dig [karakter]";
    }

    @Override
    protected List<String> argumentsHelp() {
        return null;
    }

    @Override
    protected String otherInfo() {
        return "Pl.: dig k1";
    }

    @Override
    public String getDescription() {
        return "A parameterul kapott karakter as a mezon, amin all.";
    }
}
