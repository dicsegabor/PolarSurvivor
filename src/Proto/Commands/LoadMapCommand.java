package Proto.Commands;

import Mezo.*;
import Proto.Commander.Commands.Command;
import Proto.Commander.Exceptions.WrongArgumentException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class LoadMapCommand extends Command {

    HashMap<String, Mezo> mezok;

    public LoadMapCommand(HashMap<String, Mezo> mezok){

        this.mezok = mezok;
    }

    @Override
    public void execute(String[] args) throws WrongArgumentException {

        if(args.length < 1)
            throw new WrongArgumentException("Nem adott meg fajlnevet!");

        Scanner scanner;
        try { scanner = new Scanner(new FileInputStream(args[0])); }
        catch (FileNotFoundException e) { throw new WrongArgumentException("A megadott fajl nem letezik!"); }

        int lineNumber = 1;
        while (scanner.hasNext()){

            String line[] = scanner.nextLine().split("\t");
            for (int i = 0; i < line.length; i++)
                mezok.putIfAbsent(tipus(line[i]) + "_" + lineNumber + "_" + (i + 1), letrehoz(line[i]));

            lineNumber++;
        }

        if(mezok.isEmpty())
            throw new WrongArgumentException("A megadott fajl ures!");

        else
            setSzomszedok();
    }

    private void setSzomszedok(){

        for(Map.Entry<String, Mezo> mezoEntry : mezok.entrySet())
            for(Map.Entry<String, Mezo> mezoEntry2 : mezok.entrySet())
                if(szomszedE(mezoEntry.getKey(), mezoEntry2.getKey()))
                    mezoEntry.getValue().setSzomszed(mezoEntry2.getValue());
    }

    private boolean szomszedE(String mezo_1, String mezo_2){

        mezo_1 = mezo_1.substring(mezo_1.length() - 4);
        mezo_2 = mezo_2.substring(mezo_2.length() - 4);

        int mezo_1_sor, mezo_1_oszlop;
        mezo_1_sor = Integer.parseInt(String.valueOf(mezo_1.charAt(1)));
        mezo_1_oszlop = Integer.parseInt(String.valueOf(mezo_1.charAt(3)));

        int mezo_2_sor, mezo_2_oszlop;
        mezo_2_sor = Integer.parseInt(String.valueOf(mezo_2.charAt(1)));
        mezo_2_oszlop = Integer.parseInt(String.valueOf(mezo_2.charAt(3)));

        if(mezo_1_oszlop == mezo_2_oszlop && mezo_1_sor == mezo_2_sor)
            return false;

        return (Math.abs(mezo_1_sor - mezo_2_sor) < 2 && (mezo_1_oszlop - mezo_2_oszlop) == 0 ||
               (mezo_1_sor - mezo_2_sor) == 0 && Math.abs(mezo_1_oszlop - mezo_2_oszlop) < 2);
    }

    private Mezo letrehoz(String tipus){

        switch (tipus){

            case "v": return new Lyuk(false);
            case "l": return new Lyuk(true);
            case "s": return new StabilJegtabla();
            case "i": return new InstabilJegtabla();
            default: return null;
        }
    }

    private String tipus(String karakter){

        switch (karakter){

            case "s": return "STABIL";
            case "i": return "INSTABIL";
            default: return "LYUK";
        }
    }

    @Override
    public String getName() {

        return "loadmap";
    }

    @Override
    protected String usage() {

        return "loadmap [fajlnev]";
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

        return "A megadott fajlbol betolt egy terkepet.";
    }
}
