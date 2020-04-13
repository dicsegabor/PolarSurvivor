package Program;

import java.util.Random;

public class Game {

    /**
     * Megvizsgalja, hogy van-e egy mezon jegesmedve es karakter, mert ha igen, akkor vege a jatkenak.
     */
    public static void checkForDeaths() {


    }

    /**
     * Ez a fuggveny initnel es a jegesmedve mozgatasanal lesz hasznos.
     * @param max Mekkora lehet a maximalis szam.
     * @return Visszater egy random szammal a megadott szamon belul.
     */
    public static int getRandomNumber(int max){

        Random random = new Random();

        return random.nextInt(max);
    }

    public static void endGame(){

        //TODO: Kitalalni a jatekveget
    }

    public static void nextCharacter(){

        //TODO: Kitalalni a korveget
    }
}
