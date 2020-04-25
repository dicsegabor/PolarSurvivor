package Proto.Commands;

import Proto.Commander.Commands.Command;
import Proto.Commander.Exceptions.WrongArgumentException;
import Proto.ProtoProgram;

import java.util.ArrayList;
import java.util.List;

public class DigCommand extends Command {

    @Override
    public void execute(String[] args) throws WrongArgumentException {

        if(args.length < 1)
            throw new WrongArgumentException("Nincs eleg megadott adat!");

        ProtoProgram.as(args[0]);
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

        return new ArrayList<>(){
            {
                add(String.format("%-30s%s", "[karakter]", "A karakter azonositoja, aki as."));
            }
        };
    }

    @Override
    protected String otherInfo() {
        return "Pl.: dig KUTATO_1";
    }

    @Override
    public String getDescription() {
        return "A parameterul kapott karakter as a mezon, amin all.";
    }
}
