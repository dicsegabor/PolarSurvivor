package Proto.Commands;

import Proto.Commander.Commands.Command;
import Proto.Commander.Exceptions.WrongArgumentException;

import java.util.ArrayList;
import java.util.List;

public class BuildCommand extends Command {

    @Override
    public void execute(String[] args) throws WrongArgumentException {
        //TODO: Megvalositani a funkciot
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
                add(String.format("%-30s%s", "[fajlnev]", "A fajlnak a neve, ami a betoltheto terkepet tartalmazza"));
            }
        };
    }

    @Override
    protected String otherInfo() {

        return "Pl.: loadmap map.txt\n" +
                "\n" +
                "A palya leirasa:\n" +
                "Az oszlopok kozott tabulator, a sor vegen pedig enter.\n" +
                "A kivant palya felepiteset egy vele megegyezo strukturaju rendezett\n" +
                "karakterhalmaz irja majd le, mind a konzolra iraskor, mind a fajlbol olvasaskor.\n" +
                "Ennek felepiteset az alabbi sorok szemleltetik:\n" +
                "6 5\n" +
                "v v v v v v\n" +
                "v i s s l v\n" +
                "v i s l i v\n" +
                "v i s s i v\n" +
                "v v v v v v\n" +
                "Ahol az egyes betuk jelentese: v: viz ami lyuk 0 hoval, i: instabil jegtabla, s:\n" +
                "stabil jegtabla, l: lyuk.";
    }

    @Override
    public String getDescription() {

        return "A megadott karakter epit egy iglut vagy egy satrat.";
    }
}
