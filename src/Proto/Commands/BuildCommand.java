package Proto.Commands;

import Epulet.Epulettipus;
import Proto.Commander.Commands.Command;
import Proto.Commander.Exceptions.WrongArgumentException;
import Proto.ProtoProgram;

import java.util.ArrayList;
import java.util.List;

public class BuildCommand extends Command {

    @Override
    public void execute(String[] args) throws WrongArgumentException {

        if(args.length < 2)
            throw new WrongArgumentException("Nincs eleg megadott adat!");

        try { ProtoProgram.epit(args[0], Epulettipus.valueOf(args[1])); }
        catch (IllegalArgumentException e) { throw new WrongArgumentException("Nincs ilyen epulettipus: " + args[1]); }
    }

    @Override
    public String getName() {

        return "build";
    }

    @Override
    protected String usage() {

        return "build [karakter] [epulet]";
    }

    @Override
    protected List<String> argumentsHelp() {

        return new ArrayList<>(){
            {
                add(String.format("%-30s%s", "[karakter]", "A karakter azonositoja, aki epit."));
                add(String.format("%-30s%s", "[epulet]", "Az epulettipus, amit epit. Pl.: IGLU, SATOR..."));
            }
        };
    }

    @Override
    protected String otherInfo() {

        return "Pl.: build ESZKIMO_1 IGLU";
    }

    @Override
    public String getDescription() {

        return "A paraméterül kapott karakter a tartózkodási helyén épít egy epuletet.";
    }
}
