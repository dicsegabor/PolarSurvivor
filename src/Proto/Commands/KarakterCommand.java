package Proto.Commands;

import Proto.Commander.Commands.Command;
import Proto.Commander.Exceptions.WrongArgumentException;
import Proto.ProtoProgram;
import Targy.*;

import java.util.ArrayList;
import java.util.List;

public class KarakterCommand extends Command {

    @Override
    public void execute(String[] args) throws WrongArgumentException {

        if(args.length < 2)
            throw new WrongArgumentException("Nincs eleg megadott adat!");

        if(args.length > 2){

            List<Targy> targyak = new ArrayList<>();

            for(int i = 2; i < args.length; i++)
                targyak.add(Targytipus.letrehoz(Targytipus.valueOf(args[i])));

            ProtoProgram.letrehozKarakter(args[0], args[1], targyak);
        }

        else
            ProtoProgram.letrehozKarakter(args[0], args[1], new ArrayList<>());
    }

    @Override
    public String getName() {

        return "karakter";
    }

    @Override
    protected String usage() {

        return "karakter [tipus] [mezo] [targy1] [targy2]...";
    }

    @Override
    protected List<String> argumentsHelp() {

        return new ArrayList<>(){
            {
                add(String.format("%-30s%s", "[tipus]", "A kivant karaktertipus. Pl.: KUTATO, ESZKIMO"));
                add(String.format("%-30s%s", "[mezo]", "A mezo azonositoja, amire a karaktert tenni szeretnenk."));
                add(String.format("%-30s%s", "[targy]", "A karakternek adhato targy. Pl.: LAPAT, BUVARRUHA..."));
            }
        };
    }

    @Override
    protected String otherInfo() {

        return "Pl.: karakter ESZKIMO STABIL_1_2 LAPAT";
    }

    @Override
    public String getDescription() {

        return "Letrehoz egy karaktert a parameterben megadott tipussal a megadott mezon a megadott targyakkal.";
    }
}
