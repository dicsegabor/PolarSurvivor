package Proto.Commands;

import Proto.Commander.Commands.Command;
import Proto.Commander.Exceptions.WrongArgumentException;
import Proto.ProtoProgram;
import Targy.Targy;
import Targy.Targytipus;

import java.util.ArrayList;
import java.util.List;

public class SetFieldCommand extends Command {

    @Override
    public void execute(String[] args) throws WrongArgumentException {

        if(args.length < 2)
            throw new WrongArgumentException("Nincs eleg adat megadva!");

        if(args.length > 4)
            throw new WrongArgumentException("Tul sok adat van megadva!");

        int horeteg;
        try { horeteg = Integer.parseInt(args[1]); }
        catch (IllegalArgumentException e) { throw new WrongArgumentException("A megadott '" + args[1] + "' ertek nem egesz szam!"); }

        if(args[0].matches("STABIL.*")){

            if(args.length == 2)
                ProtoProgram.beallitStabilJegtablat(args[0], horeteg, null);

            else if(args.length == 3)
                ProtoProgram.beallitStabilJegtablat(args[0], horeteg, Targytipus.letrehoz(Targytipus.valueOf(args[2])));

            else
                throw new WrongArgumentException("Tul sok adat van megadva!");
        }

        else if(args[0].matches("INSTABIL.*")){

            if(args.length < 3)
                throw new WrongArgumentException("Nincs eleg adat megadva!");

            int kapacitas;
            try { kapacitas = Integer.parseInt(args[2]); }
            catch (IllegalArgumentException e) { throw new WrongArgumentException("A megadott '" + args[2] + "' ertek nem egesz szam!"); }

            Targy targy;

            if(args.length == 3)
                ProtoProgram.beallitInstabilJegtablat(args[0], horeteg, kapacitas, null);

            else
                ProtoProgram.beallitInstabilJegtablat(args[0], horeteg, kapacitas, Targytipus.letrehoz(Targytipus.valueOf(args[3])));
        }

        else
            throw new WrongArgumentException("Nincs ilyen tipusu tabla!");
    }

    @Override
    public String getName() {

        return "setfield";
    }

    @Override
    protected String usage() {

        return "setmezo [mezõ] [hóréteg] [kapacitás] [tárgy]";
    }

    @Override
    protected List<String> argumentsHelp() {

        return new ArrayList<>(){
            {
                add(String.format("%-30s%s", "[mezõ]", "A mezo azonositoja, amit szerkesztunk."));
                add(String.format("%-30s%s", "[hóréteg]", "A kivant ho mennyisege."));
                add(String.format("%-30s%s", "[kapacitás]", "A mezo kivant kapacitasa"));
                add(String.format("%-30s%s", "[tárgy]", "A mezore rakott targy"));
            }
        };
    }

    @Override
    protected String otherInfo() {

        return "Pl.: setfield STABIL_2_2 3 KOTEL";
    }

    @Override
    public String getDescription() {
        return "A paraméterül megadott mezõt ellátja megfelelõ számú hó réteggel és kapacitással és egy tárggyal.";
    }
}
