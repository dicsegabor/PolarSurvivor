package Szkeleton.Menus.MenuPoints;

/**
 * Ez az osztály jelképezi a menüpontokat.
 */
public abstract class MenuPoint {

    /**
     * Tárolja, hogy milen szöveg jelenik meg a menüponthoz.
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
     * Pl.: Csinál egy új menüt, Függvényeket hív a programból
     */
    public abstract void function();
}
