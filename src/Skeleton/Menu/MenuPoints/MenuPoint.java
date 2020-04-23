package Skeleton.Menu.MenuPoints;

/**
 * Ez az osztaly jelkepezi a menupontokat.
 */
public abstract class MenuPoint {

    /**
     * Tarolja, hogy milyen szoveg jelenik meg a menuponthoz.
     */
    public String displayedText;

    /**
     * @param displayedText Ez a szoveg jelenik meg a menuponthoz.
     */
    public MenuPoint(String displayedText){

        this.displayedText = displayedText;
    }

    /**
     * Itt kell megvalositani a menuponthoz tartozo funkciot.
     * Ez negy reszre oszolhat:
     * Init: Letrehozzuk a hasznalni kivant objektumokat
     * Action: Meghivjuk az letrehozott objektumok kivant fuggvenyeit
     * Question: uj menut nyitunk
     * End: Vege van az adott forgatokonyvnek es meghivjuk a program lezaro fuggvenyet
     */
    public abstract void function();
}
