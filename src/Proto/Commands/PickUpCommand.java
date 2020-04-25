package Proto.Commands;

import Proto.Commander.Commands.Command;
import Proto.Commander.Exceptions.WrongArgumentException;

import java.util.List;

public class PickUpCommand extends Command {
    public PickUpCommand() {

    }

    @Override
    public void execute(String[] args) throws WrongArgumentException {

    }

    @Override
    public String getName() {
        return "pickup";
    }

    @Override
    protected String usage() {
        return "pickup [karakter]";
    }

    @Override
    protected List<String> argumentsHelp() {
        return null;
    }

    @Override
    protected String otherInfo() {
        return "Pl.: pickup k1";
    }

    @Override
    public String getDescription() {
        return "A parameterul kapott karakter felveszi a mezon levo targyat.";
    }
}
