package Szkeleton.Menu.MenuPoints.LesserUseCases;

import Szkeleton.Menu.MenuPoints.MenuPoint;
import Szkeleton.MethodCallHandler;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PlayMusic extends MenuPoint {

    /**
     * @param displayedText Ez a szöveg jelenik meg a menüponthoz.
     */
    public PlayMusic(String displayedText) {
        super(displayedText);
    }

    @Override
    public void function() {

        //Action
        File music = new File("./Music/Mortal Kombat - Theme Song.mp3");
        Desktop desktop = Desktop.getDesktop();
        if(music.exists()) {

            try { desktop.open(music); }
            catch (IOException e) {System.out.println("Nem létezik a fájl!");}
        }

        //End
        MethodCallHandler.endScenario();
    }
}
