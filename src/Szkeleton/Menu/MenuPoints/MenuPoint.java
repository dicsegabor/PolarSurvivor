package Szkeleton.Menu.MenuPoints;

/**
 * Ez az osztály jelképezi a menüpontokat.
 */
public abstract class MenuPoint {

    /**
     * Tárolja, hogy milyen szöveg jelenik meg a menüponthoz.
     */
    public String displayedText;

    /**
     * @param displayedText Ez a szöveg jelenik meg a menüponthoz.
     */
    public MenuPoint(String displayedText){

        this.displayedText = displayedText;
    }

    /**
     * Itt kell megvalósítani a menüponthoz tartozó funkciót.
     * Ez négy részre oszolhat:
     * Init: Létrehozzuk a használni kívánt objektumokat
     * Action: Meghívjuk az létrehozott objektumok kívánt függvényeit
     * Question: Új menüt nyitunk
     * End: Vége van az adott forgatókönyvnek és meghívjuk a program lezáró függvényét
     */
    public abstract void function();
}
