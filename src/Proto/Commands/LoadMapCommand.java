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

        System.out.println("");
    }

    private void setSzomszedok(){

        for(Map.Entry<String, Mezo> mezoEntry : mezok.entrySet())
            for(Map.Entry<String, Mezo> mezoEntry2 : mezok.entrySet())
                if(szomszedE(mezoEntry.getKey(), mezoEntry2.getKey()))
                    mezoEntry.getValue().setSzomszed(mezoEntry2.getValue());
    }

    private boolean szomszedE(String mezo1, String mezo2){

        mezo1 = mezo1.substring(mezo1.length() - 4);
        mezo2 = mezo2.substring(mezo2.length() - 4);

        int sor1, oszlop1;
        sor1 = Integer.parseInt(String.valueOf(mezo1.charAt(1)));
        oszlop1 = Integer.parseInt(String.valueOf(mezo1.charAt(3)));

        int sor2, oszlop2;
        sor2 = Integer.parseInt(String.valueOf(mezo2.charAt(1)));
        oszlop2 = Integer.parseInt(String.valueOf(mezo2.charAt(3)));

        if(oszlop1 == oszlop2 && sor1 == sor2)
            return false;

        return (Math.abs(sor1 - sor2) < 2 && (oszlop1 - oszlop2) == 0 ||
               (sor1 - sor2) == 0 && Math.abs(oszlop1 - oszlop2) < 2);
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
