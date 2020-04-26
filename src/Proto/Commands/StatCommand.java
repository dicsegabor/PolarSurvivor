package Proto.Commands;

import Proto.Commander.Commands.Command;
import Proto.Commander.Exceptions.WrongArgumentException;
import Proto.ProtoProgram;

import java.util.ArrayList;
import java.util.List;

public class StatCommand extends Command {

    @Override
    public void execute(String[] args) throws WrongArgumentException {

        if(args.length < 1)
            throw new WrongArgumentException("Nincs eleg megadott adat!");

        ProtoProgram.allapot(args[0]);
    }

    @Override
    public String getName() {

        return "stat";
    }

    @Override
    protected String usage() {

        return "stat [entitas azonosito]";
    }

    @Override
    protected List<String> argumentsHelp() {

        return new ArrayList<>(){
            {
                add(String.format("%-30s%s", "[entitas azonosito]", "Az entitas azonositoja, amit vizsgalunk."));
            }
        };
    }

    @Override
    protected String otherInfo() {

        return "stat JEGESMEDVE";
    }

    @Override
    public String getDescription() {
        return "A paraméterben kapott karakter tulajdonságait írja a képernyõre.";
    }
}
