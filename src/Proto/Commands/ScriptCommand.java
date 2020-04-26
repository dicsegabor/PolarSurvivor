package Proto.Commands;

import Proto.Commander.Commander;
import Proto.Commander.Commands.Command;
import Proto.Commander.Exceptions.WrongArgumentException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ScriptCommand extends Command {

    Commander commander;

    public ScriptCommand(Commander commander){

        this.commander = commander;
    }

    @Override
    public void execute(String[] args) throws WrongArgumentException {

        if(args.length < 1)
            throw new WrongArgumentException("Nem adott meg fajlnevet!");

        try { commander.listen(new FileInputStream(args[0])); }
        catch (FileNotFoundException e) { throw new WrongArgumentException("A megadott fajl nem letezik!"); }
    }

    @Override
    public String getName() {
        return "script";
    }

    @Override
    protected String usage() {
        return "script [fajlnev]";
    }

    @Override
    protected List<String> argumentsHelp() {

        return new ArrayList<>(){
            {
                add(String.format("%-30s%s", "[fajlnev]", "A fajlnak a neve, ami a betoltheto parancsokat tartalmazza"));
            }
        };
    }

    @Override
    protected String otherInfo() {

        return "script commands.txt";
    }

    @Override
    public String getDescription() {

        return "A paraméterben megkapott, a bemeneti nyelv kifejezéseit tartalmazó fájlból.";
    }
}
