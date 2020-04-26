package Proto.Commands;

import Proto.Commander.Commands.Command;
import Proto.Commander.Exceptions.WrongArgumentException;
import Proto.ProtoProgram;

import java.util.ArrayList;
import java.util.List;

public class CombineCommand extends Command {
    @Override
    public void execute(String[] args) throws WrongArgumentException {

        if(args.length < 1)
            throw new WrongArgumentException("Nincs eleg megadott adat!");

        ProtoProgram.kombinal(args[0]);
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

        return new ArrayList<>(){
            {
                add(String.format("%-30s%s", "[karakter]", "A karakter azonositoja, aki kombinal."));
            }
        };
    }

    @Override
    protected String otherInfo() {
        return "Pl.: combine ESZKIMO_1";
    }

    @Override
    public String getDescription() {
        return "A parameterul kapott karakter azon a mezon amin all osszeszerelni probal.";
    }
}
