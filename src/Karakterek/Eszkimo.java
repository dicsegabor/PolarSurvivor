package Karakterek;

import Mezok.InstabilJegtabla;
import Mezok.Mezo;
import Mezok.StabilJegtabla;
import Szkeleton.Menus.Menu;
import Szkeleton.Menus.MenuPoints.LesserMenuPoints.EndOfScenario;
import Szkeleton.Menus.MenuPoints.MainMenuPoints.CharacterFallsInWater;
import Szkeleton.Program;

import java.util.Scanner;

public class Eszkimo extends Karakter {
    private Mezo mezo = new StabilJegtabla();

    public void iglutEpit(){
        System.out.println("Instabil jégtáblára építi?");
        System.out.println("1. Igen");
        System.out.println("2. Nem");
        System.out.println("Kérem írja be a választott számot!");
        Scanner input = new Scanner(System.in);
        String answer = input.nextLine();
        while(!(answer.equals("1") || answer.equals("2"))) {
            System.out.println("Kérem írjon be egy helyes értéket!");
            answer = input.nextLine();
        }
        if(answer.equals("1"))
            this.mezo = new InstabilJegtabla();
        Program.writeToBuffer("Eszkimo.iglutEpit(){");
        Program.indent++;
        this.mezo.setIgluzott(true);
    }
}
