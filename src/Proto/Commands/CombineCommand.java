package Proto.Commands;

import Proto.Commander.Commands.Command;
import Proto.Commander.Exceptions.WrongArgumentException;

import java.util.List;

public class CombineCommand extends Command {
    @Override
    public void execute(String[] args) throws WrongArgumentException {
        //TODO: funkció megvalósítása
    }

    @Override
    public String getName() {
        return "combine";
    }

    @Override
    protected String usage() {
        return "combine [karakter]";
    }

    @Override
    protected List<String> argumentsHelp() {
        return null;
    }

    @Override
    protected String otherInfo() {
        return "Pl.: combine e2";
    }

    @Override
    public String getDescription() {
        return "A parameterul kapott karakter azon a mezon amin all osszeszerelni probal.";
    }
}
