package Proto.Commands;

import Mezo.Mezo;
import Mozgathato.Jegesmedve;
import Mozgathato.Mozgathato;
import Proto.Commander.Commands.Command;
import Proto.Commander.Exceptions.WrongArgumentException;
import Proto.Jatek;

import java.util.HashMap;
import java.util.List;

public class JegesmedveCommand extends Command {

    @Override
    public void execute(String[] args) throws WrongArgumentException {

        if(args.length < 1)
            throw new WrongArgumentException("A jegesmedvehez nem volt mezo megadva.");

        Jatek.letrehozJegesmedve(args[0]);
    }

    @Override
    public String getName() {
        return "jegesmedve";
    }

    @Override
    protected String usage() {
        return "jegesmedve [mezo]";
    }

    @Override
    protected List<String> argumentsHelp() {
        return null;
    }

    @Override
    protected String otherInfo() {
        return "Pl.: jegesmedve m12";
    }

    @Override
    public String getDescription() {
        return "Letrehoz egy jegesmedvet a parameterul megadott mezore.";
    }
}
